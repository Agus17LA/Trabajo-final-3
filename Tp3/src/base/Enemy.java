package base;

import java.util.Vector;
/**
 * Los enemigos del juego, 
 * @author Juan
 */
public class Enemy extends Character {

   
    private int expDrop;

    public Enemy() {
        super();
        expDrop = 0;
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
     * @param dropItemChance
     * @param name
     * @param id 
     */
    public Enemy(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, int dropItemChance, String name, int id) {
        super(hp, mana, dmg, maxDmg, acc, dodge, crit, def, name, id);
    }
    /**
     * 
     * @param c
     * @param expDrop 
     */
    public Enemy(Character c, int expDrop) {
        super(c);
        this.expDrop = expDrop;


    }
/**
 * Constructor de copia
 * @param e 
 */
    public Enemy(Enemy e) {
        super((Character) e);
        //arreglar y crear para asignar
        this.expDrop = e.expDrop;

    }

    public int getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(int expDrop) {
        this.expDrop = expDrop;
    }

/**
 * Metodo que devuelve el loot de este enemigo (por ahora solo su arma y armadura)
 * @return 
 */
    public String showLoot() {
        StringBuilder builder = new StringBuilder();
        builder.append("El enemigo tiene los siguientes items: ");
        builder.append("Arma: " + this.getWeapon().toString());
        builder.append("Armadura: " + this.getArmor().toString());

        return builder.toString();
    }

    
    /**
     * Primer enemigo
     */
    public void enemigoHumano() {

        setName("Javier");
        setMaxHp(40);
        setHp(getMaxHp());
        setMaxMana(5);
        setMana(getMaxMana());
        setDmg(4);
        setMaxDmg(9);
        setAcc(6);
        setDodge(3);
        setExpDrop(500);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillGolpeVil();
        this.addSkill(s);

        this.getWeapon().weaponFaka();

        this.getArmor().armorPantalosHeroicosDeHeroe();

    }

     public void enemigoEnano() {

        setName("Ernesto");
        setMaxHp(50);
        setHp(getMaxHp());
        setMaxMana(0);
        setMana(getMaxMana());
        setDmg(10);
        setMaxDmg(11);
        setAcc(20);
        setDodge(5);
        setExpDrop(500);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillFogonazo();
        this.addSkill(s);

        this.getWeapon().weaponGuadaña();

        this.getArmor().armorPonchoSucio();

    }

    public void enemigoElfo() {

        setName("Anastasio");
        setMaxHp(60);
        setHp(getMaxHp());
        setMaxMana(20);
        setMana(getMaxMana());
        setDmg(9);
        setMaxDmg(11);
        setAcc(20);
        setDodge(3);
        setExpDrop(500);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillMiedo();
        this.addSkill(s);

        this.getWeapon().weaponDecapitadora();

       this.getArmor().armorAmuletoDeEvasion();

    }

  
    
        public void enemigoElfo2() {

        setName("Budita");
        setMaxHp(90);
        setHp(getMaxHp());
        setMaxMana(20);
        setMana(getMaxMana());
        setDmg(9);
        setMaxDmg(11);
        setAcc(20);
        setDodge(3);
        setExpDrop(500);
        setCrit(5);
        setDef(0);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillParasitarAlma();
        this.addSkill(s);

        this.getWeapon().weaponCimitarraMercurial();

       this.getArmor().armorEscudoDelCapi();

    }
        public void enemigoGnomo() {

        setName("Roberto el genocida");
        setMaxHp(250);
        setHp(getMaxHp());
        setMaxMana(300);
        setMana(getMaxMana());
        setDmg(40);
        setMaxDmg(175);
        setAcc(50);
        setDodge(20);
        setExpDrop(500);
        setCrit(15);
        setDef(5);

        iniCharacterObjects();
        Skill s = new Skill();
        s.skillGolpeBasico();
        this.addSkill(s);
        s = new Skill();
        s.skillDesterrar();
        this.addSkill(s);

        this.getWeapon().weaponFrostmourne();

        this.getArmor().armorLaArmaduraOscura();

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
