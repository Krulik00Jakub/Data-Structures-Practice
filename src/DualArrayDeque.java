
/**
 * Implementation of DualArrayDeque<T> using ArrayList<T> to create two backing arrays.
 * copywright 2021-2022 Jakub krulik
 * @author Jakub
 *
 * @param <T> Generic type parameter.
 */
public class DualArrayDeque<T> extends ArrayStack<T> {
	
	ArrayStack<T> back; // back of the DualArrayDeque
	ArrayStack<T> front; // front of the DualArrayDeque
	int n;
	
	public DualArrayDeque() {
		back = new ArrayStack<T>();
		front = new ArrayStack<T>();
		n = 0;
	}
	
	/**
	 * Size function for DualArrayDeque
	 * @return The size of the DualArrayDeque
	 */
	public int size() {
		return n;
	} // end of size()
	
	/**
	 * Gets the data value stored at index i.
	 * @param i index of the DualArrayDeque
	 * @return data value stored at a[i]
	 */
	public T get(int i) {
		if (i < front.size()) {
			return front.get(front.size()-i-1);
		} else {
			return back.get(i-front.size());
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
			return front.set(front.size()-i-1, x);
		} else {
			return back.set(i - front.size(), x);
		}
	} // end of set(i, x)
	
	/**
	 * Adds a new data value after index i - 1.
	 * @param i the index of the DualArrayDeque
	 * @param x the data value to be added to the array
	 */
	public void add(int i, T x) {
		if (i <= front.size()) {
			front.add(front.size()-i, x);
		} else {
			back.add(i-front.size(), x);
		}
		n++;
		balance();
	} // end of add(i, x)
	
	public void push(T x) {
		front.add(front.size(), x);
		n++;
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
			x = front.remove(front.size()-i-1);
		} else {
			x = back.remove(i - front.size());
		}
		n--;
		return x;
	} // end of remove(i)
	
	
	/**
	 * Constructor method used by instance methods to create abstract lists.
	 * @return abstract structure ArrayList<T>
	 */
	protected ArrayStack<T> newStack() {
		return new ArrayStack<T>();
	} // end of newStack()
	
	
	/**
	 * Ensures that both sides of the DualArrayDeque<T> are storing +- the same amount of data.
	 */
	private void balance() {
		int shift = Math.abs(front.size() - back.size()) / 2; // the number of elements to be shifted from back to front or vice versa
		
		if (front.size() > back.size()*3) {
			for (int i = shift; i > 0; i--) {
				back.add(front.remove());
			}

		} else if (back.size() > front.size()*3) {
			for (int i = shift; i > 0; i--) {
				front.add(back.remove());
			}
		}
		
	} // end of balance()
	
	@Override
	public String print() {
		StringBuilder print = new StringBuilder();
		print.append("[");
		for (int i = 0; i < size(); i++) {
			print.append(get(i));
			if (i != size()-1) {
				print.append(", ");
			}
		}
		print.append("]");
		
		return print.toString();
	} // end of method print()
	
	public static void main(String[] args) {
		DualArrayDeque<Integer> q = new DualArrayDeque<Integer>();
		
		for (int i = 0; i < 100; i++) {
			q.add(i, i);
		}
		
		System.out.println("front.size: " + q.front.size());
		System.out.println("back.size: " + q.back.size());
		
		System.out.println("Size: " + q.size());
		
		System.out.println(q.print());
		
		System.out.println();
		
		for (int i = 99; i >= 0; i--) {
			System.out.println(q.remove(i));
		}
		
		
	} // end of main()

} // end of class DualArrayDeque
