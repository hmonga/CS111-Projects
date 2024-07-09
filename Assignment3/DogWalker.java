/*
 *  
 * Write the DogWalker program inside the main method
 * according to the assignment description.
 * 
 * To compile:
 *        javac DogWalker.java
 * To execute:
 *        java DogWalker 5
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 *
 */
public class DogWalker {

    public static void main(String[] args) {

       // WRITE YOUR CODE HERE
		int n = Integer.parseInt(args[0]); 
          int x = 0; 
          int y = 0; 
          double euclidean = 0; 
        for(int i = 0; i <= n; i++){
            double rand = Math.random();
            if(rand < 0.26){
                y++;
                System.out.println("(" + x + "," + y + ")");
            }
            else if(rand < 0.51){
                y--;
                System.out.println("(" + x + "," + y + ")");
            }
            else if (rand < 0.76){
                x++; 
                System.out.println("(" + x + "," + y + ")");
            }
            else{
                x--; 
                System.out.println("(" + x + "," + y + ")");
            }
    }
        euclidean = ((x * x) + (y * y)); 
        System.out.println("Squared Distance = " + euclidean);
}
}
