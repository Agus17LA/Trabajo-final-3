package base;

import inventory.Inventory;
import java.util.Vector;
import java.util.Random;

//clase personaje, tecnicamente todo ente que puede tener una pelea
public class Character extends GameObject {

    private int hp;         //vida, si llega a 0 muere(o eso deberia pasar pero no esta implementado)
    private int maxHp;
    private int mana;       //mana, energia mistica o algo asi para lanzar hechizos
    private int maxMana;
    private int dmg;        //daño, no confundir con daño fisico o fuerza, este es daño en si, no importa el tipo
    private int maxDmg;
    private int acc;        //accurecy/punteria, afecta las posibilidades de acertar un golpe

    private int dodge;       //evacion aumenta las chances de esquivar un golpe, por cuestiones de balance no debeira ser muy alto 

    private int crit;       //chances de golpe critico, sinceramente no se si dejarlo aca, con que este en las habilidades deberia ser suficiente

    private int def;        //defensa PORCENTUAL por ende 100 de defensa implicaria no recibir daño, hay que limitarlo mas tarde

    private Vector<Status> vStatus;//vector de estados o aflicciones de un personaje, un personaje puede estar aturdido y buffeado, o sufrir 2 o mas tipos distintos de venenO

    public Vector<Skill> vSkills; //vector de habilidades de un personaje

    private Weapon weapon; //arma utilizada por el personaje

    private Armor armor;    //armadura usada por el personaje

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

    public Character(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, Vector<Skill> vSkills, Weapon weapon, Armor armor, String name, int id) {
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
        this.vSkills = vSkills;
        this.weapon = weapon;
        this.armor = armor;
    }

    //el bendito constructor de copia
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

    //inicializa los objetos que tiene un character
    public void iniCharacterObjects() {
        this.vStatus = new Vector<Status>();
        this.vSkills = new Vector<Skill>();
        this.weapon = new Weapon();
        this.armor = new Armor();
    }


    /*toString feo y desactualizado que queda ilegible en la consola, 
    espero que con la interfaz grafica mejore algo*/
    public String toString() {
        return " " + getName() + "\n Vida: " + hp + "/" + maxHp + "\n Mana: " + mana + "/" + maxMana + "\n Daño: "
                + dmg + "-" + maxDmg + " || Precision extra: +" + acc + "\n Evasion:  " + dodge
                + " \n Defensa: " + def + "%" + "|| Critico: " + crit + "%";
    }

    //solo para mostrar la vida, en la mayoria de juegos que juge la vida esta siempre visible xd
    public String showHp() {
        return " " + getName() + "|| Vida: " + hp + "/" + maxHp;
    }

    public String showMana() {
        return "|| Mana: " + mana + "/" + maxMana;
    }

    //no me acuerdo el nombre de la practica del OOP que esto va, creo que era encapsulamiento 
    public boolean addSkill(Skill s) {
        return vSkills.add(s);
    }

    public String attack(Character c, Skill s) { // Recibe un ataque de "c" personaje y la habilidad que uso
        StringBuilder builder = new StringBuilder();
        int dmgTotal = 0;
        int hitChance = calculateHitChance(c, s); //calculate hit chance devuelve un int que es el % de chances de golpear
        c.setMana(c.getMana() - s.getManaCost());//aplica el coste de mana de la habilidad(el control para que le alcanze se hace mas arriba)
        if (hit(hitChance)) {//se usa ese % en una funcion que devuelve un boolean para saber si se pudo hacer el golpe
            builder.append(s.useSkill(c, this)); //funcion en la que la habilidad es usada
        } else {
            builder.append(c.getName() + " ha errado el golpe!! *"); //en caso de errar se notifica
        }
        return builder.toString(); //se devuelve lo que sea que haya pasado

    }

    public int calculateHitChance(Character c, Skill s) { //funcion simplona que devuelve las chances de que este personaje sea golpeado por "c"
        /*Se suma el total de punteria del q ataca y de esquive del que defiende y se saca una chance de acc en el total*/
        int accTotal = c.getAcc() + c.weapon.getAccMod() + s.getAccMod();
        int dodgeTotal = dodge + armor.getDodgeMod();
        int suma = dodgeTotal + accTotal;
        int hitChance = (int) (100 * accTotal) / suma; //A cuanto% equivale el hit en comparacion al total
        if (hitChance < 10 || hitChance > 95) { //para que los numeros tengan algo de sentido se hace eso
            //tambien me gusta la idea de que no importa cuanta diferencia haya siempre vas a tener la chance de golpear o de fallar, como si fuera sacar un 1 o un 20 xd
            if (hitChance < 10) {
                hitChance = 10;
            } else {
                hitChance = 95;
            }
            //por "diseño" la chance minima de golpear  es 10% y la maxima 95%
        }
        return hitChance;
    }

    public boolean hit(int hitChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < hitChance - 1; // nextInt(100) deja un numero entre 0 y 99, el cual comparamos
        // con nuestra probabilidad de golpe, si el numero arrojado es menor
        // quiere decir que el golpe fue un "miss", por ende devuelve false.

    }

    public int calculateDmg(Character c, Skill s) { // calcula el daño que recibe de "c"
        float totalDmg = 0;
        float totalDef = (float) ((100 - (def + armor.getDefMod())) / 100);
        float totalModSkill = (float) s.getDmgMod() / 100;// el daño que modifica la habilidad
        int inicialDmg = ranNum(c.getDmg(), c.getMaxDmg()); //Tira el dado del daño para saber cuanto pega
        //Tanto el daño de la habilidad como la defensa son PORCENTUALES por eso se multiplican al resultado, lo demas se suma        
        totalDmg = (float) (inicialDmg + c.weapon.getDmgMod()) * totalModSkill * totalDef;

        return (int) totalDmg; //se lo pasa a int porque los atributos se basan en enteros
    }

    //se le pasa el% de critico y devuelve si fue crit o no, simple
    public boolean isCrit(int critChance) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextInt(100) < critChance - 1;
    }

    //metodo para mostrar el vector de habilidades, se ve MUY feo en consola pero bueno
    public String showSkills() {
        StringBuilder builder = new StringBuilder();
        int i;

        for (i = 0; i < vSkills.size(); i++) {
            builder.append(vSkills.elementAt(i).toString()).append("*");
        }
        return builder.toString();
    }

    //para saber si el personaje sigue vivo o no
    public boolean isAlive() {
        return hp > 0;
    }

    public int totalSkills() {
        return vSkills.size();
    }

    /*para agregar un status al vector de status, aplica polimorfismo pero no me acuerdo el 
    nombre exactO y tambien devuelve un mensaje diciendo que status se agrego!*/
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

    //este metodo hace que los status presentes en el personaje tengan efecto, es como si fuera su "turno"
    public String statusEffect() {
        StringBuilder builder = new StringBuilder();
        if (!vStatus.isEmpty()) {
            int i = 0;
            for (i = 0; i < vStatus.size(); i++) {
                builder.append(vStatus.elementAt(i).statusTurn(this));//statusTurn es la funcion que ejecuta el turno dle status
                if (vStatus.elementAt(i).getDuration() == 0) {//si la duracion es 0 o sea termino se lo saca del vector
                    vStatus.remove(i);
                    i--;//este -- es para correr para el costado el indice, ya que al borrar java automaticamente corre todo a un costado
                }
            }

        }
        return builder.toString();
    }

//recorre el vector de estados buscando si esta aturdido el personaje
    public boolean isStunned() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i).isStun()) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isPoisonned() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i).isPoison()) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isBuffed() {
        boolean flag = false;
        int i = 0;
        for (i = 0; i < vStatus.size() && flag == false; i++) {
            if (vStatus.elementAt(i).isBuff()) {
                flag = true;
            }
        }
        return flag;
    }

}
    

