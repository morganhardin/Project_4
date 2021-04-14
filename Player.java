/** This class is for the player and is called
 * and used within the main game play and in the
 * scenarios class.
 * 
 * @author morganhardin
 *
 */
import java.util.*;

public class Player 
{
	/** This variable is protected and static so that
	 * there is only one instance of it, making however
	 * they were manipulated in other classes affected
	 * in this class.
	 * 
	 */
	protected static int playerLives;
	/** This empty constructor sets the int
	 * variable playerLives equal to 3.
	 * 
	 */
	public Player()
	{
		playerLives = 3;
	}
	/** This getter returns the int
	 * variable playerLives.
	 * 
	 * @return
	 */
	public static int getPlayerLives() 
	{
		return playerLives;
	}
	/** This setter is called in the GameApplication
	 * main method and will set the player's lives equal
	 * to the parameter.
	 * 
	 * @param lives
	 */
	public static void setPlayerLives(int lives) 
	{
		playerLives = lives;
	}
	/** This static loseLife method will be called in the Scenarios
	 * class and uses an if and else statement to make the NPC
	 * lose a life, and will make them stop following the user
	 * when they run out of lives.
	 * 
	 */
	public static void loseLife()
	{
		if (playerLives > 0)
		{
			playerLives--;
			System.out.println("You lost a life.");
			System.out.println("You now have " + Player.playerLives + " lives.");
		}
		if (playerLives == 0)
		{
			System.out.print("You ran out of lives. Try replaying the game to escape.\n");
			Kitchen.roomKitchen = false;
			Closet.roomCloset = false;
			Garage.roomGarage = false;
			LivingRoom.roomLivingRoom = false;
			Rooms.room = false;
		}
	}
}
