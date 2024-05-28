package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public String play() {
		StringBuilder str = new StringBuilder("");
		str.append("Playing " + this.getTitle());
		return str.toString();
		}
	
	public String getInformationToPlay() {
		StringBuilder str = new StringBuilder("");
		str.append("\nPlaying Track: ");
		str.append(this.getTitle());
		str.append("\nTrack length: ");
		str.append(this.getLength());
		return str.toString();
	}
	
	public boolean equals(Track track) {
		if(this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength()){
			return true;
		}
		return false;
	}
}
