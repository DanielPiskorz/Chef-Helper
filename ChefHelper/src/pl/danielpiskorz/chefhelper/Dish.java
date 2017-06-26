package pl.danielpiskorz.chefhelper;

import java.io.Serializable;

public class Dish implements Serializable{
	
	int menuId;
	String name;
	
	public Dish(int menuId, String name) {
		this.menuId = menuId;
		this.name = name;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
