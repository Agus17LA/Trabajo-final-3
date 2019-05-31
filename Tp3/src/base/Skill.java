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
public class Skill extends GameObject{
   private int dmgMod;
    private int accMod;  
    private int critMod;  

    
    public Skill(){
        super();
        dmgMod=0;
        accMod=0;
        critMod=0;
    }
    
    public Skill(String name, int id,int dmgMod, int accMod, int critMod) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
    }
    
    
    
       public int getDmgMod() {
        return dmgMod;
    }

    public void setDmgMod(int dmgMod) {
        this.dmgMod = dmgMod;
    }

    public int getAccMod() {
        return accMod;
    }

    public void setAccMod(int accMod) {
        this.accMod = accMod;
    }

    public int getCritMod() {
        return critMod;
    }

    public void setCritMod(int critMod) {
        this.critMod = critMod;
    }
   public String toString() {
	return getName()+ ": \n Mod daño: " +dmgMod+ "+ || Mod precision: "+accMod+"+|| Mod crit: "+critMod+"+";
}
}
