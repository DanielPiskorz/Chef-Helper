package pl.danielpiskorz.chefhelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Windows {
	
	public static void error(String error){
		Stage stage = new Stage();
		Label label1 = new Label(
				String.format(error));
		label1.setFont(new Font("default", 15));
		label1.setTextAlignment(TextAlignment.CENTER);
		Button closeButton = new Button("close");
		closeButton.setPadding(new Insets(7, 12, 7, 12));
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();

			}
		});
		
		VBox vbox = new VBox(label1, closeButton);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		StackPane stackPane = new StackPane(vbox);
		Scene scene = new Scene(stackPane, 300, 150);
		stage.setScene(scene);
		stage.show();
	}
	
}
