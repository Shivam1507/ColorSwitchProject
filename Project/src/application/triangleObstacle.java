package application;
import application.obstacle1;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class triangleObstacle extends obstacle1 {
public Arc a;
public Arc b;
public Arc c;
public Arc d;
private double x;
private double y;
private boolean spacePressed;
	public triangleObstacle(AnchorPane main,double x, double y) {
		this.y=y;
		a=new Arc();
		b=new Arc();
		c=new Arc();
		d=new Arc();
		 a.setCenterX(x); 
	      a.setCenterY(y); 
	      a.setRadiusX(90.0f); 
	      a.setRadiusY(90.0f); 
	      a.setStartAngle(45); 
	      a.setLength(90);
	      a.setType(ArcType.CHORD);
	     b.setCenterX(x); 
	      b.setCenterY(y); 
	      b.setRadiusX(90.0f); 
	      b.setRadiusY(90.0f); 
	      b.setStartAngle(135); 
	      b.setLength(90);
	      b.setType(ArcType.CHORD);
	     c.setCenterX(x); 
	      c.setCenterY(y); 
	      c.setRadiusX(90.0f); 
	      c.setRadiusY(90.0f); 
	      c.setStartAngle(225); 
	      c.setLength(90);
	      c.setType(ArcType.CHORD);
	      d.setCenterX(x); 
	      d.setCenterY(y); 
	      d.setRadiusX(90.0f); 
	      d.setRadiusY(90.0f); 
	      d.setStartAngle(315); 
	      d.setLength(90);
	      d.setType(ArcType.CHORD);
	      a.setStroke(Color.CYAN);
	      b.setStroke(Color.YELLOW);
	      c.setStroke(Color.DEEPPINK);
	      d.setStroke(Color.DARKVIOLET);
	      a.setStrokeWidth(10);
	      a.setFill(null);
	      b.setStrokeWidth(10);
	      b.setFill(null);
	      c.setStrokeWidth(10);
	      c.setFill(null);
	      d.setStrokeWidth(10);
	      d.setFill(null);
	      a.setStrokeLineCap(StrokeLineCap.BUTT);
	      b.setStrokeLineCap(StrokeLineCap.BUTT);
	      c.setStrokeLineCap(StrokeLineCap.BUTT);
	      d.setStrokeLineCap(StrokeLineCap.BUTT);
	      main.getChildren().add(a);
	      main.getChildren().add(b);
	      main.getChildren().add(c);
	      main.getChildren().add(d);
		 
	}
	private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }
	public double getRadius() {
		return this.a.getRadiusY();
	}
	public Arc getArcA(){
		return this.a;
	}
	public Arc getArcB(){
		return this.b;
	}
	public Arc getArcC(){
		return this.c;
	}
	public Arc getArcD(){
		return this.d;
	}
	public Color getColorA() {
		Color cc = (Color) this.a.getStroke();
		return cc;
	}
	public Color getColorB() {
		Color cc = (Color) this.b.getStroke();
		return cc;
	}
	public Color getColorC() {
		Color cc = (Color) this.c.getStroke();
		return cc;
	}
	public Color getColorD() {
		Color cc = (Color) this.d.getStroke();
		return cc;
	}
	@Override
	public void rotate(Node node,double angle, double x,double y) {
		RotateTransition rotate =new RotateTransition();
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.setByAngle(angle); 
		 rotate.setRate(0.05);
		 rotate.setCycleCount(Animation.INDEFINITE); 
		 rotate.setInterpolator(Interpolator.LINEAR);
		 rotate.setNode(node);
		movePivot(node,x,y);
		rotate.play();
	}
	public void rotateNow() {
		rotate(a,360,0,77);
		rotate(b,360,77,0);
		rotate(c,360,0,-77);
		rotate(d,360,-77,0);
	}
	public double collision(ball b1) {
		return Math.abs(b1.getCoordinateY()-this.y);
	}
	public Arc collide(ball b1) {
		
		if(b1.circle.getBoundsInParent().intersects(a.getBoundsInParent())&& (collision(b1)>=85 && collision(b1)<=95)){
			return a;
		}
		if(b1.circle.getBoundsInParent().intersects(b.getBoundsInParent())&& (collision(b1)>=85 && collision(b1)<=95)){
			return b;
		}
		if(b1.circle.getBoundsInParent().intersects(c.getBoundsInParent())&& (collision(b1)>=85 && collision(b1)<=95)){
			return c;
		}
		if(b1.circle.getBoundsInParent().intersects(d.getBoundsInParent())&& (collision(b1)>=85 && collision(b1)<=95)){
			return d;
		}
		return null;
		}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void jump(boolean bo) {
		double i=1;
		if(bo==true) {
			
		setY(getY()+i);
		a.setCenterY(getY());
		setY(getY()+i);
		b.setCenterY(getY());
		setY(getY()+i);
		c.setCenterY(getY());
		setY(getY()+i );
		d.setCenterY(getY());
		}
	}
	
	
}
