package factorypattern;

public class OfferFactory {

	public static Offer createOffer(String offerType,String offermrp,String offerName,String offerCommission)
	{
		if(offerType.equals(OfferEnum.FLYTXT.toString()))
		{
			return new FlyTxtOffer(offermrp,offerName,offerCommission);
		
		}
		
		else if(offerType.equals(OfferEnum.DEFAULT.toString()))
		{
			return new DefaultOffer	(offermrp,offerName,offerCommission);
		}
			
		else
			return null;
	}
}
