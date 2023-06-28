package org.ITSS.Homework_3;

public enum TipoProdotto {
    // Non viene applcata l'IVA
    PANE, PASTA, RISO, FRUTTA, VERDURA, CARNE,
    PESCE, UOVA, FARMACO, LIBRO, GIORNALE,
    RIVISTA, SANITA, SERVIZI_EDUCATIVI,

    // Viene applicata l'IVA
    ABBIGLIAMENTO, ELETTRONICA, BELLEZZA, GIOCATTOLI,
    DOLCI, SNACK, BEVANDE_ANALCOLICHE, BEVANDE_ALCOLICHE,
    SERVIZI_PROFESSIONALI, TRASPORTI, RISTORAZIONE,
    INTRATTENIMENTO, LUSSO, ALTRO

}