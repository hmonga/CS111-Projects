import java.util.ArrayList;

/**
 * The StopAndFrisk class represents stop-and-frisk data, provided by
 * the New York Police Department (NYPD), that is used to compare
 * during when the policy was put in place and after the policy ended.
 * 
 * @author Tanvi Yamarthy
 * @author Vidushi Jindal
 */
public class StopAndFrisk {

    /*
     * The ArrayList keeps track of years that are loaded from CSV data file.
     * Each SFYear corresponds to 1 year of SFRecords.
     * Each SFRecord corresponds to one stop and frisk occurrence.
     */
    private ArrayList<SFYear> database;

    /*
     * Constructor creates and initializes the @database array
     * 
     * DO NOT update nor remove this constructor
     */
    public StopAndFrisk() {
        database = new ArrayList<>();
    }

    /*
     * Getter method for the database.
     * *** DO NOT REMOVE nor update this method ****
     */
    public ArrayList<SFYear> getDatabase() {
        return database;
    }

    /**
     * This method reads the records information from an input csv file and
     * populates
     * the database.
     * 
     * Each stop and frisk record is a line in the input csv file.
     * 
     * 1. Open file utilizing StdIn.setFile(csvFile)
     * 2. While the input still contains lines:
     * - Read a record line (see assignment description on how to do this)
     * - Create an object of type SFRecord containing the record information
     * - If the record's year has already is present in the database:
     * - Add the SFRecord to the year's records
     * - If the record's year is not present in the database:
     * - Create a new SFYear
     * - Add the SFRecord to the new SFYear
     * - Add the new SFYear to the database ArrayList
     * 
     * @param csvFile
     */

    public void readFile(String csvFile) {

        // DO NOT remove these two lines
        StdIn.setFile(csvFile); // Opens the file
        StdIn.readLine(); // Reads and discards the header line
        
        while(StdIn.hasNextLine()){
        String[] recordEntries = StdIn.readLine().split(",");
        int year = Integer.parseInt(recordEntries[0]);
        String description = recordEntries[2];
        String gender = recordEntries[52];
        String race = recordEntries[66];
        String location = recordEntries[71];
        boolean arrested = recordEntries[13].equals("Y");
        boolean frisked = recordEntries[16].equals("Y");

        boolean yearPresent = false;

        SFRecord rec = new SFRecord(description, arrested, frisked, gender, race, location);
 
        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == (year)) {
                yearPresent = true;
                sfYear.addRecord(rec);
                break;
            }
        }
        if (yearPresent == false) {
            SFYear newYear = new SFYear(year);
            newYear.addRecord(rec);
            database.add(newYear);
        }
    }
    }

    /**
     * This method returns the stop and frisk records of a given year where
     * the people that was stopped was of the specified race.
     * 
     * @param year we are only interested in the records of year.
     * @param race we are only interested in the records of stops of people of race.
     * @return an ArrayList containing all stop and frisk records for people of the
     *         parameters race and year.
     */

    public ArrayList<SFRecord> populationStopped(int year, String race) {

        // WRITE YOUR CODE HERE
        ArrayList<SFRecord> popStop = new ArrayList<>();

        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year) {
                for (SFRecord sfRecord : sfYear.getRecordsForYear()) {
                    if (sfRecord.getRace().equals(race)) {
                        popStop.add(sfRecord);
                    }
                }
                break;
            }
        }
        return popStop; // update the return value
    }

    /**
     * This method computes the percentage of records where the person was frisked
     * and the
     * percentage of records where the person was arrested.
     * 
     * @param year we are only interested in the records of year.
     * @return the percent of the population that were frisked and the percent that
     *         were arrested.
     */
    public double[] friskedVSArrested(int year) {

        // WRITE YOUR CODE HERE
        int totalRecords = 0;
        double arrest = 0;
        double frisk = 0;
        
        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year) {
                for (SFRecord record : sfYear.getRecordsForYear()) {
                    totalRecords = sfYear.getRecordsForYear().size(); 
                    if (record.getFrisked() == true) {
                        frisk++;
                    }
                    if (record.getArrested() == true) {
                        arrest++;
                    }
                }
                break;
            }
        }
        
        double[] ans = new double[2];
        ans[1] =   (arrest / totalRecords) * 100;
        ans[0] =  (frisk / totalRecords) * 100;
        System.out.println(arrest);
        System.out.println(frisk);
        System.out.println(totalRecords);
        return ans;
        // update the return value
    }

    /**
     * This method keeps track of the fraction of Black females, Black males,
     * White females and White males that were stopped for any reason.
     * Drawing out the exact table helps visualize the gender bias.
     * 
     * @param year we are only interested in the records of year.
     * @return a 2D array of percent of number of White and Black females
     *         versus the number of White and Black males.
     */
    public double[][] genderBias(int year) {

        // WRITE YOUR CODE HERE
       
        double blackMen = 0;
        double blackWomen = 0;
        double whiteMen = 0;
        double whiteWomen = 0;
        double otherB = 0; 
        double otherW = 0; 

        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year) {
                for (SFRecord record : sfYear.getRecordsForYear()) {
                    if (record.getRace().equalsIgnoreCase("B")) {
                        if (record.getGender().equalsIgnoreCase("M")) {
                            blackMen++;
                        }
                        else if(record.getGender().equalsIgnoreCase("F")){
                            blackWomen++; 
                        }
                        else{
                            otherB++;
                        }
                    }
                    if (record.getRace().equalsIgnoreCase("W")) {
                        if(record.getGender().equalsIgnoreCase("M")){
                        whiteMen++;
                        }
                        else if(record.getGender().equalsIgnoreCase("F")){
                            whiteWomen++; 
                        }
                        else{
                            otherW++;
                        }
                    }
                }
                break; 
            }
        }
        
        double totalBlack = blackMen + blackWomen + otherB; 
        double totalWhite = whiteMen + whiteWomen + otherW; 
        double totalFemale = blackWomen + whiteWomen; 
        double totalMale = blackMen + whiteMen; 
        double totalStops = blackMen + blackWomen + whiteMen + whiteWomen + otherB + otherW;

        double[][] bias = new double[2][3]; 
        bias[0][0] = ((blackWomen / totalBlack) * 0.5) * 100; 
        bias[0][1] = ((whiteWomen / totalWhite) * 0.5) * 100; 
        bias[0][2] = (bias[0][0] + bias[0][1]); 
        bias[1][0] = ((blackMen / totalBlack) * 0.5) * 100; 
        bias[1][1] = ((whiteMen / totalWhite) * 0.5) * 100; 
        bias[1][2] = bias[1][0] + bias[1][1];
        return bias; // update the return value
    }

    /**
     * This method checks to see if there has been increase or decrease
     * in a certain crime from year 1 to year 2.
     * 
     * Expect year1 to preceed year2 or be equal.
     * 
     * @param crimeDescription
     * @param year1            first year to compare.
     * @param year2            second year to compare.
     * @return
     */

    public double crimeIncrease(String crimeDescription, int year1, int year2) {

        // WRITE YOUR CODE HERE
        double year1Occur = 0; 
        double year2Occur = 0; 
        double year1Total = 0; 
        double year2Total = 0; 
        double ans = 0; 
        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year1) {
                for (SFRecord record : sfYear.getRecordsForYear()) {
                    year1Total++; 
                    if (record.getDescription().indexOf(crimeDescription) != -1) {
                        year1Occur++;
                    }
                }
                break;
            }
        }

        for (SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year2) {
                for (SFRecord record : sfYear.getRecordsForYear()) {
                    year2Total++; 
                    if (record.getDescription().indexOf(crimeDescription) != -1) {
                        year2Occur++;
                    }
                }
                break;
            }
        }
        System.out.println(year1Occur);
        System.out.println(year2Occur);
        double year1Percent = (year1Occur / year1Total) * 100; 
        double year2Percent = (year2Occur / year2Total) * 100; 
        ans =  year2Percent - year1Percent;
    
       
        return ans;   // update the return value
    }

    /**
     * This method outputs the NYC borough where the most amount of stops
     * occurred in a given year. This method will mainly analyze the five
     * following boroughs in New York City: Brooklyn, Manhattan, Bronx,
     * Queens, and Staten Island.
     * 
     * @param year we are only interested in the records of year.
     * @return the borough with the greatest number of stops
     */
    public String mostCommonBorough(int year) {

        String[] borough = {"Brooklyn", "Manhattan", "Bronx", "Queens", "Staten Island"}; 
        int[] count = new int[5]; 
        // WRITE YOUR CODE HERE
        for(SFYear sfYear : database) {
            if (sfYear.getcurrentYear() == year) {
                for (SFRecord record : sfYear.getRecordsForYear()) {
                    if (record.getLocation().equalsIgnoreCase(borough[0])) {
                        count[0]++;
                    }
                    if (record.getLocation().equalsIgnoreCase(borough[1])) {
                        count[1]++;
                    }
                    if (record.getLocation().equalsIgnoreCase(borough[2])) {
                        count[2]++;
                    }
                    if (record.getLocation().equalsIgnoreCase(borough[3])) {
                        count[3]++;
                    }
                    if (record.getLocation().equalsIgnoreCase(borough[4])) {
                        count[4]++;
                    }
                }
                break;
            }
        }
        int max = count[0]; 
        int maxIndex = 0; 
        for(int i = 1; i < count.length; i++){
            if(count[i] > max){
                max = count[i]; 
                maxIndex = i; 
            }
        }

        return borough[maxIndex]; // update the return value
    }

}
