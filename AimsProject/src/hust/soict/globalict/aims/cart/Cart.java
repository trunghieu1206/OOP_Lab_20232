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
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.print("Ordered Items:");
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.print("\n" + (i + 1) + ". " + itemsOrdered[i].toString());
		}
		System.out.println("\n***************************************************");
	}
	
	public void searchByID(int ID) {
		if(ID > qtyOrdered) {
			System.out.println("\nNo match found!");
			return;
		}
		System.out.println("\n***********************CART***********************");
		System.out.println("Searched results for id: " + ID);
		StringBuilder str = new StringBuilder();
		str.append("DVD - ");
		str.append(itemsOrdered[ID].getTitle());
		str.append(" - ");
		str.append(itemsOrdered[ID].getCategory());
		str.append(" - ");
		str.append(itemsOrdered[ID].getDirector());
		str.append(" - ");
		str.append(itemsOrdered[ID].getLength());
		str.append(": ");
		str.append(itemsOrdered[ID].getCost());
		System.out.println(str.toString());
		System.out.println("***************************************************");
	}
	
	public void searchByTitle(String title) {
		int found = -1;
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].isMatch(title)) {
				found = 1;
				str.append("\nDVD - ");
				str.append(itemsOrdered[i].getTitle());
				str.append(" - ");
				str.append(itemsOrdered[i].getCategory());
				str.append(" - ");
				str.append(itemsOrdered[i].getDirector());
				str.append(" - ");
				str.append(itemsOrdered[i].getLength());
				str.append(": ");
				str.append(itemsOrdered[i].getCost());
			}
		}
		if(found == -1) {
			System.out.println("No match found!");
			return;
		}
		System.out.println("\n***********************CART***********************");
		System.out.print("Searched results for Title: " + title);
		System.out.println(str.toString());
		System.out.println("***************************************************");
	}
	
}
