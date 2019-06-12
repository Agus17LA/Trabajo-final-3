import java.util.Vector;

public class Enemy extends Character{

	Vector <Item> dropItems;
	private int dropItemChance;
	
	
	public Enemy() {
		super();
		dropItems=new Vector <>();
		dropItemChance=0;
	}
	
	public Enemy(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int speed, int crit, int def, int dropItemChance,String name, int id) {
		super(hp, mana, dmg, maxDmg,acc,dodge,speed,crit,def,name,id);
		this.dropItemChance=dropItemChance;
	}

	public int getDropItemChance() {
		return dropItemChance;
	}

	public void setDropItemChance(int dropItemChance) {
		this.dropItemChance = dropItemChance;
	}
	
	public void dropItem(Character c) {
		
	}
	
	public int calculateDropChance() { //funcion para calcular la chance de dropear un item al matar enemigo
		
	}
	
	public void generateItems() {//funcion para generar items a dropear random
		
	}
}
