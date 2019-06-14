/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package races;

import base.Playable;
import inventory.Inventory;
/**
 *
 * @author Juan
 */
public class Human extends Playable implements Iwarrior{

    public Human(){
        //se tiran "dados" para indicar los valores de las estadisticas
       setMaxHp(ranNum(35,45));
       setHp(getMaxHp());
       setMaxMana(ranNum(9,15));
       setMana(getMana());
       setDmg(ranNum(6,9));
       setMaxDmg(ranNum(11,16));
       setAcc(ranNum(11,16));
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
       Inventory inventory=new Inventory(100);//ver si empiezan con algun item,carga maxima
       setCrit(5);
       setDef(0);
       
       iniCharacterObjects();
    }
  
    
            @Override
    public void gainPower(){
        setMana(getMana()-5);
        setHp(getHp()-15);
        setMaxDmg(getMaxDmg()+2);   
        setDmg(getDmg()+2);  
    
        
    }
    @Override
    public void heavyTraining(){
        setDodge(getDodge()-1);
        setMaxHp(getMaxHp()+10);  
        setHp(getHp()+5);
    }
            
}
