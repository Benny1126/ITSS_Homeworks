package org.ITSS.Homework_2.Task_2;

import org.ITSS.Homework_2.Task_2.Exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.ITSS.Homework_2.Task_2.MainClassH2T2.squareCubeList;
import static org.junit.jupiter.api.Assertions.*;

class MainClassH2T2Test {

    @Test
    public void lenResultLessEqualZero() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        String[] nomi = {"Benedetto", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");

        //T01
        assertThrows(LenResultLessEqualZeroException.class, () -> {
            squareCubeList(2, 0, nomi, numeri);
        });

        //T02
        assertThrows(LenResultLessEqualZeroException.class, () -> {
            squareCubeList(-2, 2, nomi, numeri);
        });

        //T03
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

    @Test
    public void differentLenghtNomiNumeri() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        String[] nomi = {"Benedetto", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");
        String[] nomi3 = {"Benedetto", "Giovanni", "Mario"};

        //T04
        assertThrows(DifferentLenghtNomiNumeriException.class, () -> {
            squareCubeList(3, 2, nomi3, numeri);
        });

        //T05
        assertThrows(DifferentLenghtNomiNumeriException.class, () -> {
            squareCubeList(2, 2, nomi3, numeri);
        });

        //T06
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

    @Test
    public void duplicatesNomi() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2, 1};
        String[] nomi = {"Benedetto", "Giovanni", "Mario"};
        String[] nomiDupl = {"Benedetto", "Giovanni", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");
        result.add("Mario 1");

        //T07
        assertThrows(DuplicatesNomiException.class, () -> {
            squareCubeList(3, 3, nomiDupl, numeri);
        });

        //T08
        assertEquals(squareCubeList(3, 3, nomi, numeri), result);
    }

    @Test
    public void nomeContainsNumbers() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        String[] nomi = {"Benedetto", "Giovanni"};
        String[] nomiNum = {"Benedetto2", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");

        //T07
        assertThrows(NomeContainsNumbersException.class, () -> {
            squareCubeList(2, 2, nomiNum, numeri);
        });

        //T08
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

    @Test
    public void numberOffpoint() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        Integer[] numeri101 = {3, 105};
        Integer[] numeri0 = {3, 0};
        String[] nomi = {"Benedetto", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");

        //T11
        assertThrows(NumberOffpointException.class, () -> {
            squareCubeList(2, 2, nomi, numeri0);
        });

        //T12
        assertThrows(NumberOffpointException.class, () -> {
            squareCubeList(2, 2, nomi, numeri101);
        });

        //T13
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

    @Test
    public void cubeSquareLimitsExceeded() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        Integer[] numeriPariLimits = {10, 6};
        Integer[] numeriDispariLimits10 = {11, 5};
        Integer[] numeriDispariLimits7 = {7, 5};
        String[] nomi = {"Benedetto", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");

        //T14
        assertThrows(CubeSquareLimitsExceededException.class, () -> {
            squareCubeList(2, 2, nomi, numeriPariLimits);
        });

        //T16
        assertThrows(CubeSquareLimitsExceededException.class, () -> {
            squareCubeList(2, 2, nomi, numeriDispariLimits10);
        });

        //T17
        assertThrows(CubeSquareLimitsExceededException.class, () -> {
            squareCubeList(2, 2, nomi, numeriDispariLimits7);
        });

        //T15 = T18
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

    @Test
    public void nomeNullOrEmpty() throws LenResultLessEqualZeroException, NomeContainsNumbersException,
            NumberOffpointException, CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException,
            NomeNullException, DuplicatesNomiException {

        Integer[] numeri = {3, 2};
        String[] nomi = {"Benedetto", "Giovanni"};
        String[] nomiNull = {null, "Giovanni"};
        String[] nomiEmpty = {"", "Giovanni"};
        ArrayList<String> result = new ArrayList<>();
        result.add("Benedetto 27");
        result.add("Giovanni 4");

        //T19
        assertThrows(NomeNullException.class, () -> {
            squareCubeList(2, 2, nomiEmpty, numeri);
        });

        //T20
        assertThrows(NomeNullException.class, () -> {
            squareCubeList(2, 2, nomiNull, numeri);
        });

        //T21
        assertEquals(squareCubeList(2, 2, nomi, numeri), result);
    }

}