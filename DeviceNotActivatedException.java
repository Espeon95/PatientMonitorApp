/** 
 * DeviceNotActivatedException class allows each ModularDevice to throw its own 
 * unique error emssage
 */
public class DeviceNotActivatedException extends Exception
{
	public DeviceNotActivatedException(String message) {
		super( message );
	}
}