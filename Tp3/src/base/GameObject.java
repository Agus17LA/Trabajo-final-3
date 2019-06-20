package base;

import java.util.Objects;
import java.util.Random;

//super clase que no tiene ningun metodo especial (todavia?)
public class GameObject {

    private String name;
    private int id;

    public GameObject() {
        name = "";
        id = 0;
    }

    public GameObject(String name) {
        this.name = name;
        this.id = 0;
    }

    public GameObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int ranNum(int min, int max) {
        Random r = new Random(System.nanoTime());
        return r.nextInt(max - min) + min;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
  
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GameObject other = (GameObject) obj;
        if (other.getName().equals(name)) {
            return true;
        }else{
        return false;
        }
    }
//nose lo hizo el ID 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
