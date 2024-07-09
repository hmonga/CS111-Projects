public class names{ 
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]); 
        int column = Integer.parseInt(args[1]); 
        int currName = 0; 
        String[] students = new String[row * column];

        for(int i = 0; i < students.length; i++){
            students[i] = args[i+2];
        }
        String[][] classroom = new String[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; i < column; j++){
               classroom[i][j] = students[currName];
               currName++;
               System.out.print(classroom[i][j] + " ");
            }
            System.out.println();
        }

    
    }
}