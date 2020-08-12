package prototypepattern;

import java.io.Serializable;

class Foo implements Serializable{
	
	public int stuff;
	
	public String data;

	public Foo(int stuff, String data) {
		super();
		this.stuff = stuff;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Foo [stuff=" + stuff + ", data=" + data + "]";
	}
	
		
}
public class ProtoTypeUsingSerialization {

	public static void main(String[] args)
	{
		Foo foo = new Foo(1,"abcd");
		 //apache commons utility,roundtrip method serialize and deserialize the object making a deep copy
		//Foo foo2 = SerializationUtils.roundtrip(foo);
	}
}
