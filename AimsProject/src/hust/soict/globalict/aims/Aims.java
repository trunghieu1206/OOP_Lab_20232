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
	
	public static void chooseUpdateOptions() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a Media");
		System.out.println("2. Remove a Media");
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
				1,
				"The Lion King",
				"Animation",
				"Roger Allers",
				87,
				19.95f
		);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				2,
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				50,
				24.95f
		);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(
				3,
				"Aladin",
				"Animation",
				"Guy Ritchie",
				20,
				18.99f
		);
		store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc(
				4,
				"Alibaba",
				"Animation",
				"Somebody",
				34,
				50.0f
		);
		store.addMedia(dvd4);
		
		Book book1 = new Book(
				5,
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
					case 0: //exit the program
						level = "start";
						
						break;
					case 1: //view store
						store.print();
						level = "storeMenu";
						
						break;
					case 2: //update store 
						chooseUpdateOptions();
						
						
						break;
					case 3: //see current cart
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
					case 0: //back to main menu
						level = "menu";
						
						break;
					case 1: //see a media's details 
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
					case 2: //add a media to Cart
						System.out.println("Please enter the title of the Media to add to Cart");
						keyboard.nextLine();
						String userChooseTitle2 = keyboard.nextLine();
						searchedItem = store.search(userChooseTitle2);
						
						//if Media exists in store
						if(searchedItem != null) {
							//if Media has not been in the Cart
							if(cart.addMedia(searchedItem)) {
								System.out.println("Item successfully added to Cart!");
								System.out.println("Cart now contains " + cart.numberOfItems() + " item(s)");
								level = "storeMenu";
							}
							//if Media has been put in the Cart before
							else {
								System.out.println("Cannot order this Item");
								level = "storeMenu";
							}
							
						}
						//if Media not exists in store
						else {
							System.out.println("Cannot find any items with the title '" + userChooseTitle2 + "'!");
							level = "storeMenu";
						}
						
						break;
					case 3: //Play a media
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
							System.out.println("\n" + searchedItem.getTitle() + " is neither DVD nor CD, cannot play!");
						}
						else {
							System.out.println("\nCannot find any item with title '" + userChooseTitle3 + "'!");
						}
						
						break;
					case 4: //See current Cart
						cart.print();
						level = "cartMenu";
						
						break;
					default:
						System.out.println("Invalid choice, please choose again");
						
						break;
				}
			}
			else if(level.equals("updateStore")) {
				
			}
			else if(level.equals("mediaMenu")) {
				mediaDetailsMenu();
				choice = keyboard.nextInt();
				
				switch(choice) {
					case 0: //back to storeMenu
						level = "storeMenu";
						
						break;
					case 1: //Add this Media to Cart
						//if we are at this level then the Media definitely exists in Store
						
						//if Media has not been in the Cart
						if(cart.addMedia(searchedItem)) {
							System.out.println("Item successfully added to Cart!");
							System.out.println("Cart now contains " + cart.numberOfItems() + " item(s)");
							
						}
						//if Media has been put in the Cart before
						else {
							System.out.println("Cannot order this Item");
							
						}
						
						break;
					case 2: //Play this Media
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
					case 0: //back to main menu
						level = "menu";
						
						break;
					case 1: //filter Cart
						chooseFilterOptions();
						choice = keyboard.nextInt();
						
						//filter by ID
						if(choice == 1) {
							System.out.println("Enter the ID you want to filter: ");
							int userChooseID = keyboard.nextInt();
							
							Media resultItem = cart.searchByID(userChooseID);
							if(resultItem != null) {
								System.out.println("\n***********************CART***********************");
								System.out.print("Searched results for id: " + userChooseID);
								StringBuilder str = new StringBuilder();
								str.append("\n");
								str.append(resultItem.toString());
								System.out.println(str.toString());
								System.out.println("***************************************************");
							}
							else {
								System.out.println("\nNo match found for id '" + userChooseID + "'!");
							}
						}
						//filter by Title
						else if(choice == 2) {
							System.out.println("Enter the title you want to filter: ");
							keyboard.nextLine();
							String userChooseTitle = keyboard.nextLine();
							
							Media resultItem = cart.searchByTitle(userChooseTitle);
							
							//if Media exists in Cart
							if(resultItem != null) {
								StringBuilder str = new StringBuilder();
								str.append("\n");
								str.append(resultItem.toString());
								System.out.println("\n***********************CART***********************");
								System.out.print("Searched results for Title: " + userChooseTitle);
								System.out.println(str.toString());
								System.out.println("***************************************************");
							}
							//if Media does not exist in Cart
							else {
								System.out.println("\nNo match found for title '" + userChooseTitle + "'!");
							}
						}
						else {
							System.out.println("\nInvalid choice");
						}
						
						break;
					case 2: //sort Cart
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
					case 3: //Remove Media from Cart
						
						System.out.println("Enter the title of the Media you want to remove: ");
						keyboard.nextLine();
						String userChooseTitle1 = keyboard.nextLine();
						Media removeItem = cart.searchByTitle(userChooseTitle1);
						
						//if Media to be removed exists in Cart
						if(removeItem != null) {
							cart.removeMedia(removeItem);
							
						}
						//if Media to be removed does not exists in Cart
						else {
							System.out.println("\nCannot find Media with title '" + userChooseTitle1 + "'!");
						}
						
						break;
					case 4: //Play a Media in Cart
						System.out.println("Enter the title of the Media to play: ");
						keyboard.nextLine();
						String userChooseTitle2 = keyboard.nextLine();
						Media resultItem = cart.searchByTitle(userChooseTitle2);
						
						if(resultItem instanceof DigitalVideoDisc) {
							DigitalVideoDisc playableItem = (DigitalVideoDisc) resultItem;
							playableItem.play();
						}
						else if(resultItem instanceof CompactDisc) {
							CompactDisc playableItem = (CompactDisc) resultItem;
							playableItem.play();
						}
						else if(resultItem != null){
							System.out.println("\n" + resultItem.getTitle() + " is not a DVD or a CD, cannot play!");
						}
						else {
							System.out.println("\n" + userChooseTitle2 + " cannot be found in the Cart");
						}
						
						break;
					case 5: //Place order 
						System.out.println("Your order has been placed");
						cart.print();
						cart.clearCart();
						
						break;
					default:
						System.out.println("Invalid choice, please choose again");
						break;
				}
			}
		} while(choice != 0 || !level.equals("start"));
		
		System.out.println("\nApp exitted");
		keyboard.close();
		System.exit(0);;
		
	}
	
}