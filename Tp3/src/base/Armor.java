package base;

/**
 * Clase armadura, viene a ser tecnicamente la "ropa" que usa un personaje
 * jugablo o npc, ofrece modicicaciones fijas de distintas estadisticas
 * defensivas, todavia no esta claro si el "tipo" de armadura va a ser un
 * atributo o clases nuevas que hereden de esta
 */
public class Armor extends Item {

//Son modificadores LINEALES +5,+10,-4 etc 
    private int dodgeMod;
    private int defMod;

    /**
     * Constructor vacio de la clase Armor Inicializa todo en 0 y el nombre en
     * desarmado
     */
    public Armor() {
        super("desarmado");// este constructor es el de la superclase "gameobject" y solo recibe nombre, se supone que tiene que recibir un id pero no esta implementado
        dodgeMod = 0;
        defMod = 0;
    }
//constructor completo

    /**
     * @param dodgeMod
     * @param defMod
     * @param name
     * @param id
     */
    public Armor(int dodgeMod, int defMod, String name, int id) {
        super(name, id);

        this.dodgeMod = dodgeMod;
        this.defMod = defMod;
    }
//constructor de copia

    /**
     * Constructor de copia, sirve para crear nuevas estancias de objeto y no
     * sobreescribirla
     * @param a
     */
    public Armor(Armor a) {

        super((Item) a);
        this.dodgeMod = a.dodgeMod;
        this.defMod = a.defMod;
    }
    //getters y setters

    public int getDodgeMod() {
        return dodgeMod;
    }

    public void setDodgeMod(int dodgeMod) {
        this.dodgeMod = dodgeMod;
    }

    public int getDefMod() {
        return defMod;
    }

    public void setDefMod(int defMod) {
        this.defMod = defMod;
    }

    @Override
    public String toString() {
        return getName() + " Evasion: " + dodgeMod + " Defensa: " + defMod;
    }

    /**
     * Funcion cambia el valor de esta armadura por el que reciba, se usa para
     * lootear los items despojado
     *
     * @param a
     */
    public void copyArmor(Armor a) {

        this.setName(a.getName());
        this.setId(a.getId());
        this.dodgeMod = a.dodgeMod;
        this.defMod = a.defMod;
    }

    //dudo bastante que se tengan que agregar metodos nuevos
    public void armorYelmoIndestructible() {
        setName("Yelmo Indestructible");
        setId(0);
        dodgeMod = -7;
        defMod = 25;
    }

    public void armorPecheraDeBatalla() {
        setName("Pechera de Batalla");
        setId(0);
        dodgeMod = -5;
        defMod = 5;
    }

    public void armorCinturonDorado() {
        setName("Cintura Dorado");
        setId(0);
        dodgeMod = 0;
        defMod = 5;
    }

    public void armorAmuletoDelCentinela() {
        setName("Amuleto del Centinela");
        setId(0);
        dodgeMod = -5;
        defMod = 15;
    }

    public void armorArmaduraDelConquistador() {
        setName("Armadura del Conquistador");
        setId(0);
        dodgeMod = 0;
        defMod = 5;
    }

    public void armorNokia1100() {
        setName("Nokia 1100");
        setId(0);
        dodgeMod = 0;
        defMod = 50;
    }

    public void armorEscudoDelCapi() {
        setName("Escudo del Capi");
        setId(0);
        dodgeMod = 15;
        defMod = 15;
    }

    public void armorPanDeAyer() {
        setName("Pan de ayer");
        setId(0);
        dodgeMod = -5;
        defMod = 15;
    }
/**
 * Armadura inicial de los gnomos
 */
    public void armorRopaSucia() {
        setName("Ropa Sucia");
        setId(0);
        dodgeMod = 5;
        defMod = 0;
    }
/**
 * Armadura inicial de los elfos
 */
    public void armorTelaRobada() {
        setName("Tela Robada");
        setId(0);
        dodgeMod = 0;
        defMod = 1;
    }
/**
 * Armadura inicial de los enanos
 */
    public void armorMediaArmadura() {
        setName("Media armudura");
        setId(0);
        dodgeMod = -5;
        defMod = 5;
    }
/**
 * Armadura inicial de los Humanos
 */
    public void armorEscudoChico() {
        setName("Escudo chico");
        setId(0);
        dodgeMod = 0;
        defMod = 5;
    }

    public void armorAuraDeMuerte() {
        setName("Aura de Muerte");
        setId(0);
        dodgeMod = -25;
        defMod = 15;
    }

    public void armorCabezalDeHierro() {
        setName("Cabezal de Hierro");
        setId(0);
        dodgeMod = -10;
        defMod = 10;
    }

    public void armorPlacasAncestrales() {
        setName("Placas Ancestrales");
        setId(0);
        dodgeMod = -20;
        defMod = 20;
    }

    public void armorAmuletoDeEvasion() {
        setName("Amuleto de Evasion");
        setId(0);
        dodgeMod = 20;
        defMod = 0;
    }

    public void armorBataDeHospital() {
        setName("Bata de Hospital");
        setId(0);
        dodgeMod = 0;
        defMod = 0;
    }

    public void armorPiedraMagica() {
        setName("Piedra Magica");
        setId(0);
        dodgeMod = 0;
        defMod = 15;
    }

    public void armorEscudoMistico() {
        setName("Escudo Mistico");
        setId(0);
        dodgeMod = 0;
        defMod = 25;
    }

    public void armorLaArmaduraOscura() {
        setName("La Armadura Oscura");
        setId(0);
        dodgeMod = 10;
        defMod = 20;
    }

    public void armorPantalosHeroicosDeHeroe() {
        setName("Pantalones Heroicos de Heroe");
        setId(0);
        dodgeMod = 0;
        defMod = 5;
    }

    public void armorPonchoSucio() {
        setName("Poncho Sucio");
        setId(0);
        dodgeMod = 10;
        defMod = 1;
    }

    public void armorCinturonDelCampeon() {
        setName("Cinturon del Campeon");
        setId(0);
        dodgeMod = 20;
        defMod = 10;
    }

}
