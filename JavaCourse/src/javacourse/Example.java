package javacourse;

public  class Example implements SurveyGenerator {
	int x ,y, z;
	String value, className = "EXAMPLE";
	private int l = 99;
	static boolean master = true;
	
	
	Example(){
		x = 3;
	}
	Example(String value){
		this();
		this.value = value;
	}
	Example(int y , int z){
		//this();  //call a constructor
		this("YES");
		this.y = y;
		this.z =z;
		
		
	}
	static void changeMaster() {
		master = !master;
	}
	void changeX() {
		x = 777;
	}
	
	public  static class SubExample{
		int k = 3;
	}

	@Override
	public void RemoveExample() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addExample() {
		
	}
	
	@Override
	public String toString() {
		return className;
	}
	
	@Override
	public boolean equals(Object o) {
		o.getClass();
		return true;
	}
	
}
