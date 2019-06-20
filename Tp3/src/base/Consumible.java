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
public class Consumible extends Item {
   
    private int hp;
    private int mana;

    public Consumible(){
        super();
        hp=0;
        mana=0;
    }
    public Consumible(int hp, int mana) {
        super();
        this.hp = hp;
        this.mana = mana;
    }

    public Consumible(int hp, int mana, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.mana = mana;
    }

    public String toString(){
        return getName()+" cura "+hp+" de vida y "+mana+" de mana.";
    }
    
    public String use(Character c){
        if(c.getHp()+hp>c.getMaxHp()){
            c.setHp(c.getMaxHp());
        }
        else{
            c.setHp(c.getHp()+hp);
        }
        
        if(c.getMana()+mana>c.getMana()){
            c.setMana(c.getMaxMana());
        }
        else{
            c.setMana(c.getMana()+mana);
        }
        return c.getName()+" uso "+getName()+" y se curo "+hp+" de vida y "+mana+" de mana."; 
    }

 
}
