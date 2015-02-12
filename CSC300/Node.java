
public class Node {

	private int payload;
	private Node nextNode;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
	}

	
	public int getPayload() {
		return payload;
	}

	public void setPayload(int payload) {
		this.payload = payload;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
