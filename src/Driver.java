
public class Driver {
	public static void main(String[] args) {
		BinaryTree<Integer> t = new BinaryTree<>();
		Position<Integer> r = t.addRoot(15);
		Position<Integer> lr = t.addLeft(7, r);
		Position<Integer> rr = t.addRight(9, r);
		Position<Integer> llr = t.addLeft(3, lr);
		Position<Integer> rlr = t.addRight(4, lr);
		
		System.out.println(t);
	}
}
