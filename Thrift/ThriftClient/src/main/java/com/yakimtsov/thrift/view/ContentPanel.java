package com.yakimtsov.thrift.view;

import com.yakimtsov.thrift.controller.ClientManager;

import javax.swing.*;

public class ContentPanel {
    private JPanel panel;

    public ContentPanel(ClientManager clientManager){
        panel = new JPanel();
    }

    public JPanel getPanel(){
        return panel;
    }
}
