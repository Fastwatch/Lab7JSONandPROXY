package directory;

public class Employee implements Comparable<Employee> {

	private String LastName;
	private String FirstName;
	private String Phone;
	private String Department;
	
	
	
	public Employee(String lastName, String firstName, String phone, String department) {
		LastName = lastName;
		FirstName = firstName;
		Phone = phone;
		Department = department;
	}
	
	
	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	@Override
	public String toString() {
		 return LastName + ", " + FirstName + " " + Phone + " " + Department;
	}



	@Override
	public int compareTo(Employee other) {
		// TODO Auto-generated method stub
		int last = this.LastName.compareTo(other.LastName);
        return last == 0 ? this.FirstName.compareTo(other.FirstName) : last;
	}
}
