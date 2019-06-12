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
public class Stun extends Status {

    private boolean stunned;

    public Stun() {
        super();
        stunned = false;
    }
    public Stun(Stun stun){
        super(stun.getDuration());
        stunned=true;
    }

    public Stun(int duration) {
        super(duration);
        stunned = true;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
    
    

    @Override
    public String statusTurn(Character c) {
        String res=" ";
        if (stunned == true) {
            super.statusTurn(c);
            res= c.getName()+ "esta aturdido! ";
            
        }
                
        return res;

    }
    @Override
    public boolean isStun(){
        return true;
    }

}
