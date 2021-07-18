import java.util.*;

public class Question2a<T> extends SLList<T> {
	

	/** 
	 * Swaps element x, and next element in the list
	 */
	public boolean swap(int x) throws IllegalArgumentException {
		
		if (x >= n - 1) {
			throw new IllegalArgumentException("Argument of swap() must be < " + (n-1) + " , the length of the list");
		}

		Node<T> previous;
		previous = head;
		
		
		/** Locates the element before x */
		if (previous != null) {
			for (int i = 0; i + 1 != x; i++) {
				if (previous.next == null) {
					return false;
				} else {
					previous = previous.next;
				}	
			}
		} else {
			;
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
		Question2a<Integer> q = new Question2a<Integer>();
		for (int i = 0; i < 10; i++) {
			q.add(i);
		}
		
		System.out.print("Input the list element to be swapped: ");
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		
		int swapElement = stdin.nextInt();
		
		q.swap(swapElement);

		for (int i = 10; i > 0; i--) {
			int x;
			x = q.remove(); 
			System.out.println(x);
		}
		
	}
}
