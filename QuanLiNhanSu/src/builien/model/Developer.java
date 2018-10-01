package builien.model;

import java.sql.Date;

public class Developer extends Employee {
	
	private int overtime;
	
	public Developer() {
		super();
	}
	
	public Developer(int id, String name, Date birthday, String phone, String email,int baseSalary, int overtime) {
		super(id, name, birthday, phone, email, baseSalary);
		this.overtime = overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	
	public int getOvertime() {
		return overtime;	
	}
	
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Nhập số giờ làm thêm : ");
		overtime = scan.nextInt();
	}
	
	public void tinhLuong() {	
		salary = baseSalary + overtime*200000;
	}
	
	public String toString() { 
		return super.toString() + "\nLương : " + salary;
	}

}
