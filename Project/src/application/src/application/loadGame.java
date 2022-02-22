package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseButton;

public class loadGame  {
private final static String Font="src/imageSource/LemonMilkLight-owxMq.otf";
private final static String backgroundImage="imageSource/background.png";
private boolean hidden;	

private AnchorPane main;
private Scene scene;
private Stage stage;
public static int width=500;
public static int height=650;
private mainmenu mainMenu;

public loadGame(mainmenu a) {
		
	main=new AnchorPane();
	scene=new Scene(main,width,height);
	stage= new Stage();
	
	stage.setScene(scene);
		BackgroundImage background=new BackgroundImage(new Image("imageSource/background.png",1000,1000,false,true),
				BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,null);
	
	main.setBackground(new Background(background));
	returnHome();
	
	try {
		chooseLoadGame();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	hidden=true;
	mainMenu=a;
	}
public Scene getScene(){
	return this.scene;
}
	private ImageView returnHome() {
		ImageView logo=new ImageView("imageSource/homeSymbol.png");
		logo.setX(30);
	      logo.setY(30);
	    logo.setFitWidth(70);
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
			Stage p=mainMenu.getMainStage();
			
			p.setScene(mainMenu.getMainScene());
		}
		
	});
	main.getChildren().add(logo);
	return logo;
	}
	
		
	private buttons createButtons(String a,int b, int c,int a1) {
		buttons newGame=new buttons(a,a1);
		main.getChildren().add(newGame);
		newGame.setLayoutX(b);
		newGame.setLayoutY(c);
		return newGame;
	}
	
	private void chooseLoadGame() throws ClassNotFoundException, IOException {
		buttons button1=createButtons("Save Game 1", 200, 300, 23);
				
		ImageView logo=new ImageView("imageSource/chossesavedgame.png");
		logo.setX(30);
	      logo.setY(30);
	    logo.setFitWidth(200);
	     logo.setPreserveRatio(true);
		logo.setLayoutX(125);
		logo.setLayoutY(100);
		main.getChildren().add(logo);
		
		// ADding the code for serialziation
		ArrayList<saveGame1> savedGamesList=saveGame1.deserialize();
		System.out.println(savedGamesList.size()+": size of the saved games list");
		for (int i = 0; i < savedGamesList.size(); i++) {
			System.out.println("score of "+i+"th "+savedGamesList.get(i).score+" : ball y "+savedGamesList.get(i).ballY);
			
		}
//		button1.setOnAction(new EventHandler<ActionEvent>(){
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//				if(savedGamesList.size()>0) {
//					System.out.println("Running the last game ");
//					gamePlay gamePlay=new gamePlay(mainMenu, savedGamesList.get(0));
//				}
//		    	else {
//		    		System.out.println("unable to run");
//		    	}
//			}	
//		
//		}
		
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(savedGamesList.size()>0) {
					System.out.println("Running the last game ");
					mainMenu.newGame(savedGamesList.get(savedGamesList.size()-1));
					System.out.println("-----------------");
				}
		    	else {
		    		System.out.println("unable to run");
		    	}
			}
		});
		
		
	}

	

}
