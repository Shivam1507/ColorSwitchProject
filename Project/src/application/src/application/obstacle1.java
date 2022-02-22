package application;



import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public abstract class obstacle1 {
	
	public obstacle1() {
		
		
	}
	public abstract void rotate(Node node,double angle, double x,double y);
}