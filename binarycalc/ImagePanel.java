package binarycalc;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class ImagePanel extends JPanel{
    
    Image back;

    ImagePanel(URL url){
        back = Toolkit.getDefaultToolkit().getImage(url);
        setSize(Main.WID, Main.HEI);
        setLayout(null);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(back, 0, 0, back.getWidth(this)/2, back.getHeight(this)/2, this);
    }
}
