package org.ITSS.Homework_2.Task_2.Exceptions;

public class NumberOffpointException extends Exception {

    public NumberOffpointException() {
        super("Il numero presente nella lista è maggiore o uguale a 100");
    }

    public NumberOffpointException(String message) {
        super(message);
    }
}
