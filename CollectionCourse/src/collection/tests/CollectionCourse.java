
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
		
		/*
		 * System.out.println(ex2); System.out.println(c); System.out.println(ok);
		 * System.out.println(found);
		 */

		
		ArrayDeque<Integer> number = new ArrayDeque<>();
		number.add(1);
		number.add(5);
		number.add(3);
		number.add(4);

		System.out.println("ok");
		// Using Comparator	
		
		Comparator<Object> favNumber  = Comparator.comparing(x-> x.equals(3)).reversed();
		
		
		Queue<Object> numberFavs = new PriorityQueue<>(favNumber);
		numberFavs.addAll(number); // this added randomly not the same order
		while (!number.isEmpty()) {
		    System.out.print(number.poll() + " ");
		}
		
		System.out.println("ok");
		while (!numberFavs.isEmpty()) {
		    System.out.print(numberFavs.poll() + " ");
		}
		
		
		// Trying Comparator and Comparable with classes
		
		Course c1 = new Course("Math","Reyada")
				,c2 = new Course("History" , "Taree5")
				,c3 = new Course("Math", "7esabat");
		List<Course> cList = new ArrayList<>(List.of(c1, c2, c3));
		System.out.println("comparing course:");
		Collections.sort(cList);
		System.out.println(cList);
		
		Course c4= new Course("Arabic", "3araby");
		Collections.sort(cList , Course.cRule);
		System.out.println(cList);
		
		//Binary Search to get Insertion point
		
		int bin = Collections.binarySearch(cList, c4, Course.cRule);
		System.out.println("the supposed value for c4 is:" + bin);
		cList.add(Math.abs(++bin), c4);
		System.out.println(cList);

		
		
		
	}
	
}