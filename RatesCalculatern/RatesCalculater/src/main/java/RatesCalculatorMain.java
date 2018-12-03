import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RatesCalculatorMain {

    public static void main (String args []){
        Double userLoanAmount = Double.parseDouble(args[1]);
        String fileName = args[0];
        MarketCsvReader marketCsvReader = new MarketCsvReader(fileName);
        QuoteBuilder quoteBuilder = new QuoteBuilder (marketCsvReader.getListOfLenders(),userLoanAmount);
        quoteBuilder.printQuote();
    }
}
