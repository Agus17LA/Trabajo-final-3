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
        System.setProperty("sun.java2d.opengl", "false");
        PrincipalManager pm = new PrincipalManager("jueguito", Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        pm.startGame();
        pm.startPrincipalLoop();
    }
}
