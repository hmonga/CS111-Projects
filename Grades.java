public class Grades{
    public static String letter(double grade){
        if(grade <= 100 && grade >= 90)
            return "A";
        if(grade < 90 && grade >= 80)
            return "B";
        if(grade < 80 && grade >= 70)
            return "C";
        if(grade < 70 && grade >= 60)
            return "D";
        if(grade < 60 && grade >= 0)
            return "F";
        return "Invalid Input";
    }
    public static double GradesII(double exam1, double exam2, double exam3){
        double min = Math.min(exam1, Math.min(exam2, exam3));
        double total = exam1 + exam2 + exam3 -min; 
        return total / 2.0;
    }
    public static void main(String[] args) {
       System.out.println(letter(GradesII(76, 85, 97))); 
    }
}