/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine;

import base.Game;
import java.awt.Graphics;
import main.manager.statesmachine.state.game.BattleManager;
import main.manager.statesmachine.state.game.GameManager;
import main.manager.statesmachine.state.game.InitialMenu;
import main.manager.statesmachine.state.game.MenuManager;

/**
 *
 * @author Agus_
 */
public class StateManager {
    private GameState[] state;
    private GameState currentState;

    public StateManager() {
        startState();
        startCurrentState();
    }
    
    private void startState(){
        state = new GameState[5];
        state[0] = new InitialMenu();
        state[1] = new GameManager();
        state[2] = new MenuManager();
        state[3] = new BattleManager();
        state[4] = new Game();
        
    }

    private void startCurrentState() {
        currentState = state[0];
    }
    
    public void refresh(){
        currentState.refresh();
    }
    
    public void draw(final Graphics g){
        currentState.draw(g);  // encontraremos el metodo "draw" en la clase "GameManager/BattleManager/InitialMenu" que implementa "GameState".
    }
    
    public void changeCurrentState(int newState){
        currentState = state[newState];
        
    }

    public GameState getCurrentState() {
        return currentState;
    }
    
    
    
}
