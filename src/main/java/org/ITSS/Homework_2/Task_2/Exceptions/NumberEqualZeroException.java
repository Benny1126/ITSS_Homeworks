package org.ITSS.Homework_2.Task_2.Exceptions;

public class NumberEqualZeroException extends Exception {

    public NumberEqualZeroException() {
        super("Nella lista dei numeri vi è uno o più numeri uguali a zero");
    }

    public NumberEqualZeroException(String message) {
        super(message);
    }
}
