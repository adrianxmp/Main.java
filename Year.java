import java.util.ArrayList;

public class Year extends Timeline{
    int yearNumber;
    private final ArrayList<Game> gameList = new ArrayList<Game>();
    public Year(int newYear){
        this.yearNumber = newYear;
    }
    public Year(){
        this.yearNumber = 0;
    }
    public int getYearNumber() {
        return yearNumber;
    }
    public void addGame(Game newGame){
        if(gameList.contains(newGame) == true){
            System.out.println("Error! Game already exists!");
        }
        else{
            gameList.add(newGame);
        }
    }
    public Game getGame(String newID){
        for(int i = 0; i < this.gameList.size(); i++){
            if(this.gameList.get(i).getId().equals(newID)){
                return gameList.get(i);
            }
        }
        System.out.println("Error, no game found!");
        return null;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Year){
            if(this.yearNumber == ((Year) obj).yearNumber){
                return true;
            }
        }
        return false;
    }
}
