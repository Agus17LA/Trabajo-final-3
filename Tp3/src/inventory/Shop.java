package inventory;

import base.Armor;
import base.Consumible;
import base.Item;
import base.Weapon;
import java.util.ArrayList;
import java.util.Vector;

//esta funcion es de bianca

public class Shop {

	// private ArrayList <Item> shop;
	private Vector<Weapon> weapons;
	private Vector<Armor> armors;
	private Vector<Consumible> consumibles;

	public Shop() {
		weapons = new Vector<>();
		armors = new Vector<>();
		consumibles = new Vector<>();
	}

	public boolean addItem(Item i) {
		boolean flag = false;
		if (i instanceof Weapon) {
			weapons.add((Weapon) i);
			flag = true;
		} else if (i instanceof Armor) {
			armors.add((Armor) i);
			flag = true;
		} else if (i instanceof Consumible) {
			consumibles.add((Consumible) i);
			flag = true;
		}
		return flag;
	}

	public String showAllItems() {
		StringBuilder builder = new StringBuilder();
		for (Weapon i : weapons) {
			builder.append(i.toString() + "\n");
		}
		for (Armor i : armors) {
			builder.append(i.toString() + "\n");
		}
		for (Consumible i : consumibles) {
			builder.append(i.toString() + "\n");
		}
		return builder.toString();
	}

	public String showPerType(String type) {
		StringBuilder builder = new StringBuilder();
		if (type.equals("Weapon")) {
			for (Weapon i : weapons) {
				builder.append(i.toString() + "\n");
			}
		} else if (type.equals("Armor")) {
			for (Armor i : armors) {
				builder.append(i.toString() + "\n");
			}
		} else if (type.equals("Consumible")) {
			for (Consumible i : consumibles) {
				builder.append(i.toString() + "\n");
			}
		}
		return builder.toString();
	}

	public boolean removeItem(Item i) {
		boolean flag = false;
		if (i instanceof Weapon) {
			weapons.remove((Weapon) i);
			flag = true;
		} else if (i instanceof Armor) {
			armors.remove((Armor) i);
			flag = true;
		} else if (i instanceof Consumible) {
			consumibles.remove((Consumible) i);
			flag = true;
		}
		return flag;
	}

/*	public void buyItem(Character c, Item i) {//remueve el item de la store, le resta el dinero al pj y se lo agrega al inventory
		boolean flag = true;
		flag = canBuy(c, i);
		if (flag) {
			flag=removeItem(i);
                        if(c.inventory.inventorySize(c.inventory.getWeight()+i.getWeight(),c.inventory.getMaxWeight())){
			c.inventory.addItem(i);
			c.inventory.setWeight(c.inventory.getWeight()+i.getWeight());
			c.setMoney(c.getMoney() - i.getBuyPrice());
                        }
			
		}
	}

	public void sellItem(Character c, Item i) {//agrega el item a la store y le suma el dinero al pj
		boolean flag=false;
		flag=addItem(i);
		c.inventory.removeItem(i);
		c.inventory.setWeight(c.inventory.getWeight()-i.getWeight());
		c.setMoney(c.getMoney()+i.getSellPrice());
		
	}

	public int checkCharacterMoney(Character c) { // devuelve la cantidad de dinero que tiene el pj
		return c.getMoney();
	}

	public boolean canBuy(Character c, Item i) {// checkea si el pj puede realizar la compra del item por valor y
												// disponibilidad,
												// faltaria agregar si puede por lvl o tipo de item
		boolean flag = false;
		flag=c.inventory.inventorySize(c.inventory.getWeight(),c.inventory.getMaxWeight());
		if (checkCharacterMoney(c) > i.getBuyPrice() && flag) {//ver como implementar la parte de inventario
			flag = true;
		}
		return flag;
	}
	*/
	public void removeStore() {
		weapons.clear();
		armors.clear();
		consumibles.clear();
	}

}
