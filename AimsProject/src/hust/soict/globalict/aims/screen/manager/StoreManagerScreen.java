package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		ButtonListener btnListener = new ButtonListener();
		JMenu menu = new JMenu("Options");
		
		menu.add(new JMenuItem("View Store"));
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(btnListener);
		smUpdateStore.add(addBook);
		
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(btnListener);
		smUpdateStore.add(addCD);
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(btnListener);
		smUpdateStore.add(addDVD);

		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
		
	}
	
	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
		
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 4, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		
		for(Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media);
			center.add(cell);
		}
		
		return center;
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		
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
		
		store.addMedia(book1);
		
		CompactDisc cd1 = new CompactDisc(
				6,
				"A CD",
				"cd",
				"Hieu",
				50,
				99.9f,
				"hieu"
		);
		cd1.addTrack(new Track("track 1", 5));
		cd1.addTrack(new Track("track 2", 6));
		store.addMedia(cd1);
		
		new StoreManagerScreen(store);
		
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("View Store")) {
				dispose();
				new StoreManagerScreen(store);
			}
			else if(button.equals("Add DVD")) {
				dispose();
				new AddDigitalVideoDiscToStoreScreen(store);
			}
			else if(button.equals("Add CD")){
				dispose();
				new AddCompactDiscToStoreScreen(store);
			}
			else if(button.equals("Add Book")) {
				dispose();
				new AddBookToStoreScreen(store);
			}
			
		}
	}
	
}
