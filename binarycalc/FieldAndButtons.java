package binarycalc;

import java.awt.*;

import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


class TButton extends JButton{
    TButton(){
        super();
    }
    TButton(String s){
        super(s);
    }
    
    void restrict(){
        this.setEnabled(false);
    }
}

//SingletonClass
public class FieldAndButtons{
    
    private JTextField field;
    private JButton zero, one, plus, minus, multi, divi, bidec, equal, clear;
    private Font font;
    ActionListener al = new Actions();
    private JButton [] buttons;
    boolean binary;
    
    private FieldAndButtons(){
        font = new Font("Dialog", 50, 25);
        createTextField();
        createButtons();
        binary = true;
    }
    private static FieldAndButtons fab;
    private static int objectCounter = 0;
    
    public static FieldAndButtons getObject(){
        if (objectCounter++ == 0){
            fab = new FieldAndButtons();
        }
        return fab;
    }
    
    public JTextField getField(){
        return field;
    }
    
    public JButton[] getButtons(){
        return buttons;
    }
    
    public void changeConverter(){
        if (binary){
            bidec.setText("to binary");
            bidec.setBackground(new Color(220,110,150));
            for(JButton b : buttons){
                if (b instanceof TButton){
                    ((TButton)b).restrict();
                } else if (b.getText().equals("C")){
                    b.setEnabled(false);
                }
            }

        } else{
            bidec.setText("to decimal");
            bidec.setBackground(new Color(110,150,220));
            for(JButton b : buttons){
                b.setEnabled(true);
            }
        }
        binary = !binary;  
    }
    
    private void createTextField(){
        field = new JTextField("");
        field.setEditable(false);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setFont(font);
        field.setBounds(35, 40, Main.WID-85, 40);
    }
    
    private void createButtons(){
        zero = new TButton("0");
        zero.setLocation(35, 100);
        one = new TButton("1");
        one.setLocation(125, 100);
        plus = new TButton("+");
        plus.setLocation(215, 100);
        minus = new TButton("-");
        minus.setLocation(305, 100);
        multi = new TButton("X");
        multi.setLocation(395, 100);
        divi = new TButton("/");
        divi.setLocation(485, 100);
        bidec = new JButton("to decimal");
        bidec.setLocation(35, 190);
        equal = new TButton("=");
        equal.setLocation(230, 190);
        clear = new JButton("C");
        clear.setLocation(430, 190);
        buttons = new JButton[]{zero, one, plus, minus, multi, divi, bidec, equal, clear};
        
        for (JButton b : buttons){
            if (b.getText().equals("to decimal") || b.getText().equals("=")){
                b.setSize(190, 60);
            } else if(b.getText().equals("C")){
                b.setSize(140, 60);
            } else{ 
                b.setSize(80, 80);
            }
            b.setOpaque(true);
            b.setBackground(new Color(110,150,220));
            b.setFont(font);
            b.addActionListener(al);
        }
    }
}