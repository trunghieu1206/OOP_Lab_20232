package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public int addDigitalVideoDiscs(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full! Cannot add");
			return 0;
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
		return 1;
	}
	
	public int removeDigitalVideoDiscs(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			System.out.println("Your cart is empty, cannot remove!");
			return 0;
		}
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("Successfully removed DVD \"" + disc.getTitle() + "\"!");
				return 1;
			}
		}
		System.out.println("No DVD match!");
		return 0;
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}
