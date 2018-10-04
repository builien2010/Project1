package builien.model;

import java.io.Serializable;
import java.util.Date;

public class KhachHang implements Serializable{
	
	private int ma;
	private String hoTen;
	private Date namSinh;
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(int ma, String hoTen, Date namSinh) {
		this.ma = ma;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	
	public void setMa(int ma) {
		this.ma = ma;
	}
	
	public int getMa() {
		return ma;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}
	
	public Date getNamSinh() {
		return namSinh;
	}
	
	public String toString() {
		return ma + "\t" + hoTen + "\t" + DateConverter.fromDate(namSinh);
	}
	
	
}
