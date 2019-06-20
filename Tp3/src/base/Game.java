package base;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Vector;
import main.manager.Constants;
import main.manager.graphics.DrawSurface;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.state.game.BattleManager;
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;
/**
 *
 * @author Juan
 */
public class Game extends Thread implements Runnable,GameState{
    
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
        e.enemigoGnomo();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoElfo();
        enemigos.add(e);
        elf.setName("ELFO");
        dwarf.setName("ENANO");
        gnome.setName("GNOMO");
        human.setName("HUMANO");
    }
    
    
    @Override
    public void run(){
        switch(Constants.SELECTED_CHARACTER){
            case 1:
                if(Constants.ACTUAL_MAP!=2)
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(gnome,enemigos.get(0));
                            break;
                        case 1:
                            battle(gnome,enemigos.get(1));
                            break;
                        case 2:
                            battle(gnome,enemigos.get(2));
                            break;
                    }
                else
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(gnome,enemigos.get(2));
                            break;
                        case 1:
                            battle(gnome,enemigos.get(3));
                            break;
                    }
                break;
            case 2:
                if(Constants.ACTUAL_MAP!=2)
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(human,enemigos.get(0));
                            break;
                        case 1:
                            battle(human,enemigos.get(1));
                            break;
                        case 2:
                            battle(human,enemigos.get(2));
                            break;
                    }
                else
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(human,enemigos.get(3));
                            break;
                        case 1:
                            battle(human,enemigos.get(4));
                            break;
                    }
                break;
            case 3:
                if(Constants.ACTUAL_MAP!=2)
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(elf,enemigos.get(0));
                            break;
                        case 1:
                            battle(elf,enemigos.get(1));
                            break;
                        case 2:
                            battle(elf,enemigos.get(2));
                            break;
                    }
                else
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(elf,enemigos.get(3));
                            break;
                        case 1:
                            battle(elf,enemigos.get(4));
                            break;
                    }
                break;
            case 4:
                if(Constants.ACTUAL_MAP!=2)
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(dwarf,enemigos.get(0));
                            break;
                        case 1:
                            battle(dwarf,enemigos.get(1));
                            break;
                        case 2:
                            battle(dwarf,enemigos.get(2));
                            break;
                    }
                else
                    switch(Constants.ACTUAL_ENEMY_ZONE){
                        case 0:
                            battle(dwarf,enemigos.get(3));
                            break;
                        case 1:
                            battle(dwarf,enemigos.get(4));
                            break;
                    }
            default:
                System.out.println("kepaso");
                break;
        }
        
    }
    
    
    public void startt(Graphics g){
        //Constants.BATTLESTATE = true;
        this.g = g;
        this.g.setColor(Color.RED);
        this.g.fillRect(0, 0, 800, 600);
        thread = new Thread(this,"battle");
        thread.start();
    }
    
    
 /*   public String messages(){
        System.out.println(showHpsMana(player, enemy));
        System.out.println(player.statusEffect());
        System.out.println("Elija habilidad:");
        System.out.println(player.showSkills());
        playerSkill = scan.nextByte();
        return null;
    }*/
    
    public void battle(Playable player, Enemy enemy) {
        Constants.ESC = false;
        Scanner scan = new Scanner(System.in);
        boolean playerTurn = true;
        byte playerSkill = 0; //usamos byte no va a haber mas de 16 habilidades
        byte enemySkill = 0;
        Messages m=new Messages();
        //si algun personaje muere ya termina la pelea
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(showHpsMana(player, enemy));
            if (playerTurn) {
                if (player.isStunned()) {
                    /*si esta stunneado no podra jugar su turno, 
                    pero los status si tendran lugar
                     */
                    System.out.println(player.statusEffect());
                } else {

                    System.out.println(player.statusEffect());
                   do{
                    do {
                        System.out.println("Elija habilidad:");
                        System.out.println(player.showSkills()); //crear excepciones 
                        playerSkill = scan.nextByte();
                    } while (playerSkill > player.vSkills.size()|| playerSkill <= 0);
                    if(player.getMana()<player.vSkills.elementAt(playerSkill-1).getManaCost()){
                        System.out.println(player.vSkills.elementAt(playerSkill-1).getManaCost());
                        System.out.println("mana jugador"+player.getMana());
                        System.out.println("No hay mana");
                        StringBuilder builder = new StringBuilder();
                        builder.append(m.manaError());
                    	builder.toString();
                    }
                   }while (player.getMana()<player.vSkills.elementAt(playerSkill-1).getManaCost());
                    System.out.println(enemy.attack(player, player.vSkills.elementAt(playerSkill - 1)));
                }
                playerTurn = false;
            } else {
                if(enemy.isStunned()){
                    System.out.println("isStunned");
                }
                if (enemy.isStunned()) {
                    
                    System.out.println(enemy.statusEffect());
                }
                else {
                    /* Esta IA es la envidia de elon musk, lo unico que hace es dar vueltas
                    por el arreglo de habilidades 
                    */
                    System.out.println(enemy.statusEffect());
                    
                    do{
                    if (enemySkill > enemy.totalSkills() - 1) {
                        enemySkill = 0;
                    }
                    }while(enemy.getMana()<enemy.vSkills.elementAt(enemySkill).getManaCost());
                    System.out.println(player.attack(enemy, enemy.vSkills.elementAt(enemySkill)));
                    enemySkill++;
                  
                }
                playerTurn = true;
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " ha matado a " + enemy.getName());
            System.out.println(player.addXp(enemy.getExpDrop()));
            Constants.ESC = true;
        } else {
            System.out.println(enemy.getName() + " te ha matado!!");
            Constants.ESC = true;
        }
        
    }
        
    public String showHpsMana(base.Character p1, base.Character p2) {
        //para tener el estado de como va la pelea !
        return p1.showHp() + p1.showMana()+"\n" + p2.showHp()+ p2.showMana();
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
