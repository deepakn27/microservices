package factorypattern;

import java.util.ArrayList;
import java.util.List;

public class FactoryDemo {

	public static void main(String[] args) {
		
		List<Offer> offerList = new ArrayList<>();
		Offer offer = OfferFactory.createOffer("FLYTXT","12","SONAJETO","12.5");
		Offer offer1 = OfferFactory.createOffer("FLYTXT","11","SP12","11.5");
		offerList.add(offer);
		offerList.add(offer1);
		
		Offer offer2 = OfferFactory.createOffer("DEFAULT","13","DEFAULT","13.5");
		System.out.println(offer2);	

		offerList.add(offer2);
		System.out.println("printing list");
		offerList.stream().forEach(System.out::println);
		

	}

}
