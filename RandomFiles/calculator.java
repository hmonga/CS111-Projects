import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class calculator{ 
    public static void main(String[] args) {
        double mult, div, add, sub; 
       System.out.println("Give me a number");
        int num1 = StdIn.readInt(); 
      System.out.println("Give me a second Number");
        int num2 = StdIn.readInt(); 
        System.out.println("What do you want to do with the two numbers?");
        String operation = StdIn.readString();
        if(operation.equals("/") && num2 == 0){
            System.out.println("Cannot divide by 0");
        }
        else if(operation.equals("*")){
            mult = num1 * num2; 
            StdOut.println(num1 + "*" + num2 + " = " + mult);
        }
         else if(operation.equals("+")){
            add = num1 * num2; 
            StdOut.println(num1 + "+" + num2 + " = " + add);
        }
        else if(operation.equals("-")){
            sub = num1 * num2; 
            StdOut.print(num1 + "-" + num2 + " = " + sub);
        }
         else if(operation.equals("/")){
            div = (double)num1 * num2; 
            StdOut.println(num1 + "/" + num2 + " = " + div);
        }
        else{ 
            StdOut.println("Invalid Operator");
        }
    }
}