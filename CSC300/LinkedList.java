public class LinkedList 

{
	//change
	private Node head;
	private int count;

	public LinkedList()
	{
		this.head = null;
		this.count = 0;
	}

	public int get(int index)
	{
		int count = this.count();
		if(index >= count || index < 0)
		{
			System.out.println("Illegal Index");
			return -1;
		}
		else
		{
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}

	public int count()
	{
		return this.count;
	}

	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
	}

	public void addAtIndex(int payload, int index)
	{
		Node n = new Node(payload);
		if(index <= 0 || index > count){
			if(index <= 0){
				this.addFront(payload);
			} else {
				this.addEnd(payload);
			}
		}
		else
		{
			Node after = head;
			Node before = head;
			for(int i = 0; i < index-1; i++)
			{
				before = before.getNextNode();
			}
			for(int i = 0; i < index; i++)
			{
				after = after.getNextNode();
			}
			n.setNextNode(after);
			before.setNextNode(n);
			count++;
		}
		
	}

	public void addFront(int payload)
	{
		Node n = new Node(payload);
		n.setNextNode(head);
		head = n;
		this.count++;
	}

	public void addEnd(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			//find the last node in the list
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			//currNode will point to the very last Node in the list
			currNode.setNextNode(n);
		}
		this.count++;
	}
}