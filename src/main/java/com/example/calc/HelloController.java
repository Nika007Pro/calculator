package com.example.calc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

public class HelloController {
    ObservableList<String> subsList = FXCollections.observableArrayList("free","standard","vip");
    String data;
    @FXML
    private Label kolvo, sost;
    @FXML
    private TextField txt_result;
    @FXML
    private Button clear, delete, equal, point;
    @FXML
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    @FXML
    private Button CS, plus, minus, divide, multiply, percent, radical, exponent, mod;
    @FXML
    private ComboBox subs;
    @FXML
    private void initialize(){
        subs.setValue("Подписка");
        sost.setText("Ваша подписка:");
        subs.setItems(subsList);
        data = subs.getSelectionModel().getSelectedItem().toString();
        sub1.useSub(data, txt_result, percent, radical, exponent, mod, kolvo, equal, sost);
        kolvo.setVisible(false);
        equal.setDisable(true);
    }

    private double num1 = 0;
    private double num = 0;
    private double total = 0;
    private String operator = "";
    private boolean check = true;
    private boolean subIsOk = true;
    private int numOfOperations;
    private int kolvoOper;

    private Sub sub1 = new Sub(data, subIsOk, numOfOperations, Integer.toString(kolvoOper));

    public void number(String number){
        txt_result.setText(txt_result.getText() + number);
    }
    public void ComputeProcess (ActionEvent event){
        if (check) {
            txt_result.setText("");
            check = false;
        }
        Button button = (Button) event.getSource();

        String value = button.getText();
        number(value);
    }
    public void Point (ActionEvent event){
        if (check) {
            txt_result.setText("");
            check = false;
        }
        point.setDisable(false);
        Button button = (Button) event.getSource();

        String value = button.getText();
        number(value);
        point.setDisable(true);
    }
    public void ChangeSub (ActionEvent event){
        data = subs.getSelectionModel().getSelectedItem().toString();
        sub1.useSub(data, txt_result,percent, radical, exponent, mod, kolvo, equal, sost);
    }
    public void ComputeProcess2 (ActionEvent event){
        if(check){
            txt_result.setText("");
            check=false;
        }
        Button button = (Button)event.getSource();
        if(txt_result.getText().charAt(0)=='-'){
            txt_result.setText(txt_result.getText().substring(1));
        }
        else {
            txt_result.setText("-" + txt_result.getText());
        }
    }
    public void Radical (ActionEvent event){
        num = Double.parseDouble(txt_result.getText());
        total = Calculate.radical(num);
        if (total==-1) {
            txt_result.setText("Корень из отрицательного!");
        }
        else {
        txt_result.setText(String.valueOf(total));}
        operator="";
        check=true;
    }
    public void operatorProcess (ActionEvent event){
        point.setDisable(false);
        Button button = (Button)event.getSource();
        String value = button.getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator=value;
            num1 = Double.parseDouble(txt_result.getText());
            txt_result.setText("");
        }
        else{
            if(operator.isEmpty())
                return;
            double num2 = Double.parseDouble(txt_result.getText());
            if(num2==0 && operator.equals("/")){
                txt_result.setText("деление на 0");
            }
            else {
                total = Calculate.create(num1, num2, operator);
                txt_result.setText(String.valueOf(total));
                sub1.checkKolvo(kolvo, sost, equal, txt_result);
            }
            operator="";
            check=true;
        }
    }
    public void clear (ActionEvent event) {
        if(event.getSource()==clear){
            txt_result.setText("");
            point.setDisable(false);
        }
    }
    public void delete(ActionEvent event){
        if(check){
            txt_result.setText("");
            check=false;
        }
        StringBuffer number = new StringBuffer(txt_result.getText());
        number.deleteCharAt(number.length() - 1);
        txt_result.setText(number.toString());
        if(!number.toString().contains(".")){
            point.setDisable(false);}
    }
    public static boolean isNumber(String str) {
        try {
            parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
