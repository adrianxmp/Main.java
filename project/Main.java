package project;

import java.util.*;

public class Main {
    public static HashMap<String, HashMap<String, String[]>> Year = new HashMap<String, HashMap<String, String[]>>();
    public static Scanner input = new Scanner(System.in);

    /**
     * @param newYear the new year to be added, should be 4-digit positive integer
     * @author Robert Engel, T03
     * This function adds a new HashMap representing a new year to be added, it will NOT add a new value if the
     * year already exists (i.e. the key already exists)
     */
    public static void addYear(int newYear) {
        if (Year.containsKey(Integer.toString(newYear)) == true) {
            System.out.println("project.data.Year already Exists! project.data.Year Not Added");
        } else {
            HashMap<String, String[]> addYear = new HashMap<String, String[]>();
            Year.put(Integer.toString(newYear), addYear);
        }
    }

    /**
     * @param checkYear the year being added to, the function will do nothing if the given year is not a key
     *                  within the project.data.Year HashMap
     * @param gameData  the Data being added to the game, should be a String[] of length 10, with special values
     *                  for each String, showing, in order
     *                  Home Team
     *                  Away Team
     *                  Home Team Fouls
     *                  Away Team Fouls
     *                  Home Team Shots
     *                  Away Team Shots
     *                  Home Team Goals
     *                  Away Team Goals
     *                  Winner
     *                  Date
     * @author Robert Engel, T03, Feb 21 2022
     * This function adds a new game to a specific project.data.Year HashMap, along with the data for the game
     */
    public static void addGame(int checkYear, String[] gameData) {
        if (Year.containsKey(Integer.toString(checkYear)) == true) {
            String gameKey = gameData[0] + " vs. " + gameData[1] + " on " + gameData[9];
            Year.get(Integer.toString(checkYear)).put(gameKey, gameData);

        } else {
            System.out.println("Specified project.data.Year does not Exist!");
        }

    }

    /**
     * @param checkYear the year within the game which is being retrieved, should be a 4-digit positive int
     * @param checkGame the game name which is being retrieved, should be along the lines of "Home vs. Away on Date"
     * @return A String of project.data.Game Data, see addGame for the specifics
     * @author Robert Engel, T03, Feb 21 2022
     * This function returns the data of a specific game as a String, for easier access
     */
    public static String[] getGameData(int checkYear, String checkGame) {
        if (Year.containsKey(Integer.toString(checkYear)) == true) {
            if (Year.get(Integer.toString(checkYear)).containsKey(checkGame) == true) {
                return Year.get(Integer.toString(checkYear)).get(checkGame);
            }
        }
        System.out.println("Failed retrieval, game or year does not exist!");
        return null;
    }





    /**
     * This function returns the total shots of each team in a particular game
     *
     * @param gameYear    project.data.Year of the game that the user wants to see the total shots
     * @param gameChecker project.data.Game name that the user want to see the total shots. eg "Home vs Away on Date"
     * @return Returns an integer of total shots of each team in a game
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static int totalShots(int gameYear, String gameChecker) {
        String[] homeShots;
        String[] awayShots;
        // Using the getGameData function to get the shots data
        homeShots = getGameData(gameYear, gameChecker);
        awayShots = getGameData(gameYear, gameChecker);
        // Using conditional to make sure home and away shots are not equals to null
        if (homeShots != null && awayShots != null) {
            // Assigning the index of shots and adding it to a variable, then returning it
            int shotsTotal = Integer.parseInt(homeShots[4]) + Integer.parseInt(awayShots[5]);
            return shotsTotal;
        } else {
            System.out.println("Error Occurred! project.data.Game Not Found!");
            return 0;
        }
    }

    /**
     * This function returns the total fouls of each team in a particular game
     *
     * @param gameYear    project.data.Year of the game that the user wants to see the total fouls
     * @param gameChecker project.data.Game name that the user want to see the total fouls
     * @return Returns an integer of the total fouls of each team in game
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static int totalFouls(int gameYear, String gameChecker) {
        // Using the getGameData function to get the foul data
        String[] homeFouls = getGameData(gameYear, gameChecker);
        String[] awayFouls = getGameData(gameYear, gameChecker);
        // Using conditional to make sure home and away fouls are not equals to null
        if (homeFouls != null && awayFouls != null) {
            // Assigning the index of fouls and adding it to a variable, then returning it
            int foulsTotal = Integer.parseInt(homeFouls[2]) + Integer.parseInt(homeFouls[3]);
            return foulsTotal;
        } else {
            System.out.println("Error Occurred! project.data.Game Not Found!");
            return 0;
        }
    }

    /**
     * This function displays every year in the database
     *
     * @return Returns every year in the database in a form of key set
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static Set<String> allYears() {
        // Returns all the year in the database
        return Year.keySet();
    }

    /**
     * This function displays every game in a year
     *
     * @param gameYear project.data.Year that the user is looking for
     * @return Returns every game in a year
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static Set<String> allGameYears(String gameYear) {
        // Returns every game in a year
        return Year.get(gameYear).keySet();
    }

    /**
     * This function returns all the games that was in the database
     *
     * @return Returns all the year of the game which contains all the games ever played
     * @author Adrian Ponce, Feb 25, 2022, T03
     */
    public static List<String> allGamesEverPlayed() {
        ArrayList<String> games = new ArrayList<String>();
        // Looping through the hashmap to return every game ever played and adding it to an arraylist and returning it
        for (Map.Entry<String, HashMap<String, String[]>> entry : Year.entrySet()) {
            games.add(String.valueOf(entry.getValue().keySet()));
        }
        return games;
    }

    /**
     * This function loops through all the games and returns the top 5 games that has most team fouls
     *
     * @return Returns the top 5 fouls in a list of string
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static List<String> topTeamFouls() {
        ArrayList<String> fouls = new ArrayList<String>();
        // Looping through the outer hashmap
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            // Looping through the inner hashmap to access its value
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                // Adding the value of fouls from the inner Hashmap to an arraylist
                fouls.add(inner.getValue()[2]);
                fouls.add(inner.getValue()[3]);
            }
        }
        // Sorting the values
        Collections.sort(fouls, Collections.reverseOrder());
        // Slicing the top 5 value of fouls from a descending order and returning it
        List<String> top5fouls = fouls.subList(0, 5);
        return top5fouls;
    }

    /**
     * This function loops through all the games and returns the top 5 games that has most team shots
     *
     * @return Returns the top 5 team shots in a list of string
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static List<String> topTeamShots() {
        ArrayList<String> shots = new ArrayList<String>();
        // Looping through the outer hashmap
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            // Looping through the inner hashmap to access its value
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                // Adding the value of shots from the inner Hashmap to an arraylist
                shots.add(inner.getValue()[4]);
                shots.add(inner.getValue()[5]);
            }
        }
        // Sorting the values
        Collections.sort(shots, Collections.reverseOrder());
        // Slicing the top 5 value of shots from a descending order and returning it
        List<String> top5shots = shots.subList(0, 5);
        return top5shots;
    }

    /**
     * This function loops through all the games and returns the top 5 games that has most team goals
     *
     * @return Returns the top 5 team goals in a list of string
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static List<String> topTeamGoals() {
        ArrayList<String> goals = new ArrayList<String>();
        // Looping through the outer hashmap
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            // Looping through the inner hashmap to access the goals value
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                // Adding the value of goals from the inner Hashmap to an arraylist
                goals.add(inner.getValue()[6]);
                goals.add(inner.getValue()[7]);
            }
        }
        // Sorting the goals values
        Collections.sort(goals, Collections.reverseOrder());
        // Slicing the top 5 value of goals from a descending order and returning it
        List<String> top5goals = goals.subList(0, 5);
        return top5goals;
    }

    /**
     * This function returns the tally of the games that ended up as a tie game
     *
     * @return Returns the tally of the games that is a tie game
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static int gamesWithATie() {
        ArrayList<String> games = new ArrayList<String>();
        // Declaring an integer variable to keep track of the tie game
        int tieGame = 0;
        // Looping through the outer Hashmap
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            // Looping through the inner Hashmap to access the winner value
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                // Adding it to an arraylist
                games.add(inner.getValue()[8]);
            }
        }
        // Looping through the arraylist of winners data
        for (int i = 0; i < games.size(); i++) {
            // Conditional to check if there's a tie game and adding 1 to tally if there is and returning it
            if (Objects.equals(games.get(i), "Tie")) {
                tieGame++;
            }
        }
        return tieGame;
    }

    /**
     * Not much here, just the menu program call
     */
    public static void main(String[] args) {
        mainMenu();
    }
}