package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class squareObstacle extends obstacle1 {
public Line a;
public Line b;
public Line c;
public Line d;
private double e;//=175;
private double f;//=100;
private double g;//=325;
private double h;//=250;
private boolean spacePressed;
private double c1;

	squareObstacle(AnchorPane main,double e, double f, double g, double h){
		this.e=e;
		this.f=f;
		this.g=g;
		this.h=h;
		this.c1=(getF()+getH())/2;
		a=new Line(e,f,e,h);
		b=new Line(e,f,g,f);
		c=new Line(g,f,g,h);
		d=new Line(e,h,g,h);
		
		a.setStrokeWidth(10);
	
		b.setStrokeWidth(10);
		
		c.setStrokeWidth(10);
		
		d.setStrokeWidth(10);
		a.setStroke(Color.CYAN);
	      b.setStroke(Color.YELLOW);
	      c.setStroke(Color.DEEPPINK);
	      d.setStroke(Color.DARKVIOLET);
		main.getChildren().add(a);
		main.getChildren().add(b);
		main.getChildren().add(c);
		main.getChildren().add(d);
	}
	public Line LineA(){
		return this.a;
	}
	public Line LineB(){
		return this.b;
	}
	public Line LineC(){
		return this.c;
	}
	public Line LineD(){
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
	
	public double getE() {
		return e;
	}
	public void setE(double e) {
		this.e = e;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	
	public double getC1() {
		return c1;
	}
	public void setC1(double c1) {
		this.c1 = c1;
	}
	
	//square
	public double getcenter() {
		 return (getF()+getH())/2;
	}
	
	private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }
	@Override
	public void rotate(Node node, double angle, double x, double y) {
		// TODO Auto-generated method stub
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
	
	public void rotateN() {
		rotate(a,360,75,0);
		rotate(b,360,0,75);
		rotate(c,360,-75,0);
		rotate(d,360,0,-75);
	}
	
	public double collision(ball b1) {
		double w=getF();
		double i=getH();
		double y=(w+i)/2;
		return Math.abs(b1.getCoordinateY()-(y));
				
	}
	
	public Line collide(ball b1) {
		
		if(b1.circle.getBoundsInParent().intersects(a.getBoundsInParent())&& (collision(b1)>=70 && collision(b1)<=80)){
			return a;
		}
		if(b1.circle.getBoundsInParent().intersects(b.getBoundsInParent())&& (collision(b1)>=70 && collision(b1)<=80)){
			return b;
		}
		if(b1.circle.getBoundsInParent().intersects(c.getBoundsInParent())&& (collision(b1)>=70 && collision(b1)<=80)){
			return c;
		}
		if(b1.circle.getBoundsInParent().intersects(d.getBoundsInParent())&& (collision(b1)>=70 && collision(b1)<=80)){
			return d;
		}
		return null;
		
	
		
	}
	
	

	
	public void createKeyListener(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				if(event.getCode()==KeyCode.SPACE) {
					spacePressed=true;
				
				}
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode()==KeyCode.SPACE) {
					spacePressed=false;
				}
			}});
	}
	
	public void jump(boolean bo) {
		
		if(bo==true) {
		double i=1;
		setF(getF()+i);
		a.setLayoutY(getF());
		setH(getH()+i);
		a.setLayoutY(getH());
		setF(getF()+i);
		b.setLayoutY(getF());
		setH(getH()+i);
		b.setLayoutY(getH());
		setF(getF()+i);
		c.setLayoutY(getF());
		setH(getH()+i);
		c.setLayoutY(getH());
		setF(getF()+i);
		d.setLayoutY(getF());
		setH(getH()+i);
		d.setLayoutY(getH());
		}

	}
	
	
//	setF(getF()+i);
//	a.setLayoutY(getF());
//	setH(getH()+i);
//	a.setLayoutY(getH());
//	setF(getF()+i);
//	b.setLayoutY(getF());
//	setH(getH()+i);
//	b.setLayoutY(getH());
//	setF(getF()+i);
//	c.setLayoutY(getF());
//	setH(getH()+i);
//	c.setLayoutY(getH());
//	setF(getF()+i);
//	d.setLayoutY(getF());
//	setH(getH()+i);
//	d.setLayoutY(getH());
	
	
}