package org.ITSS.Homework_1;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.ITSS.Homework_1.MainClassH1.isMaggiorennePhrase;
import static org.junit.jupiter.api.Assertions.*;

class MainClassH1Test {

    // SPECIFICATION-BASED TEST
    @Test
    public void nomeCognomeNullEmpty() { // a. Casi eccezionali di nome e cognome
        assertEquals(
                isMaggiorennePhrase(null, null, 11, Date.valueOf(LocalDate.parse("2012-05-05"))),
                "Nome o cognome null"); //T1
        assertEquals(
                isMaggiorennePhrase("", "", 11, Date.valueOf(LocalDate.parse("2012-05-05"))),
                "Nome e/o cognome vuoto"); //T2
    }

    @Test
    public void boundaryCasesEta() { // b. Casi boundary età
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", -11, Date.valueOf(LocalDate.parse("2012-05-05"))),
                "Età minore di zero"); //T3
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 21, Date.valueOf(LocalDate.parse("2001-11-14"))),
                "Mario Rossi è maggiorenne!"); //T4
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 15, Date.valueOf(LocalDate.parse("2007-11-14"))),
                "Mario Rossi non è maggiorenne!"); //T5
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 17, Date.valueOf(LocalDate.parse("2005-11-14"))),
                "Mario Rossi non è maggiorenne!"); //T6
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 18, Date.valueOf(LocalDate.parse("2004-11-14"))),
                "Mario Rossi è maggiorenne!"); //T7
    }

    @Test
    public void capoletteraNomeCognomeMinuscolaMaiuscola() { // c. Casi capolettera nome e cognome
        assertEquals(
                isMaggiorennePhrase("mario", "rossi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Rossi è maggiorenne!"); //T8
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Rossi è maggiorenne!"); //T9
    }

    @Test
    public void nomeCognomeManyWords() { // d. Casi con più parole nome e cognome
        assertEquals(
                isMaggiorennePhrase("Mario Stefano Violi", "Rossi Verdi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Stefano Violi Rossi Verdi è maggiorenne!"); //T10
    }

    @Test
    public void nomeCognomeOnlyOneLetterMinuscolaMaiuscola() { // e. Casi con lettere maiuscole e minuscole di nome e cognome
        assertEquals(
                isMaggiorennePhrase("maRio", "roSsi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Rossi è maggiorenne!"); //T11
        assertEquals(
                isMaggiorennePhrase("MArIO", "ROsSI", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Rossi è maggiorenne!"); //T12
    }

    @Test
    public void lenNomeCognome() { // f. Casi con differenti lunghezze di nome e cognome
        assertEquals(
                isMaggiorennePhrase("Mario", "Marroni", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Nome minore del cognome"); //T13
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Rossi è maggiorenne!"); //T14
        assertEquals(
                isMaggiorennePhrase("Mario", "Cosi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Cosi è maggiorenne!"); //T15
    }

    @Test
    public void nomeEqualOrNotEqualCognome() { // g. Casi di confronto tra nome e cognome
        assertEquals(
                isMaggiorennePhrase("Mario", "Mario", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Nome e cognome sono uguali"); //T16
        assertEquals(
                isMaggiorennePhrase("Vittorio", "Rossi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Vittorio Rossi è maggiorenne!"); //T17
    }

    @Test
    public void nomeCognomeLenComparisonWithManyWords() { // h. Casi di confronto di lunghezza tra nome e cognome con più stringhe
        assertEquals(
                isMaggiorennePhrase("Mario Violi", "Rossi Marroni", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Nome minore del cognome"); //T18
        assertEquals(
                isMaggiorennePhrase("Mario Violi", "Rossi Verdi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Violi Rossi Verdi è maggiorenne!"); //T19
        assertEquals(
                isMaggiorennePhrase("Mario Stefano", "Rossi Verdi", 21, Date.valueOf(LocalDate.parse("2001-07-26"))),
                "Mario Stefano Rossi Verdi è maggiorenne!"); //T20
    }

    @Test
    public void comparisonDataNascitaAndEta() { // i. Casi di conforto tra data di nascita ed età
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 15, Date.valueOf(LocalDate.parse("1975-02-07"))),
                "Età non coincide con la data di nascita 48"); //T21
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 48, Date.valueOf(LocalDate.parse("1975-02-07"))),
                "Mario Rossi è maggiorenne!"); //T22
    }

    @Test
    public void etaEqualToZeroAndPeriod() { // j. Casi tra data di nascita e età è uguale a zero
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 0, Date.valueOf(LocalDate.parse("2030-07-07"))),
                "Data nascita maggiore della data odierna"); //T23
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 0, Date.valueOf(LocalDate.now())),
                "Buon compleanno Mario Rossi!"); //T24
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 0, Date.valueOf(LocalDate.parse("2020-07-07"))),
                "Età non coincide con la data di nascita 2"); //T25
    }

    @Test
    public void etaGreaterThenZeroAndPeriod() { // k. Casi tra data di nascita e età è maggiore di zero
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 10, Date.valueOf(LocalDate.parse("2018-02-07"))),
                "Età non coincide con la data di nascita 5"); //T26
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 10, Date.valueOf(LocalDate.parse("2013-02-07"))),
                "Mario Rossi non è maggiorenne!"); //T27
        assertEquals(
                isMaggiorennePhrase("Mario", "Rossi", 10, Date.valueOf(LocalDate.parse("2010-02-07"))),
                "Età non coincide con la data di nascita 13"); //T28
    }

    // CASI DI TEST AGGIUNTIVI
    @Test
    public void nomeCognomeWithNumbersAndSymbols() {
        assertEquals(
                isMaggiorennePhrase("Mar10", "Ross1", 11, Date.valueOf(LocalDate.parse("2012-05-05"))),
                "Nome o cognome non valido"); //P1
        assertEquals(
                isMaggiorennePhrase("M@rio", "R0$$i", 11, Date.valueOf(LocalDate.parse("2012-05-05"))),
                "Nome o cognome non valido"); //P2
    }

}