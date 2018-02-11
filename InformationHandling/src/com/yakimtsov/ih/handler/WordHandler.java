package com.yakimtsov.ih.handler;

import com.yakimtsov.ih.composite.Symbol;
import com.yakimtsov.ih.composite.TextComponent;
import com.yakimtsov.ih.composite.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 07.02.2018.
 */
public class WordHandler implements TextHandler {
    private TextHandler handler;

    private final String WORD_REGEXP = "[A-Za-z]+";
    private final String PUNCTUATION_MARK_REGEXP = "[!?.,()]";
    private final String SYMBOL_REGEXP = ".";
    private final String DIGIT_REGEXP = "\\d";

    Pattern wordPattern = Pattern.compile(WORD_REGEXP);
    Pattern punctuationPattern = Pattern.compile(PUNCTUATION_MARK_REGEXP);
    Pattern digitPattern = Pattern.compile(DIGIT_REGEXP);
    Pattern symbolPattern = Pattern.compile(SYMBOL_REGEXP);

    @Override
    public void setHandler(TextHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String text, TextComponent component) {
        Matcher matcher = symbolPattern.matcher(text);

        Matcher symbolMatcher;

        while (matcher.find()){
            String word = matcher.group();

            symbolMatcher = wordPattern.matcher(word);
            if(symbolMatcher.matches()){
                TextComponent child = new TextPart(TextPart.TextPartType.WORD);
                component.add(child);
                handler.handle(word, child);
            }

            symbolMatcher = digitPattern.matcher(word);
            if(symbolMatcher.matches()){
                addChild(word, component, Symbol.SymbolType.DIGIT);
            }

            symbolMatcher = punctuationPattern.matcher(word);
            if(symbolMatcher.matches()){
                addChild(word, component, Symbol.SymbolType.PUNCTUATION_MARK);
            }
        }

    }

    private void addChild(String word, TextComponent component, Symbol.SymbolType type){
            Symbol child = new Symbol(type);
            child.setValue(word);
            component.add(child);
    }

}
