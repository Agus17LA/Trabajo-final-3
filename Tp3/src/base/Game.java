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
    private byte playerSkill;
    private byte enemySkill;
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
    
    boolean h1;
    boolean h2;
    boolean h3;
    boolean h4;
    
    
    
    
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
        
        pMouse = new Point();
        skillBoxes = new Rectangle[4];
        for(int i = 0;i<skillBoxes.length;i++){
            skillBoxes[i] = new Rectangle((120*i)+26,422,100,20);
        }
        option = 0;
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
        //Scanner scan = new Scanner(System.in);
        playerTurn = true;
        playerSkill = 0; //usamos byte no va a haber mas de 16 habilidades
        enemySkill = 0;
        Messages m = new Messages();
        totalSkills=player.showSkills();
        partsSkills=totalSkills.split("\\*");
        mana = false;
        pulso = false;
        
        boolean flagAtaque;
        
        if(!Constants.dead && !player.isAlive()){
            player.setHp(player.getMaxHp());
            player.setMana(player.getMaxMana());
        }
        //si algun personaje muere ya termina la pelea
        while (player.isAlive() && enemy.isAlive()) {
            //draw(g);//System.out.println(showHpsMana(player, enemy));
            flagAtaque = false;
            dead = false;
            double i =0;
            if (playerTurn) {
                if (player.isStunned()) {
                    /*si esta stunneado no podra jugar su turno, 
                    pero los status si tendran lugar
                     */
                    System.out.println(player.statusEffect());
                } else {

                    System.out.println(player.statusEffect());
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
                            //System.out.println("No tiene mana para usar la habilidad " + player.vSkills.elementAt(playerSkill - 1).getName());
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
            System.out.println(player.getName() + " ha matado a " + enemy.getName());
            player.loot(enemy);
            if(!dead){
                System.out.println(player.addXp(enemy.getExpDrop()));
                dead = true;
            }
            Constants.ESC = true;
            Constants.BATTLESTATE = false;
        } else {
            Constants.dead = true;
            System.out.println(enemy.getName() + " te ha matado!!");
            Constants.ESC = true;
            Constants.BATTLESTATE = false;
        }

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
        
        for(int i=0;i<skillBoxes.length;i++){
            g.setColor(Color.PINK);
            g.fillRect((int)skillBoxes[i].x,(int)skillBoxes[i].y,(int)skillBoxes[i].width,(int)skillBoxes[i].height);
        }
        g.setColor(Color.BLACK);
        g.fillRect(25,445,750,130);
        
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
            g.fillRect(25,445,750,200);
            g.setColor(Color.YELLOW);
            g.drawString(showHpsMana(player, enemy),30,460);
            if(!mana){
                g.drawString("No tienes mana suficiente",30,480);
                if(Constants.PRUEBA == 1500){
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
                        if(partesAtaqueE.length>4){
                            System.out.println("que pesado");
                        }else{
                            for(int i =0; i<partesAtaqueE.length;i++){
                                g.drawString(partesAtaqueE[i],30,(20*i)+500);
                            }
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
            g.drawString("Has ganado la batalla, presione escape para salir",30,460);
        }else{
            g.setColor(Color.MAGENTA);
            g.drawString("Estas muerto, presione escape para salir",30,460);
        }
    }
        /*
    public void guardarPartida(Playable player, Enemy enemy) { //idea que se me ocurrio para implementar json con la cargada de partida
        try {
            JSONObject gameStates = new JSONObject();
            JSONArray arrayGameStates = new JSONArray();
            gameStates.put("Estados", arrayGameStates);
            JSONObject playableStates = new JSONObject();
            playableStates.put("id", player.getId());
            playableStates.put("name", player.getName());
            playableStates.put("hp", player.getHp());
            playableStates.put("hp max", player.getMaxHp());
            playableStates.put("mana", player.getMana());
            playableStates.put("mana max", player.getMaxMana());
            playableStates.put("dmg", player.getDmg());
            playableStates.put("dmg max", player.getMaxDmg());
            playableStates.put("acc", player.getAcc());
            playableStates.put("dodge", player.getDodge());
            playableStates.put("crit", player.getCrit());
            playableStates.put("def", player.getDef());
            playableStates.put("xp", player.getXp());
            playableStates.put("lvl", player.getLvl());
            playableStates.put("xp max", player.getXpMax());
            playableStates.put("stun", player.isStunned());
            playableStates.put("poison", player.isPoisonned());
            playableStates.put("buff", player.isBuffed());

            JSONArray playableStatus = new JSONArray();
            playableStates.put("status", playableStatus);//ver como agregar status actuales
            JSONArray playableSkills = new JSONArray();
            playableStates.put("skills", playableSkills);
            JSONObject skill1 = new JSONObject();
            JSONObject skill2 = new JSONObject();
            JSONObject skill3 = new JSONObject();
            JSONObject skill4 = new JSONObject();
            skill1.put("id", player.vSkills.get(0).getId());
            skill1.put("name", player.vSkills.get(0).getName());
            skill1.put("dmg mod", player.vSkills.get(0).getDmgMod());
            skill1.put("acc mod", player.vSkills.get(0).getAccMod());
            skill1.put("crit mod", player.vSkills.get(0).getCritMod());
            skill1.put("mana cost", player.vSkills.get(0).getManaCost());
            skill1.put("status chance", player.vSkills.get(0).getStatusChance());

            skill2.put("id", player.vSkills.get(1).getId());
            skill2.put("name", player.vSkills.get(1).getName());
            skill2.put("dmg mod", player.vSkills.get(1).getDmgMod());
            skill2.put("acc mod", player.vSkills.get(1).getAccMod());
            skill2.put("crit mod", player.vSkills.get(1).getCritMod());
            skill2.put("mana cost", player.vSkills.get(1).getManaCost());
            skill2.put("status chance", player.vSkills.get(1).getStatusChance());

            skill3.put("id", player.vSkills.get(2).getId());
            skill3.put("name", player.vSkills.get(2).getName());
            skill3.put("dmg mod", player.vSkills.get(2).getDmgMod());
            skill3.put("acc mod", player.vSkills.get(2).getAccMod());
            skill3.put("crit mod", player.vSkills.get(2).getCritMod());
            skill3.put("mana cost", player.vSkills.get(2).getManaCost());
            skill3.put("status chance", player.vSkills.get(2).getStatusChance());

            skill4.put("id", player.vSkills.get(3).getId());
            skill4.put("name", player.vSkills.get(3).getName());
            skill4.put("dmg mod", player.vSkills.get(3).getDmgMod());
            skill4.put("acc mod", player.vSkills.get(3).getAccMod());
            skill4.put("crit mod", player.vSkills.get(3).getCritMod());
            skill4.put("mana cost", player.vSkills.get(3).getManaCost());
            skill4.put("status chance", player.vSkills.get(3).getStatusChance());

            playableSkills.put(0, skill1);
            playableSkills.put(1, skill2);
            playableSkills.put(2, skill3);
            playableSkills.put(3, skill4);

            JSONObject playableWeapon = new JSONObject();
            JSONObject playableArmor = new JSONObject();

            playableWeapon.put("id", player.getWeapon().getId());
            playableWeapon.put("name", player.getWeapon().getName());
            playableWeapon.put("weight", player.getWeapon().getWeight());
            playableWeapon.put("dmg mod", player.getWeapon().getDmgMod());
            playableWeapon.put("acc mod", player.getWeapon().getAccMod());
            playableWeapon.put("crit mod", player.getWeapon().getCritMod());

            playableArmor.put("id", player.getArmor().getId());
            playableArmor.put("name", player.getArmor().getName());
            playableArmor.put("weight", player.getArmor().getWeight());
            playableArmor.put("hp mod", player.getArmor().getHpMod());
            playableArmor.put("dodge mod", player.getArmor().getDodgeMod());
            playableArmor.put("def mod", player.getArmor().getDefMod());

        } catch (JSONException e) {

            e.printStackTrace();
        }
    }*/
}
