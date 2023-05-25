package org.ITSS.Homework_2.Task_2.Exceptions;

public class CubeSquareLimitsExceededException extends Exception {

    public CubeSquareLimitsExceededException() {
        super("Il risultato supera i limiti predisposti");
    }

    public CubeSquareLimitsExceededException(String message) {
        super(message);
    }
}
