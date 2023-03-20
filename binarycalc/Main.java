package binarycalc;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Main {
    
    final static Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    final static int WID = 613;
    final static int HEI = 310;
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Binary Calculator");
        
        frame.setSize(WID, HEI);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(SCREEN.width/2-WID/2, SCREEN.height/2-HEI/2);
        URL u1 = Main.class.getResource("pic/binary.png");
        Image binary = Toolkit.getDefaultToolkit().getImage(u1);
        frame.setIconImage(binary);
        
        frame.setLayout(null);
        URL u2 = Main.class.getResource("pic/chess.png");
        ImagePanel impa = new ImagePanel(u2);
        FieldAndButtons fab = FieldAndButtons.getObject();
        impa.add(fab.getField());
        for (JButton b : fab.getButtons()){
            impa.add(b);
        }
        frame.add(impa);
        
        frame.setVisible(true);
    }
}
