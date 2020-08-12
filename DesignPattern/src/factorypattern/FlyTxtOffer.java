package factorypattern;

public class FlyTxtOffer implements Offer {

	String offermrp="";
	String offerName="";
	String offerCommission="";
		
	public FlyTxtOffer(String offermrp, String offerName, String offerCommission) {
		super();
		this.offermrp = offermrp;
		this.offerName = offerName;
		this.offerCommission = offerCommission;
	}
	public String getOffermrp() {
		return offermrp;
	}
	public void setOffermrp(String offermrp) {
		this.offermrp = offermrp;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferCommission() {
		return offerCommission;
	}
	public void setOfferCommission(String offerCommission) {
		this.offerCommission = offerCommission;
	}
	@Override
	public String toString() {
		return "FlyTxtOffer [offermrp=" + offermrp + ", offerName=" + offerName + ", offerCommission=" + offerCommission
				+ "]";
	}
	
	
	
}
