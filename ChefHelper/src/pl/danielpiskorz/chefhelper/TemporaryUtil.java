package pl.danielpiskorz.chefhelper;

import java.util.Arrays;

/*
 *This class exists only for adding a sample menu,
 *until the correct gui for editing menu will be done. 
 */
public class TemporaryUtil{
	static void saveNewMenu(MenuDao md) throws Exception{
		md.saveMenu(Arrays.asList(
				new Dish(1, "Chicken"),
				new Dish(2, "Steak"),
				new Dish(3, "Fish"),
				new Dish(4, "Soup"),
				new Dish(5, "Dessert")));
	}
}
