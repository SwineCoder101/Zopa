public class Lender {
    private String name;
    private double rate;
    private double available;


    public Lender(String name, double rate, double available){
        this.name=name;
        this.rate=rate;
        this.available=available;

    }

    public String getName(){
        return(name);
    }
    public double getRate(){
        return(rate);
    }
    public double getAvailableAmount(){
        return(available);
    }

    public String toString(){
        return(name + "," + rate + "," + available);
    }
}
