package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name+":"+age;
	}

	@Override
	public int hashCode() {
		//가변인자
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		
		Person p = (Person)obj;
		
		return this.name.equals(p.name) && this.age == p.age;
	}
}
