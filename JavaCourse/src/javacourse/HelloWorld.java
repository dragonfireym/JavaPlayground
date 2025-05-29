package javacourse;
import test_package.*;

public class HelloWorld {
	public static void main(String[] args) {
		int test = 11 ;
		double  test2 = 3.3E33, test3 = 3D;
		
		int newWay = switch(test) {
		case 0b11 ->3;
		case 11 -> 6;
		default -> 0 ;
		};
		
		String x = switch(newWay) {
		case 3 ,6 ,9 ->"Epic";
		default -> "Sad";
		};
		
		
		int[] arr1 = {1,2,3,4,5};
		int totalTest = 0;
		for(var i : arr1) {
			if(i == 3) continue;
			totalTest += i;
			
		}
		
		Example e = new Example(2 ,3) {
			static void changeMaster() {
				//do nothing
			}
			void changeX() {
				x = 3333;
			}
		};
		Example.SubExample sub = new Example.SubExample();
		
		
		SubClass subTest = new SubClass();
		subTest.printMe();
		subTest.printSuper();
		tryExecption();
		{
		System.out.println(subTest);
		System.out.println(e);
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(newWay);
		System.out.println(x);
		System.out.println(totalTest);
		System.out.println(e.value);
		System.out.println(e.x);
		System.out.println(Example.master);
		Example.changeMaster();
		System.out.println(Example.master);
		e.changeX();
		System.out.println(e.x);
		}
		
		
		
		
		
		
	}
	
	public static void tryExecption() {
		try {
			int x = 3/0;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("NO 0 !");
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
