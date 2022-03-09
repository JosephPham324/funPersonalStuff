/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg83;

import javax.swing.JFrame;


/**
 *
 * @author Pham Nhat Quang
 */
public class MyFrame extends JFrame {
    MyPanel panel;
    

    public MyFrame(String[] flower) {
        panel = new MyPanel(flower);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
