package package1;

public class Aims{
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"The Lion King", 
				"Animation", 
				"Roger Allers", 
				87,
				19.95f
		);
		anOrder.addDigitalVideoDiscs(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(
				"Star Wars",
				"Science Fiction",
				"George Lucas",
				87,
				24.95f
		);
		anOrder.addDigitalVideoDiscs(dvd2);
		
		DigitalVideoDisc dvd3  = new DigitalVideoDisc(
				"Aladin",
				"Animation",
				"hieu",
				20,
				18.99f
		);
		anOrder.addDigitalVideoDiscs(dvd3);
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		System.exit(0);
	}
}