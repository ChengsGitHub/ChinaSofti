package freemarker.ext.jython;

import org.python.core.PyJavaInstance;
import org.python.core.PyObject;

/**
 * {@link JythonVersionAdapter} for Jython 2.2.
 */
class Jython22VersionAdapter extends JythonVersionAdapter {

    boolean isPyInstance(Object obj) {
        return obj instanceof PyJavaInstance;
    }

    Object pyInstanceToJava(Object pyInstance) {
        return ((PyJavaInstance) pyInstance).__tojava__(java.lang.Object.class);
    }

    String getPythonClassName(PyObject pyObject) {
        return pyObject.getType().getFullName();
    }

}
