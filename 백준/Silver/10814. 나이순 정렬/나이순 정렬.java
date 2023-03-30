import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Main {
	static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {// 생성자 
			super();
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		Person[] p = new Person[N];
		for(int i=0; i<N;i++) {
			p[i] = new Person(sc.nextInt(), sc.next());
		}
		
		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.age - o2.age;
			}
		});
		
		for(int i=0;i<N;i++) {
			System.out.println(p[i].age+" "+p[i].name);
		}
		
	}// main
}