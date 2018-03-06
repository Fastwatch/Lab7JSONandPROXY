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
				fileInput(in);
				break;
			case "C":
				consoleInput(in);
				break;
			}
			
		}while(!response.equalsIgnoreCase("e"));
		
		in.close();
	}
	
	private static void consoleInput(Scanner in) {
		
	}
	
	private static void fileInput(Scanner in) {
		
	}
	
	
}
