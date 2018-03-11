package directory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainDirectory implements Directory{

	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public void print() {
		if(employeeList.isEmpty()) {
			System.out.println("Empty directory.");
			return;
		}
		for (Employee pp: employeeList) {
			System.out.println(pp.toString());
		}
	}

	@Override
	public void add(String s) {
		Gson g = new Gson();
		ArrayList<Employee> ep = (g.fromJson(s, new TypeToken<Collection<Employee>>(){}.getType()));
		for (Employee pp: ep) {
			employeeList.add(pp);
		}
		 Collections.sort(employeeList);
	}

	@Override
	public void clr() {
		employeeList.clear();		
	}

}
