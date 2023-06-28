package org.ITSS.Homework_3;

public class IvaProdotto {

    private String nome;
    private TipoProdotto tipo;
    private float prezzoNetto;

    public IvaProdotto(String nome, TipoProdotto tipo, float prezzoNetto) {
        this.nome = nome;
        this.tipo = tipo;
        this.prezzoNetto = setPrezzoNetto(prezzoNetto);
    }

    public float getIva() {
        if (tipo.equals(TipoProdotto.PANE) || tipo.equals(TipoProdotto.PASTA) || tipo.equals(TipoProdotto.RISO) ||
                tipo.equals(TipoProdotto.FRUTTA) || tipo.equals(TipoProdotto.VERDURA) || tipo.equals(TipoProdotto.CARNE) ||
                tipo.equals(TipoProdotto.PESCE) || tipo.equals(TipoProdotto.UOVA) || tipo.equals(TipoProdotto.FARMACO) ||
                tipo.equals(TipoProdotto.LIBRO) || tipo.equals(TipoProdotto.GIORNALE) || tipo.equals(TipoProdotto.RIVISTA) ||
                tipo.equals(TipoProdotto.SANITA) || tipo.equals(TipoProdotto.SERVIZI_EDUCATIVI))
            return 0.0f;
        else
            return prezzoNetto * 0.22f;
    }

    public float getPrezzoNetto() {
        return prezzoNetto;
    }

    public float setPrezzoNetto(float prezzoNetto) {
        if (prezzoNetto <= 0)
            throw new IllegalArgumentException();
        return prezzoNetto;
    }

}



