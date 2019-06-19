/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package races;

import base.Armor;
import base.Messages;
import base.Playable;
import base.Skill;
import base.Weapon;
import inventory.Inventory;

/**
 *
 * @author Juan
 */
public class Gnome extends Playable implements Image {

    // Poner para ponerle un nombre
    public Gnome() {
        // se tiran "dados" para indicar los valores de las estadisticas
        setMaxHp(ranNum(27, 34));
        setHp(getMaxHp());
        setMaxMana(ranNum(20, 30));
        setMana(getMaxMana());
        setDmg(ranNum(6, 8));
        setMaxDmg(ranNum(12, 13));
        setAcc(ranNum(30, 40));
        setDodge(ranNum(4, 7));
        setLvl(0);
        // Los valores base sirven para indicar el cambio de estadisticas cuando se sube
        // de nivel
        // Toman el mismo valor que las estadisticas iniciales
        setHpBase(getHp());
        setManaBase(getMana());
        setDmgBase(getDmg());
        setDmgMaxBase(getMaxDmg());
        setAccBase(getAcc());
        setDodgeBase(getDodge());

        // otras cosas de un personaje jugable
        setXp(0);
        setXpMax(100);
        Inventory inventory = new Inventory(60);// ver si empiezan con algun item,carga maxima
        setCrit(5);
        setDef(0);

        iniCharacterObjects();

        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillAguijon();
        this.addSkill(s);
        s = new Skill();
        s.skillTormentaElectrica();
        this.addSkill(s);
        s = new Skill();
        s.skillApocalipsis();
        this.addSkill(s);
                        
        Weapon w = new Weapon();
        w.weaponBolsasDePiedras();
        
         Armor a=new Armor();
          a.armorRopaSucia();

    }

    @Override
    public void manaTransmutation() {
        if (getMana() - 10 >= 0) {
            setMana(getMana() - 10);
            setHp(getHp() + 15);
        } else {
            Messages m = new Messages();
            StringBuilder builder = new StringBuilder();
            builder.append(m.manaError());
            builder.toString();
        }
    }

    @Override
    public void magicGain() {
        if (getMana() - 30 >= 0) {
            setMana(getMana() - 30);
            setMaxDmg(getMaxDmg() + 1);
            setDmg(getDmg() + 1);
        } else {
            Messages m = new Messages();
            StringBuilder builder = new StringBuilder();
            builder.append(m.manaError());
            builder.toString();
        }
    }

}
