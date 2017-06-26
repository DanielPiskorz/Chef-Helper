package pl.danielpiskorz.chefhelper;

class Order {
	String id;
	Dish dish;

	public Order(int id, Dish dish) {
		super();
		this.id = String.valueOf(id);
		this.dish = dish;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

}