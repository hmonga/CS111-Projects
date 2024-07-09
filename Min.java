public class Min {
    public static int min(int[] array){
        int small = 0; 
        for(int i = 0; i < array.length; i++){
        small = Math.min(array[i], array[i+1]);
        }
        return small; 
    }
    public static void main(String[] args){
            // Write code here
            int[] arr = new int[(args.length)];
            System.out.println(min(arr));
        }
    }