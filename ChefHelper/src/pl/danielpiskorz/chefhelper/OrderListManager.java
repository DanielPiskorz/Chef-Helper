package pl.danielpiskorz.chefhelper;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderListManager {

	final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	final static ObservableList<Order> mainOrderList = FXCollections.observableArrayList();
	static int orderNumber;
	
	static void addNewOrder(String menuId){
		
		try{
		mainOrderList.add(new Order(++orderNumber,
				ChefHelper.menu.stream().filter(x -> x.getMenuId() == Integer.parseInt(menuId))
						.findFirst().get()));
		}catch(NoSuchElementException exc){
			Windows.error(String.format("Dish No. %s does not exist %n in selected menu.", menuId));
		}catch(NumberFormatException exc){
			Windows.error("Wrong input data, %n insert the correct %n number of dish.");
		}
		
		
	}
	
	static void removeOrder(Order order){
		System.out.printf("Order No. %s has been released at %s. %n",
				order.getId(), LocalTime.now().format(dtf));
		mainOrderList.remove(order);
	}
}
