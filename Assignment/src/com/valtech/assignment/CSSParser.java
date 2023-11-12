package com.valtech.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSSParser {

	public static Map<String, Map<String, String>> parseCSSContent(String cssContent) {
		Pattern classPattern = Pattern.compile("\\.(\\w+)\\s*\\{([^\\}]+)\\}");
		Pattern intAttributePattern = Pattern.compile("\\s*(\\w+)\\s*:\\s*(\\d+)\\s*;");
		Pattern colorAttributePattern = Pattern.compile("\\s*(\\w+)\\s*:\\s*#([0-9a-fA-F]{6})\\s*;");

		Map<String, Map<String, String>> classAttributes = new HashMap<>();

		String[] lines = cssContent.split("\n");
		for (String line : lines) {
			Matcher classMatcher = classPattern.matcher(line);
			while (classMatcher.find()) {
				String className = classMatcher.group(1);
				String attributesBlock = classMatcher.group(2);
				Map<String, String> attributes = new HashMap<>();
				Matcher intAttributeMatcher = intAttributePattern.matcher(attributesBlock);
				while (intAttributeMatcher.find()) {
					String attributeName = intAttributeMatcher.group(1);
					String attributeValue = intAttributeMatcher.group(2);
					attributes.put(attributeName, attributeValue);
				}
				Matcher colorAttributeMatcher = colorAttributePattern.matcher(attributesBlock);
				while (colorAttributeMatcher.find()) {
					String attributeName = colorAttributeMatcher.group(1);
					String hexColor = colorAttributeMatcher.group(2);
					String rgbColor = convertHexToRGB(hexColor);
					attributes.put(attributeName, rgbColor);
				}
				classAttributes.put(className, attributes);
			}
		}

		return classAttributes;
	}

	private static String convertHexToRGB(String hexColor) {
		int colorValue = Integer.parseInt(hexColor, 16);
		int red = (colorValue >> 16) & 0xFF;
		int green = (colorValue >> 8) & 0xFF;
		int blue = colorValue & 0xFF;
		return "rgb(" + red + "," + green + "," + blue + ")";
	}
}