package main;

import base.Buff;
import base.Character;
import base.Game;
import base.Poison;
import base.Skill;

import main.manager.Constants;
import main.manager.PrincipalManager;

import base.Stun;
import java.util.Vector;
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;

//main con pruebas y nombres malos muy malos

public class Main {

    public static void main(String[] args) {

      /*
        System.setProperty("sun.java2d.opengl", "true");
        PrincipalManager pm = new PrincipalManager("jueguito", Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        pm.startGame();
        pm.startPrincipalLoop();
        */
        Game game = new Game();
        Dwarf d = new Dwarf();
        Gnome g = new Gnome();
        Elf elf = new Elf();
        Human h = new Human();
        //hp,mana,dmg/max,acc,dodge,crit,def
        //Hay un constructor con solo estadisticas y otro con items y vectores
        //Inventario, skills, arma, armadura,    nombre , Id

      
        d.setName("Enano");
        
        
       
        
        Vector<Character> enemigos = new Vector();
        g.setName("Gnomo");
        h.setName("Humano");
        elf.setName("Elfo");
        enemigos.add(g);
        enemigos.add(elf);
        enemigos.add(h);
        do {
            int ran = g.ranNum(0, 2);
            Character c=new Character (enemigos.elementAt(ran));
            game.battle(d, c);
            if (d.getHp() > 0) {
                d.lvlUp();
            }
        } while (d.getHp() > 0);

    }

}
