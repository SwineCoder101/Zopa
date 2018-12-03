import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuoteBuilder {

    protected double requestedAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;
    protected static List<Lender> listOfLenders;
    private final static int duration= 36;
    private final static double defaultRate= 0.07;


    public double getRate(){return rate;}
    public double getMonthlyRepayment(){return monthlyRepayment;}
    public double getTotalRepayment(){return totalRepayment;}


    QuoteBuilder(){
        this.requestedAmount=0;
        listOfLenders = new ArrayList<>();
    }


    QuoteBuilder(List<Lender> listOfLenders, Double requestedAmount){
        this.listOfLenders = listOfLenders;
        this.requestedAmount=requestedAmount;
        buildQuote();
    }


    private void calculateBestRate() {

        try {
            Double lowestRate = listOfLenders.stream()
                  .filter(lender -> lender.getAvailableAmount() >= requestedAmount)
                      .map(lender -> lender.getRate())
                    .sorted(Comparator.naturalOrder()).limit(1)
                    .collect(Collectors.toList()).get(0);
            //rate = round(lowestRate.get(0),1);
            rate = lowestRate;

            System.out.println("break");


        } catch(IndexOutOfBoundsException indexException){
            rate = defaultRate;
        }

    }

    private void calculateMonthlyRepayment(){
        double ratePerPeriod = Math.pow(rate + 1 ,(1.0/12.0)) - 1;
        monthlyRepayment=(ratePerPeriod*requestedAmount)/(1 - Math.pow((1 + ratePerPeriod),-36));

        monthlyRepayment = round (monthlyRepayment ,5);

    }

    private void calculateTotalPayment(){
        totalRepayment = monthlyRepayment * duration;
        totalRepayment = round (totalRepayment ,5);
    }

    private void buildQuote(){
        calculateBestRate();
        calculateMonthlyRepayment();
        calculateTotalPayment();
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public void printQuote(){
        System.out.println("Requested amount: " + requestedAmount);
        System.out.printf("Rate: %.1f",rate * 100);
        System.out.print("% \n");
        System.out.printf("Monthly repayment: %.2f \n",monthlyRepayment);
        System.out.printf("Total repayment: %.2f \n",totalRepayment);
    }
}
