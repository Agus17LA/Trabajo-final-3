package base;

//clase item, la implementacion poliforma y la del inventario todavia no esta hecha
public class Item extends GameObject {

    /*todavia no sabemos bien cual de todos estos atributos vamos a usar*/

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
