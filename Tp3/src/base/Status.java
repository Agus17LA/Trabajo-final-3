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
public class Status { // cendria a ser el estado en el que esta un personaje(stuneado envenenado etc)
    private int duration;
    
    
    public Status(){
        duration=0;
    }
    public Status(int duration){
        this.duration=duration;
    }
    
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration=duration;
    }
    
    public String statusTurn(Character c){
        if(duration>0)
            duration--;
        else
            duration=0;
        return " ";
    }
    //Sirve para poder aplicar poliformismo
    public boolean isStun(){
        return false;
    }
    public boolean isPoison(){
        return false;
    }
    public boolean isBuff(){
        return false;
    }
    
}
