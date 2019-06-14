package base;

  import java.util.Vector;

public class Enemy extends Character{
    //funcion medio vacia pero que se le van a ir agregando cosas
    /*Idea general para esto, los enemigos al morir sueltan experiencia, la cual el personaje
    jugable agarra para ir subiendo de nivel y asi mejorar. Tambien tendran una chance de tirar algun item
    especial o algo asi
    */
        private int expDrop;
	Vector <Item> dropItems;
	private int dropItemChance;
	
	
	public Enemy() {
		super();
                expDrop=0;
		dropItems=new Vector <>();
		dropItemChance=0;
	}
	
        //este constructor esta mal, supongo que estabas viendo una version vieja del trabajo cuando lo hiciste, mañana lo arreglo
	public Enemy(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, int dropItemChance,String name, int id) {
		super(hp, mana, dmg, maxDmg,acc,dodge,crit,def,name,id);
		this.dropItemChance=dropItemChance;
	}
        public Enemy(Character c,int expDrop,Vector<Item> dropItems,int dropItemChance){
            super(c);
            this.expDrop=expDrop;
            this.dropItems=dropItems;// esto creo que esta mal, hace constructores de copia
            this.dropItemChance=dropItemChance;
            
        }
        public Enemy(Enemy e){
            super((Character)e);
            //arreglar y crear para asignar
            this.expDrop=e.expDrop;
            this.dropItems=e.dropItems;
            this.dropItemChance=dropItemChance;
            
        }

	public int getDropItemChance() {
		return dropItemChance;
	}

	public void setDropItemChance(int dropItemChance) {
		this.dropItemChance = dropItemChance;
	}
	
	public void dropItem(Character c) {
		//falta el metodo en si
	}
	
	public int calculateDropChance() { //funcion para calcular la chance de dropear un item al matar enemigo
            return 0;
		//falta el metodo en si
	}
	
	public void generateItems() {//funcion para generar items a dropear random
		//falta el metodo en si
	}
}
