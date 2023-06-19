package com.example.calc;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.example.calc.HelloController.isNumber;
import static java.lang.Integer.parseInt;

public class Sub {
    private String sub;
    private boolean subIsOk;
    private int numOfOperations;
    private String kolvo;

    public Sub(String sub,boolean subIsOk, int numOfOperations, String kolvo)
    {
        this.sub = sub;
        this.subIsOk = subIsOk;
        this.numOfOperations = numOfOperations;
        this.kolvo = kolvo;
    }

    public String getSub() {return sub;}
    public void setSub(String sub) {this.sub = sub;}

    public String getkolvo() {return kolvo;}
    public void setkolvo(String kolvo) {this.kolvo = kolvo;}

    public boolean getsubIsOk() {return subIsOk;}
    public void setsubIsOk(boolean subIsOk) {this.subIsOk = subIsOk;}

    public int getnumOfOperations() {return numOfOperations;}
    public void setnumOfOperations(int numOfOperations) {this.numOfOperations = numOfOperations;}

    public void useKolvo(String kolvo, Label l){
        l.setText("У вас осталось " + kolvo + " операций.");
    }

    public void useSub(String data, TextField txt_result,Button b1, Button b2, Button b3, Button b4, Label l, Button e, Label sost) {
        l.setVisible(true);
        switch (data){
            case ("free"):
                setkolvo("2");
                b1.setDisable(true);
                b2.setDisable(true);
                b3.setDisable(true);
                b4.setDisable(true);
                break;
            case ("standard"):
                setkolvo("4");
                b1.setDisable(false);
                b2.setDisable(false);
                b3.setDisable(false);
                b4.setDisable(false);
                break;
            case ("vip"):
                setkolvo("сколько угодно");
                b1.setDisable(false);
                b2.setDisable(false);
                b3.setDisable(false);
                b4.setDisable(false);
            default:
                break;
        }
        e.setDisable(false);
        useKolvo(kolvo, l);
        txt_result.setText("");
        sost.setText("Ваша подписка: ");
    }
    public void checkKolvo(Label kolvo, Label sost, Button equal, TextField txt){
        if (isNumber(getkolvo())){
            setkolvo( Integer.toString((parseInt(getkolvo()) - 1)));
            useKolvo(getkolvo(), kolvo);
            if(parseInt(getkolvo()) == 0){
                sost.setText("Смените подписку!");
                txt.setText("Смените подписку!");
                equal.setDisable(true);
            }
        }
    }
}
