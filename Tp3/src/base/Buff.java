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
public class Buff extends Status {

    private int dmgB;
    private int accB;
    private int dodgeB;
    private int speedB;
    private int critB;
    private int defB;
    private boolean active; //sirve para ver si ya se aplico o no

    public Buff() {
        super();
        dmgB = 0;
        accB = 0;
        dodgeB = 0;
        speedB = 0;
        critB = 0;
        defB = 0;
        active=false;
    }

    public Buff(int dmgB, int accB, int dodgeB, int speedB, int critB, int defB, int duration) {
        super(duration + 1);
        this.dmgB = dmgB;
        this.accB = accB;
        this.dodgeB = dodgeB;
        this.speedB = speedB;
        this.critB = critB;
        this.defB = defB;
        active=false;
    }

    public Buff(Buff b) {
        super(b.getDuration());
        this.dmgB = b.getDmgB();
        this.accB = b.getAccB();
        this.dodgeB = b.getDodgeB();
        this.speedB = b.getSpeedB();
        this.critB = b.getCritB();
        this.defB = b.getDefB();
        active=false;
    }

    public int getDmgB() {
        return dmgB;
    }

    public void setDmgB(int dmgB) {
        this.dmgB = dmgB;
    }

    public int getAccB() {
        return accB;
    }

    public void setAccB(int accB) {
        this.accB = accB;
    }

    public int getDodgeB() {
        return dodgeB;
    }

    public void setDodgeB(int dodgeB) {
        this.dodgeB = dodgeB;
    }

    public int getSpeedB() {
        return speedB;
    }

    public void setSpeedB(int speedB) {
        this.speedB = speedB;
    }

    public int getCritB() {
        return critB;
    }

    public void setCritB(int critB) {
        this.critB = critB;
    }

    public int getDefB() {
        return defB;
    }

    public void setDefB(int defB) {
        this.defB = defB;
    }

    public String statusTurn(Character c) {
        String res = " ";
        System.out.println("HOLAAA");
        
        super.statusTurn(c);

        if (getDuration() > 0) {
             res="La modificacion esta activa.";
            if (!active) {
                System.out.println(" 8888");
                active = true;
                c.setDmg(c.getDmg() + dmgB);
                c.setAcc(c.getAcc() + accB);
                c.setDodge(c.getDodge() + dodgeB);
                c.setSpeed(c.getSpeed() + speedB);
                c.setCrit(c.getCrit() + critB);
                c.setDef(c.getDef() + defB);
                
            }
            
        } else {
            c.setDmg(c.getDmg() - dmgB);
            c.setAcc(c.getAcc() - accB);
            c.setDodge(c.getDodge() - dodgeB);
            c.setSpeed(c.getSpeed() - speedB);
            c.setCrit(c.getCrit() - critB);
            c.setDef(c.getDef() - defB);
            
           res= c.getName()+ " ya no sufre una modificacion en sus estadisticas";
        }
        return res;
    }

}
