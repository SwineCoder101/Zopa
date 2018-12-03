import java.util.InputMismatchException;

public class UserInputChecker extends QuoteBuilder implements ErrorMessage{

    private void checkBounds() throws InputMismatchException
    {
        if (!((requestedAmount > 1000) &&(requestedAmount < 15000))){
            System.out.println(VALUE_OUT_OF_BOUNDS);
            throw new InputMismatchException();
        }
    }

    private void checkIncrement() throws InputMismatchException
    {
        if (Math.floorMod((int)requestedAmount,100) !=0){
            System.out.println(WRONG_INCREMENT);
            throw new InputMismatchException();
        }
    }


}
