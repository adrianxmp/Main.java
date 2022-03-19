package project.menu;

import project.data.Timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Output extends Menu{

    public static int getShots(int gameYear, String gameID){
        int homeShots;
        int awayShots;
        homeShots = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getHomeShots();
        awayShots = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getAwayShots();
        int totalShots = homeShots + awayShots;
        return totalShots;
    }
    public static int getFouls(int gameYear, String gameID){
        int homeFouls;
        int awayFouls;
        homeFouls = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getHomeFouls();
        awayFouls = Objects.requireNonNull(Timeline.getYear(gameYear)).getGame(gameID).getAwayFouls();
        int totalFouls = homeFouls + awayFouls;
        return totalFouls;
    }

    public static List<String> topFouls() {
        ArrayList<String> timelineList = new ArrayList<>();
        ArrayList<String> fouls = new ArrayList<>();
        timelineList.add(String.valueOf(Timeline.getTimeline()));
        for (int i = 0; i < timelineList.size(); i++) {
            for (int j = 0; j < Timeline.getYear(i).getGameList().size(); j++) {
                fouls.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getHomeFouls()));
                fouls.add(String.valueOf(Timeline.getYear(i).getGameList().get(j).getAwayFouls()));
            }
        }
        Collections.sort(fouls, Collections.reverseOrder());
        List<String> topFiveFouls = fouls.subList(0, 5);
        return topFiveFouls;
    }

    public static List<String> topShots() {
        ArrayList<String> timelineList = new ArrayList<>();
        ArrayList<String> shots = new ArrayList<>();
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

}
