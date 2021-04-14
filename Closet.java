/** This class extends the abstract class Rooms and is also
 * able to call and use the variables and methods from that
 * class.
 * 
 * @author morganhardin
 *
 */
public class Closet extends Rooms
{
	/** These private and static variables are instantiated
	 * here so that they can be used and manipulated within 
	 * this class.
	 * 
	 */
	private static boolean boxes, boxesMoved, cage, cageUnlocked;
	private static boolean closet = true;
	protected static boolean roomCloset = true;
	/** This empty constructor takes the private variables along
	 * with the protected variables from the Rooms class and sets
	 * them equal to true or false, depending on how they are first
	 * used in the game. This allows for them to be manipulated
	 * throughout the game.
	 * 
	 */
	public Closet()
	{
		boxes = false;
		boxesMoved = false;
		cage = false;
		cageUnlocked = false;
		closet = true;
		roomCloset = true;
		bedroomKey = false;
	}
	/** This static Introduction method is the method called from
	 * Bedroom. Therefore this is what is first executed from that class.
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
	 * @throws InventoryException
	 */
	public static void Introduction() throws InventoryException
	{
		roomCloset = true;
		while (roomCloset == true)
		{
			if (closet == true)
			{
				System.out.print("\nYou enter the closet for the first time.\nYour eye immediately goes to the cage in the corner, although you cannot \nsee inside due to the boxes in the way.\n\nYou can CHECK the cage or boxes or GO south.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("CA"))
				{
					checkCage();
					closet = false;
				}
				else if (choice.contains("BO"))
				{
					checkBoxes();
					closet = false;
				}
				else if (choice.contains("GO") && choice.contains("SO"))
				{
					closet = false;
					roomCloset = false;
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
					closet = false;
				}
			}
			else
			{
				System.out.print("\nYou go to look through the closet again.\n\nYou can CHECK cage or boxes or GO south.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("CA"))
				{
					checkCage();
				}
				else if (choice.contains("BO"))
				{
					checkBoxes();
				}
				else if (choice.contains("GO") && choice.contains("SO"))
				{
					roomCloset = false;
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
		}
	}
	/** This checkCage method is be called from the Introduction method. There is one
	 * main if and else statement based on if the user as already been to the bed
	 * or not. No matter what, they will still have the same options of being able
	 * to drop an item or going to look elsewhere. Also within this class, the 
	 * scenarios class is called to determine if the user will lose a life or not
	 * based on there answers. The inner if and else statements use the .contains 
	 * function to determine what should be called or executed. It also allows 
	 * the user to misspell some of their input, but it is not preferred because if 
	 * they misspell the beginning what they are trying to execute will not be run.
	 * The method also calls the NPC class and allows the user to free the NPC
	 * player from the cage and follow them, or have them give hints about 
	 * certain items. This method is also static so that if the user leaves the 
	 * room and then comes back, their information will not be reset.
	 * 
	 */
	public static void checkCage()
	{
		if (cage == false && boxesMoved == false)
		{
			System.out.print("\nYou go to check the cage but the boxes are in the way.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				cage = true;
				closet = false;
			}
		}
		else if (cage == false && boxesMoved == true)
		{
			System.out.print("\nYou go to check the cage and the boxes are now moved out of the way\nYou walk up to the cage and see a guy lying inside.\n\nYou can UNLOCK cage or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if (choice.contains("UN") || choice.contains("CA"))
			{
				if (pliers == false)
				{
					System.out.print("\nSomething is stuck in the cage door. Try finding the pliers to fix it.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						closet = false;
						cageUnlocked = false;
					}
				}
				else if (pliers == true)
				{
					System.out.print("\nYou use the pliers to open the cage and walk up to the guy.\n\nYou can TALK to him or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("TA") || choice.contains("TO") || choice.contains("HI"))
					{
						Scenarios.Introduction();
						cage = true;
						cageUnlocked = true;
						NPC.NPCIntroduction();
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						cage = true;
						cageUnlocked = true;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				closet = false;
			}
		}
		else if (cage == true && boxesMoved == false)
		{
			System.out.print("\nYou come back to the cage but the boxes are still in the way.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				cage = true;
				closet = false;
			}
		}
		else if (cage == true && boxesMoved == true)
		{
			if (cageUnlocked == false)
			{
				System.out.print("\nYou come back to the cage and the boxes are finally moved out of the way.\nYou walk up to the cage and see a guy lying inside.\n\nYou can UNLOCK cage or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("UN") || choice.contains("CA"))
				{
					closet = false;
					cageUnlocked = true;
					if (pliers == false)
					{
						System.out.print("\nSomething is stuck in the cage door. Try finding the pliers to fix it.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							closet = false;
							cageUnlocked = false;
						}
					}
					else if (pliers == true)
					{
						System.out.print("\nYou use the pliers to open the cage and walk up to the guy.\n\nYou can TALK to him or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("TA") || choice.contains("GI"))
						{
							Scenarios.Introduction();
							cage = true;
							cageUnlocked = true;
							NPC.NPCIntroduction();
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							cage = true;
							cageUnlocked = true;
						}
					}
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					closet = false;
				}
			}
			else if (cageUnlocked == true && NPC.npcFollowing == true)
			{
				System.out.print("\nYou come back to an empty cage.\n\nYou can LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					cageUnlocked = true;
					cage = true;
					closet = false;
				}
			}
			else if (cageUnlocked == true && NPC.npcFollowing == false)
			{
				System.out.print("\nYou come back to the cage and see the guy standing there.\n\nYou can TALK to him or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("TO") || choice.contains("HI"))
				{
					cage = true;
					cageUnlocked = true;
					closet = false;
					NPC.NPCIntroduction();
				}
			}
		}
	}
	/** This checkBoxes method is be called from the Introduction method. There is one
	 * main if and else statement based on if the user as already been to the bed
	 * or not. No matter what, they will still have the same options of being able
	 * to drop an item or going to look elsewhere. Also within this class, the 
	 * scenarios class is called to determine if the user will lose a life or not
	 * based on there answers. The inner if and else statements use the .contains 
	 * function to determine what should be called or executed. It also allows 
	 * the user to misspell some of their input, but it is not preferred because if 
	 * they misspell the beginning what they are trying to execute will not be run.
	 * This method is also static so that if the user leaves the room and then comes
	 * back, their information will not be reset.
	 * 
	 */
	public static void checkBoxes()
	{
		if (boxes == false)
		{
			System.out.print("\nYou look through the boxes and find something shiny that catches your eye.\n\nYou can TAKE bedroom key, MOVE boxes, or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if (choice.contains("TA") || choice.contains("BED") || choice.contains("KEY"))
			{
				Scenarios.Introduction();
				closet = false;
				boxes = true;
				bedroomKey = true;
				System.out.println("\nInventory: ");
				addItem(bedroom_Key);
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				closet = false;
				boxes = true;
			}
			else if (choice.contains("MO") || choice.contains("BO"))
			{
				System.out.print("\nYou have moved the boxes out of the way where you can access the cage.\nMaybe you should take a closer look.\n\nYou can LOOK elsewhere or LOOK closer.\n--> ");
				String choice1 = input.nextLine().toUpperCase();
				if (choice1.contains("EL"))
				{
					Scenarios.Introduction();
					closet = false;
					boxes = true;
					boxesMoved = true;
				}
				else if (choice1.contains("CL"))
				{
					closet = false;
					boxes = true;
					boxesMoved = true;
					checkCage();
				}
			}
		}
		else
		{
			if (bedroomKey == false && boxesMoved == false)
			{
				System.out.print("\nYou make your way back to the boxes and see a key laying among some boxes.\n\nYou can TAKE bedroom key, MOVE boxes, or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("TA") || choice.contains("BED") || choice.contains("KEY"))
				{
					closet = false;
					boxes = true;
					bedroomKey = true;
					System.out.println("\nInventory: ");
					addItem(bedroom_Key);
				}
				else if (choice.contains("MO") || choice.contains("BO"))
				{
					System.out.print("\nYou have moved the boxes out of the way where you can access the cage.\nMaybe you should take a closer look.\n\nYou can LOOK elsewhere or LOOK closer.\n--> ");
					String choice1 = input.nextLine().toUpperCase();
					if (choice1.contains("EL"))
					{
						Scenarios.Introduction();
						closet = false;
						boxes = true;
						boxesMoved = true;
					}
					else if (choice1.contains("CL"))
					{
						closet = false;
						boxes = true;
						boxesMoved = true;
						checkCage();
					}
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					closet = false;
					boxes = true;
				}
			}
			else if (bedroomKey == true && boxesMoved == false)
			{
				System.out.print("\nYou make your way to the unmoved boxes, making it impossible to get to the cage.\n\nYou can MOVE boxes or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("MO") || choice.contains("BO"))
				{
					System.out.print("\nYou have moved the boxes out of the way where you can access the cage.\nMaybe you should take a closer look.\n\nYou can LOOK elsewhere or LOOK closer.\n--> ");
					String choice1 = input.nextLine().toUpperCase();
					if (choice1.contains("EL"))
					{
						closet = false;
						boxes = true;
						boxesMoved = true;
					}
					else if (choice1.contains("CL"))
					{
						Scenarios.Introduction();
						closet = false;
						boxes = true;
						boxesMoved = true;
						checkCage();
					}
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					closet = false;
					boxes = true;
				}
			}
			else if (bedroomKey == false && boxesMoved == true)
			{
				System.out.print("\nYou make your way back to the moved boxes and see a key lying on the floor.\n\nYou can TAKE bedroom key or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("BED") || choice.contains("KEY"))
				{
					closet = false;
					boxes = true;
					bedroomKey = true;
					System.out.println("\nInventory: ");
					addItem(bedroom_Key);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					closet = false;
					boxes = true;
				}
			}
			else if (bedroomKey == true && boxesMoved == true)
			{
				System.out.print("\nThe boxes have been moved out of the way and there is nothing among them,\nbut you can access the cage.\n\nYou can LOOK elsewhere or CHECK cage.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					closet = false;
					boxes = true;
				}
				else if (choice.contains("CH") || choice.contains("CA"))
				{
					closet = false;
					boxes = true;
					checkCage();
				}
			}
		}
	}
}
