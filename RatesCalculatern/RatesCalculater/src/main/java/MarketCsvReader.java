import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketCsvReader implements ErrorMessage{

    private List<Lender> listOfLenders;
    private List<String> listOfNames;

    MarketCsvReader(String filePath) {

        listOfLenders = new ArrayList<Lender>();
        listOfNames = new ArrayList<String>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReader(reader);

            csvReader.readAll().stream().skip(1).forEach(
                    lineArray -> listOfLenders.add
                            (new Lender(lineArray[0],Double.parseDouble(lineArray[1]),Double.parseDouble(lineArray[2]))));

            listOfNames = listOfLenders.stream().map(lender -> lender.getName()).collect(Collectors.toList());

            if (listOfNames.contains("")){
                System.out.println(MARKET_CSV_MISSING_NAME + listOfLenders.get(listOfNames.indexOf("")));
                throw new NullPointerException();
            }

        } catch (IOException io) {
            io.printStackTrace();
            System.out.println(FILE_NOT_FOUND);
        } catch (NumberFormatException numEx){
            System.out.println(MARKET_CSV_WRONG_VALUE_TYPE);
            numEx.printStackTrace();
        }
    }


    public List<Lender> getListOfLenders(){
        return(listOfLenders);
    }

}
