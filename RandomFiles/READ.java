

public class READ{
    public static void main(String[] args) {
         int a = Integer.parseInt(args[0]); // way to get input from user. input is entered when typing java Read %i %i. 
        int b = Integer.parseInt(args[1]); // 0 or 1 are index numbers. the numbers entered can be accessed. 
        int sum = a + b; 
        int prod = a * b; 
        int quot = a / b; 
        int rem = a % b; 
        System.out.println(sum);
        System.out.println(prod);
        System.out.println(quot);
        System.out.println(rem);
        

    }
}