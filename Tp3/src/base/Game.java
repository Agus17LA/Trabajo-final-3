
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
    public void battle(Character player, Character enemy) {
        Scanner scan = new Scanner(System.in);
        boolean playerTurn = true;
        byte playerSkill = 0; //usamos byte no va a haber mas de 16 habilidades
        byte enemySkill = 0;
        //si algun personaje muere ya termina la pelea
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(showHps(player, enemy));
            if (playerTurn) {
                if(player.isStunned()){
                    /*si esta stunneado no podra jugar su turno, 
                    pero los status si tendran lugar
                    */
                System.out.println(player.statusEffect());
                }
                else{
                    
                System.out.println(player.statusEffect());
                System.out.println("Elija habilidad:");
                System.out.println(player.showSkills()); //crear excepciones 
                playerSkill = scan.nextByte();
                System.out.println(enemy.attack(player, player.vSkills.elementAt(playerSkill - 1)));
                }
                playerTurn = false;
            } else {
                
                if(enemy.isStunned()){
                System.out.println(enemy.statusEffect());
                }
                else{
                    /* Esta IA es la envidia de elon musk, lo unico que hace es dar vueltas
                    por el arreglo de habilidades 
                    */
                    System.out.println(enemy.statusEffect());
                if (enemySkill > enemy.totalSkills()-1) {
                    enemySkill = 0;
                }

                System.out.println(player.attack(enemy, enemy.vSkills.elementAt(enemySkill)));
                enemySkill++;
                }
                playerTurn = true;
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " ha matado a " + enemy.getName());
        } else {
            System.out.println(enemy.getName() + " te ha matado!!");
        }

    }

    public String showHps(Character p1, Character p2) {
        //para tener el estado de como va la pelea !
        return p1.showHp() + "\n" + p2.showHp();
    }
}
