public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	String finalStmt = "";
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private void parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		// Reading: Math-Expr
		
		//read a var name
		//read a math_expr
		
		char[] charArray = theStmt.toCharArray();
		System.out.println("Reading Left: ");

		for(int i = 0; i < charArray.length; i++)
		{
			

			parse_math_expr(charArray[i]);
		}
		
		System.out.println(finalStmt);
		
	}
	
	private void parse_math_expr(char c)
	{
		//Display
		//Reading Left:
		//Read OP = *
		//Reading Right
		
		//read left
		//read op
		//read right
		
		
		switch (c)
		{
		case '+':
			System.out.println("Reading OP:" + c);
			System.out.println("Reading Right");
			 finalStmt += c;
			 break;
		case '-':
			System.out.println("Reading OP:" + c);
			System.out.println("Reading Right");
			 finalStmt += c;
			 break;
		case '/':
			System.out.println("Reading OP:" + c);
			System.out.println("Reading Right");
			 finalStmt += c;
			 break;
		case '*':
			System.out.println("Reading OP:" + c);
			System.out.println("Reading Right");
			 finalStmt += c;
			 break;
		case '=':
			System.out.println("Reading OP:" + c);
			System.out.println("Reading Right");
			System.out.println("Reading Left");
			 finalStmt += c;
			 break;
		case '(':
			System.out.println("Reading OP:" + c);
			 finalStmt += c;
			 break;
		case ')':
			System.out.println("Reading OP:" + c);
			 finalStmt += c;
			 break;
		case ' ':
			 break;
		default:
			System.out.println("Reading var:" + c);
			 finalStmt += c;
			break;
			 
		}
		
	}
}
