package tutorial02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application{
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("LoginForm");
		
		GridPane	grid	= new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		
		Text	sceneTitle	=	new Text("Welcome!");
		sceneTitle.setFont(Font.font("ubuntu mono", FontWeight.NORMAL,20));
		grid.add(sceneTitle, 0, 0,2,1);
		
		Label	userName	=	new Label("user name:");
		grid.add(userName, 0, 1);
		
		TextField	textField	=	new TextField();
		grid.add(textField, 1, 1);
		
		Label	pw	=	new Label("Password:");
		grid.add(pw, 0, 2);
		
		PasswordField	pbox	=	new PasswordField();
		grid.add(pbox, 1, 2);
		
		Button	btn	=	new Button("Sign in");
		HBox	hbox	=	new HBox(10);
		hbox.getChildren().add(btn);
		hbox.setAlignment(Pos.BOTTOM_LEFT);
		grid.add(hbox, 1, 4);
		
		final Text	actionTarget	=	new Text();
		grid.add(actionTarget, 1, 6);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				actionTarget.setFill(Color.FIREBRICK);
				actionTarget.setText("Sign in button Pressed!");
			}
		});
		
		Scene	scene	=	new Scene(grid,300,300);
		stage.setScene(scene);
		
		stage.show();
	}
	
}
