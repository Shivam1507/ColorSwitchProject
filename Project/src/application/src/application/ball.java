package application;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import com.sun.prism.paint.Paint;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class ball  {
	Circle circle;
	private double coordinateX;
	private double coordinateY;
	private double radius;
	private AnimationTimer anime;
	private double dy=0;
	private boolean y;
	private boolean spacePressed;
	public ball(double x,double y,double radius, AnchorPane main){
		coordinateX=x;
		coordinateY=y;
		this.radius=radius;
		circle=new Circle(radius);
		circle.setLayoutX(coordinateX);
		circle.setLayoutY(coordinateY);
		main.getChildren().add(circle);
	}
	public void setColor(Color a) {
		circle.setFill(a);
	}
	public Color getColor() {
		Color cc = (Color) this.circle.getFill();
		return cc;
	}
	public double getCoordinateX() {
		return this.coordinateX;
	}
	public boolean isspacePressed() {
		return this.spacePressed;
	}
	public void setspacePressed(boolean spacePressed) {
		this.spacePressed = spacePressed;
	}
	
	/*public double getcentrex() {
		return circle.getLayoutX();
	}
	public double getcentrey() {
		return circle.getLayoutY();
	}*/
	public double getRadius() {
		return radius;
	}
	public double getCoordinateY() {
		return this.coordinateY;
	}
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}
	/*public void fall(Scene scene , int height) {
		 anime= new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				createKeyListener(scene);
				jump( height);
				gravity();
			}
			 
		 };
		anime.start(); 
	}*/
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
	public void jump(int height) {
			
//			if(height<=(circle.getLayoutY()+circle.getRadius())) {
//				circle.setLayoutY(height);
//			}
//			
			
		
		 if(spacePressed==true) {
			setCoordinateY(getCoordinateY()-5);
			circle.setLayoutY(getCoordinateY());
		}
	}
	
	public void gravity() {
		
			if(getCoordinateY()<=635) {
				setCoordinateY(getCoordinateY()+1.5);
					circle.setLayoutY(getCoordinateY());
			}
		}
	
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public void stop() {
		anime.stop();
	}
	
	

	
	}
	
