import org.junit.Before;
import org.junit.Test;

public class UserInputCheckerTest {

    private MarketCsvReader marketCsvReader;

    /*
    * The test has been left incomplete because the exmaple market.csv contains lenders outside the required lending amount
    *
    * */


    @Before
    public void initializeQuote(){
        marketCsvReader = new MarketCsvReader(TestHelper.VALID_FILE_PATH);
    }

    //@Test(expected = IndexOutOfBoundsException.class)
    public void shouldOnlyAllow100Increments(){
        //Given an amount not divisible by 100
        QuoteBuilder exampleQuoteBuilder = new QuoteBuilder (marketCsvReader.getListOfLenders(),60.0);
        //When

        //Then
    }

    @Test
    public void shouldBeWithinBounds(){
        //Given
        //When
        //Then
    }

}
