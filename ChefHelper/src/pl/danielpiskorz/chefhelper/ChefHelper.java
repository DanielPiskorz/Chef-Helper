package pl.danielpiskorz.chefhelper;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ChefHelper extends Application {

	
	static MenuDao menuDao = new FileInputMenu("menu.ser");
	static List<Dish> menu; 
	
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 500, 800);
		primaryStage.setScene(scene);

		
		menu = menuDao.loadMenu();
		
		ListView<Order> listView = new ListView<>(OrderListManager.mainOrderList);
		
		listView.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {
			@Override
			public ListCell<Order> call(ListView<Order> param) {
				return new OrderCell();
			}
		});
		listView.setPrefHeight(5000);
		
		TextField dishNumberTextField = new TextField();
		dishNumberTextField.setPrefSize(115, 50);
		dishNumberTextField.setFont(new Font("default", 20));
		dishNumberTextField.setAlignment(Pos.CENTER);
		dishNumberTextField.setPromptText("Dish No.");
		
		Button addButton = new Button("Add");
		addButton.setFont(new Font("default", 25));
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				OrderListManager.addNewOrder(dishNumberTextField.getText());
				dishNumberTextField.setText("");
			}
		});
		
		Label newOrderLabel = new Label("New order:");
		newOrderLabel.setFont(new Font("default", 20));
		newOrderLabel.setTextAlignment(TextAlignment.RIGHT);

		HBox bottomBox = new HBox(newOrderLabel, dishNumberTextField, addButton);
		bottomBox.setSpacing(15);
		bottomBox.setMinHeight(80);
		bottomBox.setPadding(new Insets(15));
		bottomBox.setAlignment(Pos.CENTER_RIGHT);

		VBox mainVbox = new VBox(listView, bottomBox);
		pane.getChildren().add(mainVbox);
		primaryStage.show();
	}

	

}