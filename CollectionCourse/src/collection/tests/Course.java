package collection.tests;

import java.util.Comparator;

public class Course implements  Comparable<Course> {
	public static Comparator<Course> cRule = Comparator.comparing(Course:: getSubName)
			.thenComparing(Course::getName);
	private String name, subName;
	public Course(String name, String subName){
		this.name = name;
		this.subName = subName;
	}
	
	public String getName() {
		return this.name;
	}
	public String getSubName() {
		return this.subName;
	}
	
	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stub
		int x = this.name.compareTo(o.getName());
		return  x!=0? x: this.subName.compareTo(o.getSubName());
	}


	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.subName;
	}

}
