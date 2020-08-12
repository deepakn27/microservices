package adapterpattern;

public class IphoneCharger implements Iphone{
	
	private Iphone phone;
	
	IphoneCharger(Iphone iphone){
		this.phone=iphone;
	}
	
	@Override
	public void charge() {
		System.out.println("Iphone is charging");		
	}
}
