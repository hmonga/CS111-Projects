import java.awt.Color;

// import edu.princeton.cs.algs4.StdDraw;

/*
 *
 * Plots a Sierpinski Square of order n to standard drawing.
 *
 * Compilation:  javac SierpinskiSquare.java
 * Execution:    java SierpinskiSquare 3
 *
 * @author Jeremy Hui
 */
public class SierpinskiSquare {
   
    /**
     * Calculates half the length of the diagonal of a square of
     * a specified length.
     *
     * half length = length / square root of length
     *
     * @param length the side length of the square
     * @return the half diagonal length
     */
    public static double halfDiagLength(double length) {
        // WRITE YOUR CODE HERE
        return length / Math.sqrt(2);
    }

    /**
     * 1. Sets the pen color to be black.
     *    - Use StdDraw.setPenColor(Color.black);
     *
     * 2. Draws a filled polygon at the four points at a distance
     *    of diagHeight(length) from the center (0.5, 0.5).
     *    - Uset StdDraw.filledPolygon(x, y) where x and y are double[] with x and y coordinates.
     * @param length the side length of the square.
     */
    public static void drawDarkSquare(double length) {

        double[] x = {0.5, 0.5 - halfDiagLength(length) , 0.5, 0.5 + halfDiagLength(length)};
        double[] y = {0.5 + halfDiagLength(length), 0.5, 0.5 - halfDiagLength(length), 0.5};
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledPolygon(x, y);
           
           
    }
    
    
    

    /**
     * 1. Sets the pen color to be white.
     *    - Use StdDraw.setPenColor(Color.white);
     *
     * 2. Draws a filled square at the center of a specified length.
     *    - Use StdDraw.filledSquare(x, y, r) to draw a square of side length 2r centered at (x,y)
     *
     * @param length the side length of the square
     */
    public static void drawLightSquare(double length) {
        // WRITE YOUR CODE HEREß
        StdDraw.setPenColor(Color.white);
        double x = length / 2.0; 
        StdDraw.filledSquare(0.5, 0.5, x);
        System.out.print("L");
    }

    /**
     * Draws a Sierpinski square of order n, such that the largest filled
     * square fits in a screen of size 1 x 1, alternating between a dark
     * square and light square (starting with a dark square).
     * @param curr the current order
     * @param n the highest order to draw
     * @param length the side length of the square
     */
    public static void sierpinski(int curr, int n, double length) {
	// WRITE YOUR CODE HERE
    if(curr > n)
    {
    return;
    }

    if(curr % 2 == 0 )
    {
    drawDarkSquare(length);
    }
    else
    {
    drawLightSquare(length);
    }
    double ll = length / Math.sqrt(2.0);
    sierpinski(curr + 1, n, ll);

}   

        



    /**
     * Takes an integer command-line argument n,
     * and draws a Sierpinski square of order n in a 1 x 1 canvas.
     *
     * This method is called by Autolab. ASSUME n >= 0
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
	// WRITE YOUR CODE HERE
        int n = Integer.parseInt(args[0]);
       sierpinski(0 , n , halfDiagLength(1)); 
    }

}