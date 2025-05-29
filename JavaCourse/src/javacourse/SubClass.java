package javacourse;

public class SubClass extends Example  {
	public static String master = "Reborn";
	
	public void printMe() {
		System.out.println(master);
	}
	public void printSuper() {
		System.out.println(super.master);
	}
	
	

}
