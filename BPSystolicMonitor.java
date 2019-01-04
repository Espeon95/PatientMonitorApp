/**
 * BPSystolicMonitor currently returns a systolic BP between 90 - 145 mmHg
 */
public class BPSystolicMonitor extends ModularDevice implements ISimDevice
{	
	private int systolic;
	
	/**
	 * Returns an exception error on reading the systolic value
	 * @return error message
	 */
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on BPSystolic failed.");
		return (int)(Math.random() * ((145 - 90) + 1)) + 90;
		//return systolic;
	}
	
	/**
	 * Sets the systolic value
	 * @param newvalue new systolic value
	 */
	public void setValue(int newvalue) {
		systolic = newvalue;
	}
	
	/**
	 * Returns the systolic value
	 * @return systolic current value
	 */
	public int  getValue() {
		return systolic;
	}
}