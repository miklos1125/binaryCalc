package binarycalc;

import java.awt.event.*;


public class Actions implements ActionListener{
    
    String temporary;
    FieldAndButtons fab;
    String arithmetic;
    Integer firstNum;
    
    Actions(){
        temporary = "";
    }    

    @Override
    public void actionPerformed(ActionEvent e){
        if (fab == null) fab = FieldAndButtons.getObject();
        String myB = e.getActionCommand();
        switch (myB){
            case "0": 
            case "1": 
                modifyField(myB);
                break;
            case "+":
            case "-":
            case "X":
            case "/": 
                beforeArithmetic(myB);
                break;
            case "=":
                if (arithmetic != null && fab.getField().getText().length()>0){
                    arithmeticOperation();
                }
                break;
            case "to decimal": 
                if (fab.getField().getText().length()>0 &&
                        !fab.getField().getText().contains("E")){
                    modifyField(null);
                    fab.changeConverter();
                }
                break;
            case "to binary":
                if (fab.getField().getText().length()>0){
                    modifyField("");
                    fab.changeConverter();
                }
                break;
            case "C":
                fab.getField().setText("");
                temporary = "";
                break;
        }       
    }
    
    private void modifyField(String num){
        if (num == null){
            int x = Integer.parseInt(fab.getField().getText(), 2);
            temporary = String.valueOf(x);
        }else if (num.equals("")){
            int x = Integer.parseInt(temporary);
            temporary = x>=0 ? Integer.toBinaryString(x) : "-" + Integer.toBinaryString(Math.abs(x));
        } else {
            temporary += num;
        }
        
        fab.getField().setText(temporary);
    }
    
    private void beforeArithmetic(String s){
        try{
            firstNum = Integer.parseInt(fab.getField().getText(), 2);
        } catch (NumberFormatException e){
            fab.getField().setText("");
            firstNum = null;
            temporary = "";
            arithmetic = null;
            return;
        }
        temporary = "";
        arithmetic = s;
    }
    
    private void arithmeticOperation(){
        int secondNum = Integer.parseInt(fab.getField().getText(), 2);
        int result = 0;
        switch (arithmetic){
            case "+":
               result = firstNum + secondNum;
               break;
            case "-": 
                result = firstNum - secondNum;
                break;
            case "X":
                result = firstNum * secondNum;
                break;
            case "/":
                try{
                    result = firstNum / secondNum;
                } catch(ArithmeticException e){
                    fab.getField().setText("E");
                    temporary = "";
                    arithmetic = null;
                    return;
                }
                break;
        }
        if (result>=0){
            fab.getField().setText(Integer.toBinaryString(result));
        } else{
            fab.getField().setText("-" + Integer.toBinaryString(Math.abs(result)));
        }
        temporary = "";
        arithmetic = null;
    }
}
