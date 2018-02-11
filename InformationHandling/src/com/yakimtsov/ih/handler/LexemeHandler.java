package com.yakimtsov.ih.handler;

import com.yakimtsov.ih.composite.*;
import com.yakimtsov.ih.parser.RPNParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 07.02.2018.
 */
public class LexemeHandler implements TextHandler {
    private static Logger logger = LogManager.getLogger();
    private TextHandler handler;

    private final String LEXEME_REGEXP = "[^\\s]+";
    private final String FORMULA_REGEXP = "\\(*-?\\d.+?(?=\\s\\w{2,})";

    private Pattern pattern = Pattern.compile(LEXEME_REGEXP);


    public void setHandler(TextHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String text, TextComponent component) {
        //TODO: handler null check
        //TODO: calculate formula
        RPNParser parser = new RPNParser();

        String pureText = text.replaceAll(FORMULA_REGEXP,"2018");

        Matcher matcher = pattern.matcher(pureText);
        while (matcher.find()) {
            String lexeme = matcher.group();
            TextPart child = new TextPart(TextPart.TextPartType.LEXEME);
            component.add(child);
            handler.handle(lexeme,child);
        }
    }

}
