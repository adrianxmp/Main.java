package project.data;

public class Game extends Year {
    private String home, away, date, id;
    private int homeFouls, homeShots, homeGoals, awayFouls, awayShots, awayGoals;
    Winner gameWinner;
public Game(String newhome, String newaway, int newHomeFouls, int newAwayFouls, int newHomeShots,int newAwayShots,int newHomeGoals,int newAwayGoals, String date){
    this.home = newhome;
    this.away = newaway;
    this.homeFouls = newHomeFouls;
    this.homeShots = newHomeShots;
    this.homeGoals = newHomeGoals;
    this.awayFouls = newAwayFouls;
    this.awayShots = newAwayShots;
    this.awayGoals = newAwayGoals;
    this.date = date;
    if(newHomeGoals > newAwayGoals){
        this.gameWinner = Winner.HOME;
    }
    else if (newHomeGoals < newAwayGoals){
        this.gameWinner = Winner.AWAY;
    }
    else{
        this.gameWinner = Winner.TIE;
    }
    this.id = home + " vs. " + away + " on " + date;
}
    public enum Winner{
        HOME, AWAY, TIE
    }

    public Winner getGameWinner() {
        return gameWinner;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            if (this.id.equals(((Game) obj).id) == true) {
                return true;
            }
        }
        return false;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public String getDate() {
        return date;
    }

    public int getHomeFouls() {
        return homeFouls;
    }

    public int getHomeShots() {
        return homeShots;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayFouls() {
        return awayFouls;
    }

    public int getAwayShots() {
        return awayShots;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getId() {
        return id;
    }
}
