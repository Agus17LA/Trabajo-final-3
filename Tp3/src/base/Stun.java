/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 * Status aturdido, los controles de stun se hacen por fuera de esta clase, solo
 * sirve para indicar si esta aturdido
 *
 * @author Juan
 */
public class Stun extends Status {

    private boolean stunned;

    public Stun() {
        duration=0;
        stunned = false;
    }

    public Stun(Stun stun) {
       this.duration=stun.duration;
        stunned = true;
    }

    public Stun(int duration) {
       this.duration=duration;
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

        String res = " ";
        if (stunned == true) {
            if (duration > 0) {
                duration--;
            } else {
                duration = 0;
            }
            res = c.getName() + "esta aturdido! *";
            //el aturdimiento se chequea en la clase game, por eso esta funcion no hace nada especial
        }

        return res;

    }

}
