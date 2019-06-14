
public class GameObject {

	private int id;
	private String name;
	
	
	public GameObject () {
		id=0;
		name= " ";
	}
	
	public GameObject (int id, String name) {
		this.id=id;
		this.name=name;
		
	}
	
	public GameObject (String name) {
		this.name=name;
		this.id=0;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "ID: "+getId()+" Name: "+getName();
	}
	
}
