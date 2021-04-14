/** This class is an personalized exception
 * for inventory that extends exception.
 * 
 * @author morganhardin
 *
 */
public class InventoryException extends Exception
{
	/** This method takes the string message parameter
	 * and will then run the exception.
	 * 
	 * @param message
	 */
	public InventoryException(String message)
	{
		/** This calls the super class, or the 
		 * exception class and then puts the 
		 * inputed message into this function 
		 * that is to be called.
		 * 
		 */
		super(message);
	}
}
