package project.menu;

import project.data.*;
import java.util.*;

public abstract class Output extends Menu {
    /**
     * @param gameYear Year of the game
     * @param gameID   Game ID of the game
     * @return Returns the total shots in the game
     * @author Adrian Ponce, T03, March 20,2022
     * This method gets all shots in the game
     */
    public static int getShots(int gameYear, String gameID) {
        int homeShots = 0;
        int awayShots = 0;
        try{
            homeShots = Timeline.getYear(gameYear).getGame(gameID).getHomeShots();
            awayShots = Timeline.getYear(gameYear).getGame(gameID).getAwayShots();
        }
        catch(NullPointerException e){
            System.out.println("Error, Game does not seem to exist!");
        }

        int totalShots = homeShots + awayShots;
        return totalShots;
    }

    /**
     * @param gameYear Year of the game
     * @param gameID   Game ID of the game
     * @return Returns the total fouls of the game
     * @author Adrian Ponce, T03, March 20,2022
     * Gets the total fouls of the game
     */
    public static int getFouls(int gameYear, String gameID) {
        int homeFouls = 0;
        int awayFouls = 0;
        try{
            homeFouls = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getHomeFouls();
            awayFouls = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getAwayFouls();
        }
        catch(NullPointerException e){
            System.out.println("Error! Game does not seem to exist!");
        }

        int totalFouls = homeFouls + awayFouls;
        return totalFouls;
    }

    /**
     * @return Returns a list of top five fouls
     * @author Adrian Ponce, T03, March 20,2022
     * Gets the Top Five Fouls in all the games played
     */
    public static List<Integer> getTopFiveFouls() {
        ArrayList<Year> timelineList = Timeline.getTimeline();
        ArrayList<Integer> fouls = new ArrayList<Integer>();
        for (int i = 0; i < timelineList.size(); i++) {
            for (int j = 0; j < timelineList.get(i).getGameList().size(); j++) {
                fouls.add(timelineList.get(i).getGameList().get(j).getHomeFouls());
                fouls.add(timelineList.get(i).getGameList().get(j).getAwayFouls());
            }
        }
        Collections.sort(fouls, Collections.reverseOrder());
        List<Integer> topFiveFouls = fouls.subList(0, 5);
        return topFiveFouls;
    }

    /**
     * @return Returns a list of top five shots
     * @author Adrian Ponce, T03, March 20,2022
     * Gets the Top five shots in all the games played
     */
    public static List<String> getTopFiveShots() {
        ArrayList<String> timelineList = new ArrayList<>();
        ArrayList<String> shots = new ArrayList<>();
        timelineList.add(String.valueOf(Timeline.getTimeline()));
        for (int i = 0; i < timelineList.size(); i++) {
            for (int j = 0; j < Timeline.getYear(i).getGameList().size(); j++) {
                shots.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getHomeShots()));
                shots.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getAwayShots()));
            }
        }
        Collections.sort(shots, Collections.reverseOrder());
        List<String> topFiveShots = shots.subList(0, 5);
        return topFiveShots;
    }

    /**
     * @return Returns a list of top five goals
     * @author Adrian Ponce, T03, March 20,2022
     * Gets the Top Five Goals in all the games played
     */
    public static List<String> getTopFiveGoals() {
        ArrayList<String> timelineList = new ArrayList<>();
        ArrayList<String> goals = new ArrayList<>();
        timelineList.add(String.valueOf(Timeline.getTimeline()));
        for (int i = 0; i < timelineList.size(); i++) {
            for (int j = 0; j < Timeline.getYear(i).getGameList().size(); j++) {
                goals.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getHomeGoals()));
                goals.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getAwayGoals()));
            }
        }
        Collections.sort(goals, Collections.reverseOrder());
        List<String> topFiveGoals = goals.subList(0, 5);
        return topFiveGoals;
    }

    /**
     * @return Returns the counts of the games that ended in a tie
     * @author Adrian Ponce, T03, March 20,2022
     * Gets all the games that ended in tie
     */
    public static int getGamesWithATie() {
        ArrayList<Year> timelineList = Timeline.getTimeline();
        ArrayList<Game.Winner> gameOutcome = new ArrayList<>();
        int tieGameCounter = 0;
        for (int i = 0; i < timelineList.size(); i++) {
            for (int j = 0; j < timelineList.get(i).getGameList().size(); j++) {
                gameOutcome.add(timelineList.get(i).getGameList().get(j).getGameWinner());
            }
        }
        for (Game.Winner s : gameOutcome) {
            if (Objects.equals(s, Game.Winner.TIE)) {
                tieGameCounter++;
            }
        }
        return tieGameCounter;
    }
}