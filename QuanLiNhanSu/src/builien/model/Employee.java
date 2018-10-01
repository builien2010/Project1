package builien.model;


import java.sql.Date;
import java.util.Scanner;

public class Employee {
	
	
	protected int id;
	protected String name;
	protected Date birthday;
	protected String phone;
	protected String email;
	protected int baseSalary;
	protected int salary;
	protected Scanner scan = new Scanner(System.in);
		
	public Employee() {
		super();
	}
		
	public Employee(int id, String name, Date birthday, String phone, String email, int baseSalary) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.baseSalary = baseSalary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public int getId() {
		return id;
	}
		
	public void setName(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}
		
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
		
	public Date getBirthday() {
		return birthday;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public int getBaseSalary() {
		return baseSalary;
	}
	
	public int getSalary() {
		return salary;
	}
	public void nhap() {
			
		System.out.println("Nhập mã nhân viên: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Nhập họ tên : ");
		name = scan.nextLine();
		System.out.println("Nhập ngày sinh (yyyy-MM-dd) : ");
		birthday = Date.valueOf(scan.nextLine());
		
		System.out.println("Nhập số điện thoại : ");
		phone = scan.nextLine();
		
		System.out.println("Nhập email: ");
		email = scan.nextLine();	
		
		System.out.println("Nhập lương cơ bản: ");
		baseSalary = scan.nextInt();
		
	}
		
	public String toString() { 
		return "\nMã nhân viên: "  + id + "\nHọ Tên : " + name + "\nNgày sinh: " + birthday + "\nSĐT: " + phone + "\nEmail: " + email;
	}

}
