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
	//ランチャーの起動
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("LoginForm");	//ウィンドウのタイトル
		
		GridPane	grid	= new GridPane();	//グリッドレイアウトを設定する
		grid.setAlignment(Pos.CENTER);			//背景に対して真ん中に配置する
		grid.setHgap(10);						//セル間の余白を設定（横方向）
		grid.setVgap(10);						//セル間の余白を設定（縦方向）
		grid.setPadding(new Insets(10,10,10,10));	//グリッドの外側の余白設定
		
		Text	sceneTitle	=	new Text("Welcome!");		//表題用のテキストを設定
		sceneTitle.setFont(Font.font("ubuntu mono", FontWeight.NORMAL,20));	//フォントを指定する
		//グリッドに追加する。引数は(Text,colIndex,colIndex,colSpan,colSpan)
		grid.add(sceneTitle,0,0,2,1);						
		
		Label	userName	=	new Label("user name:");	//説明ラベル
		grid.add(userName, 0, 1);
		
		TextField	textField	=	new TextField();		//文字入力欄
		grid.add(textField, 1, 1);
		
		Label	pw	=	new Label("Password:");				//説明ラベル
		grid.add(pw, 0, 2);
		
		PasswordField	pbox	=	new PasswordField();	//パスワード入力欄
		grid.add(pbox, 1, 2);
		
		Button	btn	=	new Button("Sign in");				//サインインボタンの作成
		HBox	hbox	=	new HBox(10);					//水平に並べるhboxレイアウトを採用
		hbox.getChildren().add(btn);						//子のPaneにサインインボタンを追加
		hbox.setAlignment(Pos.BOTTOM_LEFT);					//セル中で左下に配置されるように設定
		grid.add(hbox, 1, 4);								//hboxをグリッドに追加
		
		final Text	actionTarget	=	new Text();			//ボタンを押して反応させる用のテキストを作成（中身なし）
		grid.add(actionTarget, 1, 6);						//グリッドに追加（この時点では見えない）
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				actionTarget.setFill(Color.FIREBRICK);		//ボタンが押されたら赤色に染まるように設定
				actionTarget.setText("Sign in button Pressed!");//ボタンが押されたら具体的なテキストを設定する
			}
		});
		
		Scene	scene	=	new Scene(grid,300,300);		//sceneオブジェクトにグリッドレイアウトを追加してウィンドウサイズを設定
		stage.setScene(scene);								//stageオブジェクトにシーンを設定
		stage.show();										//見えるようにする
	}
	
}
