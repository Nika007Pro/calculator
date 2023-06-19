package com.example.calc;

import javafx.scene.control.TextField;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calculate {
    public static Double radical (double num){
        if (num < 0 ){
            return -1.0;
        }
        else {
            return sqrt(num);
        }
    }
    public static Double create(double num1, double num2, String operator){
        switch (operator){
            case "+":
                return (num1+num2);
            case "-":
                return (num1-num2);
            case "/":
                if(num2==0)
                    return 0.0;
                return (num1/num2);
            case "*":
                return (num1*num2);
            case "^":
                return pow(num1, num2);
            case "mod":
                return num1%num2;
            case "%":
                return (num1 / 100)*num2;
            default:
                break;
        }
        return 0.0;
    }
}

