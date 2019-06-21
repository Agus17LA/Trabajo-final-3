package inventory;

import base.Item;
import base.Messages;
import base.Playable;

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

    /**
     * Agrega un item mas al inventario, si esta repetido lo suma al total si no
     * lo agrega como item nuevo
     *
     * @param i el item a recibir
     * @return true en caso agregar un item ya existente, false en caso de
     * agregar un item nuevo
     */
    public boolean addItem(Item i) {
        boolean flag = false;

        if (inventory.containsKey(i.getName())) {
            inventory.put(i.getName(), inventory.get(i.getName()) + 1);
            flag = true;
        } else {
            inventory.put(i.getName(), 1);
            flag = false;
        }
        return flag;
    }

    /**
     * Usa el item, si ya no quedan mas de ese item lo borra
     *
     * @param p el personaje que va a usar el item
     * @param i El item a usar
     * @return Devuelve lo que paso en forma de string
     */
    public String useItem(Playable p, Item i) {
        StringBuilder builder = new StringBuilder();
        if (inventory.containsKey(i.getName())) {
            builder.append(i.useItem(p));
            inventory.put(i.getName(), inventory.get(i.getName()) - 1);
            if (inventory.get(i.getName()) == 0) {
                inventory.remove(i.getName());
            }
        } else {
            builder.append("No se puede usar el item ");
        }
        return builder.toString();
    }

    /**
     * Borra un item del inventario
     *
     * @param el item a borrar
     * @return true en caso de poder borrar el item false en caso contrario
     */
    public boolean removeItem(Item i) {
        boolean flag=false;
        if (inventory.containsKey(i.getName())) {
            inventory.remove(i.getName());
            flag=true;
        }
        return flag;
    }

    public void emptyInventory() {
        inventory.clear();
    }

    public int howManyItems() {

        return inventory.size();
    }

    public String showInventory() { //mostrar todos los items del inventario con for each
        StringBuilder builder = new StringBuilder();
        for (String name : inventory.keySet()) {
            builder.append(name.toString());
        }
        return builder.toString();
    }

    public String showInventoryIt() { //mostrar todos los items del inventario con iterator
        StringBuilder builder = new StringBuilder();
        Iterator it = inventory.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> mapEntry = (Map.Entry<Integer, String>) it.next();
            builder.append(mapEntry.getKey() + " " + mapEntry.getValue());
        }
        return builder.toString();
    }

}
