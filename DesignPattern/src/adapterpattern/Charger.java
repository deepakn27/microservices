package adapterpattern;

public class Charger {

	public static void main(String[] args) {

		Android androidPhone=new RealMeXT();
		AndroidCharger androidPhoneCharger=new AndroidCharger(androidPhone);
		androidPhoneCharger.chargeAndroid();
	
		Iphone iphone = new Iphone11();
		Android androidIphoneAdapter=new IphoneAdaptor(iphone);
		androidIphoneAdapter.chargeAndroid();
	}
}
