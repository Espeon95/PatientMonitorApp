/**
 * ModularDevice is an abstract class that serves as a base for all modular devices
 */
public abstract class ModularDevice
{
	private boolean activated = false;
	
	/**
	 * Throws an exception if a ModularDevice is not activated
	 * @return error message specific to ModularDevice
	 */
	public abstract int read() throws DeviceNotActivatedException;
	
	/**
	 * Sets the ModularDevice to either true or false
	 * @param choice is on or off
	 */
	public void setActivated(boolean choice) {
		activated = choice;
	}
	
	/**
	 * Returns the ModularDevice's activation state
	 * @return is either on or off
	 */
	public boolean isActivated() {
		return activated;
	}
}