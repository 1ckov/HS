package pr1.uebung10;

import pr.MakeItSimple.PRException;

public class LinkedList implements OrderedList {

	private ListNode head;

	public LinkedList() {
	}

	@Override
	public void insert(Song song) {
		if (head == null) {
			// if list is empty
			ListNode n = new ListNode(song, null);
			head = n;
		}
		else {
			ListNode n = head;
			// if head has to be changed
			if (song.compareTo(n.getValue()) < 1) {
				ListNode newNode = new ListNode(song, n);
				head = newNode;

			}
			else {
				while ((n.getNext() != null) && (song.compareTo(n.getValue()) > 0)) {
					n = n.getNext();
				}
				// if new node is the last node
				if (n.getNext() == null) {
					if (song.compareTo(n.getValue()) < 1) {
						ListNode newNode = new ListNode(n.getValue(), null);
						n.setValue(song);
						n.setNext(newNode);
					}
					else {
						ListNode newNode = new ListNode(song, null);
						n.setNext(newNode);
					}
					// create ListNode element

				}
				// if new node is somewhere in list
				else {
					// create new Node with
					ListNode newNode = new ListNode(n.getValue(), n.getNext());
					n.setValue(song);
					n.setNext(newNode);
				}
			}
		}
	}

	@Override
	public int indexOf(String songName) {
		int index = 0;
		ListNode currentSong = head;
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
		int size = this.size();
		if (size <= position) {
			throw new PRException("Das ist keine gueltige position");
		}
		// removes head
		if (position == 0) {
			head = head.getNext();
		}
		else {
			//start at head 
			ListNode p = head;
			int counter = position;
			//stops one position before the node that needs to go
			while (counter > 1) {
				counter--;
				p = p.getNext();
			}
			//if we are deleting the last node
			if (position == size - 1) {
				p.setNext(null);
			}
			//if the deletion has to happen somewhere along the list
			else {
				p.setNext(p.getNext().getNext());
			}
		}
	}

	@Override
	public int size() {
		int count = 0;
		ListNode p = head;
		// if list is empty
		if (head == null) {
			return 0;
		}
		//else goes thru all elements until it reaches null
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
		// Checks the existence of the position
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
			for (int i = 0; i < position; i++) {
				p = p.getNext();
			}
			return p.getValue();
		}
	}

}
