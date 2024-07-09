public class exam{
    public static void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp; 
    }
    public static void main(String[] args) {
       int x = Integer.parseInt(args[0]);
       int y = Integer.parseInt(args[1]);
        int[] a = {1,3,7,9};
        swap(a, x, y);
    }
}