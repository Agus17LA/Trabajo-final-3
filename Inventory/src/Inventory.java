import java.util.HashMap;

public class Inventory {

	private double weight;// peso actual del inventario
	private double maxWeight;// peso maximo del inventario, recibido dependiendo el personaje creado
	HashMap<Integer, String> inventory;// usamos hash map para poder tener una forma de identificar los items mas alla
										// de los nombres

	public Inventory() {
		weight = 0;
		maxWeight = 0;
		inventory = new HashMap<Integer, String>();
	}

	public Inventory(double maxWeight) {
		weight = 0;
		this.maxWeight = maxWeight;
		inventory = new HashMap<Integer, String>();
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public HashMap<Integer, String> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Integer, String> inventory) {
		this.inventory = inventory;
	}

	public boolean inventorySize(double weight, double maxWeight) { // esta funcion comprueba que haya espacio libre en
																	// el inventario basandose en el peso maximo y el
																	// actual
		boolean flag = false;
		if (weight < maxWeight) {
			flag = true;
		}
		return flag;
	}

	public boolean addItem(Item i) {
		boolean flag = false;
		if (inventorySize((getWeight() + i.getWeight()), getMaxWeight())) {// comprueba si hay espacio suficiente para
																			// el item a agregar
			inventory.put(i.getId(), i.getName());
			flag = true;
		}
		return flag;
	}

	public void removeItem(Item i) {
		inventory.remove(i.getId());
	}

	public void emptyInventory() {
		inventory.clear();
	}

	public int howManyItems() {

		return inventory.size();
	}

	public String showInventory() { //mostrar todos los items del inventario
		StringBuilder builder = new StringBuilder();
		for (Integer id : inventory.keySet()) {
			builder.append(id.toString());
		}
		return builder.toString();
	}
	
	public String showPerType(String type) { //mostrar por tipo de item
		StringBuilder builder = new StringBuilder();
		for (Integer i : inventory.keySet()) {

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
	
}
