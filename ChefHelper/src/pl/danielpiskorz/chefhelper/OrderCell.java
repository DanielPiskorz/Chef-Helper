package pl.danielpiskorz.chefhelper;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

class OrderCell extends ListCell<Order> {
	
	final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	
	HBox hbox = new HBox();
	Label timeLabel = new Label(LocalTime.now().format(dtf));
	Label orderNumberLabel = new Label();
	Label dishNumberLabel = new Label();
	Pane pane = new Pane();
	Button readyButton = new Button("Ready");
	Order lastOrder;

	public OrderCell() {
		super();
		hbox.getChildren().addAll(timeLabel, orderNumberLabel, dishNumberLabel, pane, readyButton);
		hbox.setSpacing(10);
		HBox.setHgrow(pane, Priority.ALWAYS);
		readyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				OrderListManager.removeOrder(lastOrder);

			}
		});
	}

	@Override
	protected void updateItem(Order order, boolean empty) {
		super.updateItem(order, empty);
		setText(null);
		if (empty) {
			lastOrder = null;
			setGraphic(null);
		} else {
			lastOrder = order;
			orderNumberLabel.setText(order != null ? order.getId() : "<null>");
			dishNumberLabel.setText(order != null ? String.valueOf(order.getDish().getName()) : "<null>");
			setGraphic(hbox);
		}
	}
}