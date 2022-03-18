package project.data;

import java.util.*;
public class Timeline {
    private static final ArrayList<Year> timeline = new ArrayList<Year>();
    /**
     * @author Robert Engel, T03, March 17 2022
     *Gets the ints representing all Years in the timeline
     * @return a List of Integers showing all years
     */
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> yearList = new ArrayList<Integer>();
        for(int i = 0; i < timeline.size(); i++){
            yearList.add(i, timeline.get(i).yearNumber);
        }
        Collections.sort(yearList);
        return yearList;
    }
    /**
     * @author Robert Engel, T03, March 17 2022
     * adds a project.data.Year to the timeline array if it doesn't already exist
     */
    public static void addYear(int yearNumber){
        Year newYear = new Year(yearNumber);
        if(timeline.contains(newYear)){
            System.out.println("project.data.Year already Exists! project.data.Year not added");
        }
        else if(newYear.yearNumber == 0){
            System.out.println("Error, project.data.Year not created correctly!");
        }
        else{
            timeline.add(newYear);
        }
    }
    public static ArrayList<Year> getTimeline(){
        return timeline;
    }
    /**
     * @author Robert Engel, T03, March 17 2022
     * adds a project.data.Game to the project.data.Year if it doesn't already exist
     */
    public static void addGameToYear(Game newGame, int year){
        for(int i = 0; i < timeline.size(); i++){
            if(timeline.get(i).yearNumber == year){
                timeline.get(i).addGame(newGame);
            }
            else{
                System.out.println("Error, game not found!");
            }
        }
    }
    public Year getYear(int yearNumber){
        Year checkYear = new Year(yearNumber);
        if(timeline.contains(checkYear)){
            return checkYear;
        }
        else{
            System.out.println("Error! Year not found!");
            return null;
        }
    }
}
