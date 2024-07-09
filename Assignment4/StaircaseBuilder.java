/*
 * Write your program inside the main method to build
 * a staicase in a 2D array of characters according
 * to the assignment description
 *
 * To compile:
 *        javac StaircaseBuilder.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class StaircaseBuilder{
    public static void main(String[] args)
     {
        int d = Integer.parseInt(args[0]);
        int bricks = Integer.parseInt(args[1]);

        char[][] stairs = new char[d][d];
        //fills entire array with a space
        for(int p = 0; p < stairs.length; p++)
        {
            for(int k = 0; k < stairs[p].length; k++)
            {
                stairs[p][k] = ' ';
            }
        }
    int counter = 1; 
    int column = 0; 
        for(int col = 0; col <= d - 1; col++)
        {
            for(int row = d - 1; row >= 0; row--)
            {
                if(column < counter && bricks > 0)
                {
                    stairs[col][row] = 'X';
                    bricks--;
                }
                column++;
            }
            counter++;
            column = 0; 
        }

        //print array
         for(int p = 0; p < stairs.length; p++)
         {
            for(int k = 0; k < stairs[p].length; k++)
            {
                System.out.print(stairs[k][p]);
            }
            System.out.println();
        }
        System.out.println("Bricks Remaining: " + bricks);
    }
}