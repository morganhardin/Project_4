/** This class extends the abstract class Rooms so that it
 * can call and manipulate the variables and methods inside
 * that class in this one.
 * 
 * @author morganhardin
 *
 */
public class Garage extends Rooms
{
	/** The private static variables are instantiated here so that
	 * they can be used and changed in this class.
	 * 
	 */
	private static boolean garage = true;
	protected static boolean roomGarage = true;
	private static boolean car, hood, tank, carUnlocked, hoodOpened, hoodFixed, gasFilled;
	/** This empty constructor takes the private variables and the
	 * protected variables from the abstract class and set them
	 * equal to false and true, based on their use.
	 * 
	 */
	public Garage()
	{
		garage = true;
		car = false;
		hood = false;
		tank = false;
		carUnlocked = false;
		hoodOpened = false;
		hoodFixed = false;
		gasFilled = false;
		roomGarage = true;
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
	 */
	public static void Introduction()
	{
		roomGarage = true;
		
		while (roomGarage == true)
		{
			if (garage == true)
			{
				System.out.print("\nYou make your way to the garage and see your get away car for the first time.\n\nYou can CHECK door, hood, or tank or GO west to the living room.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("DOOR"))
				{
					garage = false;
					checkCar();
				}
				else if (choice.contains("HOOD"))
				{
					checkHood();
					garage = false;
				}
				else if (choice.contains("TANK"))
				{
					checkTank();
					garage = false;
				}
				else if (choice.contains("GO") || choice.contains("WE"))
				{
					garage = false;
					roomGarage = false;
				}
				else 
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
			else 
			{
				System.out.print("\nYou make your way back to the garage and see the car.\n\nYou can CHECK door, hood, or tank or GO west to the living room.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("DO"))
				{
					garage = false;
					checkCar();
				}
				else if (choice.contains("HO"))
				{
					garage = false;
					checkHood();
				}
				else if (choice.contains("TA"))
				{
					checkTank();
					garage = false;
				}
				else if (choice.contains("GO") || choice.contains("WE"))
				{
					garage = false;
					roomGarage = false;
				}
				else 
				{
					System.out.print("\nYour input did not match the options.\n");
				}
			}
		}
	}
	/** This checkCar method is be called from the Introduction method. There is one
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
	public static void checkCar()
	{
		if (car == false && carKey == false)
		{
			System.out.print("\nYou go to look closely at the car to find the car locked.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == true && carKey == false)
		{
			System.out.print("\nYou make your way back to the locked car.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == false && carKey == true && hoodFixed == false && gasFilled == true)
		{
			System.out.print("\nYou go to look closely at the car to find the car locked, but\nyou have the car key in your inventory.\n\nYou can USE car key or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("C") || choice.contains("KE"))
			{
				System.out.print("\nOnce you unlock the car, you realize that it will not turn on.\nAt least you don't have to fill the tank again.\n\nYou can LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					car = true;
					carUnlocked = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == true && carKey == true && hoodFixed == false && gasFilled == false)
		{
			System.out.print("\nYou go to look closely at the car to find the car locked, but\nyou have the car key in your inventory.\n\nYou can USE car key or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("C") || choice.contains("KE"))
			{
				System.out.print("\nOnce you unlock the car, you realize that it will not turn on.\nAt least you don't have to worry about filling the tank again.\n\nYou can LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					car = true;
					carUnlocked = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == false && carKey == true && hoodFixed == false && gasFilled == false)
		{
			System.out.print("\nYou go to look closely at the car to find the car locked, but\nyou have the car key in your inventory.\n\nYou can USE car key or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("C") || choice.contains("KE"))
			{
				System.out.print("\nOnce you unlock the car, you realize that it will not turn on, trying getting the hood open with one of your items.\n\nYou can LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					car = true;
					carUnlocked = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == false && carKey == true && carUnlocked == false && hoodFixed == true && gasFilled == true && NPC.npcFollowing == true)
		{
			System.out.print("\nYou turn the car on and with a full tank and a working engine, you and " + NPC.npcName + " are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
			{
				LivingRoom.roomLivingRoom = false;
				roomGarage = false;
				System.out.print("\nCongratulations you escaped!");
				Rooms.room = false;
			}
		}
		else if (car == false && carKey == true && carUnlocked == false && hoodFixed == true && gasFilled == true && NPC.npcFollowing == false)
		{
			System.out.print("\nYou turn the car on and with a full tank and a working engine, you are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
			{
				LivingRoom.roomLivingRoom = false;
				roomGarage = false;
				System.out.print("\nCongratulations you escaped!");
				Rooms.room = false;
			}
		}
		else if (car == true && carKey == true && carUnlocked == false)
		{
			System.out.print("\nYou go back to the locked car, but\nyou have the car key in your inventory.\n\nYou can USE car key or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("C") || choice.contains("KE"))
			{
				if (hoodFixed == false)
				{
					System.out.print("\nOnce you unlock the car, you realize that it will not turn on, trying getting the hood open with one of your items.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						garage = false;
						car = true;
						carUnlocked = true;
					}
				}
				else if (hoodFixed == true && gasFilled == false)
				{
					System.out.print("\nAfter fixing the hood and putting in the engine, you are able to get the car running.\nWhen the car is turned on, the gas light comes on, leaving you with no where to go.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						garage = false;
						car = true;
						carUnlocked = true;
						dropItem(car_Engine);
					}
				}
				else if (hoodFixed == true && gasFilled == true && NPC.npcFollowing == true)
				{
					System.out.print("\nYou turn the car on and with a full tank and a working engine, you and " + NPC.npcName + " are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
					{
						LivingRoom.roomLivingRoom = false;
						roomGarage = false;
						System.out.print("\nCongratulations! You escaped with " + NPC.npcName + ".");
						Rooms.room = false;
					}
				}
				else if (hoodFixed == true && gasFilled == true && NPC.npcFollowing == false)
				{
					System.out.print("\nYou turn the car on and with a full tank and a working engine, you and " + NPC.npcName + " are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
					{
						LivingRoom.roomLivingRoom = false;
						roomGarage = false;
						System.out.print("\nCongratulations! You escaped with " + NPC.npcName + ".");
						Rooms.room = false;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				car = true;
			}
		}
		else if (car == true && carUnlocked == true)
		{
			if (hoodFixed == false)
			{
				System.out.print("\nYou go back to the unlocked car and try to turn it on, but nothing happens.\nTry finding away to fix what's under the hood.\n\nYou can LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					car = true;
				}
			}
			else if (hoodFixed == true && gasFilled == false)
			{
				System.out.print("\nAfter fixing the hood and putting in the engine, you are able to get the car running.\nWhen the car is turned on, the gas light comes on, leaving you with no where to go.\n\nYou can LOOK elsewhere.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					car = true;
					carUnlocked = true;
				}
			}
			else if (hoodFixed == true && gasFilled == true && NPC.npcFollowing == true) 
			{
				System.out.print("\nYou turn the car on and with a full tank and a working engine, you and " + NPC.npcName + " are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
				{
					LivingRoom.roomLivingRoom = false;
					roomGarage = false;
					System.out.print("\nCongratulations! You escaped with " + NPC.npcName + ".");
					Rooms.room = false;
				}
			}
			else if (hoodFixed == true && gasFilled == true && NPC.npcFollowing == false)
			{
				System.out.print("\nYou turn the car on and with a full tank and a working engine, you and " + NPC.npcName + " are able to escape.\n\nYou can DRIVE THROUGH GARAGE DOOR.\n--> ");
				String choice = input.nextLine().toUpperCase();
				if (choice.contains("DR") || choice.contains("TH") || choice.contains("GA") || choice.contains("DO"))
				{
					LivingRoom.roomLivingRoom = false;
					roomGarage = false;
					System.out.print("\nCongratulations you escaped!");
					Rooms.room = false;
				}
			}
		}
	}
	/** This checkHood method is be called from the Introduction method. There is one
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
	public static void checkHood()
	{
		if (hood == false && crowbar == false && hoodOpened == false)
		{
			System.out.print("\nYou go to check the hood but find that it is stuck. Maybe find something to pry it open with.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
				
			}
		}
		else if (hood == false && crowbar == true && hoodOpened == false)
		{
			System.out.print("\nYou go to check the hood but find that it is stuck, but you have the crowbar in your inventory.\n\nYou can USE crowbar or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("CR") || choice.contains("BA"))
			{
				System.out.print("\nYou use the crowbar to open the hood of the car and find that there is no engine.\n\nYou can PLACE engine or LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("PL") || choice.contains("EN"))
				{
					if (carEngine == true)
					{
						System.out.print("\nThe engine has now been placed, allowing the car to run.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							garage = false;
							hood = true;
							hoodOpened = true;
							hoodFixed = true;
							dropItem(car_Engine);
						}
					}
					else if (carEngine == false)
					{
						System.out.print("\nYou do not have the car engine in your inventory so you cannot fix it.\nTry going to find the engine first.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							garage = false;
							hood = true;
							hoodOpened = true;
						}
					}
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					hood = true;
					hoodOpened = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
			}
		}
		else if (hood == true && crowbar == false && hoodOpened == false)
		{
			System.out.print("\nYou go to check the hood again, finding that it is still stuck. Maybe find something to pry it open with.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
			}
		}
		else if (hood == true && crowbar == true && hoodOpened == false)
		{
			System.out.print("\nYou go to check the hood but find that it is still stuck, but you have the crowbar in your inventory.\n\nYou can USE crowbar or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("US") || choice.contains("CR") || choice.contains("BA"))
			{
				System.out.print("\nYou use the crowbar to open the hood of the car and find that there is no engine.\n\nYou can PLACE engine or LOOK elsewhere.\n--> ");
				choice = input.nextLine().toUpperCase();
				if (choice.contains("PL") || choice.contains("EN"))
				{
					if (carEngine == true)
					{
						System.out.print("\nThe engine has now been placed, allowing the car to run.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.equals("LO") || choice.contains("EL"))
						{
							garage = false;
							hood = true;
							hoodOpened = true;
							hoodFixed = true;
							dropItem(car_Engine);
						}
					}
					else if (carEngine == false)
					{
						System.out.print("\nYou do not have the car engine in your inventory so you cannot fix it.\nTry going to find the engine first.\n\nYou can LOOK elsewhere.\n--> ");
						choice = input.nextLine().toUpperCase();
						if (choice.contains("LO") || choice.contains("EL"))
						{
							Scenarios.Introduction();
							garage = false;
							hood = true;
							hoodOpened = true;
						}
					}
				}
				else if (choice.contains("LO") || choice.contains("EL"))
				{
					Scenarios.Introduction();
					garage = false;
					hood = true;
					hoodOpened = true;
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
			}
		}
		else if (hoodOpened == true && hoodFixed == false)
		{
			System.out.print("\nYou come to the open hood of the car and find that there is no engine.\n\nYou can PLACE engine or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("PL") || choice.contains("EN"))
			{
				if (carEngine == true)
				{
					System.out.print("\nThe engine has now been placed, allowing the car to run.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						garage = false;
						hood = true;
						hoodOpened = true;
						hoodFixed = true;
						dropItem(car_Engine);
					}
				}
				else if (carEngine == false)
				{
					System.out.print("\nYou do not have the car engine in your inventory so you cannot fix it.\nTry going to find the engine first.\n\nYou can LOOK elsewhere.\n--> ");
					choice = input.nextLine().toUpperCase();
					if (choice.contains("LO") || choice.contains("EL"))
					{
						Scenarios.Introduction();
						garage = false;
						hood = true;
						hoodOpened = true;
					}
				}
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
				hoodOpened = true;
			}
		}
		else if (hoodFixed == true)
		{
			System.out.print("\nYou go to check on the car engine and find that is is working well enough for you to escape.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				garage = false;
				hood = true;
				hoodOpened = true;
				hoodFixed = true;
			}
		}
	}
	/** This checkTank method is be called from the Introduction method. There is one
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
	public static void checkTank()
	{
		if (tank == false && gasContainer == false && gasFilled == false)
		{
			System.out.print("\nYou go to check the tank but find that it is empty.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				tank = true;
				gasFilled = false;
			}
		}
		else if (tank == false && gasContainer == true && gasFilled == false)
		{
			System.out.print("\nYou go to check the empty tank, but luckily you have gas to fill it up.\n\nYou can FILL tank or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("FI") || choice.contains("TA"))
			{
				System.out.println("\nNow that the tank is filled, go check the rest of the car");
				tank = true;
				gasFilled = true;
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				tank = true;
				gasFilled = false;
			}
		}
		else if (tank == true && gasContainer == false && gasFilled == false)
		{
			System.out.print("\nYou go to check the tank again, but it is still empty.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				tank = true;
				gasFilled = false;
			}
		}
		else if (tank == true && gasContainer == true && gasFilled == false)
		{
			System.out.print("\nYou come back to the empty tank, but luckily you have gas to fill it up.\n\nYou can FILL tank or LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("FI") || choice.contains("TA"))
			{
				System.out.println("\nNow that the tank is filled, go check the rest of the car");
				tank = true;
				gasFilled = true;
			}
			else if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				tank = true;
				gasFilled = false;
			}
		}
		else if (tank == true && gasFilled == true)
		{
			System.out.print("\nYou come back to the tank, it is all filled up and ready for you to escape.\n\nYou can LOOK elsewhere.\n--> ");
			String choice = input.nextLine().toUpperCase();
			if (choice.contains("LO") || choice.contains("EL"))
			{
				Scenarios.Introduction();
				tank = true;
				gasFilled = true;
			}
		}
	}
}
