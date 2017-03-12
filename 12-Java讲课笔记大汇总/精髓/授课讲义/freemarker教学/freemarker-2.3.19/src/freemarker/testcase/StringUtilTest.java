package freemarker.testcase;

import freemarker.template.utility.StringUtil;
import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
    
    public StringUtilTest(String name) {
        super(name);
    }
    
    public void testJQuote() {
        assertEquals("null", StringUtil.jQuote(null));
        assertEquals("\"foo\"", StringUtil.jQuote("foo"));
        assertEquals("\"123\"", StringUtil.jQuote(Integer.valueOf(123)));
        assertEquals("\"foo's \\\"bar\\\"\"",
                StringUtil.jQuote("foo's \"bar\""));
        assertEquals("\"\\n\\r\\t\\u0001\"",
                StringUtil.jQuote("\n\r\t\u0001"));
        assertEquals("\"<\\nb\\rc\\td\\u0001>\"",
                StringUtil.jQuote("<\nb\rc\td\u0001>"));
    }

    
    public void testJQuoteNoXSS() {
        assertEquals("null", StringUtil.jQuoteNoXSS(null));
        assertEquals("\"foo\"", StringUtil.jQuoteNoXSS("foo"));
        assertEquals("\"123\"", StringUtil.jQuoteNoXSS(Integer.valueOf(123)));
        assertEquals("\"foo's \\\"bar\\\"\"",
                StringUtil.jQuoteNoXSS("foo's \"bar\""));
        assertEquals("\"\\n\\r\\t\\u0001\"",
                StringUtil.jQuoteNoXSS("\n\r\t\u0001"));
        assertEquals("\"\\u003C\\nb\\rc\\td\\u0001>\"",
                StringUtil.jQuoteNoXSS("<\nb\rc\td\u0001>"));
        assertEquals("\"\\u003C\\nb\\rc\\td\\u0001>\"",
                StringUtil.jQuoteNoXSS((Object) "<\nb\rc\td\u0001>"));
    }
    
    public void testVersionStringToNumber() {
        assertEquals(1000000, StringUtil.versionStringToInt("1"));
        assertEquals(1002000, StringUtil.versionStringToInt("1.2"));
        assertEquals(1002003, StringUtil.versionStringToInt("1.2.3"));
        assertEquals(1002003, StringUtil.versionStringToInt("01.02.03"));
        assertEquals(12034056, StringUtil.versionStringToInt("12.34.56"));
        assertEquals(1000003, StringUtil.versionStringToInt("1.0.3rc4"));
        try {
            StringUtil.versionStringToInt("x");
            fail();
        } catch (IllegalArgumentException e) {
            // nop
        }
    }
    
}
