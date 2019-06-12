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
public class Armor extends Item{
    private int hpMod;
    private int dodgeMod;
    private int defMod;

    public Armor() {
        super("desarmado");
        hpMod=0;
        dodgeMod=0;
        defMod=0;
    }

    
    
    public Armor(int hpMod, int dodgeMod, int defMod, double weight, int sellPrice, int buyPrice, int total, int stackSize, String name, int id) {
        super(weight, sellPrice, buyPrice, total, stackSize, name, id);
        this.hpMod = hpMod;
        this.dodgeMod = dodgeMod;
        this.defMod = defMod;
    }
    
    public Armor (Armor a){
        
        super((Item) a);  //preguntarle a benoffi si esto es legal
         this.hpMod = a.hpMod;
        this.dodgeMod = a.dodgeMod;
        this.defMod = a.defMod;
    }

    public int getHpMod() {
        return hpMod;
    }

    public void setHpMod(int hpMod) {
        this.hpMod = hpMod;
    }

    public int getDodgeMod() {
        return dodgeMod;
    }

    public void setDodgeMod(int dodgeMod) {
        this.dodgeMod = dodgeMod;
    }

    public int getDefMod() {
        return defMod;
    }

    public void setDefMod(int defMod) {
        this.defMod = defMod;
    }
    
    
}
