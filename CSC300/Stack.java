public class Stack
{

	private Node tail;
	
	public Stack()
	{
		tail = null;
	}
	
	public void add(int payload)
	{
		Node n = new Node(payload);
		if(this.tail == null)
		{
			this.tail = n;
		}
		else
		{
			n.setPrevNode(this.tail);
			this.tail.setNextNode(n);
			this.tail = n;
		}
		
	}
	
	public void peek() throws Exception
	{
		if(tail == null)
		{
			throw new Exception("Can Not Display End: Empty List");
		}
		System.out.println(tail.getPayload());
		
	}
	
	public void pop() throws Exception
	{
		if(tail == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		int num = tail.getPayload();
		tail = tail.getPrevNode();
		System.out.println(num);
		
	}
	
}
