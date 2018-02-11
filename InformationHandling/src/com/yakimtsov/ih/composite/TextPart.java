package com.yakimtsov.ih.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 05.02.2018.
 */
public class TextPart implements TextComponent {
    public static enum TextPartType {
        TEXT, PARAGRAPH, SENTENCE, LEXEME, WORD
    }
    private List<TextComponent> children = new ArrayList<>();
    private TextPartType textPartType;
    private final String TEXT_PART_SEPARATOR;

    public TextPart(TextPartType textPartType) {
        this.textPartType = textPartType;
        switch (textPartType){
            case TEXT: TEXT_PART_SEPARATOR = "";
                        break;
            case SENTENCE: TEXT_PART_SEPARATOR = "";
                            break;
            case PARAGRAPH: TEXT_PART_SEPARATOR = "\t";
                            break;
            case LEXEME: TEXT_PART_SEPARATOR = " ";
                       break;
            case WORD: TEXT_PART_SEPARATOR = "";
                       break;
            default: TEXT_PART_SEPARATOR = "";
        }

    }

    @Override
    public void add(TextComponent t) {
        children.add(t);
    }

    @Override
    public void remove(TextComponent t) {
        children.remove(t);
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();

        result.append(TEXT_PART_SEPARATOR);
        for (TextComponent child: children){
            result.append(child.execute());
        }

        if(textPartType == TextPartType.PARAGRAPH){
            result.append("\n");
        }

       return result.toString();
    }



}
