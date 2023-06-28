package org.ITSS.Homework_3;

import net.jqwik.api.*;
import net.jqwik.api.constraints.FloatRange;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class IvaProdottoTest {

    private static int cntExceptionGen = 0;
    @Property(tries = 40)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void invalidSetPrezzoNettoTest(
            @ForAll
            @FloatRange(min = -100.0f, max = 0, maxIncluded = true)
            float prezzoNetto) {

        assertThrows(IllegalArgumentException.class, () -> {
            new IvaProdotto("Product", TipoProdotto.ALTRO, prezzoNetto);
        });
        Statistics.label("Count prezzi netti non valido").collect(prezzoNetto);
    }

    @Property(tries = 40)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void passSetPrezzoNettoTest(
            @ForAll RoundingMode mode,
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float prezzoNetto) {

        IvaProdotto ivaProdotto = new IvaProdotto("Product", TipoProdotto.ALTRO, prezzoNetto);
        assertEquals(ivaProdotto.getPrezzoNetto(), prezzoNetto);

        float result = ivaProdotto.getPrezzoNetto();
        Statistics.label("Prezzi netti accettati").collect(result);
    }

    private static final int LEN_TIPO_PRODOTTO_ENUM = 28;
    private static final int LEN_TIPO_PRODOTTO_NO_IVA_ENUM = 14;
    private static final int LEN_TIPO_PRODOTTO_IVA_ENUM = LEN_TIPO_PRODOTTO_ENUM - LEN_TIPO_PRODOTTO_NO_IVA_ENUM;

    @Property(tries = LEN_TIPO_PRODOTTO_NO_IVA_ENUM)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void nullGetIvaTest(
            @ForAll
            @IntRange(min = 0, max = LEN_TIPO_PRODOTTO_NO_IVA_ENUM - 1)
            int randomTipoProdotto,
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float randomPrezzoNetto) {

        TipoProdotto tipoProdotto= TipoProdotto.class.getEnumConstants()[randomTipoProdotto];
        IvaProdotto ivaProdotto = new IvaProdotto("Product", tipoProdotto, randomPrezzoNetto);
        assertEquals(ivaProdotto.getIva(), 0);

        Statistics.label("Tipo prodotti senza iva").collect(tipoProdotto);
    }

    @Property(tries = LEN_TIPO_PRODOTTO_IVA_ENUM)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void notNullGetIvaTest(
            @ForAll
            @IntRange(min = LEN_TIPO_PRODOTTO_NO_IVA_ENUM, max = LEN_TIPO_PRODOTTO_ENUM - 1)
            int randomTipoProdotto,
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float randomPrezzoNetto) {

        TipoProdotto tipoProdotto= TipoProdotto.class.getEnumConstants()[randomTipoProdotto];
        IvaProdotto ivaProdotto = new IvaProdotto("Product",  tipoProdotto, randomPrezzoNetto);
        assertEquals(ivaProdotto.getIva(), randomPrezzoNetto * 0.22f);

        float result = ivaProdotto.getPrezzoNetto();
        Statistics.label("Tipo prodotti con iva").collect(tipoProdotto);
    }

}
