

public class Node
{
	private String data;
	private Node parent;
	private Node left;
	private Node right;
	
	public Node(String data, Node parent, Node left, Node right)
	{
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	
	public void addLeft(String data)
	{
		this.left = new Node(data, this, null, null);
	}
	
	public void addRight(String data)
	{
		this.right = new Node(data, this, null, null);
	}
	
	public Node getLeft()
	{
		return this.left;
	}
	
	public Node getRight()
	{
		return this.right;
	}
	
	public String getData()
	{
		return this.data;
	}
	
	public Node getParent()
	{
		return this.parent;
	}
	
	
}