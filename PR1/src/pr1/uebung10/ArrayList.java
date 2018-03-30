package pr1.uebung10;

import pr.MakeItSimple.PRException;

public class ArrayList implements OrderedList {
	private Song[] Liste;

	public ArrayList() {
		this.Liste = new Song[0];
	}

	@Override
	public void insert(Song song) {
		if (this.Liste.length == 0) {
			this.Liste = new Song[1];
			Liste[0] = song;
		} else {
			String newSong = song.getSongName();
			boolean positionFound = false;
			int position = 0;
			// Sucht die position auf der der Neue song gespeichert werden muss
			for (int j = 0; j < Liste.length && !positionFound; j++) {
				boolean previousPositionSame = true;
				for (int i = 0; i < newSong.length() && !positionFound; i++) {
					// falls erster oder vorheriger buchstabe kleiner
					if (newSong.charAt(i) < Liste[j].getSongName().charAt(i) && previousPositionSame) {
						positionFound = true;
						position = j;
					}
					// falls Buchstabe groesser
					else if (newSong.charAt(i) > Liste[j].getSongName().charAt(i)) {
						previousPositionSame = false;
					}
				}
			}
			Song[] helpArray = new Song[Liste.length + 1];
			// falls es diese Position gibt
			if (positionFound) {
				// alle Songs bis neuen
				for (int i = 0; i < position; i++) {
					helpArray[i] = Liste[i];
				}
				helpArray[position] = song;
				// alle Songs nach neuen
				for (int i = position + 1; i < Liste.length+1; i++) {
					helpArray[i] = Liste[i - 1];
				}
				Liste = helpArray;
			} else {
				// fals neue Song an letzter Position ist
				for (int i = 0; i < Liste.length; i++) {
					helpArray[i] = Liste[i];
				}
				helpArray[helpArray.length - 1] = song;
				Liste = helpArray;
			}

		}
	}

	@Override
	public int indexOf(String songName) {
		// guckt ob der song in der Liste enthalten ist
		for (int i = 0; i < Liste.length; i++) {
			if (Liste[i].getSongName().equals(songName)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void delete(int position) throws PRException {
		if (position > Liste.length - 1) {
			throw new PRException("Die Position existiert nicht");
		} else {
			Song[] helpArray = new Song[Liste.length - 1];
			for (int i = 0; i < position; i++) {
				helpArray[i] = Liste[i];
			}
			for (int i = position; i < helpArray.length; i++) {
				helpArray[i] = Liste[i + 1];
			}
			Liste = helpArray;
		}
	}

	@Override
	public int size() {
		return Liste.length;
	}

	@Override
	public Song get(int position) throws PRException {
		if (position > Liste.length - 1) {
			throw new PRException("Die Position existiert nicht");
		}
		return Liste[position];
	}

}
