package com.yakimtsov.ih.reader;

import com.yakimtsov.ih.exception.IncorrectFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Ivan on 07.02.2018.
 */
public class TextReader {
    private static Logger logger = LogManager.getLogger();

    public String read(String filename) throws IncorrectFileException {
        File file = new File(filename);
        String content;
        if (file.exists() && file.length() != 0) {
            try {
                content = new String(Files.readAllBytes(Paths.get(filename)));
            } catch (IOException e) {
                logger.catching(Level.FATAL, e);
                throw new RuntimeException(e);
            }
        } else {
            throw new IncorrectFileException("wrong file " + filename);
        }
        return content;
    }

}
