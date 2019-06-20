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
//lo mismo que armor
public class Weapon extends Item {

    private int dmgMod;
    private int accMod;
    private int critMod;

    public Weapon() {
        super("Desarmado");
        dmgMod = 0;
        accMod = 0;
        critMod = 0;
    }

    public Weapon(int dmgMod, int accMod, int critMod, String name, int id) {
        super(name, id);
        this.dmgMod = dmgMod;
        this.accMod = accMod;
        this.critMod = critMod;
    }

    public Weapon(Weapon w) {
        super((Item) w);

        this.dmgMod = w.dmgMod;
        this.accMod = w.accMod;
        this.critMod = w.critMod;
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
    
    public void copyWeapon(Weapon w){
        
        this.setName(w.getName());
        this.setId(w.getId());
        this.dmgMod = w.dmgMod;
        this.accMod = w.accMod;
        this.critMod = w.critMod;
    }

    @Override
    public String toString(){
        return getName()+" Daño: "+dmgMod+" Precision: "+ accMod+" Critico: "+critMod;
    }
    
    public void weaponEspadaGastada() {
        setName("Espada Gastada");
        setId(0);
        dmgMod = 250;
        accMod = 15;
        critMod = 15;
    }

    public void weaponPalo() {
        setName("Espada Gastada");
        setId(0);
        dmgMod = 5;
        accMod = 0;
        critMod = 0;
    }

    public void weaponHachaSinFilo() {
        setName("Hacha Sin filo");
        setId(0);
        dmgMod = 2;
        accMod = 2;
        critMod = 2;
    }

    public void weaponBolsasDePiedras() {
        setName("Bolsa de piedras");
        setId(0);
        dmgMod = 0;
        accMod = 10;
        critMod = 0;
    }

    public void weaponGuadaña() {
        setName("Guadaña");
        setId(0);
        dmgMod = 5;
        accMod = 5;
        critMod = 20;
    }

    public void weaponGranMaza() {
        setName("Gran maza");
        setId(0);
        dmgMod = 30;
        accMod = -10;
        critMod = 0;
    }

    public void weaponKatanaMagica() {
        setName("Katana magica");
        setId(0);
        dmgMod = 10;
        accMod = 10;
        critMod = 10;
    }

    public void weaponPaloDeEnfoque() {
        setName("Palo de enfoque");
        setId(0);
        dmgMod = -5;
        accMod = 25;
        critMod = 10;
    }

    public void weaponEspadaInnecesariamenteGrande() {
        setName("Espada Innecesariamente Grande");
        setId(0);
        dmgMod = 40;
        accMod = 0;
        critMod = 0;
    }

    public void weaponUnDado() {
        setName("Un dado");
        setId(0);
        dmgMod = -5;
        accMod = -5;
        critMod = 50;
    }

    public void weaponFrostmourne() {
        setName("Frostmourne");
        setId(0);
        dmgMod = 50;
        accMod = 25;
        critMod = 25;
    }

    public void weaponFaka() {
        setName("Faka");
        setId(0);
        dmgMod = 2;
        accMod = 0;
        critMod = 10;
    }

    public void weaponLanzaMistica() {
        setName("Lanza Mistica");
        setId(0);
        dmgMod =15;
        accMod =15;
        critMod =15;
    }

    public void weaponHojaDePlata() {
        setName("Hoja de Plata");
        setId(0);
        dmgMod =25;
        accMod =5;
        critMod =5;
    }

    public void weaponElMachacador() {
        setName("El Machador");
        setId(0);
        dmgMod =40;
        accMod =-5;
        critMod =5;
    }

    public void weaponDecapitadora() {
        setName("Decapitadora");
        setId(0);
        dmgMod =10;
        accMod =5;
        critMod =25;
    }
    
        public void weaponCuchillaDeHielo() {
        setName("Cuchilla de Hielo");
        setId(0);
        dmgMod = 10;
        accMod = 20;
        critMod = 5;
    }
       
        public void weaponCimitarraMercurial() {
        setName("Cimitarra mercurial");
        setId(0);
        dmgMod = 15;
        accMod = 15;
        critMod = 15;
    }
        public void weaponRamaDeAbedul() {
        setName("Rama de Abedul");
        setId(0);
        dmgMod = 3;
        accMod = 10;
        critMod = 5;
    }
        public void weaponHachaOxidada() {
        setName("Hacha Oxidada");
        setId(0);
        dmgMod = 1;
        accMod = 5;
        critMod = 1;
    }
            
}
