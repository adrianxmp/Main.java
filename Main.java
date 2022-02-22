import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static HashMap<String, HashMap<String, String[]>> Year = new HashMap<String, HashMap<String, String[]>>();
    public static Scanner input = new Scanner(System.in);
    /**
     * @author Robert Engel, T03
     * This function adds a new HashMap representing a new year to be added, it will NOT add a new value if the
     * year already exists (i.e. the key already exists)
     * @param newYear the new year to be added, should be 4-digit positive integer
     */
    public static void addYear(int newYear){
        if (Year.containsKey(Integer.toString(newYear)) == true){
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
    public static String findGame(){
        int choice = 0;
        String sChoice = "";
        System.out.println("Teams have their first letter capitalized, no periods for abbreviations");
        while (sChoice.isEmpty() == true){
            try{
                System.out.print("Please Input the Home Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true){
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        String homeTeam = sChoice;
        sChoice = "";
        while (sChoice.isEmpty() == true){
            try{
                System.out.print("Please Input the Away Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true){
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        String awayTeam = sChoice;
        sChoice = "";
        while (choice == 0){
            try{
                System.out.print("Please Input the year the game was played:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameYear = choice;
        while (choice == 0){
            try{
                System.out.print("Please Input the month the game was played, as a number (1 = January, 2 = February, etc.:");
                choice = input.nextInt();
                if (choice < 1 || choice > 12){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameMonth = choice;
        while (choice == 0){
            try{
                System.out.print("Please Input the day the game was played:");
                choice = input.nextInt();
                if (choice < 1 || choice > 31){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameDay = choice;
        String Date = gameYear + "-" + gameMonth + "-" + gameDay;
        String foundGame = homeTeam + " vs. " + awayTeam + " on " + Date;
        return foundGame;
    }
    /**
     * @author Robert Engel, T03, Feb 21 2022
     * The main part of the menu system, breaking it up for simplicity of finding specific parts of the menu.
     */
    public static void mainMenu(){
        int choice = 0;
        System.out.println("Welcome to the Premier League Database Main Menu!\nPlease Input a number to choose your action");
        System.out.println("1. Add a new Year\n2. Add a new Game to a Year\n3. General Output Menu\n4. Special Output Menu\n5. Quit the program");
        while (choice == 0){
            try{
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 5){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice){
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
                System.exit(0);
                break;
        }
    }
    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you enter in a new year
     * */
    public static void yearMenu(){
        System.out.println("Years are formatted as a 4-digit positive number");
        int choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Year:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
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
     * */
    public static void gameMenu(){
        int choice = 0;
        String sChoice = "";
        String[] gameData = new String[10];
        System.out.println("Teams have their first letter capitalized, no periods for abbreviations");
        while (sChoice.isEmpty() == true){
            try{
                System.out.print("Please Input the Home Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true){
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[0] = sChoice;
        sChoice = "";
        input.next();
        while (sChoice.isEmpty() == true){
            try{
                System.out.print("Please Input the Away Team:");
                sChoice = input.next();
                if (sChoice.isEmpty() == true){
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[1] = sChoice;
        sChoice = "";
        while (choice == 0){
            try{
                System.out.print("Please Input the Home Team Fouls:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[2] = Integer.toString(choice);
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Away Team Fouls:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[3] = Integer.toString(choice);
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Home Team Shots:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[4] = Integer.toString(choice);
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Away Team Shots:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[5] = Integer.toString(choice);
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Home Team Goals:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[6] = Integer.toString(choice);
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the Away Team Goals:");
                choice = input.nextInt();
                if (choice < 0){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        gameData[7] = Integer.toString(choice);
        if(Integer.parseInt(gameData[6]) > Integer.parseInt(gameData[7])){
            gameData[8] = "Home";
        }
        else if(Integer.parseInt(gameData[6]) < Integer.parseInt(gameData[7])){
            gameData[8] = "Away";
        }
        else if(Integer.parseInt(gameData[6]) == Integer.parseInt(gameData[7])){
            gameData[8] = "Tie";
        }
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the year the game was played:");
                choice = input.nextInt();
                if (choice < 1000 || choice > 9999){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameYear = choice;
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the month the game was played, as a number (1 = January, 2 = February, etc.:");
                choice = input.nextInt();
                if (choice < 1 || choice > 12){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        int gameMonth = choice;
        choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input the day the game was played:");
                choice = input.nextInt();
                if (choice < 1 || choice > 31){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
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
     * */
    public static void generalMenu(){
        System.out.println("Please Input a Number to choose your action");
        System.out.println("1.Print the total number of shots in a game\n2.Print the total number of fouls in a game\n3.Print all years in the database\n4.Print all the games in a year\n5.Print all games in the database\n6.Return to the Main Menu");
        int choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 6){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice){
            case 1:
                //Total number of shots in a game function
                generalMenu();
                break;
            case 2:
                //total number of fouls in a game function
                generalMenu();
                break;
            case 3:
                //print all years function
                generalMenu();
                break;
            case 4:
                //print all games in a year function
                generalMenu();
                break;
            case 5:
                //print all games ever function
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
     * */
    public static void specialMenu(){
        System.out.println("Please Input a Number to choose your action");
        System.out.println("1.Print the top 5 games for fouls\n2.Print the top 5 games for goals\n3.Print the top 5 teams for wins\n4. Print the top 5 teams for shots taken\n5.Return to the Main Menu");
        int choice = 0;
        while (choice == 0){
            try{
                System.out.print("Please Input a number:");
                choice = input.nextInt();
                if (choice < 1 || choice > 5){
                    choice = 0;
                    System.out.println("Invalid Input, Please Try again!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input! Please Try Again!");
                input.next();
            }
        }
        switch (choice){
            case 1:
                //Top 5 games for fouls function
                specialMenu();
                break;
            case 2:
                //top 5 games for goals function
                specialMenu();
                break;
            case 3:
                //top 5 teams for wins function
                specialMenu();
                break;
            case 4:
                //top 5 teams for shots taken function
                specialMenu();
                break;
            case 5:
                mainMenu();
                break;
        }
    }
    /**
     * Not much here, just the menu program call
     * */
    public static void main(String[] args) {
        mainMenu();
    }
}
