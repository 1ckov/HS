package pr1.uebung10;

import pr.MakeItSimple.PRException;

public class LinkedList implements OrderedList {

	private ListNode head;

	// public LinkedList() {
	//
	// }

	@SuppressWarnings("unused")
	@Override
	public void insert(Song song) {
		ListNode newNode = new ListNode();
		if (head == null) {
			head = newNode;
		}
		else {
			ListNode nd = head;
			if (nd.getValue().compareTo(song) == 1) {
				newNode.setNext(nd);
				head = newNode;
			}
			else{
				while(true){
					nd.getNext();
					if(nd == null){
						break;
					}
					if(nd.getValue().compareTo(song) == 1){
						newNode.setNext(nd);
						nd = newNode;
					}
					
				}
				
			}
		}
//		} else {
//			currentNode = head.getNext();
//					//sets Song als wert fuer head 
//					newNoad.setValue(head.getValue());
//					head.setValue(song);
//					head.setNext(newNoad);
//				
//			}
//			else {
//				
//				int counter = -1;
//				int stopper = 1;
//
//				// Findet die position unsuren songs
//				while (stopper == 1 && currentNode != null) {
//					stopper = song.compareTo(currentNode.getValue());
//					currentNode = currentNode.getNext();
//					counter++;
//				}
//
//				//// neuen Knoten als erstes Element einfügen
//				if (counter == 0) {
//					ListNode newNode = new ListNode();
//					newNode.setValue(song);
//					newNode.setNext(head);
//					head = newNode;
//				}
//
//				// fuegt song for current song in die liste
//				else if (counter > 0) {
//					ListNode newNode = new ListNode();
//					newNode.setValue(head.getValue());
//					currentNode.setValue(song);
//					newNode.setNext(head.getNext());
//					currentNode.setNext(newNode);
//				}
//
//			}
//		}
	}

	@Override
	public int indexOf(String songName) {
		int index = 0;
		ListNode currentSong = head.getNext();
		// such nach Song

		while (currentSong != null) {

			// falls song geffunden ist
			if (songName.equals(currentSong.getValue().getSongName())) {
				return index;
			}
			// falls nicht
			else {
				currentSong = currentSong.getNext();
				index++;
			}

		}

		return -1;
	}

	@Override
	public void delete(int position) throws PRException {
		ListNode p = head;
		int size = -1;

		// durchlauf die liste
		while (p != null) {
			p = p.getNext();
			size++;
		}

		if (size < position) {
			throw new PRException("Das ist keine gueltige position");
		}
		//enfernt song von 0ten stelle
		if (position == 0) {
			head = head.getNext();
		} else {
			p = head;

			while (position > 1) {
				position--;
				p = p.getNext();
			}

			p.setNext(p.getNext().getNext());
		}
	}

	@Override
	public int size() {
		int count = 0;
		ListNode p = head;
		//zehlt die liste durch
		while (p != null) {
			count++;
			p = p.getNext();
		}

		return count;
	}

	@Override
	public Song get(int position) throws PRException {
		ListNode p = head;
		int size = -1;
		while (p != null) {
			p = p.getNext();
			size++;
		}
		// checked ob position existiert
		if (size < position) {
			throw new PRException("Das ist keine gueltige position");
		}
		// falls der Song an 1 position gehoert
		if (position == 0) {
			p = head;
			return p.getValue();
		}
		// falls der song an position > 0 gehoert
		else {
			p = head;
			for(int i = 0; i < position; i++){
				p = p.getNext();
			}
			return p.getValue();
		}
	}

}
// package pr1.uebung10;
//
// import pr.MakeItSimple.PRException;
//
// public class LinkedList implements OrderedList {
// private ListNode head;
//
// public LinkedList(){
// this.head = null;
// }
// public LinkedList(SongImplementation song){
// this.head = new ListNode(song);
// }
//
//
// @Override
// public void insert(Song song) {
// if(head == null){
// ListNode first = new ListNode((SongImplementation)song);
// head = first;
// }
// else {
// ListNode thisSong = head;
// ListNode newSong = new ListNode((SongImplementation)song);
// int i = 0;
//
// while(thisSong.getNext()!=null){
// if(thisSong.charAt(i) > newSong.getValue().charAt(i)){
//
//
// }
// else if (head.getValue().charAt(i) < newSong.getValue().charAt(i)){
// head.setNext(newSong);
//
// }
// }
// boolean isRunning = true;
// while(isRunning){
// if(thisSong.getNext() != null){
// if(thisSong.compareTo(newSong) > 0){
// thisSong.placeSongInfront(newSong.getSong());
// this.head = newSong;
// isRunning = false;
// }
// else {
// //this Song = b
// //new Song = c
// thisSong = thisSong.getNext();
// }
// }
// else{
// thisSong.placeSongAfter(song);
// }
// }
//
// }
//
// }
//
// @Override
// public int indexOf(String songName) {
// // TODO Auto-generated method stub
// return 0;
// }
//
// @Override
// public void delete(int position) throws PRException {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public int size() {
// // TODO Auto-generated method stub
// return 0;
// }
//
// @Override
// public Song get(int position) throws PRException {
// // TODO Auto-generated method stub
// return null;
// }
//
// }
