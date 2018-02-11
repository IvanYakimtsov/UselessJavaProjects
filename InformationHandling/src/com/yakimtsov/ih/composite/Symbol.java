package com.yakimtsov.ih.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 05.02.2018.
 */
public class Symbol implements TextComponent {
    public static enum SymbolType {
        PUNCTUATION_MARK, LATTER, DIGIT
    }

    private String value;
    private SymbolType type;

    public Symbol(SymbolType type) {
        this.type = type;
    }

    public String getValue() {
       return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void add(TextComponent t) {

    }

    @Override
    public void remove(TextComponent t) {

    }

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String execute() {
        return value;
    }


}
