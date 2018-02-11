package com.yakimtsov.ih.handler;

import com.yakimtsov.ih.composite.TextComponent;

/**
 * Created by Ivan on 05.02.2018.
 */
public interface TextHandler {
    void setHandler(TextHandler handler);
    void handle(String text, TextComponent component);
}
