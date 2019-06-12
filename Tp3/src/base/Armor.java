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
/*Clase armadura, viene a ser tecnicamente la "ropa" que usa un personaje jugablo o npc, 
ofrece modicicaciones fijas de distintas estadisticas defensivas, todavia no esta claro si el "tipo"
de armadura va a ser un atributo o clases nuevas que hereden de esta*/
public class Armor extends Item {

    private int hpMod;  //Son modificadores LINEALES +5,+10,-4 etc 
    private int dodgeMod;
    private int defMod;

    public Armor() {
        super("desarmado");// este constructor es el de la superclase "gameobject" y solo recibe nombre, se supone que tiene que recibir un id pero no esta implementado
        hpMod = 0;
        dodgeMod = 0;
        defMod = 0;
    }
//constructor completo
    public Armor(int hpMod, int dodgeMod, int defMod, double weight, int sellPrice, int buyPrice, int total, int stackSize, String name, int id) {
        super(weight, sellPrice, buyPrice, total, stackSize, name, id);
        this.hpMod = hpMod;
        this.dodgeMod = dodgeMod;
        this.defMod = defMod;
    }
//constructor de copia
    public Armor(Armor a) {

        super((Item) a);  //preguntarle a benoffi si esto es legal
        this.hpMod = a.hpMod;
        this.dodgeMod = a.dodgeMod;
        this.defMod = a.defMod;
    }
    //getters y setters

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

    //dudo bastante que se tengan que agregar metodos nuevos
    
}
