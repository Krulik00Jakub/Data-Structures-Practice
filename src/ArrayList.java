import java.lang.Math;
import java.lang.reflect.Array;

/**
 * Implementation of a ArrayList<T> interface using an Array
 * 
 * All operations take constant time.
 * @author Jakub
 * 
 * @param <T>
 */

public class ArrayList<T> {
	T[] a;
	int n;
	
	/**
	 * Class constructor for ArrayList<T> interface.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		n = 0;
		a = (T[]) new Object[n];
	}
	
	/**
	 * @return Size of stack
	 */
	public int size() {
		return n;
	}
	
	/**
	 * @param i index of the array
	 * @return element i in a[]
	 */
	public T get(int i) {
		return a[i];
	}
	
	/**
	 * @param i the index of the array
	 * @param x the value to be stored at a[i]
	 * @return previous value of a[i]
	 */
	public T set(int i, T x) {
		T y = a[i];
		a[i] = x;
		return y;
	}
	
	/**
	 * Adds new element to the list
	 * @param i the index of the array
	 * @param x the value to be added to a[i]
	 */
	public void add(int i, T x) {
		if (n + 1 > a.length) {
			resize();
		}
		
		for (int j = n; j > i; j--) {
			a[j] = a[j - 1];
		}
		
		a[i] = x;
		n++;
	}
	
	/**
	 * Removes element from top of the list
	 * @return value of removed element x
	 */
	public T pop() {
		T x = a[n-1];
		a[n-1] = null;
		n--;
		if (a.length >= 3*n) {
			resize();
		}
		return x;
	}
	
	public T remove(int i) {
		T x = a[i];
		for (int j = i + 1; j < n; j++) {
			a[j-1] = a[j];
		}
		n--;
		if (a.length >= 3*n) {
			resize();
		}
		return x;
	}
	
	/**
	 * Reverses the contents of the ArrayList<T>.
	 */
	public void reverse() {
		for (int i = 0, j = n; i != j; i++, j--) {
			T x = a[i];
			a[i] = a[j];
			a[j] = x;
		}
	}
	
	/**
	 * Resizes the list
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] b = (T[]) new Object[Math.max(a.length * 2, 1)];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		a = b;
	}
	
	public static void main(String args[]) {
		int m = 10;
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			q.add(i, i);
		}
		
		System.out.println("");
		System.out.println(q.remove(3));
		System.out.println("");
		for (int i = 8; i >= 0; i--) {
			int print = q.remove(i);
			System.out.println(print);
		}
			
	}
	
}
