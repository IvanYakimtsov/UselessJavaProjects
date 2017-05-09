package com.ivan.calculator;

import com.ivan.calculator.calculatorData.CalculatorData;
import com.ivan.calculator.calculatorController.CalculatorManager;
import com.ivan.calculator.calculatorView.CalculatorMainFrame;

import javax.swing.*;
/**
 * Created by Ivan on 06.05.2017.
 */
public class Calculator {
    public static void main(String []args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new CalculatorManager(new CalculatorMainFrame(),new CalculatorData());
    }
}
