package adapterpattern;

public class AndroidCharger {

	private Android phone=null;
	
	
	public AndroidCharger() {
		
	}

	AndroidCharger(Android phone) {
		this.phone=phone;
	}
	
	public void chargeAndroid() {
		phone.chargeAndroid();
	}

	
}
