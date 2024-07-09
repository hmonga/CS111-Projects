public class multiply {

    public static int multi(int a, int b){
        if(b == 1){
            return a;
        }
        else{
            return a + multi(a, b - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(multi(2, 3));
    }
    }
   

