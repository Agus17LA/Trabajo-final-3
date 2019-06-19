package base;

/*Clase armadura, viene a ser tecnicamente la "ropa" que usa un personaje jugablo o npc, 
ofrece modicicaciones fijas de distintas estadisticas defensivas, todavia no esta claro si el "tipo"
de armadura va a ser un atributo o clases nuevas que hereden de esta*/
public class Armor extends Item {

    private int hpMod;  //Son modificadores LINEALES +5,+10,-4 etc 
    private int dodgeMod;
    private int defMod;

    public Armor() {
        super("desarmado");// este constructor es el de la superclase "gameobject" y solo recibe nombre, se supone que tiene que recibir un id pero no esta implementado
        hpMod = 0;
        dodgeMod = 0;
        defMod = 0;
    }
//constructor completo

    public Armor(int hpMod, int dodgeMod, int defMod, double weight, int sellPrice, int buyPrice, int total, int stackSize, String name, int id) {
        super(weight, sellPrice, buyPrice, total, stackSize, name, id);
        this.hpMod = hpMod;
        this.dodgeMod = dodgeMod;
        this.defMod = defMod;
    }
//constructor de copia

    public Armor(Armor a) {

        super((Item) a);
        this.hpMod = a.hpMod;
        this.dodgeMod = a.dodgeMod;
        this.defMod = a.defMod;
    }
    //getters y setters

    public int getHpMod() {
        return hpMod;
    }

    public void setHpMod(int hpMod) {
        this.hpMod = hpMod;
    }

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

    //dudo bastante que se tengan que agregar metodos nuevos
    public void armorYelmoIndestructible() {
        setName("Yelmo Indestructible");
        setId(0);
        hpMod =50;
        dodgeMod =-7;
        defMod =25;
    }

    public void armorPecheraDeBatalla() {
        setName("Pechera de Batalla");
        setId(0);
        hpMod =50;
        dodgeMod =-5;
        defMod =5;
    }

    public void armorCinturonDorado() {
        setName("Cintura Dorado");
        setId(0);
        hpMod =0;
        dodgeMod =0;
        defMod =5;
    }

    public void armorAmuletoDelCentinela() {
        setName("Amuleto del Centinela");
        setId(0);
        hpMod =10;
        dodgeMod =-5;
        defMod =15;
    }

    public void armorArmaduraDelConquistador() {
        setName("Armadura del Conquistador");
        setId(0);
        hpMod =20;
        dodgeMod =0;
        defMod =5;
    }

    public void armorNokia1100() {
        setName("Nokia 1100");
        setId(0);
        hpMod =0;
        dodgeMod =0;
        defMod =50;
    }

    public void armorEscudoDelCapi() {
        setName("Escudo del Capi");
        setId(0);
        hpMod =0;
        dodgeMod =15;
        defMod =15;
    }

    public void armorPanDeAyer() {
        setName("Pan de ayer");
        setId(0);
        hpMod =10;
        dodgeMod =-5;
        defMod =15;
    }

    public void armorRopaSucia() {
        setName("Ropa Sucia");
        setId(0);
        hpMod =0;
        dodgeMod =5;
        defMod =0;
    }

    public void armorTelaRobada() {
        setName("Tela Robada");
        setId(0);
        hpMod =5;
        dodgeMod =0;
        defMod =1;
    }

    public void armorMediaArmadura() {
        setName("Media armudura");
        setId(0);
        hpMod =20;
        dodgeMod =-5;
        defMod =5;
    }

    public void armorEscudoChico() {
        setName("Escudo chico");
        setId(0);
        hpMod =5;
        dodgeMod =0;
        defMod =5;
    }

    public void armorAuraDeMuerte() {
        setName("Aura de Muerte");
        setId(0);
        hpMod =100;
        dodgeMod =-25;
        defMod =15;
    }

    public void armorCabezalDeHierro() {
        setName("Cabezal de Hierro");
        setId(0);
        hpMod =50;
        dodgeMod =-10;
        defMod =10;
    }

    public void armorPlacasAncestrales() {
        setName("Placas Ancestrales");
        setId(0);
        hpMod =30;
        dodgeMod =-20;
        defMod =20;
    }

    public void armorAmuletoDeEvasion() {
        setName("Amuleto de Evasion");
        setId(0);
        hpMod =0;
        dodgeMod =20;
        defMod =0;
    }

    public void armorBataDeHospital() {
        setName("Bata de Hospital");
        setId(0);
        hpMod =150;
        dodgeMod =0;
        defMod =0;
    }

    public void armorPiedraMagica() {
        setName("Piedra Magica");
        setId(0);
        hpMod =15;
        dodgeMod =0;
        defMod =15;
    }

    public void armorEscudoMistico() {
        setName("Escudo Mistico");
        setId(0);
        hpMod =50;
        dodgeMod =0;
        defMod =25;
    }

    public void armorLaArmaduraOscura() {
        setName("La Armadura Oscura");
        setId(0);
        hpMod =100;
        dodgeMod =10;
        defMod =20;
    }
    
    public void armorPantalosHeroicosDeHeroe() {
        setName("Pantalones Heroicos de Heroe");
        setId(0);
        hpMod =10;
        dodgeMod =0;
        defMod =5;
    }
    
    public void armorRamaDeAbedul() {
        setName("Rama de Abedul");
        setId(0);
        hpMod =5;
        dodgeMod =10;
        defMod =1;
    }
    
    public void armorCinturonDelCampeon() {
        setName("Cinturon del Campeon");
        setId(0);
        hpMod =30;
        dodgeMod =20;
        defMod =10;
    }


}
