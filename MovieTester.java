public class MovieTester {
     
    public static void main(String[] args) {
        Movie movie1 = new Movie("Back to the Future", "PG-13", "Sci-Fi", 1.5);
        Movie movie2 = new Movie("The Dark Knight", "PG-13", "Action", 2.2);
        Movie movie3 = new Movie("Avengers", "G", "Action", 2.6);
        Movie movie4 = new Movie("Pulp Fiction", "R", "Comedy", 1.7);
        Movie movie5 = new Movie("3 Idiots", "PG-13", "Comedy", 3.1);
        //Movie[] allMovies = new Movie[5]; another way to write it
        Movie[] allMovies = {movie1, movie2, movie3, movie4, movie5};
        for(int i = 0; i < allMovies.length; i++){
            if(allMovies[i].ageCheck(13) == true){
            System.out.println(allMovies[i]);
            }
        }
    }
}
