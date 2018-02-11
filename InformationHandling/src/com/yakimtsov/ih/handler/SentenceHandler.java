package com.yakimtsov.ih.handler;

import com.yakimtsov.ih.composite.TextComponent;
import com.yakimtsov.ih.composite.TextPart;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ivan on 07.02.2018.
 */
public class SentenceHandler implements TextHandler {
    private static Logger logger = LogManager.getLogger();
    private TextHandler handler;

    //TODO: fix regex
    private final String SENTENCE_REGEXP = "\\s.+?[!?.]\\n?";

    Pattern pattern = Pattern.compile(SENTENCE_REGEXP);

    public void setHandler(TextHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String text, TextComponent component) {
        //TODO: handler null check
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent child = new TextPart(TextPart.TextPartType.SENTENCE);
            component.add(child);
            handler.handle(sentence,child);
        }
    }
}
