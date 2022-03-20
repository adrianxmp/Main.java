package project.menu;

import project.data.*;

import java.util.*;

public abstract class Menu {
    static Scanner input = new Scanner(System.in);
    /**
     * @author Robert Engel, T03, ~Feb 21 2022
     * Finds a game from user input
     * @return the data from the found game
     */
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
                input.nextLine();
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
        String foundGameId = homeTeam + " vs. " + awayTeam + " on " + Date;
        String[] foundGameData = {foundGameId, Integer.toString(gameYear)};
        return foundGameData;

    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * The main part of the menu system, breaking it up for simplicity of finding specific parts of the menu.
     */
    public static void mainMenu() {
        int choice = 0;
        System.out.println("Welcome to the Premier League Database project.Main Menu!\nPlease Input a number to choose your action");
        System.out.println("1. Add a new project.data.Year\n2. Add a new project.data.Game to a project.data.Year\n3. General Output Menu\n4. Special Output Menu\n5. Quit the program");
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
                input.close();
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
                System.out.print("Please Input the project.data.Year:");
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
        Timeline.addYear(choice);
        mainMenu();
    }

    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you enter in a new game, and all its corresponding data
     */
    public static void gameMenu() {
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
        String home = sChoice;
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
        String away = sChoice;
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
        int homeFouls = choice;
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
        int awayFouls = choice;
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
        int homeShots = choice;
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
        int awayShots = choice;
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
        int homeGoals = choice;
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
        int awayGoals = choice;
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
        Game newGame = new Game(home, away, homeFouls, awayFouls, homeShots, awayShots, homeGoals, awayGoals, Date);
        Timeline.addGameToYear(newGame, gameYear);
        mainMenu();
    }
    /**
     * @author Robert Engel, T03, Feb 21 2022
     * the part of the menu where you ask for general types of input
     */
    public static void generalMenu() {
        System.out.println("Please Input a Number to choose your action");
        System.out.println("1.Print the total number of shots in a game\n2.Print the total number of fouls in a game\n3.Print all years in the database\n4.Print all the games in a year\n5.Print all games in the database\n6.Return to the project.Main Menu");
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
                //System.out.println("The game had " + totalShots(Integer.parseInt(GameFound[1]), GameFound[0]) + " shots");
                generalMenu();
                break;
            case 2:
                GameFound = findGame();
                //System.out.println("The game had " + totalFouls(Integer.parseInt(GameFound[1]), GameFound[0]) + " fouls");
                generalMenu();
                break;
            case 3:
                //System.out.println(allYears());
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
                Year checkYear = new Year(gameYear);
                if (Timeline.getTimeline().contains(checkYear)) {
                    //System.out.println("All games for " + gameYear + " are " + allGameYears(Integer.toString(gameYear)));
                }
                generalMenu();
                break;
            case 5:
                //System.out.println(allGamesEverPlayed());
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
        System.out.println("1.Print the top 5 games for fouls\n2.Print the top 5 games for shots\n3.Print the top 5 games for goals\n4.Print how many games ended in a tie\n5.Return to the project.Main Menu");
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
                //System.out.println("The top 5 amount of fouls in a game are " + topTeamFouls());
                specialMenu();
                break;
            case 2:
                //System.out.println("The top 5 amount of shots in a game are " + topTeamShots());
                specialMenu();
                break;
            case 3:
                //System.out.println("The top 5 amount of goals in a game are " + topTeamGoals());
                specialMenu();
                break;
            case 4:
                //System.out.println(gamesWithATie() + " Games ended in a tie");
                specialMenu();
                break;
            case 5:
                mainMenu();
                break;
        }
    }

    /**
     * Creates a bunch of test data within the program, for demo purposes
     *
     * @author Robert Engel, T03, Feb 28 2022
     */
    public void testData(){
        Timeline.addYear(2020);
        Timeline.addYear(2021);
        Timeline.addYear(2022);
        Game game1 = new Game("Manchester United", "Glasborough", 1, 2, 3, 4, 3, 3,"2020-1-1");
        Game game2 = new Game("Manchester United", "Glasborough", 5, 6, 7, 8, 4, 5,"2020-1-2");
        Game game3 = new Game("Manchester United", "Glasborough", 9, 10, 11, 12, 7, 6,"2021-1-1");
        Game game4 = new Game("Manchester United", "Glasborough", 13, 14, 15, 16, 8, 8,"2021-1-2");
        Game game5 = new Game("Manchester United", "Glasborough", 17, 18, 19, 20, 9, 10,"2022-1-1");
        Game game6 = new Game("Manchester United", "Glasborough", 21, 22, 23, 24, 12, 11,"2022-1-2");
        Timeline.addGameToYear(game1, 2020);
        Timeline.addGameToYear(game2, 2020);
        Timeline.addGameToYear(game3, 2021);
        Timeline.addGameToYear(game4, 2021);
        Timeline.addGameToYear(game5, 2022);
        Timeline.addGameToYear(game6, 2022);
        System.out.println("Test Data Activated!");


    }
}
