package project.data;

import java.util.ArrayList;

public class Year extends Timeline{
    int yearNumber;
    private final ArrayList<Game> gameList = new ArrayList<Game>();
    /**
     * @author Robert Engel, T03, March 17 2022
     * normal constructor, use this one when using this class
     */
    public Year(int newYear){
        this.yearNumber = newYear;
    }
    /**
     * @author Robert Engel, T03, March 17 2022
     * Default constructor, will create errors if used
     */
    public Year(){
        this.yearNumber = 0;
    }
    public int getYearNumber() {
        return yearNumber;
    }
    /**
     * @author Robert Engel, T03, March 17 2022
     * adds a project.data.Game to the project.data.Year if it doesn't already exist
     */
    public void addGame(Game newGame){
        if(gameList.contains(newGame) == true){
            System.out.println("Error! project.data.Game already exists!");
        }
        else{
            gameList.add(newGame);
        }
    }
    /**
     * @author Robert Engel, T03, March 17 2022
     * finds a game withint the year and returns it
     * @return the game found, or null if the game was not found
     */
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
