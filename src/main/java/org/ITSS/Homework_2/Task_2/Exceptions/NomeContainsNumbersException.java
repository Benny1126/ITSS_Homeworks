package org.ITSS.Homework_2.Task_2.Exceptions;

public class NomeContainsNumbersException extends Exception {

    public NomeContainsNumbersException() {
        super("Nome contiene dei caratteri non validi");
    }

    public NomeContainsNumbersException(String message) {
        super(message);
    }
}
