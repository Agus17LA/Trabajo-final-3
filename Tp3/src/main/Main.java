package main;

import base.Buff;
import base.Character;
import base.Enemy;
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
        PrincipalManager pm = new PrincipalManager("jueguito", Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        pm.startGame();
        pm.startPrincipalLoop();
         */
        Game game = new Game();
        Vector<Enemy> enemigos = new Vector();
        Elf elf = new Elf();

        
        //Declaro los enemigos y los pongo en el vector enemigos
        Enemy e = new Enemy();
        e.enemigoGnomo();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoEnano();
        enemigos.add(e);
        e = new Enemy();
        e.enemigoHumano();
        enemigos.add(e);
        //hp,mana,dmg/max,acc,dodge,crit,def
        //Hay un constructor con solo estadisticas y otro con items y vectores
        //Inventario, skills, arma, armadura,    nombre , Id
        elf.setName("Mi Personaje");
        
        do {
            int ran = elf.ranNum(0, 2);//La funcion ranNum devuelve numeros entre 2 valores
            e=new Enemy (enemigos.elementAt(ran)); // eligue el enemigo basado en el num ran
            game.battle(elf, e); //pelea entre el elfo y el enemigo
            if (elf.getHp() > 0) { //si sigue vivo sube de nivel (porque al subir de nivel te cura)
                elf.lvlUp();
            }
        } while (elf.getHp() > 0);
         
    }

}
