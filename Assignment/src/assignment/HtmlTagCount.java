package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class HtmlTagCount {

	public static void main(String[] args) {
        String fileName = "login.html"; 
 
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 0;
            Stack<String> tagStack = new Stack<>();
            int tagCount = 0;
 
            while ((line = br.readLine()) != null) {
                lineNumber++;
                int startIndex = 0;
 
                while (true) {
                    int openIndex = line.indexOf('<', startIndex);
                    int closeIndex = line.indexOf('>', startIndex);
 
                    if (openIndex == -1 || closeIndex == -1)
                        break;
 
                    if (openIndex < closeIndex) {
                        String tag = line.substring(openIndex, closeIndex + 1);
 
                        if (tag.startsWith("</")) {
                            // Closing tag
                            String openingTag = tagStack.pop();
                            System.out.println("Ending Tag: " + openingTag);
                            System.out.println("End Line: " + lineNumber);
                        } else {
                            // Starting tag
                            System.out.println("Starting Tag: " + tag);
                            System.out.println("Start Line: " + lineNumber);
                            tagStack.push(tag);
                        }
 
                        tagCount++;
                    }
 
                    startIndex = closeIndex + 1;
                }
            }
 
           
       
			
			while (!tagStack.isEmpty()) {
				String unclosedTag = tagStack.pop();
				System.out.println("Unclosed Tag: " + unclosedTag);
			}

			System.out.println("\nTotal Tags: " + tagCount);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
