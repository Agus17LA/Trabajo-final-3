/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager;
import main.manager.control.ControlManager;
import main.manager.control.Mouse;
import main.manager.graphics.DrawSurface;
import main.manager.graphics.Window;
import main.manager.statesmachine.GameState;
import main.manager.statesmachine.StateManager;
import main.manager.statesmachine.state.game.InitialMenu;

/**
 *
 * @author Agus_
 */
public class PrincipalManager {
    private boolean inWorking = false;
    private String title;
    private int width;
    private int height;
    private DrawSurface ds;
    private Window win;
    private StateManager sm;
    
    public PrincipalManager(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }
    
    public void startGame(){
        inWorking = true;
        start();
    }
    
    private void start(){
        ds = new DrawSurface(width,height);
        win = new Window(title,ds);
        sm = new StateManager();
    }
    
    public void startPrincipalLoop(){
        int ufs = 0;
        int fps = 0;
        final int NS_FOR_SECOND = 1000000000;
        final int UPS_OBJETIVE = 80; //Guardamos en un byte pq no queremos guaradr un numero grande
        final double NS_FOR_UPDATE = NS_FOR_SECOND / UPS_OBJETIVE; //Cuantos nanosegundos tienen que pasar para que logremos cumplir nuestro objetivo de 60 actualizaciones x seg
        long updateReference = System.nanoTime(); //La primera entrada al bucle será con esta referencia
        long countReference = System.nanoTime();
        double elapsedTime;
        double delta = 0; //cantidad de tiempo que ha transcurrido hasta que se realiza una actualizacion
        while(inWorking){ 
            final long loopStart = System.nanoTime();
            elapsedTime = loopStart - updateReference;
            updateReference = loopStart; //Esta referencia nos servirá para medir el elapsedTime en las siguientes entradas al bucle dsps del primero
            delta+=elapsedTime/NS_FOR_UPDATE;
            while(delta>=1){ //Cuando llegue a 1, el bucle entrará en funcionamiento y ejecutaremos aproximadamente, de esta manera, 60 veces por segundo nuestro metodo REFRESH()
                refresh();
                ufs++;
                Constants.UFS = ufs;
                delta--;
            }
            draw();
            fps++;
            if((System.nanoTime() - countReference) >NS_FOR_SECOND){ //Si la diferencia es de mas de 1 segundo se realizará una actualizacion del contador, el objetivo es que nuestro contador se actualice cada segundo
                win.setTitle(title + "<UFS: " + ufs + "> <FPS: " + fps + ">");
                ufs = 0;
                Constants.UFS = ufs;
                fps = 0;
                countReference = System.nanoTime();
            }
        }
    }
    
    private void refresh(){
        if(ControlManager.keyboard.exit){
            sm.changeCurrentState(1);
        }else if(ControlManager.keyboard.combate){
            sm.changeCurrentState(3);
            ControlManager.keyboard.combate = false;
        }else if(ControlManager.keyboard.menu){
            sm.changeCurrentState(2);
            ControlManager.keyboard.menu = false;
        }
        
        if(Constants.NEWGAME){
            sm.changeCurrentState(1);
            Constants.NEWGAME = false;
        }
        
        sm.refresh();
        ds.refresh();
    }
    
    private void draw(){
        ds.draw(sm);
        
    }
    
    
}
