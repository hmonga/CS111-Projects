import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ADD{
    public static void main(String[] args) {
        StdOut.print("Type first Integer: ");
        int x = StdIn.readInt();
        StdOut.print("Type second Integer: ");
        int y = StdIn.readInt();
        int sum = x + y; 
        StdOut.println("Sum is: " + sum);
    }
}