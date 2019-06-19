package base;

import java.util.Scanner;
/**
 *
 * @author Juan
 */
public class Game {

    /*es como una clase en la que probamos todo pero sin ser
    el main se le puede considerar el "corazon " del juego*/
    //batalla entre 2 entes
    //funcion extremadamente modularizable
    @SuppressWarnings("empty-statement")
    public void battle(Playable player, Enemy enemy) {
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
                System.out.println(enemy.isStunned());
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
                    }while(enemy.getMana()<enemy.vSkills.elementAt(playerSkill).getManaCost());
                    System.out.println(player.attack(enemy, enemy.vSkills.elementAt(enemySkill)));
                    enemySkill++;
                  
                }
                playerTurn = true;
            }
        
            
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " ha matado a " + enemy.getName());
            System.out.println(player.addXp(enemy.getExpDrop()));
            
        } else {
            System.out.println(enemy.getName() + " te ha matado!!");
        }

    }

    public String showHpsMana(Character p1, Character p2) {
        //para tener el estado de como va la pelea !
        return p1.showHp() + p1.showMana()+"\n" + p2.showHp()+ p2.showMana();
    }
}
