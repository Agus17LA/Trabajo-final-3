
package base;


//super clase que no tiene ningun metodo especial (todavia?)
public class GameObject {
    private String name;
    private int id;
    public GameObject(){
        name="";
        id=0;
    }
       public GameObject(String name){
        this.name=name;
        this.id=0;
    }
    public GameObject(String name,int id){
        this.name=name;
        this.id=id;
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
    
}
