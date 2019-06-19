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
//Stun==aturdimiento
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
     public boolean isStun(){//se usa para controlar no aplicar el mismo tipo de status 2 veces
         return true;
     }
    

    @Override
    public String statusTurn(Character c) {
        String res=" ";
        if (stunned == true) {
            super.statusTurn(c);
            res= c.getName()+ "esta aturdido! ";
            //el aturdimiento se chequea en la clase game, por eso esta funcion no hace nada especial
        }
                
        return res;

    }
   
}
