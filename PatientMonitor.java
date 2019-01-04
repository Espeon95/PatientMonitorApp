/**
 * PatientMonitor is the bridge between the monitors and the app.
 * All ModularDevices are activated and deactivated here.
 */
public class PatientMonitor
{
	ModularDevice BPSystolic;
	ModularDevice BPDiastolic;
	ModularDevice heartRate;
	
	/**
	 * Constructor to initialize all ModularDevices
	 */
	public PatientMonitor()
	{
		BPSystolic  = new BPSystolicMonitor();
		BPDiastolic = new BPDiastolicMonitor();
		heartRate   = new HeartRateMonitor();
		this.activateAll();
	}
	
	/**
	 * Returns the heart rate value to determine whether the app is on or off
	 * @return value of off or on
	 */
	public int toggleStartStop() {
		boolean newvalue = (getHeartRate()==0) ? true : false ;
		return (newvalue ? 1 : 0);
	}
	
	/**
	 * Deactivates all ModularDevices
	 */
	private void deactivateAll() {
		heartRate  .setActivated( false );
		BPSystolic .setActivated( false );
		BPDiastolic.setActivated( false );
	}
	
	/**
	 * Activates all ModularDevices
	 */
	private void activateAll() {
		heartRate  .setActivated( true );
		BPSystolic .setActivated( true );
		BPDiastolic.setActivated( true );
	}
	
	/**
	 * Returns the heart rate. If unable to it throws an exception.
	 * @return current heart rate
	 */
	public int getHeartRate() {
		try {
			return heartRate.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
	}
	
	/**
	 * Sets the heart rate
	 */
	public void setHeartRate() {
		((HeartRateMonitor)heartRate).setValue(100);
	}
	
	/**
	 * Returns the systolic bp. If unable to it throws an exception.
	 * @return the current systolic bp
	 */
	public int getBPSystolic() {
		try {
			return BPSystolic.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
	}
	
	/**
	 * Returns the diastolic bp. If unable to it throws an exception.
	 * @return the current diastolic bp
	 */
   public int getBPDiastolic() {
		try {
			return BPDiastolic.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
	}
}