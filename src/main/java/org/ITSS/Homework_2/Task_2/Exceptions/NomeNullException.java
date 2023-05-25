package org.ITSS.Homework_2.Task_2.Exceptions;

public class NomeNullException extends Exception {

    public NomeNullException() {
        super("Nome null o blank");
    }

    public NomeNullException(String message) {
        super(message);
    }
}
