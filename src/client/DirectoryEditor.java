package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import directory.Employee;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DirectoryEditor {
	
	private static DirectoryProxy dirp;
	private static List<Employee> emp = new ArrayList<Employee>();
	
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
				if(input.equals("")) {
					
				}
			}

	}
	
	private static void fileInput(Scanner in) {
		String fileName;
		File file = null;
		
		
		System.out.print("\nPlease enter a file path:");
		fileName = in.nextLine();
		
		file = new File(fileName);
		
		
		
		if(!file.exists() || !file.isFile()) {
			System.out.println("File does not exist");
			return;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName));){
			
			String line;
			boolean canAdd = false;
			
			while ((line = br.readLine()) != null) {
				if(line.equals("END")) {
					canAdd = false;
					sendData();
				}else if(canAdd) {
					addEmp(line);
				}else if(line.equals("ADD")) {
					canAdd = true;
				}else if(line.equals("CLR")) {
					
				}else if(line.equals("PRINT")) {
					
				}
				
			}
		} catch (IOException ex) {
			System.out.println("error occured in retrieving file");
		}				
		
	}
	
	private static void sendData() {
		Gson g = new Gson();
		dirp.add(g.toJson(emp));
		emp.clear();
	}
	
	private static void addEmp(String line) {
		String[] e = line.split(" ");
		if(e.length == 4) {
			Employee tmp = new Employee(e[1], e[0], e[3], e[2]);
			emp.add(tmp);
		}
	}
	
}
