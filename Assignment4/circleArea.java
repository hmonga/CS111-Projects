public class circleArea{
    public static int pow(int x, int y){
        int base = x; 
       for(int i = y; i > 1; i--){
        x = base * x; 
       }
        return x; 
    }
    public static double PI(int r){
        double area;
        area = Math.PI * pow(r, 2);
        return area;
    }
    public static void main(String[] args) {
       int n = Integer.parseInt(args[0]); 
       int x = Integer.parseInt(args[1]);
       int y = Integer.parseInt(args[2]);
       System.out.println(pow(x, y));
        System.out.println(PI(n));
    }
}