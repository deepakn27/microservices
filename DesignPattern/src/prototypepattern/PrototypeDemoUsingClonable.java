package prototypepattern;

import java.util.Arrays;

class Address implements Cloneable
{
	public String streetName;
	public int houseNum;
	public Address(String streetName, int houseNum) {
		super();
		this.streetName = streetName;
		this.houseNum = houseNum;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", houseNum=" + houseNum + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Address(streetName,houseNum);
	}
		
}

class Person implements Cloneable
{
	public String[] names;
	public Address address;
	public Person(String[] names, Address address) {
		super();
		this.names = names;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return new Person(names.clone(),(Address)address.clone());
	}
}
public class PrototypeDemoUsingClonable {

	public static void main(String[] args) throws CloneNotSupportedException
	{
		Person john = new Person(new String[] {"John","Smith"},
				new Address("London Road",123));
		
		Person jane = (Person) john.clone();
		jane.names[0]= "jane";
		jane.address.houseNum=112;
		System.out.println(john);
		System.out.println(jane);
	}
}
