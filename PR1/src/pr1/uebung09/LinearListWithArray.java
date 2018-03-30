package pr1.uebung09;

import static pr.MakeItSimple.println;

import pr.MakeItSimple.PRException;

public class LinearListWithArray {
	private int[] list;

	/**
	 * Constructor
	 */
	public LinearListWithArray() {
		this.list = new int[0];
	}

	/**
	 * Adds the data at the first postion of the array;
	 * 
	 * @param number
	 *            - Int Value
	 */
	void addFirst(int number) {
		// if array is empty;
		if (this.list.length == 0) {
			this.list = new int[1];
			this.list[0] = number;
		}
		// if not;
		else {
			// create array sized + 1;
			int[] helpArray = new int[list.length + 1];
			helpArray[0] = number;
			// copies the content from the old array to the new one;
			for (int i = 1; i < helpArray.length; i++) {
				helpArray[i] = list[i - 1];
			}
			list = helpArray;
		}

	}

	/**
	 * Adds the data at the last postion of the array;
	 * 
	 * @param number
	 *            - Int value;
	 */
	void addLast(int number) {
		// if array is empty;
		if (this.list.length == 0) {
			this.list = new int[1];
			this.list[0] = number;
		}
		// if not;
		else {
			// creates an array with size + 1;
			int[] helpArray = new int[list.length + 1];
			helpArray[list.length] = number;
			// copies the content of the old array;
			for (int i = 0; i < list.length; i++) {
				helpArray[i] = list[i];
			}
			list = helpArray;
		}

	}

	/**
	 * Returns the first member of the List;
	 * 
	 * @return - Int Value;
	 */
	int getFirst() {
		// if list is empty;
		if (this.list.length == 0) {
			throw new PRException("Liste ist leer");
		}
		// else retrun the first element;
		else {
			return list[0];
		}

	}
	/**
	 * Returns the last member of the array;
	 * @return - Int value;
	 */
	int getLast() {
		//if list is empty;
		if (this.list.length == 0) {
			throw new PRException("Liste ist leer");
		}
		//else return last element;
		else {
			return list[list.length - 1];
		}

	}
	/**
	 * Returns a member at the given position;
	 * @param position - The position of the member you want returned;
	 * @return - Int value;
	 */
	int getAt(int position) {
		//if list is to short;
		if (this.list.length <= position) {
			throw new PRException("Liste hat nicht genügend Elemente");
		}
		//if the position is invalid;
		else if (position < 0) {
			throw new PRException("keine negativen Zahlen");
		}
		//else return the Element;
		return list[position];
	}
	/**
	 * Removes the first element of the list;
	 */
	void removeFirst() {
		//if List is empty;
		if (this.list.length == 0) {
			throw new PRException("Liste ist leer");
		}
		//copy the leftover elements into new Array;
		int[] hilfsArray = new int[list.length - 1];
		for (int i = 0; i < hilfsArray.length; i++) {
			hilfsArray[i] = list[i + 1];
		}
		list = hilfsArray;
	}
	/**
	 * Checks the list for a given Element;
	 * @param number - The number you want found;
	 * @return - True if the Element exists in the list / false if not;
	 */
	boolean contains(int number) {
		//Searches array for element;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == number) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Delets an element from the given list
	 * @param number - The element you want removed;
	 */
	void delete(int number) {
		//checks if the lsit is empty;
		if (this.list.length == 0) {
			throw new PRException("Liste ist leer");
		}
		//Checks if the element exists
		int firstPosition = -1;
		int i = 0;
		while (i < list.length && firstPosition == -1) {
			if (list[i] == number) {
				firstPosition = i;

			}
			i++;
		}
		//if so delets it and copies the leftofver content;
		int[] helpArray = new int[list.length - 1];
		if (firstPosition != -1) {
			for (int k = 0; k < firstPosition; k++) {
				helpArray[k] = list[k];
			}
			for (int j = firstPosition; j < helpArray.length; j++) {
				helpArray[j] = list[j + 1];
			}
			list = helpArray;
		}
		//if not throws an exception;
		else {
			throw new PRException("Das Element Wurde nicht gefunden;");
		}

	}
	/**
	 * Delets all the content from the given list;
	 */
	void clear() {
		this.list = new int[0];
	}
	/**
	 * Checks if the list is empty;
	 * @return - True if so / False if not;
	 */
	boolean isEmpty() {
		return !(this.list.length > 0);
	}
	/**
	 * Returns the size of the array;
	 * @return - Int value;
	 */
	int size() {
		return this.list.length;
	}
	/**
	 * Makes a clone of the given list;
	 */
	@Override
	public LinearListWithArray clone() {
		LinearListWithArray clone = new LinearListWithArray();
		clone.list = new int[this.size()];
		for (int i = 0; i < this.size(); i++) {
			clone.list[i] = this.list[i];
		}
		return clone;
	}
	/**
	 * Returns an empty list;
	 * @return - LinearListWithArray;
	 */
	public LinearListWithArray empty() {
		LinearListWithArray liste = new LinearListWithArray();
		return liste;
	}

	public static void main(String[] args) {
		LinearListWithArray list = new LinearListWithArray();
		list.addFirst(3);
		list.addFirst(2);
		list.addLast(4);
		list.addFirst(1);
		LinearListWithArray list2 = list.clone();
		// list.delete(2);
		// list.clear();
		println(list.size());
		for (int i = 0; i < list2.list.length; i++) {
			println(list2.list[i]);
		}
	}

}
