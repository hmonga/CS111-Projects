import java.util.ArrayList;
import java.util.Arrays;


public class dna2
{


   private Profile[] database;       // Holds all of the profile objects.
   private String[]  STRsOfInterest; // Holds all of the STRs as Strings we are interested in looking for.


   public dna2( String databaseFile, String STRsFile ) {


       /*** DO NOT EDIT ***/
       createDatabaseOfProfiles(databaseFile); // Calls createDatabase method to initialize the database array
       readSTRsOfInterest(STRsFile); // Calls readAllSTRs method to initialize the allSTRs array
   }




   public void createDatabaseOfProfiles ( String filename ) {


       StdIn.setFile(filename); // DO NOT remove this line, keep it as the first line in the method.


       /* WRITE YOUR CODE HERE */
       int p = Integer.parseInt(StdIn.readLine());
       database = new Profile[p];
       for(int i=0; i<p; i++){
          String name = StdIn.readLine();
          String a = StdIn.readLine();
          String b = StdIn.readLine();
          database[i] = new Profile(name, null, null, a, b);
       }
   }


   public void readSTRsOfInterest ( String filename ) {


       StdIn.setFile(filename); // DO NOT remove this line, keep as the first line in the method.


       /* WRITE YOUR CODE HERE */
       int s = Integer.parseInt(StdIn.readLine());
       STRsOfInterest = new String[s];
       for(int i=0; i<s; i++)
       {
           STRsOfInterest[i] = StdIn.readLine();
       }


   }


     public Profile createUnknownProfile ( String filename ) {


       StdIn.setFile(filename); // DO NOT remove this line, keep as the first line in the method.


   /* WRITE YOUR CODE HERE */
       String a = StdIn.readLine();
       String b = StdIn.readLine();


       return new Profile("Unknown", null, null, a, b); // update the return value
   }


    public STR findSTRInSequence ( String sequence, String STR ) {
       int c = 0;
       int h = 0;
       int str = STR.length();
       int seq = sequence.length();
       int forLoop = seq - str;
       if(str>seq)
           return new STR(STR, 0);
       else
       {
           for(int i=0; i <= forLoop; i++)
           {
               if(sequence.substring(i, i+str).equals(STR))
               {
                       c++;
                       i = i + str-1;
                       h = Math.max(c, h);            
               }
               else
                   c = 0;
           }
           return new STR(STR, h); // update the return value
       }
   }


     public void createProfileSTRs ( Profile profile, String[] allSTRs ) {


       /* WRITE YOUR CODE HERE */
       int l = allSTRs.length;
       STR[] a = new STR[l];
       STR[] b = new STR[l];;


       for(int i = 0; i<l; i++)
       {
           a[i] = findSTRInSequence(profile.getSequence1(), allSTRs[i]);
           b[i] = findSTRInSequence(profile.getSequence2(), allSTRs[i]);
       }
       profile.setS1_STRs(a);
       profile.setS2_STRs(b);
   }




   public void createDatabaseSTRs()
   {


       for(int i=0; i < database.length; i++)
           createProfileSTRs(database[i], getSTRsOfInterest());
   }


   public boolean identicalSTRs ( STR[] s1, STR[] s2 ) {


       /* WRITE YOUR CODE HERE */
       if(Arrays.equals(s1, s2))
           return true;


       return false; // update the return value
   }


     public ArrayList<Profile> findMatchingProfiles ( STR[] unknownProfileS1_STRs ) {


       /* WRITE YOUR CODE HERE */
       ArrayList<Profile> arr = new ArrayList<Profile>();
       for(int i=0; i<database.length; i++)
           if(identicalSTRs(database[i].getS1_STRs(), unknownProfileS1_STRs))
               arr.add(database[i]);


       return arr; // update the return value
   }


   public boolean punnetSquare( STR[] firstParent,  STR[] inheritedFromFirstParent,
                                STR[] secondParent, STR[] inheritedFromSecondParent ) {


       /* DO NOT EDIT */


       for ( int i = 0; i < firstParent.length; i++ ) {


           if ( !(firstParent[i].equals(inheritedFromFirstParent[i]) && secondParent[i].equals(inheritedFromSecondParent[i])) ) {
               return false; // Returns false if there is a discrepency
           }
       }
       return true;
   }


       public ArrayList<Profile> findPossibleParents ( STR[] S1_STRs, STR[] S2_STRs ) {


       /* FIX THIS METHOD */


       ArrayList<Profile> possibleParent1 = new ArrayList<>();
       ArrayList<Profile> possibleParent2 = new ArrayList<>();


        for ( int i = 0; i < database.length; i++ ) {


           if (identicalSTRs(database[i].getS1_STRs(), S2_STRs)) {
               possibleParent1.add(database[i]);
           }
           if (identicalSTRs(database[i].getS2_STRs(), S1_STRs)) {
                possibleParent2.add(database[i]);
            }
            if (identicalSTRs(database[i].getS2_STRs(), S2_STRs)) {
                possibleParent1.add(database[i]);
            }
            if (identicalSTRs(database[i].getS1_STRs(), S1_STRs)) {
                possibleParent2.add(database[i]);
            }
       }


       ArrayList<Profile> parentList = new ArrayList<>();


        for ( int p1 = 0; p1 < possibleParent1.size(); p1++ ) {


           for ( int p2 = 0; p2 < possibleParent2.size(); p2++ ) {


               if ( !possibleParent1.get(p1).equals(possibleParent2.get(p2)) ) {


                   if ( punnetSquare(possibleParent2.get(p2).getS1_STRs(), S1_STRs, possibleParent1.get(p1).getS1_STRs(), S2_STRs)) {
                       parentList.add(possibleParent1.get(p1));
                       parentList.add(possibleParent2.get(p2));
                   } else if (punnetSquare(possibleParent2.get(p2).getS1_STRs(), S1_STRs, possibleParent1.get(p1).getS2_STRs(), S2_STRs)) {
                       parentList.add(possibleParent1.get(p1));
                       parentList.add(possibleParent2.get(p2));
                   } else if (punnetSquare(possibleParent2.get(p2).getS2_STRs(), S2_STRs, possibleParent1.get(p1).getS1_STRs(), S1_STRs)) {
                       parentList.add(possibleParent1.get(p1));
                       parentList.add(possibleParent2.get(p2));
                   } else if (punnetSquare(possibleParent2.get(p2).getS2_STRs(), S1_STRs, possibleParent1.get(p1).getS2_STRs(), S2_STRs)) {
                       parentList.add(possibleParent1.get(p1));
                       parentList.add(possibleParent2.get(p2));
                   }
               }
           }
       }
       return parentList;
   }


   public Profile[] getDatabase() {


       /* DO NOT EDIT */


       return database;
   }


     public String[] getSTRsOfInterest() {


       /* DO NOT EDIT */


       return STRsOfInterest;
   }
}

