
public class BinaryTree <T>{
	private int size;
	private Node<T> root;

	public BinaryTree() {
		size = 0;
		root = null;
	}

	/**
	 * Validates and type casts the position
	 * @param p is the position you want to validate
	 * @return the node that is type casted
	 */
	private Node<T> validatePosition(Position<T> p) {
		if (!(p instanceof Node) || p == null) {
			throw new IllegalArgumentException("Not a position!");
		}
		return (Node<T>) p;
	}

	public Position<T> addRoot(T v) {
		if (root != null) {
			throw new IllegalStateException("Tree is not empty!");
		}
		root = new Node(v, null);
		size++;
		return root;
	}

	/**
	 * Method to add left child
	 * @param v is the value to place in left node
	 * @param p is the position on the tree
	 * @return left node
	 */
	public Position<T> addLeft(T v, Position<T> p){
		Node<T> n = validatePosition(p);
		if (n.left != null) {
			throw new IllegalStateException("Left Child Exists");
		}
		n.left = new Node(v, n);
		size++;
		return n.left;
	}

	/**
	 * Method to add right child
	 * @param v is the value to place in right node
	 * @param p is the position on the tree
	 * @return right node
	 */
	public Position<T> addRight(T v, Position<T> p){
		Node<T> n = validatePosition(p);
		if (n.right != null) {
			throw new IllegalStateException("Left Child Exists");
		}
		n.right = new Node(v, n);
		size++;
		return n.right;
	}

	public Node<T> getLeftChild(Position<T> p){
		Node<T> n = validatePosition(p);
		return n.left;
	}

	public Node<T> getRightChild(Position<T> p){
		Node<T> n = validatePosition(p);
		return n.right;
	}

	public Node<T> getParent(Position<T> p){
		Node<T> n = validatePosition(p);
		return n.parent;
	}
	
	public Position<T> getRoot(){
		return root;
	}
	
	public boolean hasLeft(Position<T> p) {
		Node<T> n = validatePosition(p);
		return n.left != null;
	}
	
	public boolean hasRight(Position<T> p) {
		Node<T> n = validatePosition(p);
		return n.right != null;
	}
	
	public boolean isRoot(Position<T> p) {
		Node<T> n = validatePosition(p);
		return n == root;
	}
	
	public void toString(Node<T> n, StringBuilder sb, int level) {
		if (n != null) {
			for (int i = 0; i < level; i++) {
				sb.append("\t");
			}
			
			//Recursively print the left and right children
			sb.append(n.value + "\n");
			
			toString(n.left, sb, level + 1);
			toString(n.right, sb, level + 1);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(root, sb, 0);
		return sb.toString();
	}
	
	private static class Node<T> implements Position<T>{
		private T value;
		private Node<T> left;
		private Node<T> right;
		private Node<T> parent;
		public Node(T v, Node<T> p) {
			value = v; 
			parent = p;
			left = null;
			right = null;
		}

		public String toString() {
			return value + " ";
		}

		@Override
		public T getValue() {
			return value;
		}
	}

}
