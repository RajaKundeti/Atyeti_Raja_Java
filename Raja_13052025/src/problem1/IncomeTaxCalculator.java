package problem1;
public class IncomeTaxCalculator {
    public static double calculateTax(double income){
        if(income <= 250000){
            return 0;
        } else if (income <= 500000) {
            return income+(income*0.05);
        } else if (income <= 1000000) {
            return income+(income*0.1);
        } else {
            return income+(income*0.3);
        }
    }

    public static void main(String[] args) {
        double income = 2535000;
        System.out.println("Payable Tax: "+calculateTax(income));
    }
}
