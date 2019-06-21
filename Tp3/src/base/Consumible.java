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

    public Consumible() {
        super();
        hp = 0;
        mana = 0;
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

    @Override
    public String toString() {
        return getName() + " cura " + hp + " de vida y " + mana + " de mana.";
    }

    @Override
    public String useItem(Playable p) {
        if (p.getHp() + hp > p.getMaxHp()) {
            p.setHp(p.getMaxHp());
        } else {
            p.setHp(p.getHp() + hp);
        }

        if (p.getMana() + mana > p.getMana()) {
            p.setMana(p.getMaxMana());
        } else {
            p.setMana(p.getMana() + mana);
        }
        return p.getName() + " uso " + getName() + " y se curo " + hp + " de vida y " + mana + " de mana.";
    }

    public void consumiblePocionVida() {
        setName("Pocion de vida");
        setId(0);
        hp = 50;
        mana = 0;
    }

    public void consumiblePocionMana() {
        setName("Pocion de mana");
        setId(0);
        hp = 0;
        mana = 50;
    }

    public void consumiblePocionDoble() {
        setName("Pocion doble");
        setId(0);
        hp = 50;
        mana = 50;
    }

}
