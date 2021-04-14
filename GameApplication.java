/** This class has a main method where the 
 * game will be executed and played.
 * 
 */
import java.util.*;
import java.io.*;

public class GameApplication 
{
	/** This main method is where the game is executed and the 
	 * rules are displayed. It creates an instance of the Bedroom
	 * class (where that class will be used to call the others
	 * classes). There is also a while loop that allows the 
	 * user to replay the game if they finish or run out of lives.
	 * 
	 * @param args
	 * @throws InventoryException
	 */
	public static void main(String[] args) throws InventoryException
	{
		Scanner input = new Scanner(System.in);
		
		Bedroom myBedroom = new Bedroom();
		Kitchen myKitchen = new Kitchen();
		Scenarios scenarios = new Scenarios();
		Garage myGarage = new Garage();
		Player myPlayer = new Player();
		NPC myNPC = new NPC();
		
		boolean loop = true;
		boolean rules = true;
		boolean game = true;
		
		System.out.print("Welcome to the Escape Room! Would you like to play? ");
		String answer = input.nextLine().toUpperCase();
		
		if (answer.contains("Y"))
		{
			rules = true;
		}
		else if (answer.contains("N"))
		{
			game = false;
			rules = false;
		}
		
		while (game == true)
		{
			System.out.print("\nDo you want to play on EASY, MEDIUM, or HARD?\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("EA"))
			{
				myPlayer.setPlayerLives(8);
				myNPC.setNpcLives(6);
				myNPC.setNpcName("Marshall");
			}
			else if (choice.contains("ME"))
			{
				myPlayer.setPlayerLives(5);
				myNPC.setNpcLives(4);
				myNPC.setNpcName("Ted");
			}
			else if (choice.contains("HA"))
			{
				myPlayer.setPlayerLives(3);
				myNPC.setNpcLives(2);
				myNPC.setNpcName("Barney");
			}
			
			while (rules == true)
			{
				System.out.println("\n***********************************************************************************************");
				System.out.println("1) You will receive a series of text based scenarios where you should \nrespond by typing the capitalized instructions followed by \nthe object or direction.\nExample:\tGO north\n\t\tCHECK dresser\n\t\tLOOK elsewhere");
				System.out.println("2) The goal is to find the car keys, car engine, and gas container and put them into the \ncar in order to escape from the garage.");
				System.out.println("3) You will have " + Player.playerLives + " lives, and there will be multiple encounters \nthat could cost you a life, so choose carefully.");
				System.out.println("4) Please respond to the scenarios with a yes or no.");
				System.out.println("5) The NPC character, " + NPC.npcName + ", will have " + NPC.npcLives + " lives, but will be helpful throughout the game.");
				System.out.println("6) Throughout the house there are 2 spots where you can drop items.\nIf you drop them, they will return to their original spot for you to pick them up later.\nSome objects though that are constantly being used will be immediately dropped from your inventory when used.\nBe careful though because once these items are used you cannot access them again.");
				System.out.println("\nYou are about to begin. Be careful...");
				System.out.println("***********************************************************************************************\n");
				rules = false;
			}
			while (game == true)
			{
				myBedroom.Introduction();
			}
		}
		input.close();
	}
}
