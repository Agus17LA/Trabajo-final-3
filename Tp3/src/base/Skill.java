package base;

import java.util.Random;

/**
 * La clase habilidad
 *
 * @author Juan
 */
public class Skill extends GameObject {

    private int dmgMod;
    /*modificador PORCENTUAL, ejemplos varios, 50% implicaria la mitad de daño
    100% ningun cambio, 200% el doble, 0% 0 daño, etc etc etc
     */
    private int accMod;//estos ya son lineales
    private int critMod;
    private int manaCost;
    private int statusChance;//probabilidad de aplicar TODOS los status
    private Stun stun;
    private Poison poison;
    private Buff buff;

    public Skill() {
        super();
        dmgMod = 0;
        accMod = 0;
        critMod = 0;
        manaCost = 0;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     * @param statusChance
     * @param buff
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost, int statusChance, Buff buff) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = statusChance;
        stun = new Stun();
        poison = new Poison();
        this.buff = buff;
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     * @param statusChance
     * @param stun
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost, int statusChance, Stun stun) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = statusChance;
        this.stun = stun;
        poison = new Poison();
        buff = new Buff();
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     * @param statusChance
     * @param poison
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost, int statusChance, Poison poison) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = statusChance;
        stun = new Stun();
        this.poison = poison;
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     * @param statusChance
     * @param stun
     * @param poison
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost, int statusChance, Stun stun, Poison poison) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = statusChance;
        this.stun = stun;
        this.poison = poison;
    }

    /**
     *
     * @param name
     * @param id
     * @param dmgMod
     * @param accMod
     * @param critMod
     * @param manaCost
     * @param statusChance
     * @param stun
     * @param poison
     * @param buff
     */
    public Skill(String name, int id, int dmgMod, int accMod, int critMod, int manaCost, int statusChance, Stun stun, Poison poison, Buff buff) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
        this.manaCost = manaCost;
        this.statusChance = statusChance;
        this.stun = stun;
        this.poison = poison;
        this.buff = buff;
    }

    /**
     *
     * @param s
     */
    public Skill(Skill s) {
        super(s.getName(), s.getId());
        this.dmgMod = s.getDmgMod();
        this.accMod = s.getAccMod();
        this.critMod = s.getCritMod();
        this.manaCost = s.getManaCost();
        this.statusChance = s.getStatusChance();
        stun = new Stun(s.stun);
        poison = new Poison(s.poison);
        buff = new Buff(s.buff);
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

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getStatusChance() {
        return statusChance;
    }

    public void setStatusChance(int statusChance) {
        this.statusChance = statusChance;
    }

    /**
     * Devuelve el nombre de la habilid y el coste de mana, las demas
     * estadisticas las pueden ver en el manual del juego
     *
     * @return
     */
    public String toString() {
        return getName() + " || Coste mana: " + manaCost;
    }

    /**
     * En esta funcion usamos el skill, usa funciones de Character para calcuar
     * el daño y si es critico, aplica todo el daño y el status
     *
     * @param c1
     * @param c2
     * @return
     */
    public String useSkill(Character c1, Character c2) { // c1 usa el skill en c2
        StringBuilder builder = new StringBuilder();
        int dmgTotal = 0;
        dmgTotal = c2.calculateDmg(c1, this);
        int critTotal = c1.getCrit() + c1.getWeapon().getCritMod() + critMod;
        if (isCrit(critTotal)) {
            dmgTotal = dmgTotal * 2;
            builder.append("GOLPE CRITICO! *");
        }
        c2.setHp(c2.getHp() - dmgTotal);
        builder.append(c1.getName() + "  ha usado " + getName() + " en " + c2.getName() + " por "
                + dmgTotal + " de daño!! *");
        if (statusHit()) { //Los metodos "isStatus" sirven para chekear si este skill aplica esos status
            if (stun.isStunned()) {
                builder.append(c2.addStatus(stun));
            }
            if (poison.isPoisoned()) {
                builder.append(c2.addStatus(poison));
            }
            if (buff.isBuffed()) {

                builder.append(c2.addStatus(buff));

            }
        } else {
        }
        long meta=System.currentTimeMillis()+3000;
        do{
            
        }while(System.currentTimeMillis()<meta); 
           
        return builder.toString();

    }

/**
 *  * Compara el int recibido con un numero aleatorio entre 0 y 100 y devuelve
     * true si critChance es mayor (el golpe critico) o false en caso contrario
     * (golpe normal)
 * @param critChance
 * @return 
 */
    public boolean isCrit(int critChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < critChance - 1;
    }
/**
 *  * Compara el statusChance con un numero aleatorio entre 0 y 100 y devuelve
     * true si statusChance es mayor (El status se aplica) o false en caso contrario
     * (el status no se aplica)
 * @return 
 */
    public boolean statusHit() {
        Random r = new Random(System.currentTimeMillis());
        return (r.nextInt(100) < statusChance);
    }

    //aca van "constructores" de habilidades para los pjs(supongo que despues lo metemos a un json
    //No se si esto esta bien pero bueno
    /**
     * 
     */
    
    /**
     * Habilidad basica
     */
    public void skillGolpeBasico() {
        setName("Golpe Basico");
        setId(0);
        dmgMod = 100;
        accMod = 0;
        critMod = 5;
        manaCost = 0;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    public void skillAtaque2Manos() {
        setName("Ataque a 2 manos");
        setId(0);
        dmgMod = 125;
        accMod = -5;
        critMod = 10;
        manaCost = 1;
        statusChance = 10;
        stun = new Stun(1);
        poison = new Poison();
        buff = new Buff();
    }

    public void skillDesgarrar() {
        setName("Desgarrar");
        setId(0);
        dmgMod = 75;
        accMod = 5;
        critMod = 0;
        manaCost = 3;
        statusChance = 50;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff(-3, -3, -3, -3, -3, 2);
    }

    public void skillGritoDeGuerra() {
        setName("Grito de guerra");
        setId(0);
        dmgMod = 150;
        accMod = 20;
        critMod = 0;
        manaCost = 10;
        statusChance = 30;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff(10, 10, 10, 10, 10, 3);
    }

    public void skillAguijon() {
        setName("Aguijon");
        setId(0);
        dmgMod = 50;
        accMod = 15;
        critMod = 0;
        manaCost = 10;
        statusChance = 50;
        stun = new Stun();
        poison = new Poison(10, 2);
        buff = new Buff(0, 0, -2, 0, 0, 2);
    }

    public void skillTormentaElectrica() {
        setName("Tormenta Electrica");
        setId(0);
        dmgMod = 150;
        accMod = 5;
        critMod = 5;
        manaCost = 20;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    public void skillApocalipsis() {
        setName("Apocalipsis");
        setId(0);
        dmgMod = 250;
        accMod = 15;
        critMod = 15;
        manaCost = 40;
        statusChance = 100;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff(-5, -5, 0, 0, -5, 2);
    }

    public void skillDesterrar() {
        setName("Desterrar");
        setId(0);
        dmgMod = 300;
        accMod = 10;
        critMod = 20;
        manaCost = 10;
        statusChance = 25;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff(-15, -15, 0, 0, -15, 2);
    }

    public void skillMiedo() {
        setName("Miedo");
        setId(0);
        dmgMod = 80;
        accMod = 5;
        critMod = 0;
        manaCost = 5;
        statusChance = 30;
        stun = new Stun(1);
        poison = new Poison();
        buff = new Buff();
    }

    public void skillGolpeVil() {
        setName("Golpe vil");
        setId(0);
        dmgMod = 80;
        accMod = 10;
        critMod = 5;
        manaCost = 5;
        statusChance = 50;
        stun = new Stun();
        poison = new Poison(5, 1);
        buff = new Buff(0, 0, -5, 0, 0, 1);
    }

    public void skillParasitarAlma() {
        setName("Parasitar Alma");
        setId(0);
        dmgMod = 75;
        accMod = 0;
        critMod = 0;
        manaCost = 20;
        statusChance = 70;
        stun = new Stun();
        poison = new Poison(20, 2);
        buff = new Buff(0, 0, -5, 0, 0, 1);
    }

    public void skillBolaDeFuego() {
        setName("Bola de Fuego");
        setId(0);
        dmgMod = 250;
        accMod = 10;
        critMod = 15;
        manaCost = 60;
        statusChance = 50;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff(0, -15, 0, 0, -15, 2);
    }

    public void skillDescargaDeEscarcha() {
        setName("Descarga de Escarcha");
        setId(0);
        dmgMod = 170;
        accMod = 5;
        critMod = 0;
        manaCost = 30;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    public void skillFogonazo() {
        setName("Fogonazo");
        setId(0);
        dmgMod = 140;
        accMod = -10;
        critMod = 15;
        manaCost = 30;
        statusChance = 20;
        stun = new Stun(1);
        poison = new Poison();
        buff = new Buff();
    }

    public void skillMaldicionVil() {
        setName("Maldicion Vil");
        setId(0);
        dmgMod = 50;
        accMod = 10;
        critMod = 0;
        manaCost = 50;
        statusChance = 60;
        stun = new Stun();
        poison = new Poison(50, 2);
        buff = new Buff(-2, -2, -2, -2, -2, 2);
    }

    public void skillCargaHeroica() {
        setName("Carga Heroica");
        setId(0);
        dmgMod = 50;
        accMod = 15;
        critMod = 10;
        manaCost = 5;
        statusChance = 60;
        stun = new Stun(2);
        poison = new Poison(5, 2);
        buff = new Buff();
    }

    public void skillGolpeSorprendente() {
        setName("Golpe Sorprendente");
        setId(0);
        dmgMod = 130;
        accMod = 5;
        critMod = 10;
        manaCost = 3;
        statusChance = 0;
        stun = new Stun();
        poison = new Poison();
        buff = new Buff();
    }

    public void skillMorderElPolvo() {
        setName("Morder el polvo");
        setId(0);
        dmgMod = 70;
        accMod = 20;
        critMod = 0;
        manaCost = 40;
        statusChance = 75;
        stun = new Stun();
        poison = new Poison(25, 5);
        buff = new Buff();
    }

}
