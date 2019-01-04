/**
 *BPDiastolicMonitor currently returns a diastolic value between 60 - 90mmHg
 */
public class BPDiastolicMonitor extends ModularDevice implements ISimDevice
{	
	private int diastolic;
	
	/**
	 * Returns an exception error on reading the diastolic value
	 * @return error message
	 */
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on BPDiastolic failed.");
		return (int)(Math.random() * ((90 - 60) + 1)) + 60;
		// return diastolic;
	}
	
	/**
	 * Sets the diastolic value
	 * @param newvalue new diastolic value
	 */
	public void setValue(int newvalue) {
		diastolic = newvalue;
	}
	
	/**
	 * Returns the diastolic value
	 * @return diastolic current value
	 */
	public int  getValue() {
		return diastolic;
	}
}