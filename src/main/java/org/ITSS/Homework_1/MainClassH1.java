package org.ITSS.Homework_1;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class MainClassH1 {

//    public static void main(String[] args) {
//        System.out.println(isMaggiorennePhrase("Benedetto", "Bellarte", 21, Date.valueOf(LocalDate.parse("2001-07-26"))));
//    }

    /**
     * Il metodo isMaggiorennePhrase() permette di verificare se un utente sia maggiorenne oppure no. Inoltre i dati che
     * vengono passati alla funzione devono rispettare determinate condizioni:
     * 1. nome e cognome diversi da null o blank;
     * 2. nome e cognome diversi tra loro;
     * 3. la lunghezza del nome deve essere maggiore o oguale a quella del cognome;
     * 4. età non può essere un numero negativo;
     * 5. la data di nascita deve essere coerente con l'eta che viene data in input;
     * 6. la data di nascita deve essere minore o uguale della data odierna.
     * La funzione infine effettua la capitalizzazione sulle stringhe di nome e cognome.
     *
     * @param nome Stringa che rappresenta il nome della persona
     * @param cognome Stringa che rappresenta il cognome della persona
     * @param eta Intero che rappresenta l'età della persona
     * @param dataNascita Tipo di dato Java.sql.Date che rappresenta la data di nascita della persona
     * @return Stringa che descrive l'esito finale della persona
     */
    public static String isMaggiorennePhrase(String nome, String cognome, int eta, Date dataNascita) {

        // Verifica che nome e/o cognome non siano null
        if (nome == null || cognome == null)
            return "Nome o cognome null";

        // Verifica che nome e/o cognome contengano solo lettere
        if (nome.matches(".*\\d.*") || cognome.matches(".*\\d.*"))
            return "Nome o cognome non valido";

        // Verifica che nome e/o cognome non sia una stringa vuota
        if (nome.isBlank() || cognome.isBlank())
            return "Nome e/o cognome vuoto";

        // Verifica che nome e cognome siano diversi
        if (nome.equals(cognome))
            return "Nome e cognome sono uguali";

        // Nome deve essere maggiore uguale rispetto al cognome e non può essere uguale
        if (nome.length() < cognome.length())
            return "Nome minore del cognome";

        // Verifica che l'età non sia minore di zero
        if (eta < 0)
            return "Età minore di zero";

        // Verifica che dataNascita non sia null
        if (dataNascita == null)
            return "dataNascita null";

        // Verifica che la data di nascita non sia maggiore della data odierna
        if(dataNascita.after(Date.valueOf(LocalDate.now())))
            return "Data nascita maggiore della data odierna";

        // Verifica che l'età data in input coincida con la data di nascita data in input
        int diffYears = Period.between(dataNascita.toLocalDate(), LocalDate.now()).getYears();
        if (diffYears != eta)
            return "Età non coincide con la data di nascita " + diffYears;

        // Capitalizzazione del nome
        nome = nome.toLowerCase();
        char[] stringArray = nome.toCharArray();
        boolean spazi = true;
        for(int i = 0; i < stringArray.length; i++)
            if(Character.isLetter(stringArray[i])) {
                if(spazi) {
                    stringArray[i] = Character.toUpperCase(stringArray[i]);
                    spazi = false;
                }
            }
            else
                spazi = true;
        nome = String.valueOf(stringArray);

        // Capitalizzazione del cognome
        cognome = cognome.toLowerCase();
        stringArray = cognome.toCharArray();
        spazi = true;
        for (int i = 0; i < stringArray.length; i++)
            if(Character.isLetter(stringArray[i])) {
                if(spazi) {
                    stringArray[i] = Character.toUpperCase(stringArray[i]);
                    spazi = false;
                }
            }
            else
                spazi = true;
        cognome = String.valueOf(stringArray);

        String isMaggiorenneString = null;
        if (eta >= 18) // Controllo dell'età
            isMaggiorenneString = "è maggiorenne";
        else
            isMaggiorenneString = "non è maggiorenne";

        // Verifica se la data di nascita inserita sia il giorno del compleanno confrontata con la data odierna
        if (dataNascita.toLocalDate().getDayOfMonth() == LocalDate.now().getDayOfMonth() &&
                dataNascita.toLocalDate().getMonthValue() == LocalDate.now().getMonthValue())
            return "Buon compleanno " + nome + " " + cognome + "!";

        return nome + " " + cognome + " " + isMaggiorenneString + "!";
    }
}