package prototypepattern;

import java.util.Arrays;

class Address1 
{
	public String streetName;
	public int houseNum;
	public Address1(String streetName, int houseNum) {
		super();
		this.streetName = streetName;
		this.houseNum = houseNum;
	}
	@Override
	public String toString() {
		return "Address1 [streetName=" + streetName + ", houseNum=" + houseNum + "]";
	}
	
	public Address1(Address1 other)
	{
		this(other.streetName,other.houseNum);
	}
}

class Person1 
{
	public String names;
	public Address1 address;
	public Person1(String names, Address1 address) {
		super();
		this.names = names;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person1 [names=" + names + ", address=" + address + "]";
	}
	
	public Person1(Person1 other)
	{
		names = other.names;
		address = new Address1(other.address);
	}
}
public class PrototypeDemoUsingCopyConstructor {

	public static void main(String[] args)
	{
		Person1 john = new Person1("John Smith",
				new Address1("London Road",123));
		
		Person1 jane = new Person1(john);
		jane.names= "jane";
		jane.address.houseNum=112;
		System.out.println(john);
		System.out.println(jane);
	}
}
