/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class Game {

    public void battle(Character player, Character enemy) {
        Scanner scan = new Scanner(System.in);
        boolean playerTurn = true;
        byte playerSkill = 0;
        //Skill playerSkill=new Skill();
        byte enemySkill = 0;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(showHps(player, enemy));
            if (playerTurn) {
                if(player.isStunned()){
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
        return p1.showHp() + "\n" + p2.showHp();
    }
}
