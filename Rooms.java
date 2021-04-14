/** This class is abstract, allowing the classes that extend it to use these variables and methods.
 * 
 * @author morganhardin
 *
 */
import java.util.*;

public abstract class Rooms 
{
	/** These variables are all static, meaning that there is only once instance of the
	 * boolean variables, String array, string variables, and scanner. This allows the
	 * classes that extend this abstract class to call these variables and manipulate
	 * them. The inventory array is set equal to 5 and will not be changed so that
	 * 
	 * 
	 */
	protected static Scanner input = new Scanner(System.in);
	protected static boolean room = true;
	protected static boolean carKey, bedroomKey, flashlight, baseballBat, pliers, wire, crowbar, doorHandle, carEngine, gasContainer;
	protected static String car_Key, bedroom_Key, _flashlight, baseball_Bat, _pliers, _wire, _crowbar, door_Handle, car_Engine, gas_Container;
	protected static String[] inventory = new String[5];
	/** This empty constructor sets all the boolean values to false and
	 * the sets the string variables equal to a string that defines
	 * what that object is.
	 * 
	 */
	public Rooms()
	{
		carKey = false;
		bedroomKey = false;
		flashlight = false;
		baseballBat = false;
		pliers = false;
		wire = false;
		crowbar = false;
		doorHandle = false;
		carEngine = false;
		gasContainer = false;
		car_Key = "car key";
		bedroom_Key = "bedroom key";
		_flashlight = "flashlight";
		baseball_Bat = "baseball bat";
		_pliers = "pliers";
		_wire = "wire";
		_crowbar = "crowbar";
		door_Handle = "door handle";
		car_Engine = "car engine";
		gas_Container = "gas container";
	}
	/** This Inventory method is static so that the other classes can call this
	 * method and print the inventory array. This class uses a for loop to 
	 * loop through the inventory array and will print the values of the
	 * current index i.
	 * 
	 */
	public static void Inventory()
	{
		System.out.println();
		for (int i = 0; i < inventory.length; i++)
		{
			System.out.println(inventory[i]);
		}
	}
	/** This static addItem method takes the variable item and adds it into
	 * the inventory array. It checks to make sure that the index position 
	 * is null before it sets that index equal to the item. It then breaks so
	 * that there is only one position equal to index, not all the null indexes.
	 * There is also a try and catch block that catches an error is the inventory
	 * is full. It will then print a string saying the inventory is full and an
	 * item should be dropped first. 
	 * 
	 * @param item
	 */
	public static void addItem(String item)
	{
		try
		{
			for (int a = 0; a < inventory.length; a++)
			{
				if (inventory[a] == null)
				{
					inventory[a] = item;
					if (inventory[1] != null & inventory[2] != null && inventory[3] != null && inventory[4] != null)
					{
						Inventory();
					}
					else
					{
						System.out.println(inventory[a]);
					}
					break;
				}
				else
				{
					System.out.println(inventory[a]);
				}
			}
			if (inventory[0] != null && inventory[1] != null & inventory[2] != null && inventory[3] != null && inventory[4] != null)
			{
				throw new InventoryException("\nYour inventory is full. You need to drop an item from your\ninventory in order to pick another item up.");
			}
		}
		catch (InventoryException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	/** This static removeItem method has a try catch block that will catch
	 * an error is someone is trying to drop and item when they do not need to.
	 * This happens right after they dropped an item and go back to drop another item.
	 * The for loop goes through each index within the inventory array and
	 * if the inventory index is null, will throw the exception. This will ask the user 
	 * what variable they would like to drop. If the index string is equal to the item 
	 * the user is trying to drop, it will set that variable equal to false
	 * and will set the inventory index that string is in an set it equal to null. There
	 * is also a catch block that states that after an inventory item is dropped and it
	 * was the only item, the inventory is now null. It also calls the previous
	 * Inventory method to now print the new inventory after the item has
	 * been dropped.
	 * 
	 */
	public static void removeItem()
	{
		try 
		{
			System.out.print("\nWhat item would you like to drop?\n--> ");
			String item = input.nextLine();
			for (int a = 0; a < inventory.length; a++)
			{
				if (inventory[a] == null)
				{
					throw new InventoryException("\nYou have a free space to pick up an item.\nMake sure your inventory is full before you drop another item.");	
				}
				if (inventory[a].contains(item))
				{
					if (item.equals(car_Key))
					{
						carKey = false;
					}
					else if (item.equals(bedroom_Key))
					{
						bedroomKey = false;
					}
					else if (item.equals(_flashlight))
					{
						flashlight = false;
					}
					else if (item.equals(baseball_Bat))
					{
						baseballBat = false;
					}
					else if (item.equals(_pliers))
					{
						pliers = false;
					}
					else if (item.equals(_wire))
					{
						wire = false;
					}
					else if (item.equals(_crowbar))
					{
						crowbar = false;
					}
					else if (item.equals(door_Handle))
					{
						doorHandle = false;
					}
					else if (item.equals(car_Engine))
					{
						carEngine = false;
					}
					else if (item.equals(gas_Container))
					{
						gasContainer = false;
					}
					inventory[a] = null;
					break;
				}
			}
			if (inventory[0] == null && inventory[1] == null & inventory[2] == null && inventory[3] == null && inventory[4] == null)
			{
				throw new InventoryException("\nYour inventory is empty.");
			}
		}
		catch (InventoryException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.print("\nInventory: ");
		Inventory();
	}
	/** This static dropItem method takes the item parameter and will remove that item
	 * from the inventory. This method is only used when the user uses an item that
	 * will be placed and will never be used again. It uses a try catch block and 
	 * will print an exception if the inventory is null. It also searches for the
	 * item in the array and if it is found, will set that boolean variable equal
	 * to false and will sent the index it was found equal to null.
	 * 
	 * @param item
	 */
	public static void dropItem(String item)
	{
		try {
		for (int b = 0; b < inventory.length; b++)
		{	
			if (inventory[b] == null)
			{
				if (item == car_Engine)
				{
					throw new InventoryException("");
				}
				else if (item == door_Handle)
				{
					throw new InventoryException("");
				}
				else if (item == bedroom_Key)
				{
					throw new InventoryException("");
				}
				else
				{
					throw new InventoryException("\nYou have a free space to pick up an item.\nMake sure your inventory is full before you drop another item.");	
				}
			}
			if (inventory[b].contains(item))
			{
				if (item.equals(car_Key))
				{
					carKey = false;
				}
				else if (item.equals(bedroom_Key))
				{
					bedroomKey = false;
				}
				else if (item.equals(_flashlight))
				{
					flashlight = false;
				}
				else if (item.equals(baseball_Bat))
				{
					baseballBat = false;
				}
				else if (item.equals(_pliers))
				{
					pliers = false;
				}
				else if (item.equals(_wire))
				{
					wire = false;
				}
				else if (item.equals(_crowbar))
				{
					crowbar = false;
				}
				else if (item.equals(door_Handle))
				{
					doorHandle = false;
				}
				else if (item.equals(car_Engine))
				{
					carEngine = false;
				}
				else if (item.equals(gas_Container))
				{
					gasContainer = false;
				}
			}
			inventory[b] = null;
			break;
		}
		}
		catch (InventoryException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
