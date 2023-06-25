package org.ITSS.Homework_2.Task_2.Exceptions;

public class LenResultLessEqualZeroException extends Exception {

    public LenResultLessEqualZeroException() {
        super("Il valore della lunghezza della lista dei nomi e/o numeri è minore o uguale a zero");
    }

    public LenResultLessEqualZeroException(String message) {
        super(message);
    }
}
