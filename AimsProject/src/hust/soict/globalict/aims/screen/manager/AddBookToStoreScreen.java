package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	private JTextField tfId;
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfCost;
	
	public AddBookToStoreScreen(Store store) {
		super(store);
		
	}
	
	public JPanel createCenter() {
		ButtonListener btnListener = new ButtonListener();
		
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(5, 2));
		
		
		JLabel enterId = new JLabel("Enter the ID of the Book:", SwingConstants.CENTER);
		enterId.setFont(new Font(enterId.getFont().getName(), Font.PLAIN, 15));
		enterId.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterId);
		
		tfId = new JTextField(10);
		center.add(tfId);
		
		JLabel enterTitle = new JLabel("Enter the Title of the Book:", SwingConstants.CENTER);
		enterTitle.setFont(new Font(enterTitle.getFont().getName(), Font.PLAIN, 15));
		enterTitle.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterTitle);
		
		tfTitle = new JTextField(50);
		center.add(tfTitle);
		
		JLabel enterCategory = new JLabel("Enter the Category of the Book:", SwingConstants.CENTER);
		enterCategory.setFont(new Font(enterCategory.getFont().getName(), Font.PLAIN, 15));
		enterCategory.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterCategory);
		
		tfCategory = new JTextField(50);
		center.add(tfCategory);
		
		JLabel enterCost = new JLabel("Enter the Cost of the Book:", SwingConstants.CENTER);
		enterCost.setFont(new Font(enterCost.getFont().getName(), Font.PLAIN, 15));
		enterCost.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterCost);
		
		tfCost = new JTextField(50);
		center.add(tfCost);
		
		
		center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(btnListener);
		
		container.add(confirmButton);
		
		center.add(Box.createVerticalGlue());
		center.add(container);
		
		
		return center;
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Confirm")) {
				int id = Integer.parseInt(tfId.getText());
				String title = tfTitle.getText();
				String category = tfCategory.getText();
				float cost = Float.parseFloat(tfCost.getText());
				
				Book toAddBook = new Book(id, title, category, cost);
				
				store.addMedia(toAddBook);
				
				JOptionPane.showMessageDialog(null, "Book added successfully");
			}
		}
	}
}
