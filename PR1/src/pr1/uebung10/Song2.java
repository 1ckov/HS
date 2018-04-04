package pr1.uebung10;

import pr.MakeItSimple.PRException;
import pr1.uebung07.StringExtension;

public class Song2 implements Song {
	private final String SongName;
	private final String AlbumName;
	private final String[] Artists;
	/**
	 * Constructor
	 * @param song - An array with the song data;
	 */
	public Song2(String song) {
		//if object isn ull
		if(song == null){
			throw new PRException("The String is null");
		}
		else if(song.length() < 5){
			throw new PRException("String to short");
		}
		String[]storage = StringExtension.split(song, ';');
		SongName = storage[0];
		AlbumName = storage[1];
		if(storage.length < 4){
			Artists = new String[1];
			Artists[0] = storage[2]; 
		}
		else{
			Artists = new String[(storage.length - 2)];
			for (int i = 2; i < storage.length; i++) {
				Artists[i-2] = storage[i];
			}
		}
	}

	@Override
	public String getSongName() {
		return this.SongName;
	}

	@Override
	public String getAlbumName() {
		return this.AlbumName;
	}

	@Override
	public String[] getArtists() {
		return this.Artists;
	}

	@Override
	public String toString() {
		String songInfo = "";
		String artistsHelp = "";

		for (int i = 0; i < Artists.length; i++) {
			if (i < Artists.length - 1) {
				artistsHelp += Artists[i] + " & ";
			}
			else {
				artistsHelp += Artists[i];
			}
		}

		songInfo = "Song Name: " + this.SongName + "\n" + "Artist Name:  " + artistsHelp + "\n" + "Album Name: "
				+ this.AlbumName + " ";
		return songInfo;

	}

	@Override
	public int compareTo(Song o) {
		// return this.toString().compareTo(o.toString());
		String otherSong = o.getSongName();
		String thisSong = this.getSongName();
		for (int i = 0; i < otherSong.length(); i++) {
			// if current is closer to A;
			if (thisSong.charAt(i) < otherSong.charAt(i)) {
				return -1;
			}
			// if Current is closer to Z;
			else if (thisSong.charAt(i) > otherSong.charAt(i)) {
				return 1;
			}
		}
		return 0;

	}

}
