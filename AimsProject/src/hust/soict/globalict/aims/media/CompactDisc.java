package hust.soict.globalict.aims.media;

import java.util.*;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
		super(id, title, category, director, length, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("\n" + track.getTitle() + " already exist, cannot add!");
		}
		tracks.add(track);
		System.out.println("\nSuccessfully added " + track.getTitle() + "!");
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.out.println("\n" + track.getTitle() + " does not exist, cannot remove!");
		}
		tracks.remove(track);
		System.out.println("\nSuccessfully removed " + track.getTitle() + "!");
	}
	
	public int getLength() {
		int sumLength = 0;
		for(Track track : tracks) {
			sumLength += track.getLength();
		}
		return sumLength;	
	}
	
	public String play() throws PlayerException{
		if(this.getLength() > 0) {
			StringBuilder str = new StringBuilder("");
			str.append("\nCD is containing ");
			str.append(this.tracks.size());
			str.append(" tracks");
			
			if(this.tracks.size() == 0) {
				JOptionPane.showMessageDialog(null, str);
				return str.toString();
			}
			
			str.append("\nPlaying each track one by one");
			
			for(Track track : this.tracks) {
				str.append("\n*Playing track: ");
				str.append(track.getTitle());
				str.append(track.getInformationToPlay());
				
				System.out.println("*Playing track: " + track.getTitle());
				track.play();
			}
			
			str.append("\nCD finished playing");
			return str.toString();
		}
		else {
			throw new PlayerException("ERROR: DVD Length is non-positive");
		}
		
		
	}
	
	public boolean isMatch(String title) {
		if(this.getTitle().toLowerCase().contains(title.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		str.append("CD - ");
		str.append(this.getTitle());
		str.append(" - ");
		str.append(this.getCategory());
		str.append(" - ");
		str.append(this.getDirector());
		str.append(" - ");
		str.append(this.getLength());
		str.append(": ");
		str.append(this.getCost());
		return str.toString();
	}
}
