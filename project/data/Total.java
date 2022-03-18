package project.data;

import java.util.ArrayList;

public class Total extends Year{
    private static final ArrayList<String>gameData = new ArrayList<>();
    private static int shots;
    private int fouls;
    private final String stringTotalShots = "The Home Team total shot is" + shots;

    public static int getShots(int gameYear, String gameChecker){
        Year year = new Year(gameYear);
        gameData.add(String.valueOf(year.getGame(gameChecker)));
        shots = Integer.parseInt(gameData.get(4)) + Integer.parseInt(gameData.get(5));
        return shots;
        }

    public static int getFouls() {
        return 0;
    }

}

