package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * Created by Ivan on 02.03.2017.
 */
public interface Tool extends MouseMotionListener,MouseListener {
    public Cursor getCursor();
    public void setCursor();
}
