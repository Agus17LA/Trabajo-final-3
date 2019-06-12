/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import inventory.Inventory;
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
    private Vector<Status> vStatus;
    private Inventory inventory;
    public Vector<Skill> vSkills; //vector of skills
    private Weapon weapon;
    private Armor armor;

    public Character() {
        super();
        hp = 0;
        maxHp = 0;
        mana = 0;
        maxMana = 0;
        dmg = 0;
        maxDmg = 0;
        acc = 0;
        dodge = 0;
        speed = 0;
        crit = 0;
        def = 0;
        vStatus = new Vector<Status>();
        inventory = new Inventory();
        vSkills = new Vector<Skill>();
        weapon = new Weapon();
        armor = new Armor();
    }

    public Character(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int speed, int crit, int def, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.dmg = dmg;
        this.maxDmg = maxDmg;
        this.acc = acc;
        this.dodge = dodge;
        this.speed = speed;
        this.crit = crit;
        this.def = def;
        this.vStatus = new Vector<Status>();
        this.inventory = new Inventory();
        this.vSkills = new Vector<Skill>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }

    public Character(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int speed, int crit, int def, Vector<Item> inventory, Vector<Skill> vSkills, Weapon weapon, Armor armor, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.dmg = dmg;
        this.maxDmg = maxDmg;
        this.acc = acc;
        this.dodge = dodge;
        this.speed = speed;
        this.crit = crit;
        this.def = def;
        this.inventory = new Inventory();
        this.vSkills = vSkills;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Character(Character c) {
        super(c.getName(), c.getId());
        this.hp = c.hp;
        this.maxHp = c.maxHp;
        this.mana = c.mana;
        this.maxMana = c.maxMana;
        this.dmg = c.dmg;
        this.maxDmg = c.maxDmg;
        this.acc = c.acc;
        this.dodge = c.dodge;
        this.speed = c.speed;
        this.crit = c.crit;
        this.def = c.def;
        this.vStatus = c.vStatus;
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

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
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
                + dmg + "-" + maxDmg + " || Precision extra: +" + acc + "\n Evasion:  " + dodge + "|| Velocidad: " + speed
                + " \n Defensa: " + def + "%" + "|| Critico: " + crit + "%";
    }

    public String showHp() {
        return " " + getName() + "|| Vida: " + hp + "/" + maxHp;
    }

    public boolean addSkill(Skill s) {
        return vSkills.add(s);
    }

    public String attack(Character c, Skill s) { // Recibe un ataque de "c" personaje y la habilidad que uso
        StringBuilder builder = new StringBuilder();
        int dmgTotal = 0;
        int hitChance = calculateHitChance(c, s);
        if (hit(hitChance)) {
            builder.append(s.useSkill(c, this));
        } else {
            builder.append(c.getName() + " ha errado el golpe!! \n");
        }
        return builder.toString();

    }

    public int calculateHitChance(Character c, Skill s) {
        int hitChance = 0;

        hitChance = c.getAcc() + c.weapon.getAccMod() + s.getAccMod() - dodge - armor.getDodgeMod();
        if (hitChance < 10 || hitChance > 95) {
            if (hitChance < 10) {
                hitChance = 10;
            } else {
                hitChance = 95;
            }
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

    public int calculateDmg(Character c, Skill s) { // calcula el daño que recibe de "c"
        float totalDmg = 0;
        float totalDef = (100 - (def + armor.getDefMod())) / 100;
        if (totalDef > 75 / 100) {
            totalDef = 75 / 100;
        }
        totalDmg = (c.getDmg() + c.weapon.getDmgMod()) * (s.getDmgMod() / 100) * totalDef; // daño base+daño habilidad
        // se le aplica el % de
        // armadura

        if (totalDmg < 1) {
            totalDmg = 1;
        }
        return (int) totalDmg;
    }

    public boolean isCrit(int critChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < critChance - 1;
    }

    public String showSkills() {
        StringBuilder builder = new StringBuilder();
        int i;

        for (i = 0; i < vSkills.size(); i++) {
            builder.append(vSkills.elementAt(i).toString()).append("\n");
        }
        return builder.toString();
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int totalSkills() {
        return vSkills.size();
    }

    /**
     * 
     * @param status
     * @return 
     */
    public String addStatus(Status status) {   
        String s = " ";
        if (status instanceof Stun) {
            Stun stun=new Stun((Stun) status);
            vStatus.add(stun);
            s = getName() + " fue aturdido!";
        }
        if (status instanceof Poison) {
            Poison poison=new Poison((Poison)status);
            vStatus.add(poison);
            s = getName() + " fue envenenado!";
        }
        if(status instanceof Buff){
            Buff buff=new Buff((Buff)status);
            vStatus.add(buff);
            s=getName()+" sufre una modificacion en sus estadisticas!!";
        }
        return s;
    }

    /**
     * 
     * @return 
     */
    public String statusEffect() { // aca puedo meter un try catch? preguntar cuando me acuerde
        StringBuilder builder = new StringBuilder();
        if (!vStatus.isEmpty()) {
            int i = 0;
            for (i = 0; i < vStatus.size(); i++) {
                builder.append(vStatus.elementAt(i).statusTurn(this));//preguntar a benoffiiiiiiii
                if (vStatus.elementAt(i).getDuration() == 0) {
                    vStatus.remove(i);
                    i--;
                }
            }

        }
        return builder.toString();
    }

    public boolean isStunned() {
        boolean flag=false;
       int i=0;
       for(i=0;i<vStatus.size()&&flag==false;i++){
           if(vStatus.elementAt(i).isStun())
               flag=true;
       }
        return flag;
    }
    


}
