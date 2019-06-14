/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.statesmachine;

import java.awt.Graphics;

/**
 *
 * @author Agus_
 */
public interface GameState {
    
    void refresh();
    
    void draw(final Graphics g);
    
}
