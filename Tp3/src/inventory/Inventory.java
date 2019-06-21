package inventory;

import base.Item;
import base.Messages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Inventory {

	private double weight;// peso actual del inventario
	private double maxWeight;// peso maximo del inventario, recibido dependiendo el personaje creado
	HashMap<String, Integer> inventory;// usamos hash map para poder tener una forma de identificar los items mas alla
										// de los nombres

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

	public Inventory() {
		inventory = new HashMap<String, Integer>();
	}



	/*public boolean addItem(Item i) {
		boolean flag = false;
		if (inventorySize((getWeight() + i.getWeight()), getMaxWeight())) {// comprueba si hay espacio suficiente para
																			// el item a agregar
			inventory.put(i.getId(), i.getName());
                        setWeight(getWeight()+i.getWeight());
			flag = true;
		}
		else {
			Messages m = new Messages();
			m.inventorySpaceError();
		}
		return flag;
	}*/

	/*public void removeItem(Item i) {
		inventory.remove(i.getId());
                setWeight(getWeight()-i.getWeight());
	}*/

	public void emptyInventory() {
		inventory.clear();
	}

	public int howManyItems() {

		return inventory.size();
	}

	public String showInventory() { //mostrar todos los items del inventario con for each
		StringBuilder builder = new StringBuilder();
		for (String id : inventory.keySet()) {
			builder.append(id.toString());
		}
		return builder.toString();
	}
        
        public String showInventoryIt(){ //mostrar todos los items del inventario con iterator
            StringBuilder builder=new StringBuilder();
            Iterator it=inventory.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,String> mapEntry= (Map.Entry<Integer,String>)it.next();
                builder.append(mapEntry.getKey()+" "+mapEntry.getValue());
            }
            return builder.toString();
        }
	
	public String showPerType(String type) { //mostrar por tipo de item con for each (creo habria que eliminarlo)
		StringBuilder builder = new StringBuilder();
		for (String i : inventory.keySet()) {

			if (type.equals("Armor")) {
				builder.append(i.toString()+"\n");
			}
			if (type.equals("Weapon")) {
				builder.append(i.toString()+"\n");
			}
			if (type.equals("Consumible")) {
				builder.append(i.toString()+"\n");
			}
			
		}
		return builder.toString();
	}
        
        public String showPerTypeIt(String type){ //mostrar por tipo de item con iterator (creo habria que eliminarlo)
            StringBuilder builder=new StringBuilder();
            Iterator it=inventory.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,String> mapEntry=(Map.Entry<Integer,String>)it.next();
                        if (type.equals("Armor")) {
				builder.append(mapEntry.toString()+"\n");
			}
			if (type.equals("Weapon")) {
				builder.append(mapEntry.toString()+"\n");
			}
			if (type.equals("Consumible")) {
				builder.append(mapEntry.toString()+"\n");
			}
            }
            
            return builder.toString();
        }
	
       
}
