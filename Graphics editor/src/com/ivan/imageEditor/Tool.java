package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * Created by Ivan on 02.03.2017.
 */
public interface Tool extends MouseMotionListener,MouseListener,KeyListener {
    public Cursor getCursor();

}
