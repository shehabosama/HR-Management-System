/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author bebo2
 */
public class JMyButton extends JButton
{
    public JMyButton()
    {
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
            
    }

    @Override
    protected void paintBorder(Graphics g) {
       g.setColor(Color.blue);
       g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(70,130,180));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
