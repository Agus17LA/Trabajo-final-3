/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import base.Game;
import base.Skill;
import main.manager.Constants;
import main.manager.PrincipalManager;

/**
 *
 * @author Juan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PrincipalManager pm = new PrincipalManager("",Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        
        
        
        pm.startGame(Constants.RUTA_MAGOGNOMO); //acá cargamos la ruta del personaje que se seleccionó
        
        
        pm.startPrincipalLoop();
        
        System.out.println("1");
        Game game=new Game();
        Skill hb1=new Skill("Golpe divino",001,30,100,75);//dmg,prec,crit
        Skill hm1=new Skill("golpe divino malo",001,50,100,50);
        Skill hb2=new Skill("purificacion ",001,30,100,75);
        Skill hm2=new Skill("putrefaccion",001,50,100,50);
        Skill hb3=new Skill("bokita pasion",001,200,20,75);
        Skill hm3=new Skill("gallinas putas",001,50,100,50);
        //hp,mana,dmg/max,acc,dodge,speed,crit,def
        //Hay un constructor con solo estadisticas y otro con items y vectores
        //Inventario, skills, arma, armadura,    nombre , Id
        base.Character p1=new base.Character(5000,250,100,150,50,25,10,25,10,"Jesus",002);
        base.Character p2=new base.Character(1000,500,150,50,25,10,10,25,10,"Jesus Malo",003);
        p2.addSkill(hm1);
        p2.addSkill(hm2);
        p2.addSkill(hm3);
        p1.addSkill(hb1);
        p1.addSkill(hb2);
        p1.addSkill(hb3);
        game.battle(p1, p2);
        /*System.out.println(p1.showSkills());
        System.out.println(p2.showSkills());
        System.out.println(p1.attack(p2,p2.vSkills.elementAt(0)));
        */
		
    }
    
}
