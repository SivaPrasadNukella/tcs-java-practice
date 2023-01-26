package com.test.exceptions;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {

	// Try with Resource Usage Example
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner scan = new Scanner(new File("E:\\sample_file.txt"));
				PrintWriter writer = new PrintWriter(new File("E:\\sample_file_Copy.txt"))){
			while(scan.hasNext()) {
				writer.println(scan.nextLine());
			}
			System.out.println("Completed writing Copied File.");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
