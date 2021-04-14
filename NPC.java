/** This class is for the NPC player and is called
 * and used within the main game play and in the
 * scenarios class.
 * 
 */
import java.util.*;

public class NPC 
{
	/** These variables are protected and static so that
	 * there is only one instance of them, making however
	 * they were manipulated in other classes affected
	 * in this class.
	 * 
	 */
	protected static String npcName;
	protected static int npcLives;
	protected static boolean npcFollowing, npcTalkedTo;
	protected static Scanner input = new Scanner(System.in);
	/** This empty constructor takes the protected variables
	 * from about and sets them equal to an empty string,
	 * 0, or false based on their data type.
	 * 
	 */
	public NPC()
	{
		npcName = "";
		npcLives = 0;
		npcFollowing = false;
		npcTalkedTo = false;
	}
	/** This static Introduction method is the method called from
	 * Closet. Therefore this is what is first executed from that class.
	 * This Introduction method uses multiple if and else statements that are chosen 
	 * based on the user input. If the user answers a certain way, they will either
	 * be directing to a certain method in this class or will will call a different
	 * class that will then be run. It is all in a while loop that will continue 
	 * to loop through as long as the user does not choose to go to a different room. 
	 * If this happens, then the loop will be set to false, until they enter the
	 * room again. The inner if and else statements use the .contains function to 
	 * determine what should be called or executed. It also allows the user to misspell 
	 * some of their input, but it is not preferred because if they misspell the 
	 * beginning what they are trying to execute will not be run.
	 * 
	 */
	public static void NPCIntroduction()
	{
		boolean npcLoop = true;
		while (npcLoop == true)
		{
			System.out.print("\nThe guy looks up to you and introduces himself as " + npcName + ".\nHe says he has been stuck in the cage for a while after he tried to escape.\n\nYou can ask him if he will COME WITH you, WHERE some objects are, or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("CO") || choice.contains("WI"))
			{
				System.out.print("\n" + npcName + " will now follow you around the house. He currently has " + npcLives + " lives.");
				npcFollowing = true;
			}
			else if (choice.contains("OB"))
			{
				System.out.print("\n" + npcName + " wants to know what objct you want to know more \nabout: car, flashlight, baseball bat, computer code, or door handle.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("CA"))
				{
					System.out.print("\n" + NPC.npcName + ": I believe you already know this, but the car is in the garage\nand will need to car keys, car engine, and gas container. I don't know where\nthose objects are but they are definitely in the house.");
				}
				else if (choice.contains("FL"))
				{
					System.out.print("\n" + NPC.npcName + ": Flashlight? Maybe that goes with the computer?.");
				}
				else if (choice.contains("BA"))
				{
					System.out.print("\n" + NPC.npcName + ": I think that is used in the garage. Last I checked it was hidden underneath something.");
				}
				else if (choice.contains("CO"))
				{
					System.out.print("\n" + NPC.npcName + ": Oh yeah that is found on the computer and opens a safe. I'm not sure where the safe is at though.");
				}
				else if (choice.contains("DO"))
				{
					System.out.print("\n" + NPC.npcName + ": The door handle goes to the garage. It's how you can get to the car.\nI think it is still hidden in the back of the refridgerator where I left it.");
					npcTalkedTo = true;
				}
			}
			else if (choice.contains("LO") ||choice.contains("EL"))
			{
				npcLoop = false;
			}
		}
	}
	/** This static loseLife method will be called in the Scenarios
	 * class and uses an if and else statement to make the NPC
	 * lose a life, and will make them stop following the user
	 * when they run out of lives.
	 * 
	 */
	public static void loseLife()
	{
		if (npcLives > 0)
		{
			npcLives--;
			System.out.println(npcName + " lose a life.");
			System.out.println(npcName + " now has " + npcLives + " lives.");
		}
		if (npcLives == 0)
		{
			System.out.print("\n" + npcName + " ran out of lives. " + npcName + " will no longer be following you.\n");
			npcFollowing = false;
		}
	}
	/** This getter returns the string name of 
	 * the NPC character.
	 * 
	 * @return
	 */
	public static String getNpcName() 
	{
		return npcName;
	}
	/** This setter is called in the GameApplication
	 * main method and will set the npc's name equal
	 * to the parameter.
	 * 
	 * @param npcName
	 */
	public static void setNpcName(String npcName) 
	{
		NPC.npcName = npcName;
	}
	/** This getter returns the integer value of the
	 * npc's lives.
	 * 
	 * @return
	 */
	public static int getNpcLives() 
	{
		return npcLives;
	}
	/** This setter is called in the GameAppllication
	 * main method and will set the np's lives equal
	 * to the parameter.
	 * 
	 * @param npcLives
	 */
	public static void setNpcLives(int npcLives) 
	{
		NPC.npcLives = npcLives;
	}
}
