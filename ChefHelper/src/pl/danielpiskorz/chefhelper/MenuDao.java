package pl.danielpiskorz.chefhelper;

import java.util.List;

public interface MenuDao {
	
	List<Dish> loadMenu() throws Exception;
	boolean saveMenu(List<Dish> menu) throws Exception;
}
