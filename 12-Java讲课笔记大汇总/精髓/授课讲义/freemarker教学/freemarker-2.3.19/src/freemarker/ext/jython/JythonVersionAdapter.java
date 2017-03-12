package freemarker.ext.jython;

import org.python.core.PyObject;
import org.python.core.PySystemState;

import freemarker.template.utility.StringUtil;

/**
 * Functions that has a different implementation depending on the Jython version
 * used. This was introduced to work around class-loading errors because of
 * different classes/methods being present in different Jython versions.
 */
abstract class JythonVersionAdapter {

    /**
     * Returns
     * <code>obj instanceof Py[Java]Instance</code>. 
     */
    abstract boolean isPyInstance(Object obj);
    
    /**
     * Returns
     * <code>((PyInstance) py[Java]Instance).__tojava__(java.lang.Object.class)</code>.
     */
    abstract Object pyInstanceToJava(Object pyInstance);
    
    /**
     * Returns <code>pyObject.__class__.__name__</code> 
     */
    abstract String getPythonClassName(PyObject pyObject);
    
    private static JythonVersionAdapter instance;
    
    static JythonVersionAdapter getInstance() {
        if (instance == null) {
            synchronized (JythonVersionAdapter.class) {
                if (instance == null) {
                    // Note: Only the textual version number is available in Jython 2.0. 
                    int version;
                    try {
                        // Although PySystemState.version is present in all versions,
                        // its type changes, so we must use reflection to get it.
                        version = StringUtil.versionStringToInt(
                                PySystemState.class.getField("version").get(null).toString());
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to get Jython version: " + e);
                    }
                    ClassLoader cl = JythonVersionAdapter.class.getClassLoader();
                    try {
                        if (version >= 2005000) {
                            instance = (JythonVersionAdapter) cl.loadClass(
                                    "freemarker.ext.jython.Jython25VersionAdapter")
                                .newInstance();
                        } else if (version >= 2002000) {
                            instance = (JythonVersionAdapter) cl.loadClass(
                                    "freemarker.ext.jython.Jython22VersionAdapter")
                                .newInstance();
                        } else {
                            instance = (JythonVersionAdapter) cl.loadClass(
                                    "freemarker.ext.jython.Jython20And21VersionAdapter")
                                .newInstance();
                        }
                    } catch (ClassNotFoundException e) {
                        throw adapterCreationException(e);
                    } catch (IllegalAccessException e) {
                        throw adapterCreationException(e);
                    } catch (InstantiationException e) {
                        throw adapterCreationException(e);
                    }
                }
            }
        }
        
        return instance;
    }
    
    private static RuntimeException adapterCreationException(Exception e) {
        return new RuntimeException(
                "Unexpected exception when creating JythonVersionAdapter: "
                + e); // No cause exception argument available on Java 1.2.
    }
    
}
