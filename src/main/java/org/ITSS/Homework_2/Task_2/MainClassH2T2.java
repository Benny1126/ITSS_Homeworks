package org.ITSS.Homework_2.Task_2;


import org.ITSS.Homework_2.Task_2.Exceptions.*;

import java.util.ArrayList;

public class MainClassH2T2 {

    public static ArrayList<String> squareCubeList(int n, int m, String[] nomi, Integer[] numeri) throws
            CubeSquareLimitsExceededException, NumberEqualZeroException, DifferentLenghtNomiNumeriException,
            LenResultEqualZeroException, NegativeNumberException, NumberOffpointException, NomeNullException,
            NomeContainsNumbersException, DuplicatesNomiException {

        if (n == 0 || m == 0)
            throw new LenResultEqualZeroException();
        if (n != m || n != nomi.length)
            throw new DifferentLenghtNomiNumeriException();

        for (int i = 0; i < nomi.length - 1; i++)
            for (int j = i + 1; j < nomi.length; j++)
                if (nomi[i] == nomi[j] && i != j)
                    throw new DuplicatesNomiException();

        for (int i = 0; i < n; i++) {
            if (numeri[i] < 0)
                throw new NegativeNumberException();
            else if (numeri[i] > 99)
                throw new NumberOffpointException();
            else if (numeri[i] == 0)
                throw new NumberEqualZeroException();
            else if (((numeri[i] % 2) == 0 && numeri[i] >= 10) || ((numeri[i] % 2) != 0 && numeri[i] >= 7))
                throw new CubeSquareLimitsExceededException();
            else if (nomi[i] == "" || nomi[i] == null)
                throw new NomeNullException();
            else if (nomi[i].matches(".*\\d.*"))
                throw new NomeContainsNumbersException();
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (numeri[i] % 2 == 0)
                result.add(nomi[i] + " " + numeri[i] * numeri[i]);
            else
                result.add(nomi[i] + " " + numeri[i] * numeri[i] * numeri[i]);
        }

        return result;
    }
}