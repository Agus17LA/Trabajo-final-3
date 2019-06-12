
public class Playable extends Character{

	private int xp;
	private int lvl;
	private int xpMax;//variable para saber a que punto de xp se sube de lvl
	
        //implementar subida de nivel, experiencia maxima variable e invantario
	public Playable() {
		super();
		xp=0;
		lvl=0;
		xpMax=0;
	}
	
	public Playable(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int speed, int crit, int def,int xp, int lvl,int xpMax,String name, int id) {
		super(hp,mana,dmg,maxDmg,acc,dodge,speed,crit,def,name,id);
		this.xp=xp;
		this.lvl=lvl;
		this.xpMax=xpMax;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	

	public int getXpMax() {
		return xpMax;
	}

	public void setXpMax(int xpMax) {
		this.xpMax = xpMax;
	}

	public void lvlUp() {//subir de lvl
		
	}
}
