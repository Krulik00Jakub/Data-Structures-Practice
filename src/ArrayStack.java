public class ArrayStack<T> {
	private T[] a;
	private int n;
	
	/**
	 * Constructs a new array of T with five elements.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		a = (T[]) new Object[2];
		n = 0;
	}
	
	/**
	 * Constructs a new array of T with i elements.
	 * @param i number of elements to initialise the list with
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int i) {
		a = (T[]) new Object[i];
		n = 0;
	}
	
	/**
	 * @return n the size of the array
	 */
	public int size() {
		return n;
	} // end of size() method
	
	/**
	 * Gets the value stored at index i of array a.
	 * @param i the index of the array
	 * @return a[i] the value stored
	 */
	public T get(int i) {
		return a[i];
	} // end of get(i) method
	
	/**
	 * Sets element i of array a to the value x.
	 * @param i index of array
	 * @param x value to be stored
	 * @return y value previously stored at a[i]
	 */
	public T set(int i, T x) {
		T y = a[i];
		a[i] = x;
		return y;
	} // end of set(i, x) method
	
	/**
	 * Inserts an element to the index i, moving all elements above
	 * it up by 1.
	 * @param i index of array
	 * @param x value to be stored
	 */
	public void add(int i, T x) {
		
		/*
		 * If the capacity of the list is 1 less than the number of 
		 * elements stored, more space is created in the list.
		 */
		if (n + 1 > a.length) {
			resize();
		}
		
		/*
		 * If the element to be added is smaller than the length of
		 * the list, elements from i until n are shifted up by 1.
		 */
		for (int j = n; j > i; j--) {
			a[j] = a[j-1];
		}
		
		a[i] = x;
		n++;
	} // end of add(i, x) method
	
	/**
	 * Removes an element with index i from the array.
	 * @param i the index of the element to be removed
	 * @return x the element that was removed
	 */
	public T remove(int i) {
		T x = a[i];
		for (int j = i; j < n-1; j++) {
			a[j] = a[j+1];
		}
		
		if (a.length > 3*n) {
			resize();
		}
		n--;
		return x;
	} // end of remove() method
	
	/**
	 * Shrinks the array if the capacity is 3 times larger than the
	 * size of the stack and grows the array if the capacity is 1
	 * larger than the size.
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] b;
		
		if (a.length < n + 1) {
			b = (T[]) new Object[Math.max(a.length * 2, 1)];
			for (int i = 0; i < n; i++) {
				b[i] = a[i];
			}
		} else if (a.length > 3*n) {
			b = (T[]) new Object[Math.max(a.length/2, 1)];
			for (int i = 0; i < n; i++) {
				b[i] = a[i];
			}
		} else {
			return;
		}
		a = b;
	} // end of resize() method
	
	public static void main(String[] args) {
		ArrayStack<Integer> q = new ArrayStack<Integer>();
		q.add(0, 1);
		q.add(1, 2);
		q.add(2, 3);
		q.add(3, 4);
		
		System.out.println(q.get(0));
		System.out.println(q.get(1));
		System.out.println(q.get(2));
		System.out.println(q.get(3));
		
		q.add(0, 8);
		
		for (int i = q.size(); i > 0; i--) {
			System.out.println(q.remove(i-1));
		}
		
		System.out.println("\nSize: " + q.size());
	}
	
} // end of class ArrayStack<T>
