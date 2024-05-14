package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		JLabel type;
		
		ButtonListener btnListener = new ButtonListener();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		if(media instanceof Book) {
			type = new JLabel("(Book)");
			type.setFont(new Font(type.getFont().getName(), Font.PLAIN, 15));
			type.setAlignmentX(CENTER_ALIGNMENT);
			
		}
		else if(media instanceof DigitalVideoDisc) {
			type = new JLabel("(DVD)");
			type.setFont(new Font(type.getFont().getName(), Font.PLAIN, 15));
			type.setAlignmentX(CENTER_ALIGNMENT);
		}
		else {
			type = new JLabel("(CD)");
			type.setFont(new Font(type.getFont().getName(), Font.PLAIN, 15));
			type.setAlignmentX(CENTER_ALIGNMENT);
		}
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);	
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(btnListener);
			container.add(playButton);
		}
		
		
		this.add(Box.createVerticalGlue());
		this.add(type);
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Play")){
				if(media instanceof DigitalVideoDisc) {
					DigitalVideoDisc toPlay = (DigitalVideoDisc) media;
					toPlay.play();
				}
				else {
					CompactDisc toPlay = (CompactDisc) media;
					toPlay.play();
				}
			}
		}
	}
}
