package model;

public class B {
	
	int id = A.getInstance().id;
	String name = A.getInstance().name;
	
	public static void main(String[] args) {
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		
		if ( a1.equals(a2)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}

}
