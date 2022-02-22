package application;



import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import javafx.scene.effect.DropShadow;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.*;
public class mainmenu {
private AnchorPane main;
private Scene scene;
private Stage stage;
public static int width=500;
public static int height=650;
private loadGame subload;
private pauseMenu pauseMenu;
public mainmenu() {
	main=new AnchorPane();
	scene=new Scene(main,width,height);
	stage= new Stage();
	
	stage.setScene(scene);
	buttons newGame=createButtons("New Game",160,225+80,23);
	buttons loadGame=createButtons("Load Game",160,290+80,23);
	buttons exitGame=createButtons("Exit Game",160,355+80,23);
	setBackground();
	addLogo();
	addImage(340,490);
	addImage(10,490);
	stage.setTitle("Color Switch");
	
	//main.getChildren().add(load);
	loadGame.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			loadGame();
		}
		
	});
	
	exitGame.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			quitGame();
		}
		
	});
	newGame.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			        // Update UI here.
			    	newGame(null);
					
			    }
			});
			
				
			
		}
		
	});
	
	stage.show();
}
private void addImage(int x,int y) {
	ImageView logo=new ImageView("imageSource/ghumneCircle.png");
	logo.setLayoutX(x);
	logo.setLayoutY(y);
	main.getChildren().add(logo);
	RotateTransition rotate =new RotateTransition();
	rotate.setAxis(Rotate.Z_AXIS);
	 rotate.setByAngle(360); 
	 rotate.setRate(0.1);
	 rotate.setCycleCount(Animation.INDEFINITE); 
	 rotate.setInterpolator(Interpolator.LINEAR);
	
	
	rotate.setNode(logo);
	rotate.play();
}
public Stage getMainStage() {
	return this.stage;
}
public Scene getMainScene() {
	return this.scene;
}
private buttons createButtons(String a,int b, int c,int a1) {
	buttons newGame=new buttons(a,a1);
	main.getChildren().add(newGame);
	newGame.setLayoutX(b);
	newGame.setLayoutY(c);
	return newGame;
}
private void loadGame() {
	subload=new loadGame(this);
	stage.setScene(subload.getScene());
	
}
public void newGame(saveGame1 saveGame1) {
	gamePlay gameScreen= new gamePlay(this,saveGame1);
	stage.setScene(gameScreen.getScene());
}
private void addLogo() {
	ImageView logo=new ImageView("imageSource/logo.png");
	logo.setLayoutX(85);
	logo.setLayoutY(80);
	logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

		

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			logo.setEffect(new DropShadow());
		}
		
	});
logo.setOnMouseExited(new EventHandler<MouseEvent>() {

		

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			logo.setEffect(null);
		}
		
	});
	main.getChildren().add(logo);
}
private void setBackground() {
	Image backgroundImage= new Image("imageSource/background.png",1000,1000,false,true);
	BackgroundImage background=new BackgroundImage(backgroundImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
	main.setBackground(new Background(background));
}

private void quitGame() {
	stage.close();
}
}
