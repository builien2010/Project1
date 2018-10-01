package builien.model;

import java.sql.Date;

public class Tester extends Employee {
	
	private int numberError;
	public Tester() {
		super();
	}

	public Tester(int id, String name, Date birthday, String phone, String email, int baseSalary, int numberError) {
		super(id, name, birthday, phone,  email, baseSalary);
		this.numberError = numberError;
	}
	
	public void nhap() {
		
		super.nhap();
		System.out.println("Nhập số lỗi phát hiện : ");
		numberError = scan.nextInt();
		
	}

	
	public void tinhLuong() {
		
		salary = baseSalary + numberError*50000;

	}
	
	public String toString() { 
		return super.toString() + " lương : " + salary;
	}

	

}
