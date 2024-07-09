/*
 *
 * Write the Buses program inside the main method
 * according to the assignment description.
 * 
 * To compile:
 *        javac Buses.java
 * To execute:
 *        java Buses 7302
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */

public class Buses {
    public static void main(String[] args) {

        // WRITE YOUR CODE HERE
        int busNum = Integer.parseInt(args[0]);
        int num4 = busNum % 10; 
        int num3 = (busNum / 10) % 10; 
        int num2 = (busNum / 100) % 10; 
        int num1 = (busNum / 1000) % 10; 

        if(busNum < 0){
            System.out.println("ERROR");
        }
        else if((num1 + num2 + num3 + num4) % 2 == 0){
            System.out.println("LX");
        }
        else{
            System.out.println("H");
        }

    }
}
