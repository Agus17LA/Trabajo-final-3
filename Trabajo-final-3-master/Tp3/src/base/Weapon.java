/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Juan
 */
public class Weapon extends Item{
    private int dmgMod;
    private int accMod;
    private int critMod;

   
    public Weapon() {
        super("desarmado");
        dmgMod=0;
        accMod=0;
        critMod=0;
    }

    public Weapon(int dmgMod, int accMod, int critMod, double weight, int sellPrice, int buyPrice, int total, int stackSize, String name, int id) {
        super(weight, sellPrice, buyPrice, total, stackSize, name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
    }
    
    public Weapon(Weapon w){
        super((Item) w); //preguntarle al doctor benoffi si esto es legal
       
        
     this.dmgMod = w.dmgMod;
        this.accMod = w.accMod;
        this.critMod = w.critMod;
    }

    public int getDmgMod() {
        return dmgMod;
    }

    public void setDmgMod(int dmgMod) {
        this.dmgMod = dmgMod;
    }

    public int getAccMod() {
        return accMod;
    }

    public void setAccMod(int accMod) {
        this.accMod = accMod;
    }

    public int getCritMod() {
        return critMod;
    }

    public void setCritMod(int critMod) {
        this.critMod = critMod;
    }
    
     
     
}
