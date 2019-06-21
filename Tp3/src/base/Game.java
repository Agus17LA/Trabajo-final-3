package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;
import java.util.Vector;
import main.manager.Constants;
import main.manager.control.ControlManager;
import main.manager.graphics.DrawSurface;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.state.game.BattleManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;

/**
 *
 * @author Juan
 */
public class Game extends Thread implements Runnable, GameState {

    /*es como una clase en la que probamos todo pero sin ser
    el main se le puede considerar el "corazon " del juego*/
    //batalla entre 2 entes
    //funcion extremadamente modularizable
    private Elf elf;
    private Dwarf dwarf;
    private Gnome gnome;
    private Human human;
    private Vector<Enemy> enemigos;
    private Enemy e;
    private Thread thread;
    private Graphics g;
    private Playable player;
    private Enemy enemy;
    private int playerSkill;
    private int enemySkill;
    private String totalSkills;
    private String[] partsSkills;
    private boolean mana;
    private boolean pulso;
    private boolean dead;
    private boolean ataque;
    private String ataqueEnemigo;
    private String nuestroAtaque;
    private String[] partesAtaque;
    private String[] partesAtaqueE;
    private Point pMouse;
    private Rectangle[] skillBoxes;
    private int option;
    boolean playerTurn;
    
    
    private boolean h1;
    private boolean h2;
    private boolean h3;
    private boolean h4;
    
    private boolean lootGral;
    private String loot;
    private String[] partLoot;
    private boolean drw;
    private boolean case0;
    private int contador;
    private boolean drw2;
    private String xp;
    private boolean enemigoMuerto;
    private boolean paraDibujado;
    
    public Game(){
        elf = new Elf();
        dwarf = new Dwarf();
        gnome = new Gnome();
        human = new Human();
        enemigos = new Vector();
        
        e = new Enemy();
        e.enemigoHumano();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoEnano();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoElfo();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoElfo();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoGnomo();
        enemigos.add(e);
        
        
        elf.setName("ELFO");
        dwarf.setName("ENANO");
        gnome.setName("GNOMO");
        human.setName("HUMANO");
    
        option = 0;
        drw = false;
        drw2 = false;
        enemigoMuerto = false;
        paraDibujado = false;
    }

    @Override
    public void run() {
        switch (Constants.SELECTED_CHARACTER) {
            case 1:
                if(Constants.ACTUAL_MAP!=2){
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(gnome, enemigos.get(0));
                            break;
                        case 1:
                            battle(gnome, enemigos.get(1));
                            break;
                        case 2:
                            battle(gnome, enemigos.get(2));
                            break;
                    }
                }
                else{
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(gnome,enemigos.get(3));
                            break;
                        case 1:
                            battle(gnome,enemigos.get(4));
                            break;
                    }
                }
                break;
            case 2:
                if(Constants.ACTUAL_MAP!=2){
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(human, enemigos.get(0));
                            break;
                        case 1:
                            battle(human, enemigos.get(1));
                            break;
                        case 2:
                            battle(human, enemigos.get(2));
                            break;
                    }
                }
                else{
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(human, enemigos.get(3));
                            break;
                        case 1:
                            battle(human, enemigos.get(4));
                            break;
                    }
                }
                break;
            case 3:
                if(Constants.ACTUAL_MAP!=2){
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(elf, enemigos.get(0));
                            break;
                        case 1:
                            battle(elf, enemigos.get(1));
                            break;
                        case 2:
                            battle(elf, enemigos.get(2));
                            break;
                    }
                }
                else{
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(elf, enemigos.get(3));
                            break;
                        case 1:
                            battle(elf, enemigos.get(4));
                            break;
                    }
                }
                break;
            case 4:
                if(Constants.ACTUAL_MAP!=2){
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(dwarf, enemigos.get(0));
                            break;
                        case 1:
                            battle(dwarf, enemigos.get(1));
                            break;
                        case 2:
                            battle(dwarf, enemigos.get(2));
                            break;
                    }
                }
                else{
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(dwarf, enemigos.get(3));
                            break;
                        case 1:
                            battle(dwarf, enemigos.get(4));
                            break;
                    }
                }
                break;
            default:
                System.out.println("kepaso");
                break;
        }

    }

    public void startt(){
        thread = new Thread(this,"battle");
        thread.start();
        Constants.BATTLESTATE = true;
    }

    public void battle(Playable player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        Constants.ESC = false;
        playerTurn = true;
        playerSkill = 0; //usamos byte no va a haber mas de 16 habilidades
        enemySkill = 0;
        Messages m = new Messages();
        totalSkills=player.showSkills();
        partsSkills=totalSkills.split("\\*");
        mana = false;
        pulso = false;
        enemigoMuerto = false;
        h1 = false;
        h2 = false;
        h3 = false;
        h4 = false;
        playerSkill = 0;
        if(enemy.isAlive()){
            if(!Constants.dead && !player.isAlive()){
                player.setHp(player.getMaxHp());
                player.setMana(player.getMaxMana());
            }
            //si algun personaje muere ya termina la pelea
            while (player.isAlive() && enemy.isAlive()) {
                dead = false;
                double i =0;
                if (playerTurn) {
                    if (player.isStunned()) {
                        /*si esta stunneado no podra jugar su turno, 
                        pero los status si tendran lugar
                         */
                        //System.out.println(player.statusEffect());
                    } else {
                        //System.out.println(player.statusEffect());
                        do {
                            h1 = false;
                            h2 = false;
                            h3 = false;
                            h4 = false;
                            playerSkill = 0;
                            do {
                                System.out.println("");
                                if(h1){
                                    playerSkill = 1;
                                }else if(h2){
                                    playerSkill = 2;
                                }else if(h3){
                                    playerSkill = 3;
                                }else if(h4){
                                    playerSkill = 4;
                                }
                            } while(playerSkill==0); //Este while espera a que en el otro thread se aprete una tecla
                                pulso = true;
                            if (player.getMana() < player.vSkills.elementAt(playerSkill - 1).getManaCost()) {
                                mana = false;
                            }else{
                                mana = true;
                            }
                        } while (player.getMana() < player.vSkills.elementAt(playerSkill - 1).getManaCost());
                        nuestroAtaque = enemy.attack(player, player.vSkills.elementAt(playerSkill - 1)); 
                        partesAtaque = nuestroAtaque.split("\\*");
                        ataque = false;
                    }
                    playerTurn = false;
                }else{
                    //Ejecuta el turno del enemigo
                    ataqueEnemigo = enemy.turn(player);
                    partesAtaqueE = ataqueEnemigo.split("\\*");
                    playerTurn = true;
                }
            }
            //Modularizar esta parte y agregarle lo de intercambiar loot 
            if (player.isAlive()) {
                //lootGral = true;
                //pulso = true;
                loot(enemy,player);
                if(!dead){
                    xp = player.addXp(enemy.getExpDrop());
                    dead = true;
                }
                Constants.ESC = true;
                Constants.BATTLESTATE = false;
            } else {
                Constants.dead = true;
                Constants.ESC = true;
                Constants.BATTLESTATE = false;
            }
            
        }else{
            enemigoMuerto = true;
            Constants.ESC = true;
            Constants.BATTLESTATE = false;
        }
    }
    
    public void loot(Enemy e,Playable player) {
        case0 = false;
        if(!case0){
            loot = e.showLoot();
            partLoot = loot.split("\\*");
            case0 = true;
        }
        h1 = false;
        h2 = false;
        h3 = false;
        lootGral = false;
        do {
            System.out.println("a");
            if(h1){
                System.out.println("changeddd");
                player.getWeapon().copyWeapon(e.getWeapon());
                lootGral = true;
                h1 = false;
                drw = true;
            }else if(h2){
                System.out.println("ChangeArmor");
                player.getArmor().copyArmor(e.getArmor());
                lootGral = true;
                h2 = false;
                drw2 = true;
            }else if(h3){
                lootGral = true;
            }
        } while(!lootGral);
    }
    

    public String showHpsMana(base.Character p1, base.Character p2) {
        //para tener el estado de como va la pelea !
        return p1.showHp() + p1.showMana() + "\n" + p2.showHp() + p2.showMana();
    }

    @Override
    public void refresh() {        
        if(!pulso){
            if(ControlManager.keyboard.h1.isPressed()&&!h1){
                h1 = true;
            }else if(ControlManager.keyboard.h2.isPressed()&&!h2){
                h2 = true;
            }else if(ControlManager.keyboard.h3.isPressed()&&!h3){
                h3 = true;
            }else if(ControlManager.keyboard.h4.isPressed()&&!h4){
                h4 = true;
            }
        }
    }
    

    @Override
    public void draw(Graphics g) {
        //for(int i=0;i<skillBoxes.length;i++){
        //    g.setColor(Color.DARK_GRAY);
        //    g.fillRect((int)skillBoxes[i].x,(int)skillBoxes[i].y,(int)skillBoxes[i].width,(int)skillBoxes[i].height);
        //}
        g.setColor(Color.BLACK);
        g.fillRect(25,445,750,130);
        if(!enemigoMuerto){
            if(player.isAlive() && enemy.isAlive() && !pulso){
                g.setColor(Color.YELLOW);
                g.drawString(showHpsMana(player, enemy),30,460);
                if(player.isStunned()){
                    g.drawString("Te encuentras aturdido", 30, 480);
                }else{
                    g.drawString("No te encuentras aturdido", 30, 480);
                    g.drawString("Seleccione habilidad: ",30,500);
                    if(partsSkills!=null){
                        for(int i=0;i<partsSkills.length;i++){
                            if(partsSkills[i]!=null){
                                g.drawString(partsSkills[i],30,(15*i)+517);
                            }
                        }
                    }
                }
            }else if(pulso){
                g.setColor(Color.BLACK);
                g.fillRect(25,445,750,180);
                g.setColor(Color.YELLOW);
                g.drawString(showHpsMana(player, enemy),30,460);
                if(!mana){
                    g.drawString("No tienes mana suficiente",30,480);
                    if(Constants.PRUEBA == 1500){ //cambiar esto por un contador real
                        mana = true;
                        pulso = false;
                        Constants.PRUEBA = 0;
                    }else{
                        Constants.PRUEBA++;
                    }
                }else if(!ataque){
                    if(partesAtaque!=null){
                        for(int i = 0;i<partesAtaque.length;i++){
                            g.drawString(partesAtaque[i],30,(20*i)+480);
                        }
                        if(partesAtaqueE!=null){
                            for(int i =0; i<partesAtaqueE.length;i++){
                                g.drawString(partesAtaqueE[i],30,(20*i)+520);
                            }
                        }
                        if(Constants.PRUEBA == 2000){
                            ataque = true;
                            pulso = false;
                            Constants.PRUEBA = 0;
                        }else{
                            Constants.PRUEBA++;
                        }
                    }
                }
            }else if(player.isAlive()){
                g.setColor(Color.MAGENTA);
                g.drawString("1: Reemplzar arma, 2 reemplazar armadura, 3 continuar",30,460);
                if(partLoot != null){
                    for(int i = 0;i<partLoot.length;i++){
                        g.drawString(partLoot[i],30,(20*i)+480);
                    }
                }
                if(ControlManager.keyboard.h1.isPressed() && !h1){
                    //ControlManager.keyboard.h1.keyFree();
                    if (player.getWeapon().equals(e.getWeapon())) {
                        g.drawString("Ya tienes esa arma",30,500);
                        lootGral = false;
                    } else {
                        h1 = true;
                        contador = 0;
                    }
                }else if(ControlManager.keyboard.h2.isPressed() && !h2){
                    //ControlManager.keyboard.h1.keyFree();
                    h2 = true;
                    if(player.getArmor().equals(e.getArmor())){
                        g.drawString("Ya tienes esa armadura", 30, 500);
                        lootGral = false;
                    }else{
                        h2 = true;
                    }
                }
                if(drw){
                    g.drawString("Tu nueva arma es: "+player.getWeapon().getName(),30,550);
                }
                if(drw2){
                    g.drawString("Tu nueva armadura es: "+player.getArmor().getName(),30,550);
                }
                if(xp!=null){
                    g.setColor(Color.CYAN);
                    g.drawString(xp, 500,570);
                    g.drawString("Has ganado la batalla, presione escape para salir",30,580);
                }
            }else{
                g.setColor(Color.RED);
                g.drawString("Estas muerto, presione escape para salir",30,460);
            }
        }else{
            g.setColor(Color.RED);
            g.drawString("Ya has matado a este enemigo. Presione escape para salir", 30, 460);
        }
    }
}
