package base;

/**
 * Los items son las armas/armaduras y los consumibles
 * @author Juan
 */
public class Item extends GameObject {


    public Item() {
        super();

    }

    public Item(String name) {
        super(name);

    }

    public Item(String name, int id) {
        super(name);


    }

    public Item(double weight, int total, String name, int id) {
        super(name, id);

    }

    public Item(Item i) {
        super(i.getName(), i.getId());

    }

}
