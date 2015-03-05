import java.util.Scanner;


public class TowerGame {


	private Tower t1 = new Tower();
	private Tower t2 = new Tower();
	private Tower t3 = new Tower();
	private Tower[] towers = new Tower[3];




	public TowerGame() {
		towers[0] = t1;
		towers[1] = t2;
		towers[2] = t3;

		Disc d3 = new Disc(3);
		Disc d2 = new Disc(2);
		Disc d1 = new Disc(1);
		towers[0].addDisc(d3);
		towers[0].addDisc(d2);
		towers[0].addDisc(d1);
	}

	public void towerGameOn(){
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("=> ");
			String val= input.nextLine().trim();
			if(val.equalsIgnoreCase("quit"))
			{
				break;
			}
			else if(val.equalsIgnoreCase("show"))
			{
				for(int i = 0; i < 3; i++)
				{
					System.out.println("***********");
					System.out.println("");
					Disc curr = towers[i].peek();
					if(curr == null)
					{
						System.out.println("");

					}
					else
					{
						System.out.println(curr.getSize());
						while(curr.getNextDisc() != null)
						{
							curr = curr.getNextDisc();
							System.out.println(curr.getSize());
						}
					}
					System.out.println("***********");
					System.out.println("    " + i + "     ");
					System.out.println("_____________________");
				}
			}
			else if(val.equals("move"))
			{
				System.out.print("please input source tower index: ");
				int val1 = Integer.parseInt(input.nextLine().trim());
				System.out.print("please input destination tower index: ");
				int val2 = Integer.parseInt(input.nextLine().trim());
				Disc d = towers[val1].removeDisc();
				if(towers[val2].addDisc(d))
				{
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("FAILURE");
				}
			}

		}
	}
}

