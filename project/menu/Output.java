package project.menu;

import project.data.Game;
import project.data.Timeline;
import project.data.Year;

import java.util.ArrayList;
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
}
