package base;

import java.util.Vector;

public class Enemy extends Character {

    //funcion medio vacia pero que se le van a ir agregando cosas
    /*Idea general para esto, los enemigos al morir sueltan experiencia, la cual el personaje
    jugable agarra para ir subiendo de nivel y asi mejorar. Tambien tendran una chance de tirar algun item
    especial o algo asi
     */
    private int expDrop;
    Vector<Item> dropItems;
    private int dropItemChance;

    public Enemy() {
        super();
        expDrop = 0;
        dropItems = new Vector<>();
        dropItemChance = 0;
    }

    //este constructor esta mal, supongo que estabas viendo una version vieja del trabajo cuando lo hiciste, mañana lo arreglo
    public Enemy(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, int dropItemChance, String name, int id) {
        super(hp, mana, dmg, maxDmg, acc, dodge, crit, def, name, id);
        this.dropItemChance = dropItemChance;
    }

    public Enemy(Character c, int expDrop, Vector<Item> dropItems, int dropItemChance) {
        super(c);
        this.expDrop = expDrop;
        this.dropItems = dropItems;// esto creo que esta mal, hace constructores de copia
        this.dropItemChance = dropItemChance;

    }

    public Enemy(Enemy e) {
        super((Character) e);
        //arreglar y crear para asignar
        this.expDrop = e.expDrop;
        this.dropItems = e.dropItems;
        this.dropItemChance = dropItemChance;

    }

    public int getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(int expDrop) {
        this.expDrop = expDrop;
    }

    public int getDropItemChance() {
        return dropItemChance;
    }

    public void setDropItemChance(int dropItemChance) {
        this.dropItemChance = dropItemChance;
    }

    public void dropItem(Character c) {
        //falta el metodo en si
    }

    public int calculateDropChance() { //funcion para calcular la chance de dropear un item al matar enemigo
        return 0;
        //falta el metodo en si
    }

    public void generateItems() {//funcion para generar items a dropear random
        //falta el metodo en si
    }

    //construsctores de enemigos (Sigo pensando que esta mal pero nose como hacerlo sino)
    public void enemigoEnano() {

        setName("Ernesto");
        setMaxHp(40);
        setHp(getMaxHp());
        setMaxMana(5);
        setMana(getMaxMana());
        setDmg(4);
        setMaxDmg(9);
        setAcc(10);
        setDodge(5);
        setExpDrop(100);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillAtaque2Manos();
        this.addSkill(s);

        Weapon w = new Weapon();
        w.weaponHachaOxidada();

        Armor a = new Armor();
        a.armorPantalosHeroicosDeHeroe();

    }

    public void enemigoGnomo() {

        setName("Roberto");
        setMaxHp(25);
        setHp(getMaxHp());
        setMaxMana(25);
        setMana(getMaxMana());
        setDmg(8);
        setMaxDmg(12);
        setAcc(25);
        setDodge(5);
        setExpDrop(110);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillGolpeVil();
        this.addSkill(s);

        Weapon w = new Weapon();
        w.weaponPaloDeEnfoque();

        Armor a = new Armor();
        a.armorPiedraMagica();

    }
    
    public void enemigoElfo() {

        setName("Anastasio");
        setMaxHp(30);
        setHp(getMaxHp());
        setMaxMana(20);
        setMana(getMaxMana());
        setDmg(9);
        setMaxDmg(11);
        setAcc(20);
        setDodge(3);
        setExpDrop(100);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillTormentaElectrica();
        this.addSkill(s);

        Weapon w = new Weapon();
        w.weaponRamaDeAbedul();

        Armor a = new Armor();
        a.armorPonchoSucio();

    }

    public void enemigoHumano() {

        setName("Javier");
        setMaxHp(50);
        setHp(getMaxHp());
        setMaxMana(10);
        setMana(getMaxMana());
        setDmg(10);
        setMaxDmg(11);
        setAcc(20);
        setDodge(5);
        setExpDrop(150);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillAtaque2Manos();
        this.addSkill(s);
        s = new Skill();
        s.skillDesgarrar();
        this.addSkill(s);

        Weapon w = new Weapon();
        w.weaponCimitarraMercurial();

        Armor a = new Armor();
        a.armorCinturonDelCampeon();

    }
    
    public String turn(Character c) {
        StringBuilder builder = new StringBuilder();
        if (this.isStunned()) {
            builder.append(statusEffect());
        } else {
            /* Logica atras de la IA, los enemigos solo tienen 2 habilidades por disenio, 
            el golpe basico y otra mas que cuesta mana, si tienen mana tiran la habilidad 
            y si no el golpe basico
             */
            builder.append(statusEffect());

            if (getMana() >= vSkills.elementAt(1).getManaCost()) {
                //La habilidad 2, 1 en el arreglo, siempre es la habilidad que cuesta mana, si el mana le alcanza la tira
                builder.append(c.attack(this, this.vSkills.elementAt(1)));
            } else //La habilidad 1 siempre es el basico que no cuensta mana
            {
                builder.append(c.attack(this, this.vSkills.elementAt(0)));
            }

        }
        return builder.toString();

    }
    
    

}
