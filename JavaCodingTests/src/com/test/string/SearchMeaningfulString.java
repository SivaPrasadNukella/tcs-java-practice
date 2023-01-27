package com.test.string;

import java.util.Arrays;
import java.util.List;

public class SearchMeaningfulString {
	
	//Line1 is a dictionary of words. Convert Line 2 to a meaningful sentence by referring to the words in Line1.
	// String line1 = "I,A,AM,HE,HERE";
	// String line2 = "IAMHERE";
	//Solution :I AM HE HERE

	public static void main(String[] args) {

		String line1 = "I,A,AM,HE,HERE";
		String line2 = "IAMHERE";
		
		String[] wordArray = line1.split(",");
		List<String> wordArrayList = Arrays.asList(wordArray);
		
		System.out.println(wordArrayList);
		System.out.println(line2);
		
		char[] line2Array =  line2.toCharArray();
		StringBuffer solution = new StringBuffer();
		String tempStr = "";
		
		for (int i=0; i<line2Array.length; i++) {
			
			String str = Character.toString(line2Array[i]);
			
			boolean matchFound = false;
			tempStr = "";
			
			for(int j=i+1; j<line2Array.length; j++) {
				
				String str1 = Character.toString(line2Array[j]);
				
				if(tempStr.isEmpty()) {
					tempStr = str + str1;
				}else {
					tempStr = tempStr + str1;
				}
				
				if(wordArrayList.contains(tempStr)) {
					appendToSolution(solution, tempStr);
					matchFound = true;
				}
			}
			
			
			if(!matchFound && wordArrayList.contains(str)) {
				appendToSolution(solution, str);
			}
		}
		
		System.out.println(solution);
	}
	
	private static void appendToSolution(StringBuffer solution, String str) {
		
		if(solution.length() == 0) {
			solution.append(str);
		}else {
			solution.append(" " + str);
		}
	}

}
