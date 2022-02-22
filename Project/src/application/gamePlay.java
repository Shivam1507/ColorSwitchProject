package application;
import java.util.ArrayList;
import java.util.Random;



import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font; 

public class gamePlay {
	
	private AnimationTimer anime;
	private Timeline timeline;
	private final static String Font="src/imageSource/LemonMilkLight-owxMq.otf";
	private final static String backgroundImage="imageSource/background.png";
		private ball ball;
		boolean deathManager=false;
	private AnchorPane main;
	private Scene scene;
	private Stage stage;
	public static int width=500;
	public static int height=650;
	public pauseMenu pause;
	public deathManager death; 
	public mainmenu mainMenu;
	public int nstar;
	ArrayList<star> starslist=new ArrayList<star>();
	circleObstacle a;
	triangleObstacle b;
	plusObstacle c;
	colorChanger b1;
	Text text;
	Text text1;
	ImageView logo2;
	int score=0;
	
	public gamePlay(mainmenu u, saveGame1 saveGame1) {
		main=new AnchorPane();
		scene=new Scene(main,width,height);
		mainMenu=u;
		nstar=0;
		
		
			BackgroundImage background=new BackgroundImage(new Image("imageSource/background.png",1000,1000,false,true),
					BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		
		main.setBackground(new Background(background));
		pauseButton();
		starScore();
		
		if(saveGame1==null) {
			ball=new ball(250,635,10, main);
			ball.setColor(Color.CYAN);
			a=new circleObstacle(main,250,200);
			a.rotateNow();
			b=new triangleObstacle(main,250,-650);
			b.rotateNow();
			c=new plusObstacle(main,155,-275,345,-275);
			c.rotateNow();
			c.rotateNow1();
			
			b1=new colorChanger(main,200,500);
			star b2=new star(main,240,200);
			star b3=new star(main,240,-650);
			star b4=new star(main,240,-275);
			starslist.add(b2);
			starslist.add(b3);
			starslist.add(b4);
			b1.rotateNow();
			b2.rotateNow();
			b3.rotateNow();
			b4.rotateNow();
			text1 = new Text();
			String t1 = Integer.toString(score);
		
		
			text1.setText(t1);
			text1.setX(120); 
			text1.setY(100);
			text1.setFill(Color.WHITE); 
			text1.setStyle("-fx-font: 30 arial;");
			main.getChildren().add(text1);
			checkcollision(a,b,c,b1,b2,b3,b4,main, b1.logo,logo2);
			
		}
		else {
			ball=new ball(250,saveGame1.ballY,10, main);
			ball.setColor(Color.CYAN);
			a=new circleObstacle(main,250,saveGame1.circleY);
			a.rotateNow();
			b=new triangleObstacle(main,250,saveGame1.triangleY);
			b.rotateNow();
			c=new plusObstacle(main,155,saveGame1.plusY,345,saveGame1.plusY);
			c.rotateNow();
			c.rotateNow1();
			
			b1=new colorChanger(main,200,(int)saveGame1.colorChangerY);
			double y=saveGame1.starY.get(0);
			star b2=new star(main,240,(int)y);
			y=saveGame1.starY.get(1);
			star b3=new star(main,240,(int)y);
			y=saveGame1.starY.get(2);
			star b4=new star(main,240,(int)y);
			starslist.add(b2);
			starslist.add(b3);
			starslist.add(b4);
			b1.rotateNow();
			b2.rotateNow();
			b3.rotateNow();
			b4.rotateNow();
			text1 = new Text();
			score=saveGame1.getScore();
			System.out.println("+++++++++++"+saveGame1.score);
			String t1 = (""+saveGame1.score);
		
		
			text1.setText(t1);
			text1.setX(120); 
			text1.setY(100);
			text1.setFill(Color.WHITE); 
			text1.setStyle("-fx-font: 30 arial;");
			main.getChildren().add(text1);
			checkcollision(a,b,c,b1,b2,b3,b4,main, b1.logo,logo2);
			
		}
		
		
		
		
		
	}
		
	
	public Scene getScene() {
		return this.scene;
	}
	private void createSub() {
		if(deathManager==true) {
			death=new deathManager(mainMenu);
		}
		else {
		pause=new pauseMenu(mainMenu,this.ball,this.a,this.c,this.b,this.starslist,this.b1,this.score);
		}
		
	}
	private ImageView pauseButton() {
		ImageView logo=new ImageView("imageSource/pausesymbol.png");
		logo.setX(400);
	      logo.setY(30);
	    logo.setFitWidth(35);
	     logo.setPreserveRatio(true);
		logo.setLayoutX(10);
		logo.setLayoutY(10);
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				DropShadow a=new DropShadow();
				logo.setEffect(a);
				a.setColor(Color.WHITE);
				a.setBlurType(BlurType.GAUSSIAN);
				a.setRadius(100); 
				a.setHeight(100);
				 a.setWidth(100); 
			}
			
		});
	logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				logo.setEffect(null);
				
			}
			
		});
	logo.setOnMouseClicked(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			createSub();
			if(deathManager==true) {
			death.MoveScreen();
			main.getChildren().add(death);
		
			}
			else {
				pause.MoveScreen();
				main.getChildren().add(pause);
			}
			
		}

		
		
		
	});
	main.getChildren().add(logo);
	return logo;
	}
	private ImageView starScore() {
		ImageView logo2=new ImageView("imageSource/star.png");
		logo2.setX(10);
	      logo2.setY(10);
	    logo2.setFitWidth(55);
	     logo2.setPreserveRatio(true);                 
		logo2.setLayoutX(10);
		logo2.setLayoutY(10);
		
		Text text = new Text();
		String t = "Score:";
		text.setText(t);
		text.setX(20); 
		text.setY(100);
		text.setFill(Color.WHITE); 
		text.setStyle("-fx-font: 30 arial;");
		
		
		
		
	main.getChildren().add(logo2);
	main.getChildren().add(text);
	
	
	return logo2;
	}
	
	
	public void check(Arc v) {
		Color cc = (Color) v.getStroke();
		if(cc!=ball.getColor()) {
	    	  
	        anime.stop();
	    	  deathManager=true;
	    	  death=new deathManager(mainMenu);
	    	  if(deathManager==true) {
	    		 
	  			death.MoveScreen();
	  			main.getChildren().add(death);
	      }}}
	
	public void check1(Line l) {
		Color cc = (Color) l.getStroke();
		if(cc!=ball.getColor()) {
	    	  
	        anime.stop();
	    	  deathManager=true;
	    	  death=new deathManager(mainMenu);
	    	  if(deathManager==true) {
	    		 
	  			death.MoveScreen();
	  			main.getChildren().add(death);
	      }}
	}
	
	
	
	
		public void checkcollision(circleObstacle a,triangleObstacle b,plusObstacle c,/*squareObstacle d,*/colorChanger b1,star b2,star b3,star b4,AnchorPane main, ImageView logo, ImageView logo2) {
			
			 int i=0;
			 anime= new AnimationTimer() {

					@Override
					public void handle(long arg0) {
						
						if(ball.getCoordinateY()<=500) {
						 
						// TODO Auto-generated method stub
						ball.createKeyListener(scene);
						ball.jump( height);
						ball.gravity();
						a.jump(ball.isspacePressed());
						b.jump(ball.isspacePressed());
						c.jump(ball.isspacePressed());
						b1.jump(ball.isspacePressed());
						b2.jump(ball.isspacePressed());
						b3.jump(ball.isspacePressed());
						b4.jump(ball.isspacePressed());
						
						if(a.getY()>=740) {
							a.setY(b.getY()-500);
							b2.logo.relocate(b2.getCoordinateX(),b.getY()-500);
							b2.setCoordinateY(b.getY()-500);
							
						}
						else if(b.getY()>=740) {
							b.setY(c.getY()-500);
							b3.logo.relocate(b3.getCoordinateX(),c.getY()-500);
							b3.setCoordinateY(c.getY()-500);
						}
						
						else if(c.getY()>=740&&c.getW()>=740) {
							c.setY(a.getY()-500);
							c.setW(a.getY()-500);
							b4.logo.relocate(b4.getCoordinateX(),a.getY()-500);
							b4.setCoordinateY(a.getY()-500);
						}
											
						
						//circle
						Arc v=  a.collide(ball);
						if(v!=null) {
						check(v);}

						
						//triangle
						Arc l1=b.collide(ball);
						if(l1!=null) {
							check(l1);
						}

						
						//plus
						Arc l2=c.collide(ball);
						if(l2!=null) {
							check(l2);
						}
						
						
						//colorchanger
						int x=b1.collide(ball);
						if(x==1) {
							b1.checkit(logo,ball,main);
							b1.logo.relocate(200,b2.getCoordinateY()-500);
							b1.setCoordinateY(b1.getCoordinateY()-500);
						}
										
						
					 //star
						int y=b2.collide(ball);
						if(y==1) {
							b2.logo.relocate(b2.getCoordinateX(),800);
							b2.setCoordinateY(800);
							score=score+1;
							
						}
						
						int y3=b3.collide(ball);
						if(y3==1) {
							b3.logo.relocate(b2.getCoordinateX(),800);
							b3.setCoordinateY(800);
							score=score+1;
						}
						
						int y4=b4.collide(ball);
						if(y4==1) {
							b4.logo.relocate(b4.getCoordinateX(),800);
							b4.setCoordinateY(800);
							score=score+1;
						}
						
					}
						
						
						
					
						else {
							// TODO Auto-generated method stub
							ball.createKeyListener(scene);
							ball.jump( height);
							ball.gravity();
							if(a.getY()>=740) {
								a.setY(c.getY()-500);
								
							}
							else if(b.getY()>=740) {
								b.setY(a.getY()-500);
							}
							
							else if(c.getY()>=740&&c.getW()>=740) {
								c.setY(b.getY()-500);
								c.setW(b.getY()-500);
							}
						
//														
//							//circle
							Arc v=  a.collide(ball);
							if(v!=null) {
							check(v);}
						
////							//triangle
							Arc l1=b.collide(ball);
							if(l1!=null) {
								check(l1);
							}
							
////							//plus
							Arc l3=c.collide(ball);
							if(l3!=null) {
								check(l3);
							}
							
							
							//colorchanger
							int x=b1.collide(ball);
							if(x==1) {
								b1.checkit(logo,ball,main);
								b1.logo.relocate(200,b2.getCoordinateY()-500);
								b1.setCoordinateY(b1.getCoordinateY()-500);
							}
							
							
//							
							
							
							int y=b2.collide(ball);
							if(y==1) {
								b2.logo.relocate(b2.getCoordinateX(),800);
								b2.setCoordinateY(800);
								score=score+1;
							}
							
							int y3=b3.collide(ball);
							if(y3==1) {
								b3.logo.relocate(b2.getCoordinateX(),800);
								b3.setCoordinateY(800);
								score=score+1;
							}
							
							int y4=b4.collide(ball);
							if(y4==1) {
								b4.logo.relocate(b4.getCoordinateX(),800);
								b4.setCoordinateY(800);
								score=score+1;
							}
							
						
					}
					text1.setText(""+score);
					 
					}};
					
				anime.start(); 
				
			      
				   
			 }}