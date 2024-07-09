/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class BusStop {

    public static void main(String[] args) {

        // WRITE YOUR CODE HERE
        char[] bus = new char[args.length]; 

        for(int i = 0; i < bus.length; i++){
             char c = args[i].charAt(0);
             bus[i] = c;
            //System.out.println(bus[i]);
        }

       int counter = 0; 
       int bestStop = -1; 
       boolean matchFound = false; 
        while(counter != args.length - 1){
            if(bus[args.length - 1] == bus[counter]){
                if(bestStop == - 1 || counter + 1 < bestStop){
                    bestStop = counter + 1; 
                    matchFound = true; 
                }
            }
            counter++; 
         }
         
         if(!matchFound){
            System.out.println("-1");
         }
         if(bestStop != -1){
            System.out.println(bestStop);
         }
    }
}
