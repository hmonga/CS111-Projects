public class returnArray{ 
    public static double[] create(int n){
        double[] a = new double[n]; 
        for(int i = 0; i < a.length; i++){
            a[i] = i;
        }
        return a; 
    }
    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        double[] createdArray = create(length);
        for(int i = 0; i < createdArray.length; i++)
        {
        System.out.print(createdArray[i] + " ");
        }
    }
}