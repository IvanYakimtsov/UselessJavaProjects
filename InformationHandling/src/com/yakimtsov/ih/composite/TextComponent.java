package com.yakimtsov.ih.composite;

import java.util.List;

/**
 * Created by Ivan on 05.02.2018.
 */
public interface TextComponent {
    void add(TextComponent t);
    void remove(TextComponent t);
  //  void setValue(String value);
    List<TextComponent> getChildren();

    String execute();
}
