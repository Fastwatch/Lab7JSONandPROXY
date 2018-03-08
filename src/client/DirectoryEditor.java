package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import directory.Employee;

public class DirectoryEditor {
	
	private static DirectoryProxy dirp = new DirectoryProxy();
	private static List<Employee> emp = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String response;
		
		System.out.println("File (F) or Console (C) Input?");
		response = in.nextLine();
		if(response.equalsIgnoreCase("F")) {
			fileInput(in);

		} else if (response.equalsIgnoreCase("C")) {
			consoleInput(in);
		}

		
		in.close();
	}
	
	private static void consoleInput(Scanner in) {
		String input;
		boolean consoleInput = true;
		boolean canAdd = false;
		
		System.out.println("Type \"Exit\" at any time to end program");

		
		while(consoleInput) {

			while ((input = in.nextLine()) != null) {

				
				if(input.equals("Exit")) {
					consoleInput = false;
					break;
				}else if(input.equals("END")) {
					canAdd = false;
					sendData();
				}else if(canAdd) {
					if(input.split(" ").length == 4) {
						addEmp(input);
					} else {
						System.out.println("Please enter employee while in Add mode, or type \"END\" to stop Add mode");
					}
				}else if(input.equals("ADD")) {
					canAdd = true;
				}else if(input.equals("CLR")) {
					dirp.clr();
				}else if(input.equals("PRINT")) {
					dirp.print();
					System.out.println();
				}
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
					dirp.clr();
				}else if(line.equals("PRINT")) {
					dirp.print();
					System.out.println();
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
