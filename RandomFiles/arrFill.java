public class arrFill{ 
    public static void main(String[] args) {
        int arrSize =  Integer.parseInt(args[1]);
        int val =  Integer.parseInt(args[0]);
        int[] arr = new int[arrSize];
        arr[0] = val; 
        
        for(int j = 1; j < arrSize; j++){
            arr[j] = arr[j - 1] * 2; 
            System.out.println(arr[j]);
        }
      
    }
}