/** This class extends the abstract class Rooms and uses some of the
 * variables in that class. This class is also the main hub for the 
 * game and will link to all the other classes and methods.
 * 
 * @author morganhardin
 *
 */
public class Bedroom extends Rooms
{
	/** These private variables are instantiated here because they are
	 * only used in the Bedroom class.
	 * 
	 */
	private boolean bed;
	private boolean dresser;
	private boolean nightstand;
	private boolean bedroom;
	private boolean doorUnlocked;
	/** This empty constructor sets the boolean variables from the Rooms class
	 * and the private variables equal to false;
	 * 
	 */
	public Bedroom() 
	{
		bed = false;
		dresser = false;
		nightstand = false;
		bedroom = true;
		doorUnlocked = false;
		wire = false;
		flashlight = false;
	}
	/** This Introduction method uses multiple if and else statements that are chosen 
	 * based on the user input. If the user answers a certain way, they will either
	 * be directing to a certain method in this class or will will call a different
	 * class that will then be run. It is all in a while loop that will continue 
	 * to loop through as long as the player has more than 0 lives or if they
	 * have not completed the game yet. The inner if and
	 * else statements use the .contains function to determine what should 
	 * be called or executed. It also allows the user to misspell some of
	 * their input, but it is not preferred because if they misspell the
	 * beginning what they are trying to execute will not be run.
	 * 
	 * @throws InventoryException
	 */
	public void Introduction() throws InventoryException
	{
		while (room == true)
		{
		if (bedroom == true)
		{
			
			System.out.println("You wake up in a dark bedroom. \n\nThere are two doors, one going north to the closet and one going east to \nthe living room, along with a dresser, a bed, and a nightstand.\n\nYou can GO north or east. You can also CHECK the dresser, bed, or nightstand.");
			System.out.print("--> ");
			String choice = input.nextLine().toUpperCase();
			
			if(choice.contains("GO") && choice.contains("NO"))
			{
				Closet.Introduction();
				bedroom = false;
			}
			else if (choice.contains("GO") && choice.contains("EA"))
			{
				if (bedroomKey == false)
				{
					bedroom = false;
					System.out.print("\nThis door is locked. You need to find the bedroom key to unlock it.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						doorUnlocked = false;
						bedroom = false;
					}
				}
				else if (bedroomKey == true)
				{
					System.out.print("\nThis door is locked, but you have the bedroom key.\n\nYou can USE bedroom key or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("US") || choice.contains("BED") || choice.contains("KEY"))
					{
						doorUnlocked = true;
						bedroom = false;
						dropItem(bedroom_Key);
						System.out.print("\nYou unlocked the bedroom door. You can now get to the living room.");
						LivingRoom.Introduction();
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						bedroom = false;
					}
				}
				else if (doorUnlocked == true)
				{
					doorUnlocked = true;
					bedroom = false;
					LivingRoom.Introduction();
				}
			}
			else if (choice.contains("DR"))
			{
				checkDresser();
			}
			else if (choice.contains("BE"))
			{
				checkBed();
			}
			else if (choice.contains("NI"))
			{
				checkNightStand();
			}
			else
			{
				System.out.print("\nYour input did not match the options.\n");
			}
		}
		else
		{
			System.out.print("\nYou go to look through the bedroom once again.\n\nYou can GO north to the closet or east to the living room.\nYou may also CHECK the dresser, bed, and nightstand.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if(choice.contains("GO") && choice.contains("NO"))
			{
				Closet.Introduction();
				bedroom = false;
			}
			else if (choice.contains("GO") && choice.contains("EA"))
			{
				if (bedroomKey == false && doorUnlocked == false)
				{
					bedroom = false;
					System.out.print("\nThis door is locked. You need to find the bedroom key to unlock it.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						bedroom = false;
					}
				}
				else if (bedroomKey == true && doorUnlocked == false)
				{
					System.out.print("\nThe door is locked but you have the bedroom key.\n\nYou can USE bedroom key to unlock the door or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("US") || choice.contains("BED") || choice.contains("KEY"))
					{
						bedroom = false;
						doorUnlocked = true;
						dropItem(bedroom_Key);
						System.out.println("\nYou have unlocked the door to the living room.");
						LivingRoom.Introduction();
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						bedroom = false;
					}
				}
				else if (doorUnlocked == true)
				{
					LivingRoom.Introduction();
				}
			}
			else if (choice.contains("DR"))
			{
				checkDresser();
			}
			else if (choice.contains("BE"))
			{
				checkBed();
			}
			else if (choice.contains("NI"))
			{
				checkNightStand();
			}
			else
			{
				System.out.print("\nYour input did not match the options.\n");
			}
		}
		}
	}
	/** This checkBed method is be called from the Introduction method. There is one
	 * main if and else statement based on if the user as already been to the bed
	 * or not. No matter what, they will still have the same options of being able
	 * to drop an item or going to look elsewhere. Also within this class, the 
	 * scenarios class is called to determine if the user will lose a life or not
	 * based on there answers. The inner if and else statements use the .contains 
	 * function to determine what should be called or executed. It also allows the 
	 * user to misspell some of their input, but it is not preferred because if they 
	 * misspell the beginning what they are trying to execute will not be run.
	 * 
	 */
	public void checkBed()
	{
		if (bed == false)
		{
			System.out.print("\nThe bed you woke up in has nothing on top or underneath the bed.\n\nYou can DROP item or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("DR") || choice.contains("IT"))
			{
				bedroom = false;
				bed = true;
				for (int i = 0; i < inventory.length; i++)
				{
					if (inventory[i] != null)
					{
						Inventory();
						removeItem();
						break;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				bedroom = false;
				bed = true;
			}
		}
		else
		{
			System.out.print("\nYou have already checked the bed and it is still empty.\n\nYou can DROP item or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("DR") || choice.contains("IT"))
			{
				for (int i = 0; i < inventory.length; i++)
				{
					if (inventory[i] != null)
					{
						Inventory();
						removeItem();
						break;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				bedroom = false;
			}
		}
	}
	/** The checkDresser method has one main if and else statement that
	 * will determine if the user has visited the dresser or not. It also
	 * gives the user multiple options of being able to pick up items and 
	 * changing the text based on if the item has been picked up or not.
	 * If the item is picked up, the addItem method is called from Rooms.
	 * The scenarios class is also called in this method. The inner if and
	 * else statements use the .contains function to determine what should 
	 * be called or executed. It also allows the user to misspell some of
	 * their input, but it is not preferred because if they misspell the
	 * beginning what they are trying to execute will not be run.
	 * 
	 */
	public void checkDresser()
	{
		if (dresser == false)
		{
			System.out.print("\nThe dresser is hidden in the corner of the room. \nOn top, you see a flashlight peeking out behind the lamp.\n\nYou can TAKE the flashlight or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("TA") || choice.contains("FL"))
			{
				bedroom = false;
				dresser = true;
				flashlight = true;
				System.out.println("\nInventory: ");
				addItem(_flashlight);
			
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				bedroom = false;
				dresser = true;
			}
		}
		else
		{
			if (flashlight == false)
			{
				System.out.print("\nYou come back to the dresser and see the flashlight on the surface.\n\nYou can LOOK elsewhere or TAKE flashlight.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("FL"))
				{
					flashlight = true;
					bedroom = false;
					System.out.println("\nInventory: ");
					addItem(_flashlight);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					bedroom = false;
				}
				
			}
			else if (flashlight == true)
			{
				System.out.print("\nYou come back to the dresser and find the surface empty.\n\nYou can LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					bedroom = false;
				}
			}
		}
	}
	/** The checkNightstand method has one main if and else statement that
	 * will determine if the user has visited the dresser or not. It also
	 * gives the user multiple options of being able to pick up items and 
	 * changing the text based on if the item has been picked up or not.
	 * If the item is picked up, the addItem method is called from Rooms.
	 * The scenarios class is also called in this method. The inner if and
	 * else statements use the .contains function to determine what should 
	 * be called or executed. It also allows the user to misspell some of
	 * their input, but it is not preferred because if they misspell the
	 * beginning what they are trying to execute will not be run.
	 * 
	 */
	public void checkNightStand()
	{
		if (nightstand == false)
		{
			System.out.print("\nYou go to check the nightstand and see a wire laying on the table.\n\nYou can LOOK elsewhere or TAKE wire.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("TA") || choice.contains("WI"))
			{
				bedroom = false;
				wire = true;
				nightstand = true;
				System.out.println("\nInventory: ");
				addItem(_wire);
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				bedroom = false;
				nightstand = true;
			}
		}
		else
		{
			if (wire == false)
			{
				System.out.print("\nYou come back to the nightstand and see the wire.\n\nYou can TAKE wire or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("WI"))
				{
					Scenarios.Introduction();
					bedroom = false;
					wire = true;
					System.out.println("\nInventory: ");
					addItem(_wire);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					bedroom = false;
				}
			}
			else if (wire == true)
			{
				System.out.print("\nYou come back to an empty nightstand.\n\nYou can LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					bedroom = false;
				}
			}
		}
	}
}
