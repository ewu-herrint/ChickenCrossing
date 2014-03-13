
public class MakeResources 
{
	public static Node makeTree()
	{
		Node root = new Node(null, null, null, null); 
		
		root.addLeft(null); 	// 0
		root.addRight(null); 	// 1
		
		// MAKE LEFT BRANCH OF TREE
		Node left = root.getLeft();
		left.addLeft("U"); 		// 00
		left.addRight(null); 	// 01
		
		Node right = left.getRight();
		right.addLeft(null);	// 010
		right.addRight(null); 	// 011
		
		left = right.getLeft();
		left.addLeft("N");		// 0100
		left.addRight("F");		// 0101
		
		right = right.getRight();
		right.addLeft("T");		// 0110
		right.addRight("O");	// 0111
		
		// MAKE RIGHT BRANCH OF TREE
		right = root.getRight();
		right.addLeft("R"); 	// 10
		right.addRight(null); 	// 11
		
		right = right.getRight();
		right.addLeft(null);	// 110
		right.addRight(null); 	// 111
		
		left = right.getLeft();
		left.addLeft("V"); 		// 1100
		left.addRight("W");		// 1101
		
		right = right.getRight();
		right.addLeft("E");		// 1110
		right.addRight("H");	// 1111
		
		
		return root;
	}
	
	public static String[] makeArray()
	{
		String[] array = new String[99];
		array[24] = "mur";
		array[14] = "der!";
		
		return array;
		
	}
}
