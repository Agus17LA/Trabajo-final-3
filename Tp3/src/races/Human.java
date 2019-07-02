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
public class Human extends Playable implements Iwarrior {

	public Human() {
		// se tiran "dados" para indicar los valores de las estadisticas
		setMaxHp(ranNum(35, 45));
		setHp(getMaxHp());
		setMaxMana(ranNum(29, 35));
		setMana(getMaxMana());
		setDmg(ranNum(6, 9));
		setMaxDmg(ranNum(11, 17));
		setAcc(ranNum(11, 16));
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
		Inventory inventory = new Inventory();// ver si empiezan con algun item,carga maxima
		setCrit(5);
		setDef(0);

		iniCharacterObjects();
                Skill s=new Skill();
                s.skillGolpeBasico();
                this.addSkill(s);
                s=new Skill();
                s.skillGolpeSorprendente();
                this.addSkill(s);
                 s=new Skill();
                s.skillCargaHeroica();
                this.addSkill(s);
                 s=new Skill();
                s.skillMorderElPolvo();
                this.addSkill(s);
                this.getWeapon().weaponEspadaGastada();
                
                 this.getArmor().armorEscudoChico();
	}

	@Override
	public String gainPower() {
            StringBuilder builder = new StringBuilder();
		if (getMana() - 5 >= 0) {
			if (getHp() - 15 >= 0) {
				setMana(getMana() - 5);
				setHp(getHp() - 15);
				setMaxDmg(getMaxDmg() + 2);
				setDmg(getDmg() + 2);
			} else {
				Messages m = new Messages();
				builder.append(m.hpError());
				
			}
		} else {
			Messages m = new Messages();			
			builder.append(m.manaError());
			
		}
               return builder.toString();
	}

	@Override
	public String heavyTraining() {
            StringBuilder builder = new StringBuilder();
		if (getDodge() - 1 >= 0) {
			setDodge(getDodge() - 1);
			setMaxHp(getMaxHp() + 10);
			setHp(getHp() + 5);
		} else {
			Messages m = new Messages();
			builder.append(m.dodgeError());
		}
                return builder.toString();
	}

}
