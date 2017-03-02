package com.ivan.imageEditor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

/**
 * Created by Ivan on 02.03.2017.
 */
public interface Tool extends MouseMotionListener,MouseListener {
    public Cursor getCursor();
    public void setCursor();
}
