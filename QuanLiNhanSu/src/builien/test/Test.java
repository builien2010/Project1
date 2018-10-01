package builien.test;

import java.util.ArrayList;
import java.util.Scanner;

import builien.database.DeleteStaff;
import builien.database.DisplayStaff;
import builien.database.InsertStaff;
import builien.model.Employee;



public class Test {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Employee> staff;
	
	public static void menu() {
		System.out.println("-------------------------------MENU---------------------------------");
		System.out.println("1. Thêm nhân viên. ");
		System.out.println("2. Hiển thị danh sách nhân viên trong công ty .");
		System.out.println("3.Xóa nhân viên.");
		System.out.println("4.Thoát");
		System.out.println("\nBạn muốn làm gì ?");
		int choose = scan.nextInt();
		switch(choose) {
		case 1:
			them();
			break;
		case 2:
			xuat();
			break;
		case 3:
			xoa();
			break;
		case 4: 
			System.err.print("Kết thúc");
			System.exit(0);
			
		}
		
	}
	private static void xoa() {
		DeleteStaff del = new DeleteStaff();
		del.delete();
		
	}
	private static void xuat() {
		DisplayStaff dis = new DisplayStaff();
		dis.display();
	}
	private static void them() {
		InsertStaff in = new InsertStaff();
		in.insert();
	}
	
	public static void main(String[] args) {

		staff = new ArrayList<>();
		
		while(true) {
			menu();
		}

	}

}
