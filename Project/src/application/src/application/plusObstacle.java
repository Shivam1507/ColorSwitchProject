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

public class plusObstacle extends obstacle1 {
public Arc a;
public Arc b;
public Arc c;
public Arc d;
public Arc e;
public Arc f;
public Arc g;
public Arc h;
private double x;
private double y;
private double z;
private double w;
private boolean spacePressed;
	public plusObstacle(AnchorPane main,double x, double y,double z,double w) {
		this.y=y;
		this.w=w;
		// TODO Auto-generated constructor stub
		a=new Arc();
		b=new Arc();
		c=new Arc();
		d=new Arc();
		e=new Arc();
		f=new Arc();
		g=new Arc();
		h=new Arc();
		 a.setCenterX(x); 
	      a.setCenterY(y); 
	      a.setRadiusX(90.0f); 
	      a.setRadiusY(90.0f); 
	      a.setStartAngle(45); 
	      a.setLength(90);
	      
	     b.setCenterX(x); 
	      b.setCenterY(y); 
	      b.setRadiusX(90.0f); 
	      b.setRadiusY(90.0f); 
	      b.setStartAngle(135); 
	      b.setLength(90);
	     
	     c.setCenterX(x); 
	      c.setCenterY(y); 
	      c.setRadiusX(90.0f); 
	      c.setRadiusY(90.0f); 
	      c.setStartAngle(225); 
	      c.setLength(90);
	      
	      d.setCenterX(x); 
	      d.setCenterY(y); 
	      d.setRadiusX(90.0f); 
	      d.setRadiusY(90.0f); 
	      d.setStartAngle(315); 
	      d.setLength(90);
	     
	      e.setCenterX(z); 
	      e.setCenterY(w); 
	      e.setRadiusX(90.0f); 
	      e.setRadiusY(90.0f); 
	      e.setStartAngle(45); 
	      e.setLength(90);
	      
	     f.setCenterX(z); 
	      f.setCenterY(w); 
	      f.setRadiusX(90.0f); 
	      f.setRadiusY(90.0f); 
	      f.setStartAngle(135); 
	      f.setLength(90);
	     
	     g.setCenterX(z); 
	      g.setCenterY(w); 
	      g.setRadiusX(90.0f); 
	      g.setRadiusY(90.0f); 
	      g.setStartAngle(225); 
	      g.setLength(90);
	      
	      h.setCenterX(z); 
	      h.setCenterY(w); 
	      h.setRadiusX(90.0f); 
	      h.setRadiusY(90.0f); 
	      h.setStartAngle(315); 
	      h.setLength(90);
	     
	      
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
	      e.setStroke(Color.CYAN);
	      f.setStroke(Color.DARKVIOLET);
	      g.setStroke(Color.DEEPPINK);
	      h.setStroke(Color.YELLOW);
	      e.setStrokeWidth(10);
	      e.setFill(null);
	      f.setStrokeWidth(10);
	      f.setFill(null);
	      g.setStrokeWidth(10);
	      g.setFill(null);
	      h.setStrokeWidth(10);
	      h.setFill(null);
	      e.setStrokeLineCap(StrokeLineCap.BUTT);
	      f.setStrokeLineCap(StrokeLineCap.BUTT);
	      g.setStrokeLineCap(StrokeLineCap.BUTT);
	      h.setStrokeLineCap(StrokeLineCap.BUTT);
	      main.getChildren().add(e);
	      main.getChildren().add(f);
	      main.getChildren().add(g);
	      main.getChildren().add(h);
		 
	}
	private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }
	private void movePivot1(Node node, double z, double w){
        node.getTransforms().add(new Translate(-z,-w));
        node.setTranslateX(z); node.setTranslateY(w);
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
	public Arc getArcE(){
		return this.e;
	}
	public Arc getArcF(){
		return this.f;
	}
	public Arc getArcG(){
		return this.g;
	}
	public Arc getArcH(){
		return this.h;
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
	public Color getColorE() {
		Color cc = (Color) this.e.getStroke();
		return cc;
	}
	public Color getColorF() {
		Color cc = (Color) this.f.getStroke();
		return cc;
	}
	public Color getColorG() {
		Color cc = (Color) this.g.getStroke();
		return cc;
	}
	public Color getColorH() {
		Color cc = (Color) this.h.getStroke();
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
	
	public void rotate1(Node node,double angle, double z,double w) {
		RotateTransition rotate1 =new RotateTransition();
		rotate1.setAxis(Rotate.Z_AXIS);
		rotate1.setByAngle(angle); 
		 rotate1.setRate(0.05);
		 rotate1.setCycleCount(Animation.INDEFINITE); 
		 rotate1.setInterpolator(Interpolator.LINEAR);
		
		
		rotate1.setNode(node);
		movePivot1(node,z,w);
		rotate1.play();
	}
	public void rotateNow() {
		rotate(a,360,0,77);
		rotate(b,360,77,0);
		rotate(c,360,0,-77);
		rotate(d,360,-77,0);
	}
	
	public void rotateNow1() {
		rotate1(e,-360,0,77);
		rotate1(f,-360,77,0);
		rotate1(g,-360,0,-77);
		rotate1(h,-360,-77,0);
	}
	
	public double collision(ball b1) {
		return (b1.getCoordinateY()-(this.y+this.w)/2);
	}
	
	public Arc collide(ball b1) {
		
		if(b1.circle.getBoundsInParent().intersects(a.getBoundsInParent()) &&b1.circle.getBoundsInParent().intersects(e.getBoundsInParent())&&(collision(b1)>=-2&&collision(b1)<=2)) {
			return a;
		}
		if(b1.circle.getBoundsInParent().intersects(b.getBoundsInParent()) &&b1.circle.getBoundsInParent().intersects(h.getBoundsInParent())&&(collision(b1)>=-2&&collision(b1)<=2)) {
			return b;
		}
		if(b1.circle.getBoundsInParent().intersects(c.getBoundsInParent()) &&b1.circle.getBoundsInParent().intersects(g.getBoundsInParent())&&(collision(b1)>=-2&&collision(b1)<=2)) {
			return c;
		}
		if(b1.circle.getBoundsInParent().intersects(d.getBoundsInParent()) &&b1.circle.getBoundsInParent().intersects(f.getBoundsInParent())&&(collision(b1)>=-2&&collision(b1)<=2)) {
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
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
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
	setW(getW()+i);
	e.setCenterY(getW());
	setW(getW()+i);
	f.setCenterY(getW());
	setW(getW()+i);
	g.setCenterY(getW());
	setW(getW()+i );
	h.setCenterY(getW());
	}
}
	
	
}

