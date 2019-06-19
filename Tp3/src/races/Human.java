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
		setMaxMana(ranNum(9, 15));
		setMana(getMaxMana());
		setDmg(ranNum(6, 9));
		setMaxDmg(ranNum(11, 16));
		setAcc(ranNum(11, 16));
		setDodge(ranNum(4, 7));

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
		Inventory inventory = new Inventory(100);// ver si empiezan con algun item,carga maxima
		setCrit(5);
		setDef(0);

		iniCharacterObjects();
                Skill s=new Skill();
                s.skillGolpeBasico();
                System.out.println("Daño de mi personaje: " +getDmg());
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
                Weapon w=new Weapon();
                w.weaponEspadaGastada();
                
                Armor a=new Armor();
                 a.armorEscudoChico();
	}

	@Override
	public void gainPower() {
		if (getMana() - 5 >= 0) {
			if (getHp() - 15 >= 0) {
				setMana(getMana() - 5);
				setHp(getHp() - 15);
				setMaxDmg(getMaxDmg() + 2);
				setDmg(getDmg() + 2);
			} else {
				Messages m = new Messages();
				StringBuilder builder = new StringBuilder();
				builder.append(m.hpError());
				builder.toString();
			}
		} else {
			Messages m = new Messages();
			StringBuilder builder = new StringBuilder();
			builder.append(m.manaError());
			builder.toString();
		}

	}

	@Override
	public void heavyTraining() {
		if (getDodge() - 1 >= 0) {
			setDodge(getDodge() - 1);
			setMaxHp(getMaxHp() + 10);
			setHp(getHp() + 5);
		} else {
			Messages m = new Messages();
			StringBuilder builder = new StringBuilder();
			builder.append(m.dodgeError());
			builder.toString();
		}
	}

}
