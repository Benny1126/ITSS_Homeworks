package org.ITSS.Homework_2.Task_2.Exceptions;

public class LenResultEqualZeroException extends Exception {

    public LenResultEqualZeroException() {
        super("Il valore della lunghezza della lista dei nomi e/o numeri è uguale a zero");
    }

    public LenResultEqualZeroException(String message) {
        super(message);
    }
}
