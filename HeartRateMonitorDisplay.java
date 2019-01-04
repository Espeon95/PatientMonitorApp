/**
 * HeartRateMonitorDisplay graphically depicts the heart rate
 */
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeartRateMonitorDisplay extends DeviceDisplayWidget
{
	ImageView iv;
	Text      heartRateValue;
	
	public HeartRateMonitorDisplay(PatientMonitor initMonitor, int initxpos, int initypos) {
		super(initMonitor, initxpos, initypos);
	}
	
	/** 
	 * Initializes the Group to depict the heart rate using an image and text
	 */
	public void initialize() {
		float initxpos = (float)basex;
		float initypos = (float)basey;
		
		Label heartRateLabel = new Label("Heart rate:");
		heartRateLabel.setTranslateY(initypos + 20);
		heartRateLabel.setTranslateX(initxpos + 6);
		heartRateLabel.setFont(Font.font("Calibri",FontWeight.NORMAL, 12));
    	
    	heartRateValue = new Text(initxpos + 135, initypos - 33, "value");
    	heartRateValue.setFont(Font.font("Calibri",FontWeight.NORMAL,FontPosture.ITALIC, 12));
    	heartRateValue.setX(initxpos + 30);
    	heartRateValue.setY(initypos + 50);

    	Image image = new Image( "heartrate.jpeg" );
		iv = new ImageView( image );
		iv.setX( initxpos );
		iv.setY( initypos );
		iv.setPreserveRatio( true );
		iv.setFitWidth( 80.0 );
		
		this.getChildren().addAll(iv, heartRateLabel, heartRateValue);
	}
	
	/**
	 * Updates by retrieving the heart rate every second
	 */
	public void update() {
		int heartRate;
		
		try {
			heartRate  = monitor.getHeartRate();
		}
		catch(Exception ex) {
			System.out.println( ex );
			heartRate = 0;
		}
		
		heartRateValue.setText(Integer.toString(heartRate));
	}
}