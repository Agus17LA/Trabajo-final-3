/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package races;
 
import base.Messages;
import base.Playable;
import inventory.Inventory;
/**
 *
 * @author Juan
 */
public class Gnome extends Playable implements Image{
	

    //Poner para ponerle un nombre
    public Gnome(){
        //se tiran "dados" para indicar los valores de las estadisticas
       setMaxHp(ranNum(27,34));
       setHp(getMaxHp());
       setMaxMana(ranNum(20,30));
       setMana(getMana());
       setDmg(ranNum(9,10));
       setMaxDmg(ranNum(12,13));
       setAcc(ranNum(25,35));
       setDodge(ranNum(4,7));
       
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
       Inventory inventory=new Inventory(60);//ver si empiezan con algun item,carga maxima
       setCrit(5);
       setDef(0);
       
       iniCharacterObjects();
    }
    
    @Override
    public void manaTransmutation() {
    	if(getMana()-10>=0) {
        setMana(getMana()-10);
        setHp(getHp()+15);
    	}
    	else {
    		Messages m = new Messages();
    		m.manaError();
    	}
    }

    @Override
    public void magicGain() {
    	if(getMana()-30>=0) {
    	setMana(getMana()-30);
        setMaxDmg(getMaxDmg()+1);   
        setDmg(getDmg()+1);  
    	}
    	else {
    		Messages m = new Messages();
    		m.manaError();
    	}
    }
    
    
}
