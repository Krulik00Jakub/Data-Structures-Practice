

/**
 * Implementation of DualArrayDeque using ArrayStacks to create two backing arrays.
 *
 * copyright 2020-2021 Jakub Krulik
 * @author Jakub Krulik 3509416
 *
 * @param <T> Type parameter for the type of object to be stored in the DualArrayDeque.
 */
public class DualArrayDeque<T> {
	
	ArrayStack<T> back; // back of the DualArrayDeque
	ArrayStack<T> front; // front of the DualArrayDeque
	
	public DualArrayDeque() {
		back = new ArrayStack<T>();
		front = new ArrayStack<T>();
	}
	
	/**
	 * Size function for DualArrayDeque
	 * @return The size of the DualArrayDeque
	 */
	public int size() {
		return front.size() + back.size();
	} // end of size()
	
	/**
	 * Gets the data value stored at index i.
	 * @param i index of the DualArrayDeque
	 * @return data value stored at a[i]
	 */
	public T get(int i) {
		if (i < front.size()) {
			return front.get(front.size() - i - 1);
		} else { // else if (i > front.size())
			return back.get(i - front.size());
		}
	} // end of get(i) 
	
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
	} // end of set(i, x)
	
	/**
	 * Adds a new data value after index i.
	 * @param i the index of the DualArrayDeque
	 * @param x the data value to be added to the array
	 */
	public void add(int i, T x) {
		if (i <= front.size()) {
			front.add(front.size() - (i), x);
		} else {
			back.add(i - front.size(), x);
		}
		
		if (front.size() + 1 < back.size() || back.size() + 1 < front.size()) {
			balance();
		}
	} // end of add(i, x)
	
	/**
	 * Removes data value at index i and decrements the list.
	 * @param i the index of the DualArrayDeque
	 * @return the removed data value x
	 */
	public T remove(int i) {
		T x;
		if (i < front.size()) {
			x = front.remove(front.size() - i);
		} else {
			x = back.remove(i - front.size() - 1);
		}
		return x;
	} // end of remove(i)
	
	/**
	 * Ensures that both sides of the DualArrayDeque are storing +/- the same amount of data.
	 */
	private void balance() {
		/*
		 * The number of elements to be shifted from back to front or
		 * vice versa.
		 */
		int shift = Math.abs(front.size() - back.size()) / 2;
		
		/*
		 * This part is executed if back is much larger than front.
		 */
		if (front.size() + 1 < back.size()) {
			
			for (int i = shift; i > 0; i--) {
				front.add(0, back.remove(0));
			}
			
		/* 
		 * This part is executed if front is much larger than back.
		 */	
		} else if (back.size() + 1 < front.size()) {			
			
			for (int i = shift; i > 0; i--) {
				back.add(0, front.remove(0));
			}
			
		} else ;
		
	} // end of balance()
	
	/**
	 * main() method, where the DualArrayDeque is tested for functionality.
	 */
	public static void main(String[] args) {
		DualArrayDeque<Integer> q = new DualArrayDeque<Integer>();
		
		/*
		 * Adds 100 integers to q.
		 */
		for (int i = 0; i < 100; i++) {
			q.add(i, i);
		}
		
		/*
		 * Prints all data stored in q
		 */
		System.out.print("[");
		for (int i = 0; i < 100; i++) {
			System.out.print(" " + q.get(i) + ",");
		}
		System.out.println("]");
		
		DualArrayDeque<Integer> a = new DualArrayDeque<Integer>();
		a.add(0, 1);
		a.add(1, 2);
		System.out.println(a.get(0));
		System.out.println(a.get(1));
	} // end of main()

} // end of class DualArrayDeque
