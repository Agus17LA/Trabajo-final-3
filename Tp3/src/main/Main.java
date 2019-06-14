package main;

import base.Buff;
import base.Game;
import base.Poison;
import base.Skill;

import main.manager.Constants;
import main.manager.PrincipalManager;

import base.Stun;


//main con pruebas y nombres malos muy malos
public class Main {

    
    public static void main(String[] args) {

        // TODO code application logic here
        
        PrincipalManager pm = new PrincipalManager("",Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        pm.startGame(Constants.RUTA_MAGOGNOMO); //acá cargamos la ruta del personaje que se seleccionó
        pm.startPrincipalLoop();
 
          System.out.println("1");
		Game game=new Game();
                Poison poison=new Poison(); //daño duracion
                Stun stun=new Stun();//duracion
                Buff buff=new Buff(2000,0,0,0,0,5);
		Skill hb1=new Skill("Golpe divino",001,0,100,75,100,buff);//dmg,prec,crit
		Skill hm1=new Skill("golpe divino malo",001,0,100,50);
		Skill hb2=new Skill("purificacion ",001,0,100,75);
		Skill hm2=new Skill("putrefaccion",001,0,100,50);
		Skill hb3=new Skill("bokita pasion",001,0,20,75);
		Skill hm3=new Skill("Velez campeón",001,0,100,50);
                //hp,mana,dmg/max,acc,dodge,crit,def
                //Hay un constructor con solo estadisticas y otro con items y vectores
                //Inventario, skills, arma, armadura,    nombre , Id
		base.Character p1=new base.Character(5000,250,100,150,50,25,25,10,"Jesus",002);
		base.Character p2=new base.Character(10000,500,150,50,25,10,25,10,"Jesus Malo",003);
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
