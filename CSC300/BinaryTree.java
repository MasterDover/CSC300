public class BinaryTree 
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private BinaryTree parentTree;
	private int depth;

	public BinaryTree()
	{
		this(0, null);
	}

	private BinaryTree(int depth, BinaryTree bT)
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.parentTree = bT;
		this.depth = depth;
	}

	public boolean search(int value)
	{
		//return true if value is in the tree
		//return false if value is not in the tree
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			if(this.payload == value)
			{
				return true;
			}
			else
			{
				if(value < payload)
				{
					//check the left
					if(this.leftTree == null)
					{
						return false;
					}
					else
					{
						return this.leftTree.search(value);
					}
				}
				else
				{
					//check the right
					if(this.rightTree == null)
					{
						return false;
					}
					else
					{
						return this.rightTree.search(value);
					}
				}
			}
		}
	}

	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}

	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}
	}

	private void visitPreOrder()
	{
		System.out.println(this.payload);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}

	public void displayPreOrder()
	{
		System.out.println("**** Pre Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
	}

	private void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload);
	}

	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
		}
	}

	private int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}

	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			//boolean-expr?true-val:false-val
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}
	}
	private void rotateRight()
	{
		if(this.parentTree.parentTree.parentTree !=null)
		{
			this.parentTree.parentTree.parentTree.rightTree = this.parentTree;
			this.parentTree.leftTree = this.parentTree.parentTree;
			this.parentTree.parentTree.rightTree = null;
			this.parentTree.parentTree = this.parentTree.parentTree.parentTree;
			this.parentTree.leftTree.parentTree = this.parentTree;

		}
		else
		{
			this.parentTree.leftTree = this.parentTree.parentTree;
			this.parentTree.parentTree.rightTree = null;
			this.parentTree.parentTree = null;
			this.parentTree.leftTree.parentTree = this.parentTree;

		}
		this.parentTree.depth--;
		this.parentTree.leftTree.depth++;

	}
	private void rotateLeft()
	{
		if(this.parentTree.parentTree.parentTree !=null)
		{
			this.parentTree.parentTree.parentTree.leftTree = this.parentTree;
			this.parentTree.rightTree = this.parentTree.parentTree;
			this.parentTree.parentTree.leftTree = null;
			this.parentTree.parentTree = this.parentTree.parentTree.parentTree;
			this.parentTree.rightTree.parentTree = this.parentTree;

		}
		else
		{
			this.parentTree.rightTree = this.parentTree.parentTree;
			this.parentTree.parentTree.leftTree = null;
			this.parentTree.parentTree = null;
			this.parentTree.rightTree.parentTree = this.parentTree;

		}
		this.parentTree.depth--;
		this.parentTree.rightTree.depth++;
	}


	public void add(int value)
	{
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree(this.depth+1, this);	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1, this);
				}
				this.rightTree.add(value);
			}

		}


		if(this.depth >=2)
		{
			if(!(this.parentTree.parentTree.isBalanced()))
			{
				if(this.parentTree.rightTree == null)
				{
					if(this.parentTree.parentTree.rightTree == this.parentTree)
					{
						this.parentTree.parentTree.rightTree = this;
						this.parentTree.leftTree = null;
						this.rightTree = this.parentTree;
						this.parentTree = this.rightTree.parentTree;
						this.rightTree.parentTree = this;

						this.depth--;
						this.rightTree.depth++;

						rotateRight();
					}
					else
					{
						rotateRight();
					}
				}
				if(this.parentTree.leftTree == null)
				{
					if(this.parentTree.parentTree.leftTree == this.parentTree)
					{
						this.parentTree.parentTree.leftTree = this;
						this.parentTree.rightTree = null;
						this.leftTree = this.parentTree;
						this.parentTree = this.leftTree.parentTree;
						this.leftTree.parentTree = this;

						this.depth--;
						this.rightTree.depth++;
						
						rotateLeft();
					}
					else
					{
						rotateLeft();
					}
				}
			}
		}
	}
}
