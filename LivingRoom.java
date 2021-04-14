/** This class extends that abstract class Rooms and is 
 * able to use and manipulate the protected variables
 * along with class the methods.
 * 
 * @author morganhardin
 *
 */
public class LivingRoom extends Rooms
{
	/** These private static variables are used only in this
	 * class, but are static because this class is being called from the
	 * Bedroom class. Therefore, these variables only have one instance.
	 * 
	 */
	private static boolean couch, desk, computer, cushions, drawer, computerUnlocked, computerFixed, doorFixed;
	protected static boolean roomLivingRoom;
	private static boolean livingRoom = true;
	/** This empty constructor takes the private variables along
	 * with Rooms's protected variables and sets them equal to 
	 * false. These variables will then be used and 
	 * manipulated within this class.
	 * 
	 */
	public LivingRoom()
	{
		couch = false;
		desk = false;
		computer = false;
		cushions = false;
		drawer = false;
		computerUnlocked = false;
		computerFixed = false;
		doorFixed = false;
		livingRoom = true;
		carKey = false;
		baseballBat = false;
		roomLivingRoom = true;
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
		roomLivingRoom = true;
		while (roomLivingRoom == true)
		{
			if (livingRoom == true)
			{
				System.out.print("\nYou enter the living room for the first time.\nYour eye immediately goes to the couch and the desk.\n\nYou can CHECK the couch and desk or GO west to the bedroom,\neast to the garage, or south to the kitchen.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("CO"))
				{
					checkCouch();
					livingRoom = false;
				}
				else if (choice.contains("DE"))
				{
					checkDesk();
					livingRoom = false;
				}
				else if (choice.contains("GO") && choice.contains("WE"))
				{
					livingRoom = false;
					roomLivingRoom = false;
				}
				else if (choice.contains("GO") && choice.contains("EA"))
				{
					if (doorHandle == false && doorFixed == false)
					{
						System.out.print("\nThe door to the garage has no door handle.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							livingRoom = false;
						}
					}
					else if (doorHandle == true && doorFixed == false)
					{
						System.out.print("\nThe door has no door handle, but you have it in your inventory.\n\nYou can FIX door handle or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("FI") || choice.contains("DO") || choice.contains("HA"))
						{
							System.out.print("\nYou have fixed the door handle. You can now freely move between the living room and the garage.\n");
							Garage.Introduction();
							livingRoom = false;
							dropItem(door_Handle);
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							livingRoom = false;
						}
					}
				}
				else if (choice.contains("GO") && choice.contains("SO"))
				{
					Kitchen.Introduction();
					livingRoom = false;
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
					livingRoom = false;
				}
			}
			else
			{
				System.out.print("\nYou come back to the living room again.\n\nYou can CHECK the couch and desk or GO west to the bedroom, \neast to the garage, or south to the kitchen.\n--> ");
				String choice = input.nextLine().toUpperCase();
				
				if (choice.contains("CO"))
				{
					checkCouch();
				}
				else if (choice.contains("DE"))
				{
					checkDesk();
				}
				else if (choice.contains("GO") && choice.contains("WE"))
				{
					roomLivingRoom = false;
				}
				else if (choice.contains("GO") && choice.contains("EA"))
				{
					if (doorHandle == false && doorFixed == false)
					{
						System.out.print("\nThe door to the garage has no door handle.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							doorFixed = false;
						}
					}
					else if (doorHandle == true && doorFixed == false)
					{
						System.out.print("\nThe door has no door handle, but you have it in your inventory.\n\nYou can FIX door handle or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("FI") || choice.contains("DO") || choice.contains("HA"))
						{
							doorFixed = true;
							System.out.print("\nYou have fixed the door handle. You can now freely move between the living room and the garage.\n");
							Garage.Introduction();
							dropItem(door_Handle);
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							doorFixed = false;
						}
					}
					else if (doorFixed == true)
					{
						Garage.Introduction();
					}
				}
				else if (choice.contains("GO") && choice.contains("SO"))
				{
					Kitchen.Introduction();
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
		}
	}
	/** This checkCouch method is be called from the Introduction method. There is one
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
	public static void checkCouch()
	{
		if (couch == false)
		{
			System.out.print("\nYou go to look at the couch, nothing sticking out to you.\n\nYou can CHECK cushions or underneath or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			couch = true;
			
			if (choice.contains("CU"))
			{
				System.out.print("\nYou stick your hand between the cushions, only to find them empty.\n\nYou can LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					couch = true;
					livingRoom = false;
					cushions = true;
				}
			}
			else if (choice.contains("UN"))
			{
				System.out.print("\nBending down to look underneath the couch, you see there is a baseball bat.\n\nYou can TAKE bat or LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("BA"))
				{
					Scenarios.Introduction();
					couch = true;
					livingRoom = false;
					baseballBat = true;
					System.out.println("\nInventory: ");
					addItem(baseball_Bat);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					couch = true;
					livingRoom = false;
				}
			}
		}
		else if (couch == true)
		{
			System.out.print("\nYou make your way back to the couch.\n\nYou can CHECK cushions or underneath or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if (choice.contains("CU"))
			{
				if (cushions == false)
				{
					System.out.print("\nYou decide to stick your hand between the couch cushions, only to find them empty.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						couch = true;
						livingRoom = false;
						cushions = true;
					}
				}
				else if (cushions == true)
				{
					System.out.print("\nOnce again, you find the couch cushions empty.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						couch = true;
						livingRoom = false;
						cushions = true;
					}
				}
			}
			else if (choice.equals("CHECK UNDERNEATH"))
			{
				if (baseballBat == false)
				{
					System.out.print("\nAfter bending down again, you see the baseball bat is still there.\n\nYou can TAKE bat or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("TA") || choice.contains("BA"))
					{
						Scenarios.Introduction();
						couch = true;
						livingRoom = false;
						baseballBat = true;
						System.out.println("\nInventory: ");
						addItem(baseball_Bat);
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						couch = true;
						livingRoom = false;
					}
				}
				else
				{
					System.out.print("\nGoing to look underneath the couch, you find it empty.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						couch = true;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				couch = true;
				livingRoom = false;
			}
			else
			{
				System.out.print("\nYour input did not match the options.");
				livingRoom = false;
			}
		}
	}
	/** This checkDesk method is be called from the Introduction method. There is one
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
	public static void checkDesk()
	{
		if (desk == false)
		{
			System.out.print("\nYou go to look at the desk and notice a locked computer and a \nslightly opened drawer.\n\nYou can CHECK computer or drawer or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			desk = true;
			
			if (choice.contains("CO"))
			{
				if (flashlight == false)
				{
					System.out.print("\nYou check the computer, only to find it will not turn on.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						desk = true;
						livingRoom = false;
						computer = true;
						computerUnlocked = false;
					}
				}
				else if (flashlight == true && computerUnlocked == false && computerFixed == false)
				{
					System.out.print("\nYou check the computer, only to find it won't turn on. Luckily you have the flashlight to look closer.\n\nYou can USE flashlight or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("US") || choice.contains("FL"))
					{
						System.out.print("\nYou use the flashlight to see the problem and notice something is missing.\nTry finding the wire to fix this issue.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("US") || choice.contains("WI"))
						{
							if (wire == true)
							{
								System.out.print("\nYou use the wire and begin searching through the files.\nYou stumble across the code 5835. Maybe you should remember that.\n\nYou can LOOK elsewhere.\n--> ");
								choice = input.nextLine().toUpperCase();
								if (choice.contains("LO") || choice.contains("EL"))
								{
									Scenarios.Introduction();
									desk = true;
									livingRoom = false;
									computerUnlocked = true;
									computerFixed = true;
								}
							}
							else if (wire == false)
							{
								System.out.print("\nYou do not have the wire to fix the computer.\n\nYou can LOOK elsewhere.\n--> ");
								choice = input.nextLine().toUpperCase();
								if (choice.contains("LO") || choice.contains("EL"))
								{
									Scenarios.Introduction();
									desk = true;
									livingRoom = false;
									computerUnlocked = true;
									computerFixed = false;
								}
							}
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = true;
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						desk = true;
						livingRoom = false;
						computer = true;
					}
				}
				else if (computerUnlocked == true && wire == true && computerFixed == false)
				{
					System.out.print("\nYou check the computer. Since you have the wire, \nyou can now use it to try and fix it.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("US") || choice.contains("WI"))
					{
						desk = true;
						livingRoom = false;
						computer = true;
						computerUnlocked = true;
						computerFixed = true;
						System.out.println("\nYou have fixed the computer. You look through the files and find the code: 5835\nIt might be helpful to remember that.");
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						desk = true;
						livingRoom = false;
						computer = true;
						computerUnlocked = true;
					}
				}
				else if (computerFixed == true)
				{
					System.out.print("\nYou come back to the computer to find the file with the code pulled up. You see that the code is: 5835.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						desk = true;
						livingRoom = false;
						computer = true;
						computerUnlocked = true;
						computerFixed = true;
					}
				}
			}
			else if (choice.contains("DR"))
			{
				System.out.print("\nOpening the drawer you find a car key.\n\nYou can TAKE car key or LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("CAR") || choice.contains("KEY"))
				{
					Scenarios.Introduction();
					desk = true;
					livingRoom = false;
					drawer = true;
					carKey = true;
					System.out.println("\nInventory: ");
					addItem(car_Key);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					desk = true;
					livingRoom = false;
					drawer = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				desk = true;
				livingRoom = false;
				drawer = true;
			}
		}
		else
		{
			System.out.print("\nYou make your way back to the desk.\n\nYou can CHECK computer or drawer or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			
			if (choice.contains("CO"))
			{
				if (computer == false)
				{
					if (flashlight == false && computerUnlocked == false && computerFixed == false)
					{
						System.out.print("\nYou check the computer, only to find it will not turn on.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = false;
							computerFixed = false;
						}
					}
					else if (flashlight == true && computerUnlocked == false && computerFixed == false)
					{
						System.out.print("\nYou check the computer, only to find it will not turn on. Luckily you have the flashlight so you can look closer.\n\nYou can USE flashlight or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("US") || choice.contains("FL"))
						{
							System.out.print("\nYou use the flashlight and notice a wire is missing.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("US") || choice.contains("WI"))
							{
								if (wire == true)
								{
									System.out.print("\nYou use the wire and begin searching through the files.\nYou stumble across the code 5835. Maybe you should remember that.\n\nYou can LOOK elsewhere.\n--> ");
									choice = input.nextLine().toUpperCase();
									if (choice.contains("LO") || choice.contains("EL"))
									{
										desk = true;
										livingRoom = false;
										computerUnlocked = true;
										computerFixed = true;
									}
								}
								else if (wire == false)
								{
									System.out.print("\nYou do not have the wire to fix the computer.\n\nYou can LOOK elsewhere.\n--> ");
									choice = input.nextLine().toUpperCase();
									if (choice.contains("LO") || choice.contains("EL"))
									{
										desk = true;
										livingRoom = false;
										computerUnlocked = true;
										computerFixed = false;
									}
								}
							}
							else if (choice.contains("LO") || choice.contains("EL"))
							{
								Scenarios.Introduction();
								desk = true;
								livingRoom = false;
								computer = true;
								computerUnlocked = true;
								computerFixed = false;
							}
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
						}
					}
					else if (computerUnlocked == true && wire == false && computerFixed == false)
					{
						System.out.print("You make your way back to the computer, still not being able to turn it on without the wire.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = true;
						}
					}
					else if (computerUnlocked == true && wire == true && computerFixed == false)
					{
						System.out.print("\nFinally having the wire to turn on the computer.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("US") || choice.contains("WI"))
						{
							System.out.print("\nYou use the wire and begin searching through the files.\nYou stumble across the code 5835. Maybe you should remember that.\n\nYou can LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("LO") || choice.contains("EL"))
							{
								desk = true;
								livingRoom = false;
								computer = true;
								computerUnlocked = true;
								computerFixed = true;
							}
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
						}
					}
					else if (computerUnlocked == true && computerFixed == true)
					{
						System.out.print("\nYou make your way to the computer, looking through the files. You see the code 5835.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = true;
							computerFixed = true;
						}
					}
				}
				else if (computer == true)
				{
					if (flashlight == false && computerUnlocked == false && computerFixed == false)
					{
						System.out.print("\nYou check the computer again, only to find it will not turn on.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = false;
							computerFixed = false;
						}
					}
					else if (flashlight == true && computerUnlocked == false && computerFixed == false)
					{
						System.out.print("\nYou check the computer again, only to find it will not turn on.\nLuckily you have the flashlight so you can see better.\n\nYou can USE flashlight or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("US") || choice.contains("FL"))
						{
							System.out.print("\nYou use the flashlight but notice a wire is missing, keeping it from turning on.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("US") || choice.contains("WI"))
							{
								if (wire == true)
								{
									System.out.print("\nYou use the wire and begin searching through the files.\nYou stumble across the code 5835. Maybe you should remember that.\n\nYou can LOOK elsewhere.\n--> ");
									choice = input.nextLine().toUpperCase();
									if (choice.contains("LO") || choice.contains("EL"))
									{
										Scenarios.Introduction();
										desk = true;
										livingRoom = false;
										computerUnlocked = true;
										computerFixed = true;
									}
								}
								else if (wire == false)
								{
									System.out.print("\nYou do not have the wire to fix the computer.\n\nYou can LOOK elsewhere.\n--> ");
									choice = input.nextLine().toUpperCase();
									if (choice.contains("LO") || choice.contains("EL"))
									{
										desk = true;
										livingRoom = false;
										computerUnlocked = true;
										computerFixed = false;
									}
								}
							}
							else if (choice.contains("LO") || choice.contains("EL"))
							{
								desk = true;
								livingRoom = false;
								computer = true;
								computerUnlocked = true;
								computerFixed = false;
							}
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
						}
					}
					else if (computerUnlocked == true && wire == false && computerFixed == false)
					{
						System.out.print("You make your way back to the computer, still not being able to turn it on without the wire.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = true;
						}
					}
					else if (computerUnlocked == true && wire == true && computerFixed == false)
					{
						System.out.print("\nFinally having access to the wire, you can fix the computer.\n\nYou can USE wire or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("US") || choice.contains("WI"))
						{
							System.out.print("\nYou use the wire and begin searching through the files.\nYou stumble across the code 5835. Maybe you should remember that.\n\nYou can LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("LO") || choice.contains("EL"))
							{
								Scenarios.Introduction();
								desk = true;
								livingRoom = false;
								computer = true;
								computerUnlocked = true;
								computerFixed = true;
							}
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							computer = true;
						}
					}
					else if (computerUnlocked == true && computerFixed == true)
					{
						System.out.print("\nYou make your way to the computer, looking through the files. You see the code 5835.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							desk = true;
							livingRoom = false;
							computer = true;
							computerUnlocked = true;
							computerFixed = true;
						}
					}

				}
			}
			else if (choice.contains("DR"))
			{
				if (drawer == false)
				{
					System.out.print("\nOpening the drawer you find a car key.\n\nYou can TAKE car key or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("TA") || choice.contains("CAR") || choice.contains("KEY"))
					{
						Scenarios.Introduction();
						desk = true;
						livingRoom = false;
						drawer = true;
						carKey = true;
						System.out.println("\nInventory: ");
						addItem(car_Key);
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						desk = true;
						livingRoom = false;
						drawer = true;
					}
				}
				else if (drawer == true)
				{
					if (carKey == false)
					{
						System.out.print("\nYou come back to the drawer and see the car key once again.\n\nYou can TAKE car key or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("TA") || choice.contains("CAR") || choice.contains("KEY"))
						{
							desk = true;
							livingRoom = false;
							drawer = true;
							carKey = true;
							System.out.println("\nInventory: ");
							addItem(car_Key);
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							drawer = true;
						}
					}
					else if (carKey == true)
					{
						System.out.print("\nYou return to the drawer and find it empty.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							desk = true;
							livingRoom = false;
							drawer = true;
						}
					}
				}
			}
		}
	}
}
