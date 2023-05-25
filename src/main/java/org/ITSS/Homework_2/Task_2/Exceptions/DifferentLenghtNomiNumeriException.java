package org.ITSS.Homework_2.Task_2.Exceptions;

public class DifferentLenghtNomiNumeriException extends Exception {

    public DifferentLenghtNomiNumeriException() {
        super("La lista dei numeri e quella dei nomi hanno lunghezze differenti");
    }

    public DifferentLenghtNomiNumeriException(String message) {
        super(message);
    }
}
