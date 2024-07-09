public class interest{ 
    public static void main(String[] args) {
        double principal = 520.0; 
        double rate = 0.035;
        double numberOfYears = 2; 
        int n = 12; 

        double amount = principal * Math.pow((1 + rate/n),(n*numberOfYears));
        System.out.println("The compunt interest after " + numberOfYears + " years is " +  amount + "dollars");
    }
}