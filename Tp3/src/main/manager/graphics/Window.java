/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.manager.graphics;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Agus_
 */
public class Window extends JFrame{
    private String title;
    private JLabel layout;
    private JPanel jp;
    
    
    public Window(String title, DrawSurface ds){
        this.title = title;
        configWindow(ds);
    }

    private void configWindow(DrawSurface ds) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setIconImage();
        setLayout(new BorderLayout());
        add(ds,BorderLayout.CENTER);
        // setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        
        layout = new JLabel();
        jp = new JPanel();
        layout.setIcon(new ImageIcon("textures/borde.png"));
        jp.add(layout);
        add(jp);
        validate();
        
        setVisible(true);
        
    }
}
