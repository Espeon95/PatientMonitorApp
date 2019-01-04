/**
 * DeviceDisplayWidget allows for a common base with all display widgets
 */
import javafx.scene.Group;

public abstract class DeviceDisplayWidget extends Group
{
    PatientMonitor monitor;
    int basex;
    int basey;
    
    /**
     * Constructs the group
     */
    public DeviceDisplayWidget(PatientMonitor the_cm, int initx, int inity)
    {
        super();
        this.monitor = the_cm;
        this.basex = initx;
        this.basey = inity;
        this.initialize();
    }
    
    /**
     * Initializes the DeviceDisplayWidget's graphical depiction of its monitor
     */
    protected abstract void initialize();
    
    /**
     * Updates the DeviceDisplayWidget's monitor with the current value
     */
    public abstract void update();
}