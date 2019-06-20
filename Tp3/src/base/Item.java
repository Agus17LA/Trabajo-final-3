package base;

//clase item, la implementacion poliforma y la del inventario todavia no esta hecha
public class Item extends GameObject {

    /*todavia no sabemos bien cual de todos estos atributos vamos a usar*/
    private double weight;
    private int total;

    public Item() {
        super();
        weight = 0;
        total = 0;
    }

    public Item(String name) {
        super(name);
        weight = 0;
        total = 0;
    }

    public Item(String name, int id) {
        super(name);
        weight = 0;
        total = 0;

    }

    public Item(double weight, int total, String name, int id) {
        super(name, id);
        this.weight = weight;
        this.total = total;

    }

    public Item(Item i) {
        super(i.getName(), i.getId());
        this.weight = i.weight;
        this.total = i.total;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
