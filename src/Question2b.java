/**
 * Method swap() of class
 */

public class Question2b<T> extends DLList<T> {

	/** Swaps element x, and next element in the list */
	public boolean swap(int x) {
		
		Node<T> previous;
		previous = dummy;

		/** Locates the element before x */
		for (int i = 0; i - 1 != x; i++) {
			previous = previous.next;
		}

		/**
		 * Declares two nodes that store the places of the two list elements to be
		 * swapped
		 */
		Node<T> first;
		first = previous.next;
		Node<T> second;
		second = first.next;

		/** 
		 * Swaps positions of first and second
		 */
		previous.next = second;
		first.next = second.next;
		second.next = first;

		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
