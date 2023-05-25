package org.ITSS.Homework_2.Task_2.Exceptions;

public class NegativeNumberException extends Exception {

    public NegativeNumberException() {
        super("Nella lista dei numeri vi è uno o più numeri negativi");
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}
