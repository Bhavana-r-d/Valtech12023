package assignment;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
 
public class WebScraper {
	 
	
	    public static void main(String[] args) {
	       
	        Set<String> commonWords = new HashSet<>(Arrays.asList("is", "are","as", "if", "and", "the","to","of"));
	 
	       
	        Map<String, Integer> wordCounts = new HashMap<>();
	 
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader("C://Users/Bhavana.D/Desktop/essay.txt"));
	            String line;
	 
	            while ((line = reader.readLine()) != null) {
	                
	                String[] words = line.split("\\s+");
	 
	                for (String word : words) {
	                    
	                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
	 
	                    if (!commonWords.contains(word)) {
	                      
	                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
	                    }
	                }
	            }
	 
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	       
	        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	}

 
    
