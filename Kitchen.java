/** This class extends the abstract class Rooms
 * and is able to call and use the variables and 
 * methods in that class.
 * 
 * @author morganhardin
 *
 */
public class Kitchen extends Rooms
{
	/** These private and static variables are instantiated
	 * here so that they can be used and manipulated 
	 * within this class.
	 * 
	 */
	private static boolean refridgerator, pantry, table, cabinets, safe, safeUnlocked, vase, vaseBroken;
	protected static boolean roomKitchen = true;
	private static boolean kitchen = false;
	/** This empty constructor sets all of the private and protected
	 * variables from this class and the abstract class equal to
	 * false so that they can be used in this class.
	 * 
	 */
	public Kitchen()
	{
		refridgerator = false;
		pantry = false;
		table = false;
		cabinets = false;
		safe = false;
		safeUnlocked = false;
		vase = false;
		vaseBroken = false;
		roomKitchen = true;
		kitchen = false;
		carEngine = false;
		pliers = false;
		crowbar = false;
	}
	/** This static Introduction method is the method called from
	 * LivingRoom. Therefore this is what is first executed from that class.
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
		roomKitchen = true;
		while (roomKitchen == true)
		{
			if (kitchen == false)
			{
				System.out.print("\nYou enter the kitchen for the first time, looking around to find a pantry, \ncabinets, a table, and a refridgerator.\n\nYou can CHECK pantry, cabinets, table, or refridgerator, or GO north.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("PA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkPantry();
				}
				else if (choice.contains("CA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkCabinets();
				}
				else if (choice.contains("TA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkTable();
				}
				else if (choice.contains("RE"))
				{
					kitchen = true;
					roomKitchen = true;
					checkRefridgerator();
				}
				else if (choice.contains("GO") && choice.contains("NO"))
				{
					kitchen = true;
					roomKitchen = false;
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
			else if (kitchen == true)
			{
				System.out.print("\nYou enter the kitchen again, seeing the pantry, cabinets, \ntable, and refridgerator.\n\nYou can CHECK pantry, cabinets, table, or refridgerator, or GO north.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("PA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkPantry();
				}
				else if (choice.contains("CA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkCabinets();
				}
				else if (choice.contains("TA"))
				{
					kitchen = true;
					roomKitchen = true;
					checkTable();
				}
				else if (choice.contains("RE"))
				{
					kitchen = true;
					roomKitchen = true;
					checkRefridgerator();
				}
				else if (choice.contains("GO") && choice.contains("NO"))
				{
					kitchen = true;
					roomKitchen = false;
				}
				else
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
		}
	}
	/** This checkPantry method is be called from the Introduction method. There is one
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
	public static void checkPantry() throws InventoryException
	{
		if (pantry == false)
		{
			System.out.print("\nYou open the pantry to find pliers lying on a shelf.\n\nYou can TAKE pliers or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("TA") || choice.contains("PL"))
			{
				Scenarios.Introduction();
				kitchen = true;
				pantry = true;
				pliers = true;
				System.out.println("\nInventory: ");
				addItem(_pliers);
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				kitchen = true;
				pantry = true;
			}
		}
		else
		{
			if (pliers == false)
			{
				System.out.print("\nYou come back to the pantry to find pliers lying on a shelf.\n\nYou can TAKE pliers or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("PL"))
				{
					Scenarios.Introduction();
					kitchen = true;
					pantry = true;
					pliers = true;
					System.out.println("\nInventory: ");
					addItem(_pliers);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					kitchen = true;
					pantry = true;
				}
			}
			else if (pliers == true)
			{
				System.out.print("\nYou make your way back to the pantry to find it empty.\n\nYou can LOOK ELSEWHERE.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					kitchen = true;
					pantry = true;
				}
			}
		}
	}
	/** This checkCabinets method is be called from the Introduction method. There is one
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
	public static void checkCabinets()
	{
		if (cabinets == false)
		{
			System.out.print("\nYou begin opening every cabinet in the kitchen. You ultimately find a car engine hiding in the back.\n\nYou can TAKE car engine or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("TA") || choice.contains("CA") || choice.contains("EN"))
			{
				kitchen = true;
				cabinets = true;
				carEngine = true;
				System.out.println("\nInventory: ");
				addItem(car_Engine);
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				kitchen = true;
				cabinets = true;
			}
		}
		else
		{
			if (carEngine == false)
			{
				System.out.print("\nYou come back to the cabinets where the car engine is at.\n\nYou can TAKE car engine or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("CA") || choice.contains("EN"))
				{
					Scenarios.Introduction();
					kitchen = true;
					cabinets = true;
					carEngine = true;
					System.out.println("\nInventory: ");
					addItem(car_Engine);
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					kitchen = true;
					cabinets = true;
				}
			}
			else if (carEngine == true)
			{
				System.out.print("\nYou make your way back to the cabinets to find it empty.\n\nYou can LOOK ELSEWHERE.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					kitchen = true;
					cabinets = true;
				}
			}
		}
	}
	/** This checkTable method is be called from the Introduction method. There is one
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
	public static void checkTable()
	{
		if (table == false)
		{
			System.out.print("\nYou go to look at the table and see a safe sitting in\none of the chairs and a vase on the table.\n\nYou can CHECK safe or vase or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("SA"))
			{
				if (safe == false && safeUnlocked == false)
				{
					System.out.print("\nLooking closer at the safe, you notice that it is locked. \nPerhaps you need to find a code.\n\nYou can ENTER code or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("EN") || choice.contains("CO"))
					{
						Scenarios.Introduction();
						System.out.print("\nEnter the code:\n--> ");
						String code1 = input.nextLine();
						if (code1.contains("5835"))
						{
							System.out.print("\nYou have unlocked the safe. You open it to find the gas container.\n\nYou can TAKE gas container or LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("TA") || choice.contains("GAS") || choice.contains("CO"))
							{
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = true;
								gasContainer = true;
								System.out.println("\nInventory: ");
								addItem(gas_Container);
							}
							else if (choice.contains("LO") || choice.contains("EL"))
							{
								Scenarios.Introduction();
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
						else if (!code1.contains("5835"))
						{
							System.out.print("\nThe code you entered is not correct. Try going to find the code.\n\nYou can LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("LO") || choice.contains("EL"))
							{
								Scenarios.Introduction();
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = false;
					}
				}
			}
			else if (choice.contains("VA"))
			{
				if (vase == false && vaseBroken == false && baseballBat == false)
				{
					System.out.print("\nYou go to check the vase but something is stuck inside. Maybe try to find something to break it with.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = false;
					}
				}
				else if (vase == false && vaseBroken == false && baseballBat == true)
				{
					System.out.print("\nYou go to check the vase but something is stuck inside. Luckily, you have the baseball bat.\n\nYou can BREAK vase or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("BR") || choice.contains("VA"))
					{
						System.out.print("\nYou broke the vase, finding a crowbar inside.\n\nYou can TAKE crowbar or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("TA") || choice.contains("CR"))
						{
							table = true;
							kitchen = true;
							vase = true;
							vaseBroken = true;
							crowbar = true;
							System.out.println("\nInventory: ");
							addItem(_crowbar);
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							table = true;
							kitchen = true;
							vase = true;
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				table = true;
				kitchen = true;
				vase = true;
			}
		}
		else
		{
			System.out.print("\nYou go to look at the table again and see a safe sitting in one of\nthe chairs and a vase on the table.\n\nYou can CHECK safe or vase or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("SA"))
			{
				if (safe == false && safeUnlocked == false && gasContainer == false)
				{
					System.out.print("\nLooking closer at the safe, you notice that it is locked. \nPerhaps you need to find a code.\n\nYou can ENTER code or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("EN") || choice.contains("CO"))
					{
						System.out.print("\nEnter the code:\n--> ");
						String code1 = input.nextLine();
						if (code1.contains("5835"))
						{
							System.out.print("\nYou have unlocked the safe. You open it to find the gas container.\n\nYou can TAKE gas container or LOOK elsewhere.\n--> ");
							String choice1 = input.nextLine().toUpperCase();
							if (choice1.contains("TA") || choice1.contains("GAS") || choice1.contains("CO"))
							{
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = true;
								gasContainer = true;
								System.out.println("\nInventory: ");
								addItem(gas_Container);
							}
							else if (choice1.contains("LO") || choice1.contains("EL"))
							{
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
						else if (!code1.contains("5835"))
						{
							System.out.print("\nThe code you entered is not correct. Try going to find the code.\n\nYou can LOOK elsewhere.\n--> ");
							String choice1 = input.nextLine().toUpperCase();
							if (choice1.contains("LO") || choice1.contains("EL"))
							{
								Scenarios.Introduction();
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = false;
					}
				}
				else if (safe == true && safeUnlocked == false && gasContainer == false)
				{
					System.out.print("\nYou come back to the locked safe.\nPerhaps you need to find a code.\n\nYou can ENTER code or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("EN") || choice.contains("CO"))
					{
						System.out.print("\nEnter the code:\n--> ");
						String code1 = input.nextLine();
						if (code1.contains("5835"))
						{
							System.out.print("\nYou have unlocked the safe. You open it to find the gas container.\n\nYou can TAKE gas container or LOOK elsewhere.\n--> ");
							String choice1 = input.nextLine().toUpperCase();
							if (choice1.contains("TA") || choice1.contains("GAS") || choice1.contains("CO"))
							{
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = true;
								gasContainer = true;
								System.out.println("\nInventory: ");
								addItem(gas_Container);
							}
							else if (choice1.contains("LO") || choice1.contains("EL"))
							{
								Scenarios.Introduction();
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
						else if (!code1.contains("5935"))
						{
							System.out.print("\nThe code you entered is not correct. Try going to find the code.\n\nYou can LOOK elsewhere.\n--> ");
							choice = input.nextLine().toUpperCase();
							if (choice.contains("LO") || choice.contains("EL"))
							{
								table = true;
								kitchen = true;
								safe = true;
								safeUnlocked = false;
							}
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = false;
					}
				}
				else if (safe == true && safeUnlocked == true && gasContainer == false)
				{
					System.out.print("\nYou make your way back to the safe and see the gas container.\n\nYou can TAKE gas container or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("TA") || choice.contains("GA") || choice.contains("CO"))
					{
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = true;
						gasContainer = true;
						System.out.println("\nInventory: ");
						addItem(gas_Container);
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = true;
					}
				}
				else if (safe == true && safeUnlocked == true && gasContainer == true)
				{
					System.out.print("\nYou make your way back to the safe, finding it empty.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						safe = true;
						safeUnlocked = true;
					}
				}
			}
			else if (choice.contains("VA"))
			{
				if (vase == false && vaseBroken == false && baseballBat == false)
				{
					System.out.print("\nYou go to check the vase but something is stuck inside. Maybe try to find something to break it with.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = false;
					}
				}
				else if (vase == false && vaseBroken == false && baseballBat == true)
				{
					System.out.print("\nYou go to check the vase but something is stuck inside. Luckily, you have the baseball bat.\n\nYou can BREAK vase or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("BR") || choice.contains("VA"))
					{
						System.out.print("\nYou broke the vase, finding a crowbar inside.\n\nYou can TAKE crowbar or LOOK elsewhere.\n--> ");
						String choice1 = input.nextLine().toUpperCase();
						if (choice1.contains("TA") || choice1.contains("CR"))
						{
							table = true;
							kitchen = true;
							vase = true;
							vaseBroken = true;
							crowbar = true;
							System.out.println("\nInventory: ");
							addItem(_crowbar);
						}
						else if (choice1.contains("LO") || choice1.contains("EL"))
						{
							Scenarios.Introduction();
							table = true;
							kitchen = true;
							vase = true;
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
					}
				}
				else if (vase == true && vaseBroken == false && baseballBat == false)
				{
					System.out.print("\nYou go back to the vase but something is stuck inside. Maybe try to find something to break it with.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = false;
					}
				}
				else if (vase == true && vaseBroken == false && baseballBat == true && crowbar == false)
				{
					System.out.print("\nYou go to check the vase again but something is stuck inside. Luckily, you have the baseball bat.\n\nYou can BREAK vase or LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("BR") || choice.contains("VA"))
					{
						System.out.print("\nYou broke the vase, finding a crowbar inside.\n\nYou can TAKE crowbar or LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("TA") || choice.contains("CR"))
						{
							table = true;
							kitchen = true;
							vase = true;
							vaseBroken = true;
							crowbar = true;
							System.out.println("\nInventory: ");
							addItem(_crowbar);
						}
						else if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							table = true;
							kitchen = true;
							vase = true;
						}
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
					}
				}
				else if (vase == true && vaseBroken == true && crowbar == false)
				{
					System.out.print("\nYou make your way back to the broken vase and find the crowbar lying among the shards.\n\nYou can TAKE crowbar or LOOk elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("TA") || choice.contains("CR"))
					{
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = true;
						crowbar = true;
						System.out.println("\nInventory: ");
						addItem(_crowbar);
					}
					else if (choice.contains("LO") || choice.contains("EL"))
					{
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = true;
					}
				}
				else if (vase == true && vaseBroken == true && crowbar == true)
				{
					System.out.print("\nYou make your way back to the shards of the vase, finding nothing among them.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						table = true;
						kitchen = true;
						vase = true;
						vaseBroken = true;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				table = true;
				kitchen = true;
				vase = true;
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
	public static void checkRefridgerator()
	{
		if (refridgerator == false)
		{
			System.out.print("\nYou go open the refridgerator for the first time, immediately seeing \na door handle hiding behind some expired food.\n\nYou can TAKE door handle, DROP item, or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("TA") || choice.contains("DO") || choice.contains("HA"))
			{
				refridgerator = true;
				kitchen = true;
				doorHandle = true;
				addItem(door_Handle);
			}
			else if (choice.contains("DR") || choice.contains("IT"))
			{
				kitchen = false;
				refridgerator = true;
				System.out.print("\nInventory: ");
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
				refridgerator = true;
				kitchen = true;
			}
		}
		else
		{
			if (doorHandle == false)
			{
				System.out.print("\nYou come back to the refridgerator and still see the door handle.\n\nYou can TAKE door handle, DROP item, or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("TA") || choice.contains("DO") || choice.contains("HA"))
				{
					refridgerator = true;
					kitchen = true;
					doorHandle = true;
					System.out.println("\nInventory: ");
					addItem(door_Handle);
				}
				else if (choice.contains("DR") || choice.contains("IT"))
				{
					kitchen = true;
					refridgerator = true;
					System.out.print("\nInventory: ");
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
					refridgerator = true;
					kitchen = true;
				}
			}
			else if (doorHandle == true)
			{
				System.out.print("\nYou come back to the refridgerator and find it empty.\n\nYou can DROP item or LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("DR") || choice.contains("IT"))
				{
					kitchen = true;
					refridgerator = true;
					System.out.print("\nInventory: ");
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
					refridgerator = true;
					kitchen = true;
				}
			}
		}
	}
}
