package singletonpattern;

public class DoubleCheckSingleton {
	
	private static DoubleCheckSingleton INSTANCE;
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private DoubleCheckSingleton(){
		
	}
	
	public static DoubleCheckSingleton getSingletonInstance()
	{
		if(INSTANCE==null)
		{
		   synchronized(DoubleCheckSingleton.class)
			{			
				if(INSTANCE==null)
				{
					INSTANCE = new DoubleCheckSingleton();
				}
			}
		}
		
		return INSTANCE;
	}
	public static void main(String[] args)
	{
		DoubleCheckSingleton singleton = DoubleCheckSingleton.getSingletonInstance();
	    singleton.setValue(111);


	    System.out.println(singleton.getValue());

	    singleton.setValue(222);

	    DoubleCheckSingleton singleton1 = DoubleCheckSingleton.getSingletonInstance();
	    System.out.println(singleton1.getValue());
	    System.out.println(singleton.getValue());
	}
}
