/**
 * ISimDevice provides a common interface to keep additional monitors unified and modular
 */
public interface ISimDevice
{
   /**
    * Sets a new value for the modular device
    * @param newvalue a new integer value for the modular device 
    */
	public void setValue(int newvalue);
	
	/**
	 * Returns the value for the modular device
	 * @return ModularDevice's current value
	 */
	public int  getValue();
}