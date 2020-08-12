package singletonpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class EmployeeSingleton implements Serializable
{
	private EmployeeSingleton() {}
	
	int id;
	
	static class EmployeeSingletonCreator
	{
		private static final EmployeeSingleton e = new EmployeeSingleton();
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public static EmployeeSingleton getEmployeeObject()
	{
		return EmployeeSingletonCreator.e;
	}
	
	protected Object readResolve() {
		return EmployeeSingletonCreator.e;
	}
}
public class EnumUsingBillPugh {

	static void saveToFile(EmployeeSingleton e,String fileName) throws IOException
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
	
	static EmployeeSingleton getFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		try(FileInputStream fin = new FileInputStream(fileName);
			ObjectInputStream oi = new ObjectInputStream(fin);)
		{
			EmployeeSingleton e = (EmployeeSingleton) oi.readObject();
			return e;
		}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		EmployeeSingleton e = EmployeeSingleton.getEmployeeObject();
		e.setId(10);
		System.out.println(e.getId());
		saveToFile(e, "employee.bin");
		e.setId(11);
		EmployeeSingleton empread = getFromFile("employee.bin");
		
		System.out.println(e == empread);
		System.out.println("After reading from original object- " + e.getId());
		System.out.println("After reading from read object- " + empread.getId());
	}
	
	
}
