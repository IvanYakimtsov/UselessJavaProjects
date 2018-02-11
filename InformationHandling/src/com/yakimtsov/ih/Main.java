package com.yakimtsov.ih;

import com.yakimtsov.ih.handler.configurator.TextHandlerConfigurator;
import com.yakimtsov.ih.composite.TextComponent;
import com.yakimtsov.ih.exception.IncorrectFileException;
import com.yakimtsov.ih.reader.TextReader;

/**
 * Created by Ivan on 07.02.2018.
 */
public class Main {

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        TextHandlerConfigurator componentParser = new TextHandlerConfigurator();
        try {
            String text = textReader.read("Data/text.txt");
            TextComponent component = componentParser.parseComponents(text);
            System.out.println(component.execute());
        } catch (IncorrectFileException e) {

        }
    }
}
