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
public class Elf extends Playable implements Image {

	public Elf() {
		// se tiran "dados" para indicar los valores de las estadisticas
		setMaxHp(ranNum(25, 32));
		setHp(getMaxHp());
		setMaxMana(ranNum(25, 33));
		setMana(getMaxMana());
		setDmg(ranNum(10, 11));
		setMaxDmg(ranNum(13, 15));
		setAcc(ranNum(25, 35));
		setDodge(ranNum(2, 6));

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
		Inventory inventory = new Inventory(80);// ver si empiezan con algun item,carga maxima
		setCrit(5);
		setDef(0);

		iniCharacterObjects();
                
                Skill s=new Skill();
                s.skillGolpeBasico();
                this.addSkill(s);
                s=new Skill();
                s.skillAguijon();
                this.addSkill(s);
                 s=new Skill();
                s.skillTormentaElectrica();
                this.addSkill(s);
                 s=new Skill();
                s.skillApocalipsis();
                this.addSkill(s);
                
                 Weapon w=new Weapon();
                w.weaponPalo();
                
                Armor a=new Armor();
                a.armorTelaRobada();
                
	}

	@Override
	public void manaTransmutation() {
		if (getMana() - 25 >= 0) {
			setMana(getMana() - 25);
			setHp(getHp() + 50);
		} else {
			Messages m = new Messages();
			StringBuilder builder = new StringBuilder();
			builder.append(m.manaError());
			builder.toString();
		}

	}

	@Override
	public void magicGain() {
		if (getMana() - 40 >= 0) {
			setMana(getMana() - 40);
			setMaxDmg(getMaxDmg() + 3);
		} else {
			Messages m = new Messages();
			StringBuilder builder = new StringBuilder();
			builder.append(m.manaError());
			builder.toString();

		}
	}
}
