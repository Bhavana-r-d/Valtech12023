package htmlParser.test;


import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import htmlParser.HtmlParser;
 
@RunWith(Parameterized.class)
public class HtmlParserTest {
 
    private final String htmlContent;
    private final int expectedStartTags;
    private final int expectedEndTags;
 
    public HtmlParserTest(String htmlContent, int expectedStartTags, int expectedEndTags) {
        this.htmlContent = htmlContent;
        this.expectedStartTags = expectedStartTags;
        this.expectedEndTags = expectedEndTags;
    }
 
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{"<html > <head>	<title>Hello</title> </head><body>	<form action=hello>Name : <input name=name type=input><input type=submit name=Submit value=say hello></form></body></html>",7,5},
                {"<html><body><h1>Hello</h1></body></html>", 3, 3},
                {"<div><p>Paragraph</p></div>", 2, 2},
                {"<p>One</p><p>Two</p><p>Three</p>", 3, 3},
               
        });
    }
 
    @Test
    public void testParseHtml() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(htmlContent.getBytes());
        List<String> result = HtmlParser.parseHtml(inputStream);
        int actualStartTags = 0;
        int actualEndTags = 0;
        for (String line : result) {
            if (line.startsWith("Start Tag")) {
                actualStartTags++;
            } else if (line.startsWith("End Tag")) {
                actualEndTags++;
            }
        }
        assertEquals(expectedStartTags, actualStartTags);
        assertEquals(expectedEndTags, actualEndTags);
    }
}
