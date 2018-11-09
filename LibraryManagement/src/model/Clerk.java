// Done

package model;

public class Clerk extends Staff{
	
	int desk;
	public static int currentdeskNumber = 0;
	
	public Clerk(int id, String name, String address, int phone, double salary, int dk) {
		
		super(id, name, address, phone, salary);
		
		if( dk == -1) {
			desk = currentdeskNumber;
		}else {
			desk = dk;
		}
		
		currentdeskNumber++;
		
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Desk number: " + desk);
	}
	

}
