package application;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import javafx.util.Duration;

public class deathManager extends SubScene {
	private final static String Font="src/imageSource/LemonMilkLight-owxMq.otf";
	private final static String backgroundImage="imageSource/background.png";
	private gamePlay game;	
	private boolean hidden;
	
	private Scene scene;
	private Stage stage;
	public static int width=500;
	public static int height=650;
	private mainmenu mainMenu;
	public deathManager(mainmenu u) {
		super(new AnchorPane(), width, height);
		Image backgroundImage= new Image("imageSource/background.png",1000,1000,false,true);
		BackgroundImage background=new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
		AnchorPane root=(AnchorPane) this.getRoot();
		buttons Resurrect=createButtons("Resurrect",160,225+80,23);
		buttons Restart=createButtons("Restart Game",160,290+80,18);
		buttons exitGame=createButtons("Exit to Main Menu",160,355+80,15);
		root.setBackground(new Background(background));
		mainMenu=u;
		Resurrect.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				MoveScreen();
				
			}});
		
		Restart.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				        // Update UI here.
				    	newGame();
						
				    }
				});
				
					
				
			}
			
		});
		
		
		exitGame.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Stage stage = (Stage) root.getScene().getWindow();
			stage.setScene(mainMenu.getMainScene());
				
			}});
		hidden=true;
	}
	private buttons createButtons(String a,int b, int c,int a1) {
		buttons newGame=new buttons(a,a1);
		AnchorPane root=(AnchorPane) this.getRoot();
		root.getChildren().add(newGame);
		newGame.setLayoutX(b);
		newGame.setLayoutY(c);
		GameOverLogo();
		return newGame;
	}
	private ImageView GameOverLogo() {
		ImageView logo=new ImageView("imageSource/GameOver.png");
		logo.setX(25);
	      logo.setY(70);
	    logo.setFitWidth(300);
	     logo.setPreserveRatio(true);
	 	logo.setLayoutX(85);
		logo.setLayoutY(80);
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				DropShadow a=new DropShadow();
				logo.setEffect(a);
				
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
			
		}
		
	});
	AnchorPane root=(AnchorPane) this.getRoot();
	root.getChildren().add(logo);
	return logo;
	}
	public void MoveScreen() {
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if(hidden==true) {
			transition.setToX(-676);
			transition.setToX(0);
		hidden=false;
		}
		else {
			transition.setToX(-676);
		hidden=true;
		}
		
		transition.play();
	}
	
	private void newGame() {
		mainmenu mm=new mainmenu();
		mm.newGame(null);
	}
}

