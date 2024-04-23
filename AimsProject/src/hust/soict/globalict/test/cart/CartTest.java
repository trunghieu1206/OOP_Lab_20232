package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String args[]) {
		//Create a new Cart 
		Cart cart = new Cart();
		
		//Create a new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King",
				"Animation",
				"Roger Allers",
				87,
				19.95f
		);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				50,
				24.95f
		);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
				"Aladin",
				"Animation",
				"Guy Ritchie",
				20,
				18.99f
		);
		cart.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(
				"Alibaba",
				"Animation",
				"Somebody",
				34,
				50.0f
		);
		cart.addMedia(dvd4);
		
		
		
		//Test the print method
		cart.print();
		
		cart.sort();
		
		cart.print();
		
	}
}	
