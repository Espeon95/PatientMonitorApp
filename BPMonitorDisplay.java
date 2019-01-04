/**
 * BPMonitorDisplay graphically depicts the blood pressure
 */
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.util.Duration;

public class BPMonitorDisplay extends DeviceDisplayWidget
{
	Rectangle mainSysBox;
	Rectangle sysBox;
	Text      systolicValue;
	Text      diastolicValue;
	
	public BPMonitorDisplay(PatientMonitor initMonitor, int initxpos, int initypos) {
		super(initMonitor, initxpos, initypos);
	}
	
	/** 
	 * Initializes the Group to depict the blood pressure using an animated path and text
	 */
	public void initialize() {
		float initxpos = (float)basex;
		float initypos = (float)basey;
		
		// Create the systolic label and its value
		Label systolicLabel = new Label("Systolic:");
		systolicLabel.setTranslateY(initypos - 45);
		systolicLabel.setTranslateX(initxpos + 80);
		systolicLabel.setFont(Font.font("Calibri",FontWeight.NORMAL, 12));
    	
    	systolicValue = new Text(initxpos + 135, initypos - 33, "value");
    	systolicValue.setFont(Font.font("Calibri",FontWeight.NORMAL,FontPosture.ITALIC, 12));
    	
    	// Create the diastolic label and its value
    	Label diastolicLabel = new Label("Diastolic:");
		diastolicLabel.setTranslateY(initypos - 30);
		diastolicLabel.setTranslateX(initxpos + 80);
		diastolicLabel.setFont(Font.font("Calibri",FontWeight.NORMAL, 12));
		
    	diastolicValue = new Text(initxpos + 135, initypos - 18, "value");
    	diastolicValue.setFont(Font.font("Calibri",FontWeight.NORMAL,FontPosture.ITALIC, 12));
    	
    	final Rectangle wave = new Rectangle(20, 20, 3,3);
    	wave.setFill(Color.DARKGREEN);
    	
    	Rectangle boxStroke = new Rectangle(initxpos, initypos - 45, 70, 50);
    	boxStroke.setFill(Color.TRANSPARENT);
    	boxStroke.setStroke(Color.BLACK);

		// Create the animated path
		final Path path = new Path();
		path.getElements().add(new MoveTo(initxpos, initypos));
		path.getElements().add(new LineTo(initxpos + 20.0f, initypos));
		path.getElements().add(new CubicCurveTo(initxpos + 25, initypos - 15.0f, initxpos + 30.0f, initypos + 10.0f, initxpos + 30.0f, initypos));
		path.getElements().add(new CubicCurveTo(initxpos + 35, initypos - 80.0f, initxpos + 30.0f, initypos, initxpos + 40.0f, initypos));
		path.getElements().add(new LineTo(initxpos + 45.0f, initypos));
		path.getElements().add(new CubicCurveTo(initxpos + 55.0f, initypos - 20.0f, initxpos + 55.0f, initypos, initxpos + 60.0f, initypos));
		path.getElements().add(new LineTo(initxpos + 70.0f, initypos));
		path.setOpacity(0.5);
    
		final PathTransition pathTransition = new PathTransition();

		pathTransition.setDuration(Duration.seconds(1.0));
		pathTransition.setDelay(Duration.seconds(.5));
	   pathTransition.setPath(path);
		pathTransition.setNode(wave);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(false);
		pathTransition.play();

		this.getChildren().addAll(wave, path, systolicLabel, diastolicLabel, boxStroke, systolicValue, diastolicValue );
	}
	
	/**
	 * Updates by retrieving the systolic and diastolic blood pressure every second
	 */
	public void update() {
		int diastolic,
		    systolic;
		
		try {
			systolic  = monitor.getBPSystolic();
			diastolic = monitor.getBPDiastolic();
		}
		catch(Exception ex) {
			System.out.println( ex );
			systolic = 0;
			diastolic = 0;
		}
		
		systolicValue.setText(Integer.toString(systolic));
		diastolicValue.setText(Integer.toString(diastolic));
	}
}