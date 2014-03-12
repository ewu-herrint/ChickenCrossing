
public class ChickenCrossing {

	public static void main(String[] args) 
	{
		Node root = new Node(null, null, null, null);
		
		root.addLeft("Left");
		root.addRight("Right");
		
		System.out.println(root.getLeft().getData());
		System.out.println(root.getRight().getData());
	}

}
