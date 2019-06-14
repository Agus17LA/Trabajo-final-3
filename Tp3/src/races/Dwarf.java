/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package races;

//no hay nada implementado en este package, pero seguro que en algun momento lo  va a haber
import base.Playable;
import inventory.Inventory;

/**
 *
 * @author Juan
 */
public class Dwarf extends Playable implements Iwarrior {

    public Dwarf() {

        //se tiran "dados" para indicar los valores de las estadisticas
        setMaxHp(ranNum(40, 50));
        setHp(getMaxHp());
        setMaxMana(ranNum(7, 12));
        setMana(getMana());
        setDmg(ranNum(4, 8));
        setMaxDmg(ranNum(10, 19));
        setAcc(ranNum(10, 15));
        setDodge(ranNum(6, 9));

        //Los valores base sirven para indicar el cambio de estadisticas cuando se sube de nivel
        //Toman el mismo valor que las estadisticas iniciales
        setHpBase(getHp());
        setManaBase(getMana());
        setDmgBase(getDmg());
        setDmgMaxBase(getMaxDmg());
        setAccBase(getAcc());
        setDodgeBase(getDodge());

        //otras cosas de un personaje jugable
        setXp(0);
        setXpMax(100);
        Inventory inventory = new Inventory(100);//ver si empiezan con algun item,carga maxima
        setCrit(5);
        setDef(0);

        iniCharacterObjects();

    }

    @Override
    public void gainPower() {
        setMana(getMana() - 7);
        if (getHp() - 20 < 1) {
            setHp(getHp() - 20);
                setMaxDmg(getMaxDmg() + 6);
                setDmg(getDmg() + 1);
        }
        else
        {
    }

    public void heavyTraining() {
        setDodge(getDodge() - 2);
        setMaxHp(getMaxHp() + 15);
        setHp(getHp() + 10);
    }

}
