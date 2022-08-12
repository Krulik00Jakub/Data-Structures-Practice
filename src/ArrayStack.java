
/**
 * Implementation of a ArrayList<T> interface using an Array.
 * All operations take constant time.
 *
 * copywright 2021-2022 Jakub Krulik
 * @author Jakub
 * 
 * @param <T> Generic type parameter.
 */

public class ArrayStack<T> {
	T[] a;
	int n;
	
	/**
	 * Class constructor for ArrayList<T> interface.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		n = 0;
		a = (T[]) new Object[1];
	} // end of constructor
	
	/**
	 * @return Size of stack
	 */
	public int size() {
		return n;
	} // end of size() method
	
	/**
	 * @param i index of the array
	 * @return element i in a[]
	 */
	public T get(int i) {
		return a[i];
	} // end of get(i) method
	
	/**
	 * @param i the index of the array
	 * @param x the value to be stored at a[i]
	 * @return previous value of a[i]
	 */
	public T set(int i, T x) {
		T y = a[i];
		a[i] = x;
		return y;
	} // end of set(i, x) method
	
	public void push(T x) {
		if (n + 1 >= a.length) {
			resize();
		}
		a[n] = x;
		n++;
	} // end of push() method
	
	/**
	 * Adds new element to the list
	 * @param i the index of the array
	 * @param x the value to be added to a[i]
	 */
	public void add(int i, T x) {
		if (n + 1 > a.length) {
			resize();
		}
		
		for (int j = n; j > i; j--) 
			a[j] = a[j-1];
		a[i] = x;
		n++;
	} // end of add(i, x) method
	
	public void add(T x) {
		add(0, x);
	} // end of add(x) method
	
	/**
	 * Removes element from top of the list
	 * @return value of removed element x
	 */
	public T pop() {
		T x = a[n-1];
		a[n-1] = null;
		n--;
		if (a.length > 3*n) { // used to be >=
			resize();
		}
		return x;
	} // end of pop() method
	
	/**
	 * Removes element a[i] from the list.
	 * @param i
	 * @return element removed from the list
	 */
	public T remove(int i) {
		T x = a[i];
		for (int j = i; j < n-1; j++) {
			a[j] = a[j+1];
		}
		n--;
		if (a.length >= 3*n) resize();
		return x;
	} // end of remove(i) method
	
	public T remove() {
		return remove(0);
	} // end of remove() method
	
	/**
	 * Reverses the contents of the MyArrayList<T>.
	 */
	public void reverse() {
		T x;
		for (int i = 0, j = n; i < j; i++, j--) {
			x = a[i];
			a[i] = a[j];
			a[j] = x;
		}
	} // end of reverse() method
	
	/**
	 * Resizes the list
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		
		/**
		 * Temporary list for resizing.
		 */
		T[] b;
		
		if (a.length < n + 1) {
			b = (T[]) new Object[Math.max(a.length * 2, 1)];
			for (int i = 0; i < n; i++) {
				b[i] = a[i];
			}
		} else if (a.length > 2*n) {
			b = (T[]) new Object[Math.max(a.length/2, 1)];
			for (int i = 0; i < n; i++) {
				b[i] = a[i];
			}
		} else return;
		a = b;
	} // end of resize() method
	
	/**
	 * Resizes the list to specific length.
	 * @param nn the new size of the list
	 */
	@SuppressWarnings("unchecked")
	public void resize(int nn) {
		T[] b = (T[]) new Object[nn];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		a = b;
	} // end of resize() method
	
	/** Clears the list in O(1) time */
	public String clear() {
		String x = print();
		n = 0;
		resize();
		return x;
	} // end of clear() method
	
	public String print() {
		StringBuilder print = new StringBuilder();
		print.append("[");
		for (int i = 0; i < n; i++) {
			print.append(get(i));
			if (i != n-1) {
				print.append(", ");
			}
		}
		print.append("]");
		
		return print.toString();
	} // end of print() method
	
	/**
	 * Tests the data structure.
	 * @param args command line arguments
	 */
	public static void main(String args[]) {
		int m = 100;
		ArrayStack<Integer> q = new ArrayStack<Integer>();
		for (int i = 0; i < m; i++) {
			q.add(i, i);
		}
		
		System.out.println(q.print());
		
		for (int i = 0; i < m; i++) {
			System.out.println(q.remove(0));
		}
	} // end of main() method
	
} // end of class ArrayList
