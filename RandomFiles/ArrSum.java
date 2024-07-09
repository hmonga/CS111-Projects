public class ArrSum{
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},
                        {1,3,5,7},
                        {9,8,7,3},
                        {2,0,2,4}};
    
       
        for(int r = 0; r < arr.length; r++){
            int sum = 0; 
            for(int c = 0; c < arr[r].length; c++){
                sum += arr[r][c];
            }
        System.out.println("sum of elements in row " + r + " is " + sum);
    }
}
}