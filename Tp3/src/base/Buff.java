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

    public Buff() {
        super();
        dmgB = 0;
        accB = 0;
        dodgeB = 0;
        speedB = 0;
        critB = 0;
        defB = 0;
    }

    public Buff(int dmgB, int accB, int dodgeB, int speedB, int critB, int defB, int duration) {
        super(duration);
        this.dmgB = dmgB;
        this.accB = accB;
        this.dodgeB = dodgeB;
        this.speedB = speedB;
        this.critB = critB;
        this.defB = defB;
    }

    public Buff(Buff b) {
        super(b.getDuration());
        this.dmgB = b.getDmgB();
        this.accB = b.getAccB();
        this.dodgeB = b.getDodgeB();
        this.speedB = b.getSpeedB();
        this.critB = b.getCritB();
        this.defB = b.getDefB();
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
}
