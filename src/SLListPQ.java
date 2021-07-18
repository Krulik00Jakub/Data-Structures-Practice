public class SLListPQ<T extends Comparable<T>> {

	/** 
	 * Defines a Node in the context of an SLList 
	 */
	@SuppressWarnings("hiding")
	class Node<T extends Comparable<T>> {
		T x;
		Node<T> next;
	} // end of class Node

	Node<T> head; // Front of the SLList

	Node<T> tail; // Tail of the SLList

	int n = 0; // Number of elements in the SLList

	/**
	 * Adds elements to the SLList ensuring that they are in the order of smallest
	 * to largest
	 */
	public void add(T x) {
		Node<T> u = new Node<T>();
		u.x = x;
		Node<T> previous = head;
		if (previous != null) {
			while ((previous.x.compareTo(u.x) < 1 && previous.next != null)) { // Error fixed, added "&& previous.next
																				// != null"
				previous = previous.next;
			}
			Node<T> current = previous.next;
			u.next = current;
			previous.next = u;
		} else {
			tail = u;
			head = u;
			previous = head;
		}
		n++; // Increases the list element counter by 1
	} // End of add(x) subroutine

	/**
	 * Deletes the first value from the list and sets the second value to the head
	 */
	public T deleteMin() {
		T x = head.x;
		head = head.next;
		n--; // Decreases the list element counter by 1
		return x;
	} // End of deleteMin() subroutine

	/** 
	 * Returns the first and smallest value of the list 
	 */
	public int size() {
		return n;
	} // End of size() subroutine

	public static void main(String[] args) {
		SLListPQ<Integer> q = new SLListPQ<Integer>();
		for (int i = 0; i < 100; i++) {
			q.add(i);
		}

		for (int i = 100; i > 0; i--) {
			int min = q.deleteMin();
			System.out.println(min);
		}
		System.out.print("It works!!!");

	} // End of main() subroutine
} // End of class SLList
