package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame{
	protected Store store;
	
	public AddItemToStoreScreen(Store store) {
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
		
		JMenuItem viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(btnListener);
		menu.add(viewStore);
		
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
	
	JPanel createHeader() {
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
	
	public abstract JPanel createCenter();
	
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
