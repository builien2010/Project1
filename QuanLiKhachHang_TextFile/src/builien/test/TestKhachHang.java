package builien.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import builien.model.DateConverter;
import builien.model.KhachHang;
import builien.model.TextFile;

public class TestKhachHang {
	
	static ArrayList<KhachHang> dsKH = new ArrayList<>();
	
	static Scanner scan = new Scanner(System.in);
	public static void menu() {
		System.out.println("--------------------------------MENU--------------------------");
		System.out.println("1.Nhập");
		System.out.println("2.Xuất");
		System.out.println("3.Lưu");
		System.out.println("4.Mở");
		System.out.println("5.Thoát");
		
		System.out.println("Bạn muốn gì : ");
		int chon = scan.nextInt();
		
		switch(chon) {
		case 1:
			nhap();
			break;
		case 2:
			xuat();
			break;
		case 3:
			luu();
			break;
		case 4: 
			mo();
			break;
		case 5:
			System.err.println("Tạm biệt");
			System.exit(0);
			break;
		}
		
		
	}

	private static void luu() {
		
		if(TextFile.saveFile(dsKH,"D:\\Ki1Nam3\\Project1\\JavaBasic\\QuanLiKhachHang_TextFile\\data.txt")) {
			System.out.println("Lưu file thành công ");
		}else {
			System.out.println("Lưu file không thành công .");
		}
		
	}

	private static void mo() {
		
		//dsKH = TextFile.readFile("/media/builien/Study/Ki1Nam3/Project1/JavaBasic/QuanLiKhachHang_TextFile/data.txt");
		dsKH = TextFile.readFile("D:\\\\Ki1Nam3\\\\Project1\\\\JavaBasic\\\\QuanLiKhachHang_TextFile\\\\data.txt");
		xuat();
		
		
	}

	private static void xuat() {
		
		System.out.println("Danh sách tất cả các khách hàng : ");
		for (KhachHang kh: dsKH) {
			System.out.println(kh);
		}
		
	}

	private static void nhap() {
		System.out.println("Nhập mã : ");
		int ma = scan.nextInt();
		scan.nextLine();
		System.out.println("Nhập họ tên : ");
		String hoTen = scan.nextLine();
		System.out.println("Nhập năm sinh(dd/MM/yyyy): ");
		Date namSinh = DateConverter.fromString(scan.nextLine());
		
		KhachHang kh = new KhachHang(ma, hoTen, namSinh);	
		dsKH.add(kh);
		
		
	}

	public static void main(String[] args) {
		
		while(true) {
			menu();
		}

	}

}
