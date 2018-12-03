import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.round;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class QuoteTest extends TestHelper{


    private MarketCsvReader marketCsvReader;

    @Before
    public void initializeQuote(){
        marketCsvReader = new MarketCsvReader(VALID_FILE_PATH);

    }

    @Test
    public void shouldFindLowestRate(){
        //Given a market when all lenders have enough to lend
        QuoteBuilder exampleQuoteBuilder = new QuoteBuilder (marketCsvReader.getListOfLenders(),60.0);

        //Then lowest rate should be 0.069
        exampleQuoteBuilder.printQuote();
        assertThat(exampleQuoteBuilder.getRate(), is(0.069));
    }

    @Test
    public void shouldDisregardLendersWithAmountsLessThanRequest(){
        //Given a market when some lenders have enough to lend (all but the 60)
        QuoteBuilder exampleQuoteBuilder = new QuoteBuilder (marketCsvReader.getListOfLenders(),500.0);

        //Then lowest rate should be 0.071
        exampleQuoteBuilder.printQuote();
        assertThat(exampleQuoteBuilder.getRate(), is(0.071));

    }

    @Test
    public void shouldCalculateCorrectRateAndMonthlyAndTotalRepayment(){
        //Given example market when user enters 1000
        QuoteBuilder exampleQuoteBuilder = new QuoteBuilder (marketCsvReader.getListOfLenders(),1000.0);

        //Then the calculation for the rate/monthly repayment/total repayment
        exampleQuoteBuilder.printQuote();


        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.CEILING);

        assertEquals(0.07,exampleQuoteBuilder.getRate());
        assertEquals(30.78,Double.parseDouble(df.format(exampleQuoteBuilder.getMonthlyRepayment())));
        assertEquals(1108.04,Double.parseDouble(df.format(exampleQuoteBuilder.getTotalRepayment())));

    }

}
