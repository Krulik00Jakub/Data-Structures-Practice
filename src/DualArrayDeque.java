
/**
 * Implementation of DualArrayDeque<T> using ArrayList<T> to create two backing arrays.
 * @author Jakub
 *
 * @param <T>
 */
public class DualArrayDeque<T> extends ArrayList<T> {
	
	ArrayList<T> back;
	ArrayList<T> front;
	
	/**
	 * Size function for DualArrayDeque
	 * @return The size of the DualArrayDeque
	 */
	public int size() {
		return front.size() + back.size();
	}
	
	/**
	 * Gets the data value stored at index i.
	 * @param i index of the DualArrayDeque
	 * @return data value stored at a[i]
	 */
	public T get(int i) {
		if (i < front.size()) {
			return front.get(front.size() - i - 1);
		} else {
			return back.get(i-front.size());
		}
	}
	
	/**
	 * Sets the data value at index i, to x.
	 * @param i index of the DualArrayDeque
	 * @param x data value to be stored
	 * @return the data value that is stored at index i
	 */
	public T set(int i, T x) {
		if (i < front.size()) {
			return front.set(front.size() - i - 1, x);
		} else {
			return back.set(i - front.size(), x);
		}
	}
	
	/**
	 * Adds a new data value after index i - 1.
	 * @param i the index of the DualArrayDeque
	 * @param x the data value to be added to the array
	 */
	public void add(int i, T x) {
		if (i < front.size()) {
			front.add(front.size() - i, x);
		} else {
			back.add(i - front.size(), x);
		}
		balance();
	}
	
	/**
	 * Removes data value at index i and decrements the list.
	 * @param i the index of the DualArrayDeque
	 * @return the removed data value x
	 */
	public T remove(int i) {
		T x;
		if (i < front.size()) {
			x = front.remove(front.size() - i - 1);
		} else {
			x = back.remove(i - front.size());
		}
		return x;
	}
	
	/**
	 * Constructor method used by instance methods to create temporary lists.
	 * @return abstract structure ArrayList<T>
	 */
	protected ArrayList<T> newStack() {
		return new ArrayList<T>();
	}
	
	/**
	 * Ensures that both sides of the DualArrayDeque<T> are storing +- the same amount of data.
	 */
	private void balance() {
		int n = size();
		
		/** this part is executed if back is much larger than front */
		if (3*front.size() < back.size()) {
			int s = n/2 - front.size();
			ArrayList<T> l1 = newStack();
			ArrayList<T> l2 = newStack();
			
			/** adds the first half of the elements in the DualArrayDeque to l1 */
			for (int i = 0; i < s; i++) {
				l1.add(i, front.get(i)); //NOT FINISHED
			}
			
			l1.reverse();
			
			/** adds all of the elements in the front array to l1 */
			for (int i = 0; i < front.size(); i++) {
				l1.add(front.size() + i, front.get(i));
			}
			
			/** adds the remaining elements in back, to l2 */
			for (int i = s; i < back.size(); i++) {
				l2.add(i, back.get(i));
			}
			
			front = l1;
			back = l2;
			
		/** this part is executed if front is much larger than back */	
		} else if (3*back.size() < front.size()) {
			int s = front.size() - n/2;
			ArrayList<T> l1 = newStack();
			ArrayList<T> l2 = newStack();
			
			/** adds the second half of front to l1 */
			for (int i = s; i < front.size(); i++) {
				l1.add(i, front.get(i));
			}
			
			/** adds the first half of front to l2 */
			for (int i = 0; i < s; i++) {
				l2.add(i, front.get(i));
			}
			
			l2.reverse();
			
			/** appends back to the end of l2 */
			for (int i = 0, j = s; i < back.size(); i++, j++) {
				l2.add(j, back.get(i));
			}
			
			front = l1;
			back = l2;
		}
	}

}
