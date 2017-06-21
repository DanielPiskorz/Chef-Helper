import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ChefHelper extends Application {

	static int orderNumber;

	static String newOrderId() {
		return "Order No. " + String.valueOf(++orderNumber);
	}

	static ObservableList<String> mainOrderList =
			FXCollections.observableArrayList();

	static class Order extends ListCell<String> {

		HBox hbox = new HBox();
		Label label = new Label("/empty label/");
		Pane pane = new Pane();
		Button readyButton = new Button("Ready");
		String lastOrder;

		public Order() {
			super();
			hbox.getChildren().addAll(label, pane, readyButton);
			HBox.setHgrow(pane, Priority.ALWAYS);
			readyButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.printf("%s has been released at %tR. %n",
							lastOrder, new Date());
					mainOrderList.remove(lastOrder);

				}
			});
		}

		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			setText(null); // No text in label of super class
			if (empty) {
				lastOrder = null;
				setGraphic(null);
			} else {
				lastOrder = item;
				label.setText(item != null ? item : "<null>");
				setGraphic(hbox);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setScene(scene);

		ListView<String> lv = new ListView<>(mainOrderList);
		lv.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new Order();
			}
		});

		Button addButton = new Button("Add new order");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainOrderList.add(newOrderId());
			}
		});
		
		VBox mainVbox = new VBox(lv, addButton);
		pane.getChildren().add(mainVbox);
		primaryStage.show();
	}

}