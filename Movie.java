public class Movie {
    private String title; 
    private int rating;        // 1 to 5 
    private String maturityRating;  // G, PG, PG-13, R
    private String genre; 
    private double runtime; 

    //constructor(s)
    public Movie(String title, String maturityRating, String genre, double runtime){
        this.title = title; 
        this.maturityRating = maturityRating; 
        this.genre = genre; 
        this.runtime = runtime; 
        rating = 0; 
    }
    // operations

    public String getMaturityRating(){
        return maturityRating;
    }

    public int getRating(){
        return rating; 
    }

    public double getRuntime(){
        return runtime; 
    }
        //set rating of a move movie1.setRating(4);
    public void setRating(int rate){
        if(rate < 1 || rate > 5){
            System.out.print("Not a valid rating");
        }
        else{
             rating = rate;
        } 
    }

        //checkAge - take in an age, return true if they can watch 
    public boolean ageCheck(int age){
        //R > 17
        boolean canWatch = false; 
        if(age >= 17 && maturityRating.equals("R")){
            return canWatch; 
        }
        else if(age >= 13 && maturityRating.equals("PG-13")){
            return canWatch; 
        }
        else if(maturityRating.equals("G")){
            return canWatch; 
        }
        else{
            return canWatch; 
        }
    }

    public String toString(){
        //<title> is a <genre> movie and is <runtime> hours long. It has a maturity rating of <maturityRating> and viewer rating of <rating>
       String sentence = title + " is a " + genre + " movie and is " + runtime + " hours long. It has a maturity Rating of " + maturityRating + " and viewer rating of " + rating; 
        return sentence; 
    }
}
