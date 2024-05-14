package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField tfId;
	private JTextField tfTitle;
	private JTextField tfCategory;
	private JTextField tfDirector;
	private JTextField tfLength;
	private JTextField tfCost;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}
	
	public JPanel createCenter() {
		ButtonListener btnListener = new ButtonListener();
		
		JPanel center = new JPanel();
		
		center.setLayout(new GridLayout(7, 2));
		
		
		JLabel enterId = new JLabel("Enter the ID of the CD:", SwingConstants.CENTER);
		enterId.setFont(new Font(enterId.getFont().getName(), Font.PLAIN, 15));
		enterId.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterId);
		
		tfId = new JTextField(10);
		center.add(tfId);
		
		JLabel enterTitle = new JLabel("Enter the Title of the CD:", SwingConstants.CENTER);
		enterTitle.setFont(new Font(enterTitle.getFont().getName(), Font.PLAIN, 15));
		enterTitle.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterTitle);
		
		tfTitle = new JTextField(50);
		center.add(tfTitle);
		
		JLabel enterCategory = new JLabel("Enter the Category of the CD:", SwingConstants.CENTER);
		enterCategory.setFont(new Font(enterCategory.getFont().getName(), Font.PLAIN, 15));
		enterCategory.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterCategory);
		
		tfCategory = new JTextField(50);
		center.add(tfCategory);
		
		JLabel enterDirector = new JLabel("Enter the Director of the CD:", SwingConstants.CENTER);
		enterDirector.setFont(new Font(enterDirector.getFont().getName(), Font.PLAIN, 15));
		enterDirector.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterDirector);
		
		tfDirector = new JTextField(10);
		center.add(tfDirector);
		
		JLabel enterLength = new JLabel("Enter the Length of the CD:", SwingConstants.CENTER);
		enterLength.setFont(new Font(enterLength.getFont().getName(), Font.PLAIN, 15));
		enterLength.setAlignmentX(CENTER_ALIGNMENT);
		center.add(enterLength);
		
		tfLength = new JTextField(50);
		center.add(tfLength);
		
		JLabel enterCost = new JLabel("Enter the Cost of the CD:", SwingConstants.CENTER);
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
				String director = tfDirector.getText();
				int length = Integer.parseInt(tfLength.getText());
				float cost = Float.parseFloat(tfCost.getText());
				
				DigitalVideoDisc toAddDVD = new DigitalVideoDisc(id, title, category, director, length, cost);
				
				store.addMedia(toAddDVD);
				
				JOptionPane.showMessageDialog(null, "DVD added successfully");
			}
		}
	}
}
