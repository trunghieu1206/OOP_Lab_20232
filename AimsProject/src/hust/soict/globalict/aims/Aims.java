package hust.soict.globalict.aims;

import java.util.*;
import java.io.*;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;

public class Aims{
	public static void showMenu() {
		System.out .println("\nAIMS main menu: ");
		System.out .println("--------------------------------");
		System.out .println("1. View store");
		System.out .println("2. Update store");
		System.out .println("3. See current cart");
		System.out .println("0. Exit");
		System.out .println("--------------------------------");
		System.out .println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out .println("\nStore Options: ");
		System.out .println("--------------------------------");
		System.out .println("1. See a media’s details");
		System.out .println("2. Add a media to cart");
		System.out .println("3. Play a media");
		System.out .println("4. See current cart");
		System.out .println("0. Back");
		System.out .println("--------------------------------");
		System.out .println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("\nMedia Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out .println("Options: ");
		System.out .println("--------------------------------");
		System.out .println("1. Filter media in cart");
		System.out .println("2. Sort media in cart");
		System.out .println("3. Remove media from cart");
		System.out .println("4. Play a media");
		System.out .println("5. Place order");
		System.out .println("0. Back");
		System.out .println("--------------------------------");
		System.out .println("Please choose a number: 0-1-2-3-4-5");
		}
	
	public static void chooseFilterOptions() {
		System.out.println("Filter options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number 1-2");
	}
	
	public static void chooseSortOptions() {
		System.out.println("Sort options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number 1-2");
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		Scanner keyboard = new Scanner(System.in);
		String level = "menu";
		int choice = 0;
		Media searchedItem = null;
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King",
				"Animation",
				"Roger Allers",
				87,
				19.95f
		);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				50,
				24.95f
		);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
				"Aladin",
				"Animation",
				"Guy Ritchie",
				20,
				18.99f
		);
		store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(
				"Alibaba",
				"Animation",
				"Somebody",
				34,
				50.0f
		);
		store.addMedia(dvd4);
		
		Book book1 = new Book(
				"Treasure Islands",
				"Adventure",
				99.9f
		);
		
		book1.addAuthor("Robert");
		book1.addAuthor("Louis");
		book1.addAuthor("Stevenson");
		
		store.addMedia(book1);
		
		do{
			if(level.equals("menu")) {
				showMenu();
				choice = keyboard.nextInt();
				
				switch(choice) {
					case 0:
						level = "start";
						
						break;
					case 1:
						store.print();
						level = "storeMenu";
						
						break;
					case 2:
						System.out.println("Please choose ");
						
						break;
					case 3:
						cart.print();
						level = "cartMenu";
						
						break;
					default:
						System.out.println("Invalid choice, please choose again");
						
						break;
				}
			}
			else if(level.equals("storeMenu")) {
				storeMenu();
				choice = keyboard.nextInt();
				
				switch(choice) {
					case 0:
						level = "menu";
						break;
					case 1:
						System.out.println("Please enter the title you want to search: ");
						String userChooseTitle1 = keyboard.nextLine();
						userChooseTitle1 = keyboard.nextLine();
						searchedItem = store.search(userChooseTitle1);
						
						if(searchedItem == null) {
							System.out.println("No match found for '" + userChooseTitle1 + "'!");
						}
						else {
							System.out.println("\n***********************Store**********************");
							System.out.println("Searched results for Title: " + userChooseTitle1);
							System.out.println(searchedItem.toString());
							System.out.println("***************************************************");
							level = "mediaMenu";
						}
						
						break;
					case 2:
						System.out.println("Please enter the title of the Media to add to Cart");
						keyboard.nextLine();
						String userChooseTitle2 = keyboard.nextLine();
						searchedItem = store.search(userChooseTitle2);
						
						if(searchedItem != null) {
							cart.addMedia(searchedItem);
							System.out.println("Item successfully added to Cart!");
							System.out.println("Cart now contains " + cart.numberOfItems() + " item(s)");
							level = "storeMenu";
						}
						else {
							System.out.println("Cannot find any items with the title '" + userChooseTitle2 + "'!");
							level = "storeMenu";
						}
						
						break;
					case 3:
						System.out.println("Please enter the title of the Media to play: ");
						keyboard.nextLine();
						String userChooseTitle3 = keyboard.nextLine();
						searchedItem = store.search(userChooseTitle3);
						
						if(searchedItem instanceof DigitalVideoDisc) {
							DigitalVideoDisc playableSearchedItem = (DigitalVideoDisc) searchedItem;
							playableSearchedItem.play();
						}
						else if(searchedItem instanceof CompactDisc) {
							CompactDisc playableSearchedItem = (CompactDisc) searchedItem;
							playableSearchedItem.play();

						}
						else  if(searchedItem != null){
							System.out.println("\n" + searchedItem.getTitle() + " is neither DVD or CD, cannot play!");
						}
						else {
							System.out.println("\nCannot find any item with title '" + userChooseTitle3 + "'!");
						}
						
						break;
					case 4:
						cart.print();
						
						break;
					default:
						System.out.println("Invalid choice, please choose again");
						
						break;
				}
			}
			else if(level.equals("mediaMenu")) {
				mediaDetailsMenu();
				choice = keyboard.nextInt();
				
				switch(choice) {
					case 0:
						level = "storeMenu";
						
						break;
					case 1:
						System.out.println("Please enter the title of the Media appearing on your screen to confirm adding to Cart");
						keyboard.nextLine();
						String userChooseTitle = keyboard.nextLine();
						
						if(searchedItem.getTitle().equals(userChooseTitle)) {
							cart.addMedia(searchedItem);
							System.out.println("Item successfully added to Cart!");
							System.out.println("Cart now contains " + cart.numberOfItems() + " item(s)");
							level = "storeMenu";
						}
						else {
							System.out.println("Title is not correct");
							level = "storeMenu";
						}
						
						break;
					case 2:
						if(searchedItem instanceof DigitalVideoDisc) {
							DigitalVideoDisc playableItem = (DigitalVideoDisc) searchedItem;
							playableItem.play();
						}
						else if(searchedItem instanceof CompactDisc) {
							CompactDisc playableItem = (CompactDisc) searchedItem;
							playableItem.play();
						}
						else {
							System.out.println("\n" + searchedItem.getTitle() + " is not a DVD or a CD, cannot play!");
						}
						
						break;
					default:
						System.out.println("Invalid choice, please choose again");
						break;
				}
			}
			else if(level.equals("cartMenu")) {
				cartMenu();
				choice = keyboard.nextInt();
				
				switch(choice) {
					case 0:
						level = "menu";
						
						break;
					case 1:
						chooseFilterOptions();
						choice = keyboard.nextInt();
						
						if(choice == 1) {
							int userChooseID = keyboard.nextInt();
							cart.searchByID(userChooseID);
						}
						else if(choice == 2) {
							keyboard.nextLine();
							String userChooseTitle = keyboard.nextLine();
							cart.searchByTitle(userChooseTitle);
						}
						else {
							System.out.println("\nInvalid choice");
						}
						
						break;
					case 2:
						chooseSortOptions();
						choice = keyboard.nextInt();
						
						if(choice == 1) {
							cart.sortByTitle();
						}
						else if(choice == 2) {
							cart.sortByCost();
						}
						else {
							System.out.println("\nInvalid choice");
						}
						
						break;
					case 3:
						System.out.println("Enter the title of the Media you want to remove: ");
						keyboard.nextLine();
						String userChooseTitle = keyboard.nextLine();
				}
			}
		} while(choice != 0 || !level.equals("start"));
		System.out.println("\nApp exitted");
		keyboard.close();
		System.exit(0);;
		
	}
	
}