import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static HashMap<String, HashMap<String, String[]>> Year = new HashMap<String, HashMap<String, String[]>>();
    /**
     * @author Robert Engel, T03
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
    /**
     * @author Robert Engel, T03, Feb 21 2022
     * This function adds a new game to a specific Year HashMap, along with the data for the game
     * @param checkYear the year being added to, the function will do nothing if the given year is not a key
     * within the Year HashMap
     * @param gameData the Data being added to the game, should be a String[] of length 10, with special values
     * for each String, showing, in order
     * Home Team
     * Away Team
     * Home Team Fouls
     * Away Team Fouls
     * Home Team Shots
     * Away Team Shots
     * Home Team Goals
     * Away Team Goals
     * Winner
     * Date
     */
    public static void addGame(int checkYear, String[] gameData){
        if( Year.containsKey(Integer.toString(checkYear)) == true){
            String gameKey = gameData[1] + " vs. " + gameData[2] + " on " + gameData[9];
            Year.get(Integer.toString(checkYear)).put(gameKey, gameData);

        }
        else{
            System.out.println("Specified Year does not Exist!");
        }

    }
    /**
     * @author Robert Engel, T03, Feb 21 2022
     * This function returns the data of a specific game as a String, for easier access
     * @param checkYear the year within the game which is being retrieved, should be a 4-digit positive int
     * @param checkGame the game name which is being retrieved, should be along the lines of "Home vs. Away on Date"
     * @return A String of Game Data, see addGame for the specifics
     */
    public static String[] getGameData(int checkYear, String checkGame){
        if (Year.containsKey(Integer.toString(checkYear)) == true){
            if(Year.get(Integer.toString(checkYear)).containsKey(checkGame) == true){
                return Year.get(Integer.toString(checkYear)).get(checkGame);
            }
        }
            System.out.println("Failed retrieval, game or year does not exist!");
            return null;
    }
    public static void main(String[] args) {

    }
}
