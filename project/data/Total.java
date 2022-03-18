package project.data;

import java.util.ArrayList;

public class Total extends Year{
    private static final ArrayList<String>shotsData = new ArrayList<>();
    private static final ArrayList<String>foulsData = new ArrayList<>();
    private static int shots, fouls;
    private final String stringTotalShots = "The Home Team total shot is" + shots;

    public static int getShots(int gameYear, String gameChecker){
        Year year = new Year(gameYear);
        shotsData.add(String.valueOf(year.getGame(gameChecker)));
        shots = Integer.parseInt(shotsData.get(4)) + Integer.parseInt(shotsData.get(5));
        return shots;
        }

    public static int getFouls(int gameYear, String gameChecker) {
        Year year = new Year(gameYear);
        foulsData.add(String.valueOf(year.getGame(gameChecker)));
        fouls = Integer.parseInt(foulsData.get(2)) + Integer.parseInt(foulsData.get(3));
        return fouls;
    }

}

