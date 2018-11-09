package model;

public class A {
	
	public int id;
	public String name;
	
	private static A obj;
	public static A getInstance() {
		obj = new A();
		return obj;
	}

}
