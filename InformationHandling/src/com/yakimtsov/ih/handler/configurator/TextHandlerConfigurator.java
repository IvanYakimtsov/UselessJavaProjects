package com.yakimtsov.ih.handler.configurator;

import com.yakimtsov.ih.composite.TextComponent;
import com.yakimtsov.ih.composite.TextPart;
import com.yakimtsov.ih.handler.*;

/**
 * Created by Ivan on 07.02.2018.
 */
public class TextHandlerConfigurator {
    private ParagraphHandler paragraphHandler = new ParagraphHandler();
    private SentenceHandler sentenceHandler = new SentenceHandler();
    private LexemeHandler lexemeHandler = new LexemeHandler();
    private WordHandler wordHandler = new WordHandler();
    private SymbolHandler symbolHandler = new SymbolHandler();


    public TextHandlerConfigurator(){
        paragraphHandler.setHandler(sentenceHandler);
        sentenceHandler.setHandler(lexemeHandler);
        lexemeHandler.setHandler(wordHandler);
        wordHandler.setHandler(symbolHandler);
    }

    public TextComponent parseComponents(String text){
        TextComponent textComponent = new TextPart(TextPart.TextPartType.TEXT);
        paragraphHandler.handle(text,textComponent);
        return textComponent;
    }
}
