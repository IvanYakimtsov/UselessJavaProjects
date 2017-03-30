package com.ivan.tableEditor;

import javax.swing.*;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableEditor {
    public static void main(String args[]){
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
        new TableController(new TableModel(),new TableView(5));
    }
}
