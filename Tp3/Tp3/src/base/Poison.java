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
public class Poison extends Status{
    private int dmg;
    private boolean poisoned;
    
    
    public Poison(){
        super();
        dmg=0;
        poisoned=false;
    }
    public Poison(int dmg,int duration){
        super(duration);
        this.dmg=dmg;
        this.poisoned=true;
    }
    public Poison(Poison poison){
        super(poison.getDuration());
        this.dmg=poison.dmg;
        this.poisoned=poison.isPoisoned();
        
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }
    
    
    @Override
    public String statusTurn(Character c){
        String res=" "; 
            super.statusTurn(c);
            c.setHp(c.getHp()-dmg);
                 res= c.getName() + " sufre "+dmg+ " de daño por veneno!";          
        return res;
        
    }
   
}
