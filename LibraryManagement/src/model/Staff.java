// Done

package model;

public class Staff extends Person{
	
	protected double salary;

	public Staff(int id, String name, String address, int phone, double salary) {
		super(id, name, address, phone);
		this.salary = salary;	
	}

	public Staff() {
		super();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Salary: " + salary + "\n");
	}
	
	
	
	
	
	
}
