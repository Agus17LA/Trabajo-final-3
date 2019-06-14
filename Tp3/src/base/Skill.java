package base;

import java.util.Random;

public class Skill extends GameObject {

    private int dmgMod;
    /*modificador PORCENTUAL, ejemplos varios, 50% implicaria la mitad de daño
    100% ningun cambio, 200% el doble, 0% 0 daño, etc etc etc
     */
    private int accMod;//estos ya son lineales
    private int critMod;
    private int statusChance;//la posiblidad de aplicar el status en el objetivo
    //los distintos status, aca es donde podria hacer un vector de status, pero por ahora esto es suficiente
    private Stun stun;
    private Poison poison;
    private Buff buff;

    public Skill() {
        super();
        dmgMod = 0;
        accMod = 0;
        critMod = 0;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    //MUCHOS constructores
    public Skill(String name, int id, int dmgMod, int accMod, int critMod) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int statusChance, Buff buff) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = statusChance;
        stun = new Stun();
        poison = new Poison();
        this.buff = buff;
    }

    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int statusChance, Stun stun) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = statusChance;
        this.stun = stun;
        poison = new Poison();
        buff = new Buff();
    }

    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int statusChance, Poison poison) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = statusChance;
        stun = new Stun();
        this.poison = poison;
    }

    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int statusChance, Stun stun, Poison poison) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = statusChance;
        this.stun = stun;
        this.poison = poison;
    }

    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int statusChance, Stun stun, Poison poison, Buff buff) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.statusChance = statusChance;
        this.stun = stun;
        this.poison = poison;
        this.buff = buff;
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
        return getName() + ": \n Mod daño: " + dmgMod + "+ || Mod precision: " + accMod + "+|| Mod crit: " + critMod + "+";
    }

    /*en esta funcion usamos el skill, es muy basica en el sentido de que solo pega
    y aplica el debuff, si queremos que por ejemplo cure, 
            podes hacer que el daño sea negativo*/
    public String useSkill(Character c1, Character c2) { // c1 usa el skill en c2
        StringBuilder builder = new StringBuilder();
        int dmgTotal = 0;
        dmgTotal = c2.calculateDmg(c1, this);
        int critTotal = c1.getCrit() + c1.getWeapon().getCritMod() + critMod;
        if (isCrit(critTotal)) {
            dmgTotal = dmgTotal * 2;
            builder.append("GOLPE CRITICO!\n");
        }
        c2.setHp(c2.getHp() - dmgTotal); 
        builder.append(c1.getName() + "  ha usado " + getName() + " en " + c2.getName() + " por "
                + dmgTotal + " de daño!! \n");
        if (statusHit()) {
            if (stun.isStunned()) {
                builder.append(c2.addStatus(stun));
            }
            if (poison.isPoisoned()) {
                builder.append(c2.addStatus(poison));
            }
            if(buff.isBuffed()){
                builder.append(c2.addStatus(buff));
            }
        } else {
        }
        return builder.toString();

    }
    
    
//funciones ya explicadas que no se porque tambien aparecen aca
    public boolean isCrit(int critChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < critChance - 1;
    }

    public boolean statusHit() {
        Random r = new Random(System.currentTimeMillis());
        return (r.nextInt(100) < statusChance);
    }

}
