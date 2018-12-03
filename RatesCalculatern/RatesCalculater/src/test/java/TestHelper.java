
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import org.junit.Test;


public class TestHelper {



    private static final String DUMMMY_FILE="dummyMarket.txt";
    protected static final String VALID_FILE_PATH="market.csv";
    private static final String INVALID_FILE_PATH="myfile1.csv";


    @SuppressWarnings( "unchecked" )

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    private PrintStream givenDummyFile(){
        try {
            PrintStream fileStream = new PrintStream(new File(DUMMMY_FILE));
            fileStream.println("Lender,Rate,Available");
            return(fileStream);
        }
        catch(IOException io){
            io.printStackTrace();
        }
        return(null);
    }


    public void clearDummyFile(PrintStream fileStream){
        fileStream.flush();
        fileStream.close();
        try {
            Files.deleteIfExists(Paths.get(DUMMMY_FILE));
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public void givenMarketCsvReaderFromDummyFileWithInvalidContent(String invalidString){
        PrintStream fileStream = givenDummyFile();
        fileStream.println(invalidString);
        new MarketCsvReader(DUMMMY_FILE);
    }

    public MarketCsvReader givenMarketFileWithValidFilePath(){
        return(new MarketCsvReader(VALID_FILE_PATH));
    }

    public MarketCsvReader givenMarketFileWithInvalidFilePath(){
        return(new MarketCsvReader(INVALID_FILE_PATH));
    }





    @Test( timeout = 250 )
        public void test() throws Exception {
            captureOut();

            // Run whatever code you're testing

            String theOutput = getOut();

            // Compare what you expect with theOutput

        }

        /**
         * Turns on stdOut output capture
         */
        private void captureOut() {
            System.setOut( new PrintStream( outContent ) );
        }

        /**
         * Turns on stdErr output capture
         */
        public void captureErr() {
            System.setErr( new PrintStream( errContent ) );
        }

        /**
         * Turns off stdOut capture and returns the contents
         * that have been captured
         *
         * @return
         */
        public String getOut() {
            System.setOut( new PrintStream( new FileOutputStream( FileDescriptor.out ) ) );
            return outContent.toString().replaceAll( "\r", "" );

        }

        /**
         * Turns off stdErr capture and returns the contents
         * that have been captured
         *
         * @return
         */
        public String getErr() {
            System.setErr( new PrintStream( new FileOutputStream( FileDescriptor.out ) ) );
            return errContent.toString().replaceAll( "\r", "" );
        }
}
