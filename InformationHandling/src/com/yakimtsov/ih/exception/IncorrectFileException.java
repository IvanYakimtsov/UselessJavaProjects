package com.yakimtsov.ih.exception;

/**
 * Created by Ivan on 21.01.2018.
 */
public class IncorrectFileException extends Exception {
    public IncorrectFileException(String message){
        super(message);
    }

    public IncorrectFileException(){
    }

    public IncorrectFileException(Throwable th){
        super(th);
    }

    public IncorrectFileException(String m,Throwable th){
        super(m,th);
    }
}
