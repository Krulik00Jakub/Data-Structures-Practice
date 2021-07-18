
public class SLList<T> {

	@SuppressWarnings("hiding")
	class Node<T> {
		T x;
		Node<T> next;
	} // End of class Node<T>
	
	Node<T> tail;
	Node<T> head;
	int n;
	
	public int size() {
		return n;
	}
	
	public void add(T x) {
		Node<T> u = new Node<T>();
		u.x = x;
		if (n == 0) {
			head = u;
		} else {
			tail.next = u;
		}
		tail = u;
		n++;
	}
	
	public T remove() {
		if (n == 0)	return null;
		T x = head.x;
		head = head.next;
		if (--n == 0) tail = null;
		return x;
	}
	
} // End of class SLList<T>
