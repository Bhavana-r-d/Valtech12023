package assignment.test;


import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import assignment.CSSParser;
 
@RunWith(Parameterized.class)
public class CSSParserTest {
 
    private final String cssContent;
    private final int expectedClassCount;
 
    public CSSParserTest(String cssContent, int expectedClassCount) {
        this.cssContent = cssContent;
        this.expectedClassCount = expectedClassCount;
    }
 
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {" .class1 { color: #FF5733; } .class2 { font-size: 12; }", 2},
                {".my-class{font-size: 16px;color: #336699;background-color: #f4f4f4;margin: 10px;padding: 5px;}",},
                {".another-class {	font-size: 14px;color: #ff6347;	background-color: #00ff00;margin: 8px;padding: 3px}",}
                // Add more test cases as needed
        });
    }
 
    @Test
    public void testParseCSSContent() {
        Map<String, Map<String, String>> classAttributes = CSSParser.parseCSSContent(cssContent);
        assertEquals(expectedClassCount, classAttributes.size());
    }
}