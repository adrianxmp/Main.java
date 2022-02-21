import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static HashMap<String, HashMap> Year = new HashMap<String, HashMap>();
    /**
     * @author Robert Engel, T03
     * Feb 21, 2022
     * This function adds a new HashMap representing a new year to be added, it will NOT add a new value if the
     * year already exists (i.e. the key already exists)
     * @param newYear the new year to be added, should be 4-digit positive integer
     */
    public static void addYear(int newYear){
        if (Year.containsKey(newYear) == true){
            System.out.println("Year already Exists! Year Not Added");
        }
        else{
            HashMap<String, String[]> addYear = new HashMap<String, String[]>();
            Year.put(Integer.toString(newYear), addYear);
        }
    }
    public static void addGame(int checkyear, String[] gameData){

    }
    public static void main(String[] args) {

    }
}
