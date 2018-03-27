package com.yakimtsov.thrift.dao;

/**
 * Created by Ivan on 21.01.2018.
 */
public class DAOException extends Exception {
    public DAOException(String message){
        super(message);
    }

    public DAOException(){
    }

    public DAOException(Throwable th){
        super(th);
    }

    public DAOException(String m, Throwable th){
        super(m,th);
    }
}
