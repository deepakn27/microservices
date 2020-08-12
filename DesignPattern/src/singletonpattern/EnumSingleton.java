package singletonpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum Employee{
	INSTANCE;
	
	int id;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		this.id = value;
	}
	
	
}
public class EnumSingleton {
	
	static void saveToFile(Employee e,String fileName) throws IOException
	{
		try(FileOutputStream fo = new FileOutputStream(fileName);
			ObjectOutputStream oo = new ObjectOutputStream(fo);)
		{
			oo.writeObject(e);
		}catch(Exception exp)
		{
			System.out.println("Exception e");
		}
	}
	
	static Employee getFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		try(FileInputStream fin = new FileInputStream(fileName);
			ObjectInputStream oi = new ObjectInputStream(fin);)
		{
			Employee e = (Employee) oi.readObject();
			return e;
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Employee e = Employee.INSTANCE;
		
		e.setId(555);
		System.out.println(e.getId());
		saveToFile(e, "employee1.bin");
		e.setId(11);
				
		Employee empread = getFromFile("employee1.bin");
		
		System.out.println(e == empread);
		System.out.println("After reading from original object- " + e.getId());
		System.out.println("After reading from read object- " + empread.getId());
	}
}
