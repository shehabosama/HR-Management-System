/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;

/**
 *
 * @author bebo2
 */
public class JTextBox extends JTextField 
{
    public JTextBox(int Size)
    {
        super(Size);
        setOpaque(false);
    }

    @Override
    protected void paintBorder(Graphics g) {
       g.setColor(Color.blue);
       g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
