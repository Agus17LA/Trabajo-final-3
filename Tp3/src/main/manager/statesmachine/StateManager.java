/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine;

import java.awt.Graphics;
import main.manager.statesmachine.state.game.BattleManager;
import main.manager.statesmachine.state.game.GameManager;
import main.manager.statesmachine.state.game.MenuManager;

/**
 *
 * @author Agus_
 */
public class StateManager {
    private GameState[] state;
    private GameState currentState;

    public StateManager(String characterRute) {
        startState(characterRute);
        startCurrentState();
    }
    
    private void startState(String characterRute){
        state = new GameState[4];
        state[0] = new GameManager(characterRute);
        state[1] = new MenuManager();
        state[2] = new BattleManager();
        
    }

    private void startCurrentState() {
        currentState = state[0];
    }
    
    public void refresh(){
        currentState.refresh();
    }
    
    public void draw(final Graphics g){
        currentState.draw(g);  // encontraremos el metodo "draw" en la clase "GameManager" que implementa "GameState".
    }
    
    public void changeCurrentState(int newState){
        currentState = state[newState];
    }

    public GameState getCurrentState() {
        return currentState;
    }
    
    
    
}
