
package collection.tests;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionCourse {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		boolean ok = c.addAll(List.of("A","B","C")); // use also removeAll to select a set you want
		//retainAll remove everything except in this list
		boolean found = c.containsAll(List.of("A","B"));
		boolean isEmpty = c.isEmpty();
		c.stream().forEach(e -> System.out.println(e+1));
		//Lambda expressions >:
		c.stream()
			.filter(e -> e == "B")
			.forEach(e-> System.out.println(e));
		
//		//enhance lambda , not will not work as it is String which have some problems
//		c.stream()
//		.filter(String::equals("B"))
//		.forEach(e-> System.out.println(e));
		
		//This mainly for instances of classes >>:
		c.stream().filter(new Predicate<String>() {
		    @Override
		    public boolean test(String s) {
		        return s.startsWith("A");
		    }
		}).forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
			
		});
		Collection<String> ex2 = c.stream().filter(t -> t == "C" ).collect(Collectors.toList());
		
		System.out.println(ex2);
		System.out.println(c);
		System.out.println(ok);
		System.out.println(found);
	}
	
}