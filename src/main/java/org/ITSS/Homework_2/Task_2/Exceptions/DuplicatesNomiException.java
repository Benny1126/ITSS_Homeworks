package org.ITSS.Homework_2.Task_2.Exceptions;

public class DuplicatesNomiException extends Exception {

    public DuplicatesNomiException() {
        super("Nella lista nomi sono presenti due o più nomi uguali");
    }

    public DuplicatesNomiException(String message) {
        super(message);
    }
}
