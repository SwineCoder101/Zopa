import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarketCsvReaderTest extends TestHelper implements ErrorMessage{

    @Test
    public void shouldHandleFileNotFound(){
        //Given invalid file path, then should throw File not found
        MarketCsvReader readInvalidPathCsvReader = givenMarketFileWithInvalidFilePath();
        assertThat(getOut().contains("NoSuchFileException"), is(false));
    }

    @Test
    public void shouldParseAllLenders() {

        //Given example market file and all lenders are parsed
        MarketCsvReader marketCsvReader = givenMarketFileWithValidFilePath();

        List<String> listOfNames = marketCsvReader.getListOfLenders().stream()
                .map(lender -> lender.getName()).collect(Collectors.toList());

        //Then all names of lenders should be read
        Assert.assertTrue(listOfNames.contains("Bob"));
        Assert.assertTrue(listOfNames.contains("Jane"));
        Assert.assertTrue(listOfNames.contains("Fred"));
        Assert.assertTrue(listOfNames.contains("Mary"));
        Assert.assertTrue(listOfNames.contains("John"));
        Assert.assertTrue(listOfNames.contains("Dave"));
        Assert.assertTrue(listOfNames.contains("Angela"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldHandleFormatWhenMissingName() {
        givenMarketCsvReaderFromDummyFileWithInvalidContent(",0.05,1000");

        //Then
        String stdOutStr = getOut();
        Assert.assertTrue(stdOutStr.contains(",0.05,1000.0"));
    }





}
