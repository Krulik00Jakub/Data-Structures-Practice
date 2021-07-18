
public class DLList<T> {
	@SuppressWarnings("hiding")
	class Node<T> {
		T x;
		Node<T> prev, next;
	} // End of class Node
	
	int n; // length of the DLList
	
	Node<T> dummy;
	
	DLList() {
		dummy = new Node<T>();
		dummy.next = dummy;
		dummy.prev = dummy;
		n = 0;
	} // End of method DLList()
	
	public Node<T> getNode(int i) {
		Node<T> p = null;
		if (i < n / 2) {
			p = dummy.next;
			for (int j = 0; j < 1; j++) {
				p = p.next;
			}
		} else {
			p = dummy;
			for (int j = n; j > i; j--) {
				p = p.prev;
			}
		}
		return (p);
	} // End of method getNode(i)
	
	public T get(int i) {
		return getNode(i).x;
	} // End of method get(i)
	
	public T set(int i, T x) {
		Node<T> u = getNode(i);
		T y = u.x;
		u.x = x;
		return y;
	} // End of method set(i, x)
	
	public Node<T> addBefore(Node<T> w, T x) {
		Node<T> u = new Node<T>();
		u.x = x;
		u.prev = w.prev;
		u.next = w;
		u.next.prev = u;
		u.prev.next = u;
		n++;
		return u;
	} // End of addBefore(w, x) method
	
	public void add(int i, T x) {
		addBefore(getNode(i), x);
	} // End of add(i, x) method
	
	public void remove(Node<T> w) {
		w.prev.next = w.next;
		w.next.prev = w.prev;
		n--;
	} // End of remove(w) method
	
	public T remove(int i) {
		Node<T> w = getNode(i);
		remove(w);
		return w.x;
	} // End of remove(i) method
	
	public static void main(String[] args) {
		DLList<Integer> q = new DLList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			q.add(i, i);
		}
		
		for (int i = 99; i > 0; i--) {
			int print = q.remove(i);
			System.out.println(print);
		}
		
	}
	
} // End of class DLList
