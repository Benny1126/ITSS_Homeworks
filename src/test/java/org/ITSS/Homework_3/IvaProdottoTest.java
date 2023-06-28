package org.ITSS.Homework_3;

import net.jqwik.api.*;
import net.jqwik.api.constraints.FloatRange;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IvaProdottoTest {

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
    }

    @Property(tries = 40)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void passSetPrezzoNettoTest(
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float prezzoNetto) {
        IvaProdotto ivaProdotto = new IvaProdotto("Product", TipoProdotto.ALTRO, prezzoNetto);
        assertEquals(ivaProdotto.getPrezzoNetto(), prezzoNetto);

        float result = ivaProdotto.getPrezzoNetto();
        Statistics.label("Prezzi Netti Accettati").collect(result);
    }

    private static final int LEN_TIPO_PRODOTTO_ENUM = 28;
    private static final int LEN_TIPO_PRODOTTO_NO_IVA_ENUM = 14;
    private static final int LEN_TIPO_PRODOTTO_IVA_ENUM = LEN_TIPO_PRODOTTO_ENUM - LEN_TIPO_PRODOTTO_NO_IVA_ENUM;

    @Property(tries = LEN_TIPO_PRODOTTO_NO_IVA_ENUM)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void nullGetIvaTest(
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float randomPrezzoNetto) {
        TipoProdotto randomTipoProdotto = getRandomEnumValue(TipoProdotto.class, 0, LEN_TIPO_PRODOTTO_NO_IVA_ENUM - 1);
        IvaProdotto ivaProdotto = new IvaProdotto("Product", randomTipoProdotto, randomPrezzoNetto);
        assertEquals(ivaProdotto.getIva(), 0);

        float result = ivaProdotto.getPrezzoNetto();
        Statistics.label("Prezzi Netti Accettati").collect(result);
    }

    public static <T extends Enum<TipoProdotto>> T getRandomEnumValue(Class<T> clazz, int minIndex, int maxIndex) {
        Random random = new Random();
        int index = random.nextInt(maxIndex) + minIndex;
        return clazz.getEnumConstants()[index];
    }

    @Property(tries = LEN_TIPO_PRODOTTO_IVA_ENUM)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void notNullGetIvaTest(
            @ForAll
            @FloatRange(min = 0, max = 100.0f, maxIncluded = true, minIncluded = false)
            float randomPrezzoNetto) {
        TipoProdotto randomTipoProdotto = getRandomEnumValue(TipoProdotto.class, LEN_TIPO_PRODOTTO_NO_IVA_ENUM, LEN_TIPO_PRODOTTO_IVA_ENUM - 1);
        IvaProdotto ivaProdotto = new IvaProdotto("Product", randomTipoProdotto, randomPrezzoNetto);
        assertEquals(ivaProdotto.getIva(), randomPrezzoNetto * 0.22f);

        float result = ivaProdotto.getPrezzoNetto();
        Statistics.label("Prezzi Netti Accettati").collect(result);
    }

}
