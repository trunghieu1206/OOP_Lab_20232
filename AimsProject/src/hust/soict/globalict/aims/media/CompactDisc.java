package hust.soict.globalict.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
		super(id, title, category, director, length, cost);
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
	
	public void play() {
		System.out.println("\nCD is containing " + tracks.size());
		System.out.println("Playing each track one by one");
		for(Track track : tracks) {
			System.out.println("*Playing track: " + track.getTitle());
			track.play();
		}
		System.out.println("CD finished playing");
	}
}
