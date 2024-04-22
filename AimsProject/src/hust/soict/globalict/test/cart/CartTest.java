package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.cart.Cart;

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
		cart.addDigitalVideoDiscs(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				87,
				24.95f
		);
		cart.addDigitalVideoDiscs(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
				"Aladin",
				"Animation",
				18.99f
		);
		cart.addDigitalVideoDiscs(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(
				"Alibaba",
				"Animation",
				50.0f
		);
		cart.addDigitalVideoDiscs(dvd4);
		
		
		//Test the print method
		cart.print();
		
		//Test the search method by ID
		cart.searchByID(0);
		
		//Test the search method by Title
		cart.searchByTitle("Al");
		
	}
}	
