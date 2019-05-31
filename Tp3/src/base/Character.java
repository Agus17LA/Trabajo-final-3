/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.Vector;
import java.util.Random;

/**
 *
 * @author Juan
 */
public class Character extends GameObject {
    private int hp;
    private int maxHp;
    private int mana;
    private int maxMana;
    private int dmg;
    private int maxDmg;
    private int acc;
    private int dodge;
    private int speed;
    private int crit;
    private int def;
    private Vector <Item> inventory;
    public Vector <Skill> vSkills; //vector of skills
    private Weapon weapon;
    private Armor armor;

   public Character(){
       super();
       hp=0;
       maxHp=0;
       mana=0;
       maxMana=0;
       dmg=0;
       maxDmg=0;
       acc=0;
       dodge=0;
       speed=0;
       crit=0;
       def=0;
       inventory= new Vector<Item>();
       vSkills=new Vector<Skill>();
       weapon= new Weapon();
       armor=new Armor();
   }
    
public Character(int hp, int mana, int dmg, int maxDmg,int acc, int dodge, int speed, int crit, int def, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.dmg = dmg;
        this.maxDmg = maxDmg;
        this.acc=acc;
        this.dodge = dodge;
        this.speed = speed;
        this.crit = crit;
        this.def = def;
        this.inventory = new Vector<Item>();
        this.vSkills = new Vector<Skill>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }
   
   
    public Character(int hp, int mana, int dmg, int maxDmg,int acc, int dodge, int speed, int crit, int def, Vector<Item> inventory, Vector<Skill> vSkills, Weapon weapon, Armor armor, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.dmg = dmg;
        this.maxDmg = maxDmg;
        this.acc=acc;
        this.dodge = dodge;
        this.speed = speed;
        this.crit = crit;
        this.def = def;
        this.inventory = inventory;
        this.vSkills = vSkills;
        this.weapon = weapon;
        this.armor = armor;
    }
    
    public Character (Character c){
        super(c.getName(),c.getId());
        this.hp = c.hp;
        this.maxHp = c.maxHp;
        this.mana = c.mana;
        this.maxMana = c.maxMana;
        this.dmg = c.dmg;
        this.maxDmg = c.maxDmg;
        this.acc=c.acc;
        this.dodge = c.dodge;
        this.speed = c.speed;
        this.crit = c.crit;
        this.def = c.def;
        this.inventory = c.inventory;
        this.vSkills = c.vSkills;
        this.weapon = c.weapon;
        this.armor = c.armor;
        
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }
    public int getAcc(){
        return acc;
    }
    public void setAcc(int acc){
        this.acc=acc;
    }
    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Vector<Item> getInventory() {
        return inventory;
    }

    public void setInventory(Vector<Item> inventory) {
        this.inventory = inventory;
    }

    public Vector<Skill> getvSkills() {
        return vSkills;
    }

    public void setvSkills(Vector<Skill> vSkills) {
        this.vSkills = vSkills;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    
    public String toString() {
		return " " + getName() + "\n Vida: " + hp + "/" + maxHp + "\n Mana: " + mana + "/" + maxMana + "\n Daño: "
				+ dmg +"-"+maxDmg+ " || Precision extra: +" + acc + "\n Evasion:  " + dodge+"|| Velocidad: " + speed + 
				  " \n Defensa: "  + def  + "%"  + "|| Critico: " +crit +"%";
    }
    public String showHp() {
		return " " + getName() + "|| Vida: " + hp + "/" + maxHp;
	}
    public boolean addSkill(Skill s){
        return vSkills.add(s);
    }
    
    public String attack(Character c,Skill s) { // Recibe un ataque de "p" personaje y el numero de habilidad elejida
		StringBuilder builder = new StringBuilder();
		int dmgTotal = 0;
		int hitChance = calculateHitChance(c,s);
		if (hit(hitChance)) {
			dmgTotal = calculateDmg(c,s);
                        int critTotal=c.crit+c.weapon.getCritMod()+s.getCritMod();
			if (isCrit(critTotal)) {
				dmgTotal = dmgTotal * 2;
				builder.append("GOLPE CRITICO!\n");
			}
			hp = hp - dmgTotal; //tendria que chequear si esta vivo
                   
			builder.append(c.getName() + "  ha usado " + s.getName() + " en " + getName() + " por "
					+ dmgTotal + " de daño!! \n");
		} else {
			builder.append(c.getName() + " ha errado el golpe!! \n");
		}
		return builder.toString();

	}

	public int calculateHitChance(Character c, Skill s) {
		int hitChance = 0;

		hitChance = c.getAcc()  +c.weapon.getAccMod() + s.getAccMod()- dodge- armor.getDodgeMod();
		if (hitChance < 10 || hitChance > 95) {
			if (hitChance < 10)
				hitChance = 10;
			else
				hitChance = 95;
		}
		return hitChance;
	}

	public boolean hit(int hitChance) {
		Random r = new Random(System.currentTimeMillis());
		return r.nextInt(100) < hitChance - 1; // nextInt(100) deja un numero entre 0 y 99, el cual comparamos
														// con
														// nuestra probabilidad de golpe, si el numero arrojado es menor
														// quiere decir que el golpe fue un "miss", por ende devuelve
														// false.

	}

	public int calculateDmg(Character c,Skill s) {
		int totalDmg = 0;
                int totalDef= def +armor.getDefMod();
		if (totalDef > 0)
			totalDmg = (int) ((((c.getDmg() + s.getDmgMod() + c.weapon.getDmgMod()))* (100 - totalDef)) / 100);// daño base+daño habilidad
																								// se le aplica el % de
																								// armadura
		else
			totalDmg = c.getDmg() + c.weapon.getDmgMod()+s.getDmgMod();
		if (totalDmg < 1)
			totalDmg = 1;
		return totalDmg;
	}

	public boolean isCrit(int critChance) {
		Random r = new Random(System.currentTimeMillis());
		return r.nextInt(100) < critChance - 1;
	}
        
        public String showSkills() {
		StringBuilder builder=new StringBuilder();
        int i;
		
		for(i=0;i<vSkills.size();i++) {
			builder.append(vSkills.elementAt(i).toString()).append("\n");
		}
		return builder.toString();
	}
	public boolean isAlive() {
		return hp>0;
	}
	public int totalSkills() {
		return vSkills.size();
	}
}
