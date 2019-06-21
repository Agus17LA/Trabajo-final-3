package base;

import inventory.Inventory;
import java.util.Vector;
import java.util.Random;

/**
 * Clase personaje, de ella heredan enemy y playable, indica las funciones con
 * las que se maneja una pelea
 *
 * @author Juan
 */
public class Character extends GameObject {

    private int hp;         //vida, si llega a 0 muere(o eso deberia pasar pero no esta implementado)
    private int maxHp;
    private int mana;       //mana, energia mistica o algo asi para lanzar hechizos
    private int maxMana;
    private int dmg;        //daño, no confundir con daño fisico o fuerza, este es daño en si, no importa el tipo
    private int maxDmg;     //daño maximo, a la hora de aplicar el daño
    private int acc;        //accurecy/punteria, afecta las posibilidades de acertar un golpe

    private int dodge;       //evacion aumenta las chances de esquivar un golpe, por cuestiones de balance no debeira ser muy alto 

    private int crit;       //chances de golpe critico, sinceramente no se si dejarlo aca, con que este en las habilidades deberia ser suficiente

    private int def;        //defensa PORCENTUAL por ende 100 de defensa implicaria no recibir daño, hay que limitarlo mas tarde

    private Vector<Status> vStatus;//vector de estados o aflicciones de un personaje, un personaje puede estar aturdido y buffeado, o sufrir 2 o mas tipos distintos de venenO

    public Vector<Skill> vSkills; //vector de habilidades de un personaje

    private Weapon weapon; //arma utilizada por el personaje

    private Armor armor;    //armadura usada por el personaje

    /**
     * Constructor vacio
     */
    public Character() {
        super();
        hp = 0;
        maxHp = 0;
        mana = 0;
        maxMana = 0;
        dmg = 0;
        maxDmg = 0;
        acc = 0;
        dodge = 0;
        crit = 0;
        def = 0;
        vStatus = new Vector<Status>();
        vSkills = new Vector<Skill>();
        weapon = new Weapon();
        armor = new Armor();
    }

    /**
     *
     * @param hp
     * @param mana
     * @param dmg
     * @param maxDmg
     * @param acc
     * @param dodge
     * @param crit
     * @param def
     * @param name
     * @param id
     */
    public Character(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, String name, int id) {
        super(name, id);
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
        this.dmg = dmg;
        this.maxDmg = maxDmg;
        this.acc = acc;
        this.dodge = dodge;
        this.crit = crit;
        this.def = def;
        this.vStatus = new Vector<Status>();
        this.vSkills = new Vector<Skill>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }

    /**
     * Constructor de copia, no tiene mucha implementacion pero sirve mucho a la
     * hora de testear nuevas cosas
     *
     * @param c
     */
    public Character(Character c) {
        super(c.getName(), c.getId());
        this.hp = c.hp;
        this.maxHp = c.maxHp;
        this.mana = c.mana;
        this.maxMana = c.maxMana;
        this.dmg = c.dmg;
        this.maxDmg = c.maxDmg;
        this.acc = c.acc;
        this.dodge = c.dodge;
        this.crit = c.crit;
        this.def = c.def;
        this.vStatus = c.vStatus;
        this.vSkills = c.vSkills;
        this.weapon = c.weapon;
        this.armor = c.armor;

    }
    //muchos getters y setters que nose si usamos alguna vez, mejor que sobren a que falten supongo

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    /**
     * Inicializa los objetos adentro de Character
     */
    public void iniCharacterObjects() {
        this.vStatus = new Vector<Status>();
        this.vSkills = new Vector<Skill>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }

    /**
     * toString feo y desactualizado que queda ilegible en la consola, espero
     * que con la interfaz grafica mejore algo
     *
     * @return
     */
    public String toString() {
        return " " + getName() + "\n Vida: " + hp + "/" + maxHp + "\n Mana: " + mana + "/" + maxMana + "\n Daño: "
                + dmg + "-" + maxDmg + " || Precision extra: +" + acc + "\n Evasion:  " + dodge
                + " \n Defensa: " + def + "%" + "|| Critico: " + crit + "%";
    }

    /**
     * Devuelve vida/vidaMaxima
     *
     * @return
     */
    public String showHp() {
        return " " + getName() + "|| Vida: " + hp + "/" + maxHp;
    }

    /**
     * Devuelve mana/manaMaximo
     *
     * @return
     */
    public String showMana() {
        return "|| Mana: " + mana + "/" + maxMana;
    }

    /**
     * Agrega un nuevo skill a las disponibles del personaje (solo se implementa
     * en constructores)
     *
     * @param s
     * @return
     */
    public boolean addSkill(Skill s) {
        return vSkills.add(s);
    }

    /**
     * Recibe un ataque de "c" personaje y la habilidad que este uso y devuelve
     * un String con todo lo que paso en ese ataque
     *
     * @param c
     * @param s
     * @return
     */
    public String attack(Character c, Skill s) {
        StringBuilder builder = new StringBuilder();
        int hitChance = calculateHitChance(c, s);
        c.setMana(c.getMana() - s.getManaCost());//aplica coste de mana (el control se hace mas arriba)
        if (hit(hitChance)) {
            builder.append(s.useSkill(c, this)); //funcion en la que la habilidad es usada
        } else {
            builder.append(c.getName() + " ha errado el golpe!! *"); //en caso de errar se notifica
        }
        return builder.toString(); //se devuelve lo que sea que haya pasado

    }

    /**
     * Recibe el personaje y el ataque que uso y en base a una regla de 3 simple
     * determina las chances en 1 a 100 de que el golpea suceda
     *
     * @param c
     * @param s
     * @return
     */
    public int calculateHitChance(Character c, Skill s) {
        int accTotal = c.getAcc() + c.weapon.getAccMod() + s.getAccMod();
        int dodgeTotal = dodge + armor.getDodgeMod();
        int suma = dodgeTotal + accTotal;
        int hitChance = (int) (100 * accTotal) / suma;
        if (hitChance < 10 || hitChance > 95) {
            if (hitChance < 10) {
                hitChance = 10;
            } else {
                hitChance = 95;
            }
        }
        return hitChance;
    }

    /**
     * Compara el int recibido con un numero aleatorio entre 0 y 100 y devuelve
     * true si hitchance es mayor (el golpe sucedio) o false en caso contrario
     * (golpe errado)
     *
     * @param hitChance
     * @return
     */
    public boolean hit(int hitChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < hitChance - 1;

    }

    /**
     * Calcula el daño aplicando los porcentajes de aumento de las armaduras y
     * habilidades, internamente trabajo con doubles aunque reciba y devuelva
     * int
     *
     * @param c
     * @param s
     * @return
     */
    public int calculateDmg(Character c, Skill s) {
        double totalDmg = 0;
        double totalDef = ((double) (100 - (def + armor.getDefMod()))) / 100;
        double totalModSkill = ((double) (s.getDmgMod())) / 100;// el daño que modifica la habilidad
        int inicialDmg = ranNum(c.getDmg(), c.getMaxDmg()) + c.weapon.getDmgMod(); //Tira el dado del daño para saber cuanto pega
        //Tanto el daño de la habilidad como la defensa son PORCENTUALES por eso se multiplican al resultado, lo demas se suma        
        totalDmg = (double) inicialDmg * totalModSkill * totalDef;
        return (int) totalDmg; //se lo pasa a int porque los atributos se basan en enteros
    }

    /**
     * Compara el int recibido con un numero aleatorio entre 0 y 100 y devuelve
     * true si critChance es mayor (el golpe critico) o false en caso contrario
     * (golpe normal)
     *
     * @param critChance
     * @return
     */
    public boolean isCrit(int critChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < critChance - 1;
    }

    /**
     * Devuelve las habilidades disponible, solo devuelve el nombre de la
     * habilidad y un numero al lado
     *
     * @return
     */
    public String showSkills() {
        StringBuilder builder = new StringBuilder();
        int i;

        for (i = 0; i < vSkills.size(); i++) {
            builder.append((i + 1) + "- " + vSkills.elementAt(i).toString()).append("*");
        }
        return builder.toString();
    }

    /**
     * Devuelve si el personaje esta vivo o no en base a su vida actual
     * comparada con 0
     *
     * @return
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * Devuelve la cantidad de skills que tiene este personaje Encapsulamiento
     * del metodo Vector.size()
     *
     * @return
     */
    public int totalSkills() {
        return vSkills.size();
    }

    /**
     * Agrega el status al vector de status. Devuelve un mensaje en base la
     * instancia de status que recibe
     *
     * @param status
     * @return
     */
    public String addStatus(Status status) {
        String s = " ";
        if (status instanceof Stun) {
            if (!this.isStunned()) {
                Stun stun = new Stun((Stun) status);
                vStatus.add(stun);
                s = getName() + " fue aturdido!";
            }
        }
        if (status instanceof Poison) {
            if (!this.isPoisonned()) {
                Poison poison = new Poison((Poison) status);
                vStatus.add(poison);
                s = getName() + " fue envenenado!";
            }
        }
        if (status instanceof Buff) {
            if (!this.isBuffed()) {
                Buff buff = new Buff((Buff) status);
                vStatus.add(buff);
                s = getName() + " sufre una modificacion en sus estadisticas!!";
            }
        }
        return s;
    }

    /**
     * Aplica los efectos de status que tenga el personaje Si el status termina
     * su duracion lo borra del vector
     *
     * @return
     */
    public String statusEffect() {
        StringBuilder builder = new StringBuilder();
        if (!vStatus.isEmpty()) {
            int i = 0;
            for (i = 0; i < vStatus.size(); i++) {
                builder.append(vStatus.elementAt(i).statusTurn(this));//statusTurn es la funcion que ejecuta el turno dle status
                if (vStatus.elementAt(i).duration == 0) {//si la duracion es 0 o sea termino se lo saca del vector
                    vStatus.remove(i);
                    i--;//se resta el contador porque java borra y acomoda todo automaticamente
                }
            }

        }
        return builder.toString();
    }

    /**
     * Devuelve si el personaje tiene un aturdimiento activo
     *
     * @return
     */
    public boolean isStunned() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i) instanceof Stun) {          
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Devuelve si el personaje tiene un veneno activo
     *
     * @return
     */
    public boolean isPoisonned() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i) instanceof Poison) {          
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Devuelve si el personaje tiene un buff activo
     *
     * @return
     */
    public boolean isBuffed() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i) instanceof Buff) {          
                flag = true;
            }
        }
        return flag;
    }

}
