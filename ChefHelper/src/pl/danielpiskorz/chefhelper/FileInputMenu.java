package pl.danielpiskorz.chefhelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileInputMenu implements MenuDao {

	String file;
	
	
	public FileInputMenu(String file) {
		this.file = file;
	}



	@Override
	public List<Dish> loadMenu() throws Exception {
		List<Dish> menu;
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		menu = (List<Dish>) ois.readObject();
	    ois.close();
		return menu;
	}



	@Override
	public boolean saveMenu(List<Dish> menu) throws Exception {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(menu);
	    oos.close();
		return true;
	}
	
	

}
