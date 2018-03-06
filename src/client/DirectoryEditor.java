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
	
	private static boolean inputSanitation(String input[]) {
		boolean isSanitized = true;


		if(input.length != 4 && input.length != 1) {
			isSanitized = false;
		}

		if(!isSanitized) {
			System.out.println("Invalid format. Please enter in format \"[First Name] [Last Name] [Department] [Phone Number] \"");
		}
		
		return isSanitized;
	}
	
	private static void consoleInput(Scanner in) {
			String rawInput;
			String input[];
			rawInput = in.nextLine();
			input = rawInput.split(" ");
			
			//Check to see if input is correct

			if(!inputSanitation(input)) {
				//Failed sanitation check
			} else {
				//Input is good to go
				if(input[0].equalsIgnoreCase("Add")) {
					//Go to add loop (until end)					
				}
			}

	}
	
	private static void fileInput(Scanner in) {
		
	}
	
	
}
