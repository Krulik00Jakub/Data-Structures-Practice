
public class BTTraversals<T extends Comparable<T>> extends BinaryTree<T> {
	public Node<T> getNode(T x, Node<T> u) {
		
		if (r == nil) {
			throw new Error("Binary Tree is empty");
		}
		if (u == nil) {
			throw new Error("X does not exist within the tree");
		}
		
		if (u.x == x) {
			/*
			while (true) {
				if (u.left != nil) {
					return u.left.x;
				} else if (u.right != nil) {
					return u.right.x;
				} else {
					u = u.parent.right; // switches to the next branch of the tree
				}
			}*/
			
			return u;
		}
		
		if (x.compareTo(u.x) <= 0) {
			return getNode(x, u.left);
		} else {
			return getNode(x, u.right);
		}
	} // end of preOrderGetNode(x, u) method
	
	public T preOrderNext(T x) {
		Node<T> u = getNode(x, r);
		/*
		while (u.right != nil) {
			if (u.left != nil) {
				u = u.left;
			} else if (u.right != nil) {
				return u.right.x;
			} else {
				u = u.parent.right; // switches to the next branch of the tree
			}
		}*/
		
		Node<T> prev = u;
		
		if (u.left != nil) {return u.left.x;}
		else {
			while (u != nil) {
				u = u.parent;
				
				if (prev == u.left && u.right != nil) {
					return u.right.x;
				}
				prev = u;
			}
			throw new Error("u.next does not exist");
		}
		
		
	} // end of preOrderNext(x) method
	
	/**
	 * static function prints the element after x in pre-order.
	 * @param args
	 */
	public static void preOrderNext() {
        BTTraversals<Integer> tree = new BTTraversals<Integer>();
        tree.r = new Node<>(3);
        
        tree.r.left = new Node<Integer>(1);
        tree.r.right = new Node<Integer>(5);
        tree.r.left.parent = tree.r;
        tree.r.right.parent = tree.r;
        
        
        tree.r.left.left = new Node<Integer>(0);
        tree.r.left.right = new Node<Integer>(2);
        tree.r.left.left.parent = tree.r.left;
        tree.r.left.right.parent = tree.r.left;
        
        
        tree.r.right.left = new Node<Integer>(4);
        tree.r.right.right = new Node<Integer>(6);
        tree.r.right.left.parent = tree.r.right.right.parent = tree.r.right;
        
        
        System.out.println("The element in the tree after element 4 in pre-order traversal is: "+tree.preOrderNext(4));
        System.out.println();
	}
}
