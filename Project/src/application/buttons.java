package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.effect.BlurType;

public class buttons extends Button {
private final String FontPath="src/imageSource/LemonMilkLight-owxMq.otf";
private final String ButtonPressed="-fx-background-color: transparent; -fx-background-Image: url('/imageSource/black.png');";
private final String ButtonStyle="-fx-background-color: transparent; -fx-background-Image: url('/imageSource/white.png');";

public buttons(String text,int a) {
	setText(text);
	setButtonFont(a);
	setPrefWidth(190);
	setPrefHeight(49);
	setStyle(ButtonStyle);
	initializeButtonListener();
}
private void setButtonFont(int a)  {
	try {
	setFont(Font.loadFont(new FileInputStream(FontPath), a));
	
	}
	catch (FileNotFoundException e) {
		setFont(Font.font("Verdana",23));
	}
	}
private void setButtonPressedStyle() {
	setStyle(ButtonPressed);
	setPrefHeight(45);
	setLayoutY(getLayoutY()+4);
	
}

private void setButtonReleasedStyle() {
	setStyle(ButtonStyle);
	setPrefHeight(45);
	setLayoutY(getLayoutY()-4);
	
}
private void initializeButtonListener() {
	setOnMousePressed(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			if(event.getButton().equals(MouseButton.PRIMARY)) {
				setButtonPressedStyle();
			}
		}

		
		
	});
	setOnMouseReleased(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			if(event.getButton().equals(MouseButton.PRIMARY)) {
				setButtonReleasedStyle();
			}
		}

		
		
	});
	setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			DropShadow a=new DropShadow();
			setEffect(a);
			a.setColor(Color.WHITE);
			a.setBlurType(BlurType.GAUSSIAN);
			a.setRadius(100); 
			a.setHeight(100);
			 a.setWidth(100); 
		}
		
	});
	setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			setEffect(null);
		}
		
	});
	
}

	
}
