public class BinaryTree 
{
	private Node root;
	
	public BinaryTree()
	{
		this.root = null;
	}
	
	public void displayPostOrder()
	{
		System.out.println("**** In Order ****");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			displayPostOrder(root);
		}
	}
	public void displayPostOrder(Node n)
	{
		if(n == null)
		{
			return;
		}
		else
		{
			displayPostOrder(n.getLeftNode());
			displayPostOrder(n.getRightNode());
			
			System.out.println(n.getPayload());
		}
	}
	
	public void displayInOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			displayInOrder(root);
			System.out.println();
		}
	}
	public void displayInOrder(Node n)
	{
		if(n == null)
		{
			return;
		}
		else
		{
			displayInOrder(n.getLeftNode());
			System.out.println(n.getPayload());
			displayInOrder(n.getRightNode());
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		if(this.root == null)
		{
			this.root = theNode;
		}
		else
		{
			this.root.addNode(theNode);
		}
		
	}
}
