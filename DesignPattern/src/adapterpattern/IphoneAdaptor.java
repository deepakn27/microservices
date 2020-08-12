package adapterpattern;
public class IphoneAdaptor implements Android {
	
	private Iphone iphone;
	
	public IphoneAdaptor(Iphone iphone)
	{
		this.iphone = iphone;
	}

	@Override
	public void chargeAndroid() {
		iphone.charge();
	}
}
