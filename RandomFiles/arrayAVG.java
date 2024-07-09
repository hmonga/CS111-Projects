public class arrayAVG{
    public static void main(String[] args) {
        int row; 
        int column; 
        double[][] grades = {
            {56, 78, 67},
            {79, 92, 83},
            {90, 89, 79},
            {51, 67, 84},
        };
        for(row = 0; row < grades.length; row++){
            double sum = 0; 
            for(column = 0; column < grades[row].length; column++){
                sum += grades[row][column];
            }
                 double average = sum / grades[row].length; 
                System.out.println("Exam " + (row + 1)  + " average is " + average);
        }
        }
       
    }
