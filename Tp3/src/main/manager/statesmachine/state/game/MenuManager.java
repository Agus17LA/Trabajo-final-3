/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine.state.game;

import java.awt.Color;
import java.awt.Graphics;
import main.manager.statesmachine.GameState;

/**
 *
 * @author Agus_
 */
public class MenuManager implements GameState{

    @Override
    public void refresh() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(100, 200, 200, 200);
    }
    
}
