package com.yakimtsov.ih.handler;

import com.yakimtsov.ih.composite.TextComponent;
import com.yakimtsov.ih.composite.TextPart;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 05.02.2018.
 */
public class ParagraphHandler implements TextHandler {
    private static Logger logger = LogManager.getLogger();
    private TextHandler handler;

    private final String PARAGRAPH_REGEXP = "\\t.+[!?.]";

    Pattern pattern = Pattern.compile(PARAGRAPH_REGEXP);

//    public ParagraphHandler(TextHandler handler) {
//        this.handler = handler;
//    }


    public void setHandler(TextHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String text, TextComponent component) {
        //TODO: handler null check

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String paragraph = matcher.group();
            TextComponent child = new TextPart(TextPart.TextPartType.PARAGRAPH);
            component.add(child);
            handler.handle(paragraph,child);
        }

    }
}
