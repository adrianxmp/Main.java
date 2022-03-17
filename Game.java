public class Game extends Year {
    private String home, away, date;
    private int homeFouls, homeShots, homeGoals, awayFouls, awayShots, awayGoals;
    private final String id = home + " vs. " + away + " on " + date;
public Game(String newhome, String newaway, String newdate, int newHomeFouls, int newHomeShots, int newHomeGoals, int newAwayFouls, int newAwayShots, int newAwayGoals){
    this.home = newhome;
    this.away = newaway;
    this.date = newdate;
    this.homeFouls = newHomeFouls;
    this.homeShots = newHomeShots;
    this.homeGoals = newHomeGoals;
    this.awayFouls = newAwayFouls;
    this.awayShots = newAwayShots;
    this.awayGoals = newAwayGoals;
}
    private enum winner {
        HOME, AWAY, TIE
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
