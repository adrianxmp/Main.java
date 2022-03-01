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
            System.out.println("Year already Exists! Year Not Added");
        } else {
            HashMap<String, String[]> addYear = new HashMap<String, String[]>();
            Year.put(Integer.toString(newYear), addYear);
        }
    }

    /**
     * @param checkYear the year being added to, the function will do nothing if the given year is not a key
     *                  within the Year HashMap
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
     * This function adds a new game to a specific Year HashMap, along with the data for the game
     */
    public static void addGame(int checkYear, String[] gameData) {
        if (Year.containsKey(Integer.toString(checkYear)) == true) {
            String gameKey = gameData[0] + " vs. " + gameData[1] + " on " + gameData[9];
            Year.get(Integer.toString(checkYear)).put(gameKey, gameData);

        } else {
            System.out.println("Specified Year does not Exist!");
        }

    }

    /**
     * @param checkYear the year within the game which is being retrieved, should be a 4-digit positive int
     * @param checkGame the game name which is being retrieved, should be along the lines of "Home vs. Away on Date"
     * @return A String of Game Data, see addGame for the specifics
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

    public static String[] findGame() {
        int choice = 0;
        String sChoice = "";
        System.out.println("Teams have their first letter capitalized, no periods for abbreviations");
        while (sChoice.isEmpty() == true) {
            try {
                System.out.print("Please Input the Home Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true) {
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        String homeTeam = sChoice;
        sChoice = "";
        input.nextLine();
        while (sChoice.isEmpty() == true) {
            try {
                System.out.print("Please Input the Away Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true) {
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.nextLine();
            }
        }
        String awayTeam = sChoice;
        sChoice = "";
        while (choice == 0) {
            try {
                System.out.print("Please Input the year the game was played:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameYear = choice;
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the month the game was played, as a number (1 = January, 2 = February, etc.):");
                choice = input.nextInt();
                if (choice < 1 || choice > 12) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameMonth = choice;
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the day the game was played:");
                choice = input.nextInt();
                if (choice < 1 || choice > 31) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameDay = choice;
        String Date = gameYear + "-" + gameMonth + "-" + gameDay;
        String foundGame = homeTeam + " vs. " + awayTeam + " on " + Date;
        String[] foundGameData = {foundGame, Integer.toString(gameYear)};
        return foundGameData;
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * The main part of the menu system, breaking it up for simplicity of finding specific parts of the menu.
     */
    public static void mainMenu() {
        int choice = 0;
        System.out.println("Welcome to the Premier League Database Main Menu!\nPlease Input a number to choose your action");
        System.out.println("1. Add a new Year\n2. Add a new Game to a Year\n3. General Output Menu\n4. Special Output Menu\n5. Create Test Data\n6. Quit the program");
        while (choice == 0) {
            try {
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 6) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice) {
            case 1:
                yearMenu();
                break;
            case 2:
                gameMenu();
                break;
            case 3:
                generalMenu();
                break;
            case 4:
                specialMenu();
                break;
            case 5:
                TestData();
                mainMenu();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you enter in a new year
     */
    public static void yearMenu() {
        System.out.println("Years are formatted as a 4-digit positive number");
        int choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Year:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        addYear(choice);
        mainMenu();
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you enter in a new game, and all its corresponding data
     */
    public static void gameMenu() {
        int choice = 0;
        String sChoice = "";
        String[] gameData = new String[10];
        System.out.println("Teams have their first letter capitalized, no periods for abbreviations");
        while (sChoice.isEmpty() == true) {
            try {
                System.out.print("Please Input the Home Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true) {
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[0] = sChoice;
        sChoice = "";
        input.nextLine();
        while (sChoice.isEmpty() == true) {
            try {
                System.out.print("Please Input the Away Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true) {
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[1] = sChoice;
        sChoice = "";
        while (choice == 0) {
            try {
                System.out.print("Please Input the Home Team Fouls:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[2] = Integer.toString(choice);
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Away Team Fouls:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[3] = Integer.toString(choice);
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Home Team Shots:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[4] = Integer.toString(choice);
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Away Team Shots:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[5] = Integer.toString(choice);
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Home Team Goals:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[6] = Integer.toString(choice);
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the Away Team Goals:");
                choice = input.nextInt();
                if (choice < 0) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[7] = Integer.toString(choice);
        if (Integer.parseInt(gameData[6]) > Integer.parseInt(gameData[7])) {
            gameData[8] = "Home";
        } else if (Integer.parseInt(gameData[6]) < Integer.parseInt(gameData[7])) {
            gameData[8] = "Away";
        } else if (Integer.parseInt(gameData[6]) == Integer.parseInt(gameData[7])) {
            gameData[8] = "Tie";
        }
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the year the game was played:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameYear = choice;
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the month the game was played, as a number (1 = January, 2 = February, etc.):");
                choice = input.nextInt();
                if (choice < 1 || choice > 12) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameMonth = choice;
        choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input the day the game was played:");
                choice = input.nextInt();
                if (choice < 1 || choice > 31) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameDay = choice;
        String Date = gameYear + "-" + gameMonth + "-" + gameDay;
        gameData[9] = Date;
        addGame(gameYear, gameData);
        mainMenu();
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you ask for general types of input
     */
    public static void generalMenu() {
        System.out.println("Please Input a Number to choose your action");
        System.out.println("1.Print the total number of shots in a game\n2.Print the total number of fouls in a game\n3.Print all years in the database\n4.Print all the games in a year\n5.Print all games in the database\n6.Return to the Main Menu");
        int choice = 0;
        String[] GameFound;
        while (choice == 0) {
            try {
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 6) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice) {
            case 1:
                GameFound = findGame();
                System.out.println("The game had " + totalShots(Integer.parseInt(GameFound[1]), GameFound[0]) + " shots");
                generalMenu();
                break;
            case 2:
                GameFound = findGame();
                System.out.println("The game had " + totalFouls(Integer.parseInt(GameFound[1]), GameFound[0]) + " fouls");
                generalMenu();
                break;
            case 3:
                System.out.println(allYears());
                generalMenu();
                break;
            case 4:
                choice = 0;
                while (choice == 0) {
                    try {
                        System.out.print("Please Input the year you would like to see:");
                        choice = input.nextInt();
                        if (choice < 1000 || choice > 9999) {
                            choice = 0;
                            System.out.println("Invalid Input, Please Try again!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please Try Again!");
                        input.next();
                    }
                }
                int gameYear = choice;
                if (Year.containsKey(Integer.toString(choice)) == true){
                    System.out.println("All games for " + gameYear + " are " + allGameYears(Integer.toString(gameYear)));
                }
                generalMenu();
                break;
            case 5:
                System.out.println(allGamesEverPlayed());
                generalMenu();
                break;
            case 6:
                mainMenu();
                break;
        }
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you ask for special types of input
     */
    public static void specialMenu() {
        System.out.println("Please Input a Number to choose your action");
        System.out.println("1.Print the top 5 games for fouls\n2.Print the top 5 games for shots\n3.Print the top 5 games for goals\n4.Print how many games ended in a tie\n5.Return to the Main Menu");
        int choice = 0;
        while (choice == 0) {
            try {
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 5) {
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice) {
            case 1:
                System.out.println("The top 5 amount of fouls in a game are " + topTeamFouls());
                specialMenu();
                break;
            case 2:
                System.out.println("The top 5 amount of shots in a game are " + topTeamShots());
                specialMenu();
                break;
            case 3:
                System.out.println("The top 5 amount of goals in a game are " + topTeamGoals());
                specialMenu();
                break;
            case 4:
                System.out.println(gamesWithATie() + " Games ended in a tie");
                specialMenu();
                break;
            case 5:
                mainMenu();
                break;
        }
    }
    /**
     * Creates a bunch of test data within the program, for demo purposes
     * @author Robert Engel, T03, Feb 28 2022
     * */
    public static void TestData(){
        addYear(2020);
        addYear(2021);
        addYear(2022);
        String[] game1 = {"Manchester", "Glasborough", "22", "33", "11", "18", "5", "7", "Home", "2020-1-1"};
        String[] game2 = {"Manchester", "Glasborough", "23", "34", "12", "19", "7", "5", "Away", "2020-1-2"};
        String[] game3 = {"Manchester", "Glasborough", "24", "35", "13", "20", "5", "5", "Tie", "2020-1-3"};
        String[] game4 = {"Manchester", "Glasborough", "25", "36", "14", "21", "8", "6", "Home", "2021-1-1"};
        String[] game5 = {"Manchester", "Glasborough", "26", "37", "15", "22", "9", "7", "Away", "2021-1-2"};
        String[] game6 = {"Manchester", "Glasborough", "27", "38", "16", "23", "9", "8", "Tie", "2021-1-3"};
        String[] game7 = {"Manchester", "Glasborough", "28", "39", "17", "24", "5", "7", "Home", "2022-1-1"};
        String[] game8 = {"Manchester", "Glasborough", "29", "40", "18", "25", "7", "5", "Away", "2022-1-2"};
        String[] game9 = {"Manchester", "Glasborough", "21", "41", "19", "26", "5", "5", "Tie", "2022-1-3"};
        addGame(2020, game1);
        addGame(2020, game2);
        addGame(2020, game3);
        addGame(2021, game4);
        addGame(2021, game5);
        addGame(2021, game6);
        addGame(2022, game7);
        addGame(2022, game8);
        addGame(2022, game9);
        System.out.println("Test Data Activated!");
    }
    /**
     * This function returns the total shots of each team in a particular game
     *
     * @param gameYear    Year of the game that the user wants to see the total shots
     * @param gameChecker Game name that the user want to see the total shots. eg "Home vs Away on Date"
     * @return Returns an integer of total shots of each team in a game
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static int totalShots(int gameYear, String gameChecker) {
        String[] homeShots;
        String[] awayShots;
        homeShots = getGameData(gameYear, gameChecker);
        awayShots = getGameData(gameYear, gameChecker);
        if (homeShots != null && awayShots != null) {
            int shotsTotal = Integer.parseInt(homeShots[4]) + Integer.parseInt(awayShots[5]);
            return shotsTotal;
        }
        else{
            System.out.println("Error Occured! Game Not Found!");
            return 0;
        }
    }

    /**
     * This function returns the total fouls of each team in a particular game
     *
     * @param gameYear    Year of the game that the user wants to see the total fouls
     * @param gameChecker Game name that the user want to see the total fouls
     * @return Returns an integer of the total fouls of each team in game
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static int totalFouls(int gameYear, String gameChecker) {
        String[] homeFouls = getGameData(gameYear, gameChecker);
        String[] awayFouls = getGameData(gameYear, gameChecker);
        if (homeFouls != null && awayFouls != null) {
            int foulsTotal = Integer.parseInt(homeFouls[2]) + Integer.parseInt(homeFouls[3]);
            return foulsTotal;
        }
        else{
            System.out.println("Error Occured! Game Not Found!");
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
        return Year.keySet();
    }

    /**
     * This function displays every game in a year
     *
     * @param gameYear Year that the user is looking for
     * @return Returns every game in a year
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static Set<String> allGameYears(String gameYear) {
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
        for (Map.Entry<String, HashMap<String, String[]>> entry : Year.entrySet()) {
            games.add(String.valueOf(entry.getValue().keySet()));
        }
        return games;
    }

    public static int topTeamFouls() {
        ArrayList<String[]> fouls = new ArrayList<String[]>();
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                fouls.add(inner.getValue());
            }
        }
        int totalFouls;

    }

    public static String topTeamShots() {
        ArrayList<String[]> shots = new ArrayList<String[]>();
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                shots.add(inner.getValue());
            }
        }
    }

    public static String topTeamGoals() {
        String[] goals;
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                goals = inner.getValue();
            }
        }
    }

    public static String topTeamWins() {
        String[] wins;
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                wins = inner.getValue();
            }
        }
    }

    /**
     * This function loops through all the games and returns the top 5 games that has most team fouls
     *
     * @return Returns the top 5 fouls in a list of string
     * @author Adrian Ponce, Feb 24, 2022, T03
     */
    public static List<String> topTeamFouls() {
        ArrayList<String> fouls = new ArrayList<String>();
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                fouls.add(inner.getValue()[2]);
                fouls.add(inner.getValue()[3]);
            }
        }
        Collections.sort(fouls, Collections.reverseOrder());
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
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                shots.add(inner.getValue()[4]);
                shots.add(inner.getValue()[5]);
            }
        }
        Collections.sort(shots, Collections.reverseOrder());
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
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                goals.add(inner.getValue()[6]);
                goals.add(inner.getValue()[7]);
            }
        }
        Collections.sort(goals, Collections.reverseOrder());
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
        int tieGame = 0;
        for (Map.Entry<String, HashMap<String, String[]>> outer : Year.entrySet()) {
            for (Map.Entry<String, String[]> inner : outer.getValue().entrySet()) {
                games.add(inner.getValue()[8]);
            }
        }
        for (int i = 0; i < games.size(); i++) {
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