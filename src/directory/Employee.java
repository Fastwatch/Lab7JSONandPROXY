package directory;

public class Employee implements Comparable<Employee> {

	private String LastName;
	private String FirstName;
	private String Phone;
	private String Department;

	
	
	public Employee(String lastName, String firstName, String phone, String department) {
		LastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
		FirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
		Phone = phone;
		Department = department.toUpperCase();
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
