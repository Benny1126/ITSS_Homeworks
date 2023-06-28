package org.ITSS.Homework_2.Task_2;


import org.ITSS.Homework_2.Task_2.Exceptions.*;

import java.util.ArrayList;

public class MainClassH2T2 {

    /**
     * La funzione squareCubeList() prende in input quattro parametri e restituisce un oggetto di tipo ArrayList.
     * Per la lista dei numeri viene calcolato il quadrato o il cubo del singolo numero della lista a seconda
     * che questo sia rispettivamente pari o dispari. Inoltre, si verifica che il quadrato non superi 99 e il cubo 299.
     * Dopo aver effettuato i calcoli la funzione restituisce un oggetto di tipo ArrayList contenente i risultati
     * calcolati.
     *
     * @param n Intero che rappresenta la lunghezza che dovrebbe avere la lista dei nomi
     * @param m Intero che rappresenta la lunghezza che dovrebbe avere la lista dei numeri
     * @param nomi Array di stringhe che rappresenta il nome di una persona
     * @param numeri Array di Integer che contiene un numero su cui calcolare il quadrato o il cubo
     *
     * @return ArrayList contenente la lista dei risultati dei quadrati e dei cubi
     *
     * @throws CubeSquareLimitsExceededException se il risultato supera i limiti predisposti;
     * @throws DifferentLenghtNomiNumeriException se la lista dei numeri e quella dei nomi hanno lunghezze differenti;
     * @throws LenResultLessEqualZeroException se il valore della lunghezza della lista dei nomi e/o numeri è minore o uguale a zero;
     * @throws NumberOffpointException se il numero presente nella lista è maggiore o uguale a 100;
     * @throws NomeNullException se il nome null o blank;
     * @throws NomeContainsNumbersException se il nome contiene dei caratteri non validi;
     * @throws DuplicatesNomiException se nella lista nomi sono presenti due o più nomi uguali.
     */
    public static ArrayList<String> squareCubeList (int n, int m, String[] nomi, Integer[] numeri) throws
            CubeSquareLimitsExceededException, DifferentLenghtNomiNumeriException, NumberOffpointException,
            NomeNullException, NomeContainsNumbersException, DuplicatesNomiException, LenResultLessEqualZeroException {

        if (n <= 0 || m <= 0)
            throw new LenResultLessEqualZeroException();
        if (n != m || n != nomi.length)
            throw new DifferentLenghtNomiNumeriException();

        for (int i = 0; i < nomi.length - 1; i++)
            for (int j = i + 1; j < nomi.length; j++)
                if (nomi[i] == nomi[j] && i != j)
                    throw new DuplicatesNomiException();

        for (int i = 0; i < n; i++) {
            if (numeri[i] <= 0 || numeri[i] >= 101)
                throw new NumberOffpointException();
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