package base;

/**
 * El status veneno
 *
 * @author Juan
 */
public class Poison extends Status {

    private int dmg;
    private boolean poisoned;

    public Poison() {
        duration=0;
        dmg = 0;
        poisoned = false;
    }

    /**
     * Recibe el daño por turno y la duracion en turnos
     *
     * @param dmg
     * @param duration
     */
    public Poison(int dmg, int duration) {
          this.duration = duration;
        this.dmg = dmg;
        this.poisoned = true;
    }

    public Poison(Poison poison) {
       this.duration=poison.duration;
        this.dmg = poison.dmg;
        this.poisoned = poison.isPoisoned();

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
    /**
     * Funcion que ejecuta el turno del status
     */
    public String statusTurn(Character c) {
        String res = " ";
        if (duration > 0) {
            duration--;
        } else {
            duration = 0;
        }
        c.setHp(c.getHp() - dmg);
        /*el veneno es conocido como algo dañino por eso hace daño*/
        res = c.getName() + " sufre " + dmg + " de daño por veneno! *";
        return res;

    }

}
