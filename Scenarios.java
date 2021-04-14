/** This class will be called many times
 * throughout the game play throughout the 
 * Introduction method.
 * 
 */
import java.util.*;
import java.io.*;

public class Scenarios 
{
	/** These protected and static variables are instantiated
	 * here so that they can be called and manipulated within
	 * this class .
	 * 
	 */
	protected static String answer;
	protected static int line;
	protected static ArrayList<String> scenario = new ArrayList<String>();
	protected static ArrayList<String> escape_yes = new ArrayList<String>();
	protected static ArrayList<String> escape_no = new ArrayList<String>();
	protected static ArrayList<String> lose_yes = new ArrayList<String>();
	protected static ArrayList<String> lose_no = new ArrayList<String>();
	protected static Scanner scan = new Scanner(System.in);
	protected static Random random = new Random();
	/** This static Introduction method begins with a try catch block to determine
	 * if a file is read or not. If the file does not exist, an exception
	 * will be printed. This method reads 5 files, puts them into their array,
	 * and uses Math.random to choose a random line based on the user input.
	 * It will then decide which return and consequences will be shown, 
	 * only subtracting a life and calling the Player and NPC classes
	 * when needed.
	 * 
	 */
	public static void Introduction()
	{
		try
		{
			FileReader fr = new FileReader("Scenarios.txt");
			FileReader yesEscape = new FileReader("Escape_Yes.txt");
			FileReader noEscape = new FileReader("Escape_No.txt");
			FileReader yesLose = new FileReader("Lose_Yes.txt");
			FileReader noLose = new FileReader("Lose_No.txt");
			Scanner input = new Scanner(fr);
			Scanner input1 = new Scanner(yesEscape);
			Scanner input2 = new Scanner(noEscape);
			Scanner input3 = new Scanner(yesLose);
			Scanner input4 = new Scanner(noLose);
			line = 0;
			while (input.hasNextLine())
			{
				line = line + 1;
				scenario.add(input.nextLine());
			}
			while (input1.hasNextLine())
			{
				escape_yes.add(input1.nextLine());
			}
			while (input2.hasNextLine())
			{
				escape_no.add(input2.nextLine());
			}
			while (input3.hasNextLine()) 
			{
				lose_yes.add(input3.nextLine());
			}
			while (input4.hasNextLine()) 
			{
				lose_no.add(input4.nextLine());
			}
			int options = random.nextInt(line);
			System.out.println("\n" + scenario.get(options));
			System.out.print("--> ");
			String choice = scan.nextLine().toUpperCase();
			if (choice.contains("Y"))
			{
				double options1 = Math.random();
				if (options1 < 0.5)
				{
					System.out.println("\n" + escape_yes.get(options));
				}
				else if (options1 >= 0.5)
				{
					System.out.println("\n" + lose_yes.get(options) + "\n");
					Player.loseLife();
					if (NPC.npcFollowing == true)
					{
						NPC.loseLife();
					}
				}
			}
			else if (choice.contains("N"))
			{
				double options2 = Math.random();
				if (options2 < 0.5)
				{
					System.out.println("\n" + escape_no.get(options));
				}
				else if (options2 >= 0.5)
				{
					System.out.println("\n" + lose_no.get(options) + "\n");
					Player.loseLife();
					if (NPC.npcFollowing == true)
					{
						NPC.loseLife();
					}
				}
			}
		}
		catch (FileNotFoundException ex) 
		{
			System.out.println("File Not Found");
		}
	}
}
