/**
 *HeartRateMonitor currently returns a heart rate value between 60 - 120 beats/min
 */
 public class HeartRateMonitor extends ModularDevice implements ISimDevice
{	
	private int heartRate = 0;
	
	/**
	 * Returns an exception error on reading the heart rate value
	 * @return error message
	 */
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on heartrate failed.");
		return (int)(Math.random() * ((120 - 60) + 1)) + 60;
		// return heartRate;
	}
	
	/**
	 * Sets the heart rate value
	 * @param newvalue new heart rate value
	 */
	public void setValue(int newvalue) {
		heartRate = newvalue;
	}
	
	/**
	 * Returns the heart rate value
	 * @return heart rate current value
	 */
	public int  getValue() {
		return heartRate;
	}
}