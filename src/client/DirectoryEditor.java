package client;

import java.util.Scanner;

public class DirectoryEditor {
	
	private static DirectoryProxy dirp;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String response;
		
		do {
			System.out.println("File (F) or Console (C) Input, or Exit (E)?");
			response = in.nextLine();
			switch(response.toUpperCase()) {
			case "F":
				fileInput();
				break;
			case "C":
				consoleInput();
				break;
			}
			
		}while(!response.equalsIgnoreCase("e"));
		
		in.close();
	}
	
	private static void consoleInput() {
		
	}
	
	private static void fileInput() {
		
	}
	
	
}
