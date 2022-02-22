package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class star extends obstacle1 {
	private double coordinateX;
	private double coordinateY;
	public ImageView logo=new ImageView("imageSource/star.png");
	public star(AnchorPane main, int x, int y){
		setCoordinateX(x);
		setCoordinateY(y);
		logo.setX(30);
	      logo.setY(30);
	    logo.setFitWidth(25);
	     logo.setPreserveRatio(true);
		logo.setLayoutX(x);
		logo.setLayoutY(y);
		main.getChildren().add(logo);
	
	}
	private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }
	public double getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	
	}
	public double getCoordinateY() {
		return coordinateY;
	}
	
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
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
		rotate(logo,360,0,0);
	}
	
	public int collide(ball b1) {
		if(b1.getCoordinateY()>=getCoordinateY()-2 && b1.getCoordinateY()<=getCoordinateY()+2){
			return 1;
		}
		
		return 0;}
		
		
	public void checkit (ImageView logo,ball ball,AnchorPane main) {
			Color cc=ball.getColor();
			if(cc==Color.CYAN) {
				Random rand=new Random(); 
			      int upperbound = 2;
			      int ran = rand.nextInt(upperbound);
			      if(ran==0) {
			    	  ball.setColor(Color.DARKVIOLET);
			      }
			      if(ran==1) {
			    	  ball.setColor(Color.YELLOW);
			      }
			      if(ran==2) {
			    	  ball.setColor(Color.DEEPPINK);
			      }}
			if(cc==Color.DARKVIOLET) {
				Random rand=new Random(); 
			      int upperbound = 2;
			      int ran = rand.nextInt(upperbound);
			      if(ran==0) {
			    	  ball.setColor(Color.CYAN);
			      }
			      if(ran==1) {
			    	  ball.setColor(Color.YELLOW);
			      }
			      if(ran==2) {
			    	  ball.setColor(Color.DEEPPINK);
			      }}
			if(cc==Color.YELLOW) {
				Random rand=new Random(); 
			      int upperbound = 2;
			      int ran = rand.nextInt(upperbound);
			      if(ran==0) {
			    	  ball.setColor(Color.CYAN);
			      }
			      if(ran==1) {
			    	  ball.setColor(Color.DARKVIOLET);
			      }
			      if(ran==2) {
			    	  ball.setColor(Color.DEEPPINK);
			      }}
			if(cc==Color.DEEPPINK) {
				Random rand=new Random(); 
			      int upperbound = 2;
			      int ran = rand.nextInt(upperbound);
			      if(ran==0) {
			    	  ball.setColor(Color.CYAN);
			      }
			      if(ran==1) {
			    	  ball.setColor(Color.YELLOW);
			      }
			      if(ran==2) {
			    	  ball.setColor(Color.DARKVIOLET);
			      }}
			
			main.getChildren().remove(logo);
			
			
		}
	
	
	
	public void jump(boolean bo) {
		double i=4;
		if(bo==true) {
			logo.relocate(coordinateX, getCoordinateY()+i);
		setCoordinateY(getCoordinateY()+i);
		}
	}
		
	
		
	}

