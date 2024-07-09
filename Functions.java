public class Functions{
    public static double sum(double[] a){
        double sum = 0; 
        for(int i = 0; i < a.length; i++){
             sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        double[] arr = new double[args.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Double.parseDouble(args[i]);
        }
        
        System.out.println(sum(arr));
    }
}