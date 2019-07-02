/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package races;

import base.Armor;
import base.Messages;
//no hay nada implementado en este package, pero seguro que en algun momento lo  va a haber
import base.Playable;
import base.Skill;
import base.Weapon;
import inventory.Inventory;

/**
 *
 * @author Juan
 */
public class Dwarf extends Playable implements Iwarrior {

	public Dwarf() {

		// se tiran "dados" para indicar los valores de las estadisticas
		setMaxHp(ranNum(40, 50));
		setHp(getMaxHp());
		setMaxMana(ranNum(10, 15));
		setMana(getMaxMana());
		setDmg(ranNum(4, 6));
		setMaxDmg(ranNum(10, 19));
		setAcc(ranNum(15, 20));
		setDodge(ranNum(6, 9));
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
		Inventory inventory = new Inventory();// ver si empiezan con algun item,carga maxima
		setCrit(5);
		setDef(0);

		iniCharacterObjects();
                Skill s=new Skill();
                s.skillGolpeBasico();
                this.addSkill(s);
                s=new Skill();
                s.skillAtaque2Manos();
                this.addSkill(s);
                 s=new Skill();
                s.skillDesgarrar();
                this.addSkill(s);
                 s=new Skill();
                s.skillGritoDeGuerra();
                this.addSkill(s);
                
                
                this.getWeapon().weaponHachaSinFilo();
                
                this.getArmor().armorMediaArmadura();

	}

	@Override
	public String gainPower() {
            StringBuilder builder = new StringBuilder();
		if (getMana() - 7 >= 0) {
			if (getHp() - 20 > 0) {
				setMana(getMana() - 7);
				setHp(getHp() - 20);
				setMaxDmg(getMaxDmg() + 6);
				setDmg(getDmg() + 1);
			} else {
				Messages m = new Messages();// pongo la creacion del objeto aca para que se cree solo si es necesario y
											// no quede creado sin usarse
				builder.append(m.hpError());
			}
		} else {
			Messages m = new Messages();
			builder.append(m.manaError());

		}
               			return builder.toString();
	}

	public String heavyTraining() {
            StringBuilder builder = new StringBuilder();
		if (getDodge() - 2 >= 0) {
			setDodge(getDodge() - 2);
			setMaxHp(getMaxHp() + 15);
			setHp(getHp() + 10);
		} else {
			Messages m = new Messages();
			builder.append(m.dodgeError());

		}
			return builder.toString();
	}
            
}
