package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import java.util.LinkedList;

public class Store {
	private LinkedList<DigitalVideoDisc> itemsInStore = new LinkedList<DigitalVideoDisc>();
	
	public boolean checkExistenceDVD(DigitalVideoDisc dvd) {
		for(DigitalVideoDisc itemInStore : itemsInStore) {
			if(itemInStore.equals(dvd)) {
				return true;
			}
		}
		return false;
	}
	
	public int addDVD(DigitalVideoDisc dvd) {
		if(this.checkExistenceDVD(dvd)) {
			System.out.println("\n" + dvd.getTitle() + " already exists in the store!");
			return 0;
		}
		itemsInStore.add(dvd);
		System.out.println("\nSuccessfully added " + dvd.getTitle() + " to the store!");
		return 1;
	}
	
	public int removeDVD(DigitalVideoDisc dvd) {
		if(!this.checkExistenceDVD(dvd)) {
			System.out.println("\n" + dvd.getTitle() + " does not exist in the store, cannot remove!");
			return 0;
		}
		itemsInStore.remove(dvd);
		System.out.println("\n" + dvd.getTitle() + " successfully removed from the store!");
		return 1;
	}	
	
	public String toString() {
		StringBuilder str = new StringBuilder("");
		for(DigitalVideoDisc itemInStore : itemsInStore) {
			str.append("\n");
			str.append("DVD - ");
			str.append(itemInStore.getTitle());
			str.append(" - ");
			str.append(itemInStore.getCategory());
			str.append(" - ");
			str.append(itemInStore.getDirector());
			str.append(" - ");
			str.append(itemInStore.getLength());
			str.append(": ");
			str.append(itemInStore.getCost());
		}
		return str.toString();
	}
	
	public void print() {
		System.out.println("\n***********************Store***********************");
		System.out.print("Available DVDs in Store:");
		System.out.println(this.toString());
		System.out.println("***************************************************");
	}
}
