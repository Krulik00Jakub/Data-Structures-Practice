import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree<T extends Comparable<T>> {
	@SuppressWarnings("hiding")
	public static class Node<T extends Comparable<T>> {
		
		T x;
		
		Node<T> parent;
		Node<T> left;
		Node<T> right;
		
		public int compareTo(Node<T> u) {
			return this.x.compareTo(u.x);
		}
		
		public Node(T x) {
			this.x = x;
			
		}
	}
	
	/**
	 * Index of the root node
	 */
	Node<T> r; 
	
	/**
	 * null node
	 */
	Node<T> nil;
	
	/**
	 * Number of elements in the tree
	 */
	int n;
	
	public BinaryTree() {
		r = nil;
		n = 0;
	}
	
	/**
	 * appends elements to the tree in order
	 * @param x
	 */
	public void add(T x) {
		
		Queue<Node<T>> q = new LinkedList<>();
		
		n++;
		
		if (r != nil) {
			q.add(r);
		} else {
			r.x = x;
			return;
		}
		
		while (!q.isEmpty() ) {
			Node<T> u = q.remove();
			if (u.left != nil) {
				q.add(u.left);
			} else {
				u.left.x = x;
				return;
			}
			if (u.right != nil) {
				q.add(u.right);
			} else {
				u.right.x = x;
				return;
			}
		}
	} // end of add(x) method;
	/*
	public T remove() {
	      if (u == nil) return -1;
	      return 1 + Math.max(height(u.left), height(u.right));
	}
  */
}
