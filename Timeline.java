import java.util.*;
public class Timeline {
    private static final ArrayList<Year> timeline = new ArrayList<Year>();
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> yearList = new ArrayList<Integer>();
        for(int i = 0; i < timeline.size(); i++){
            yearList.add(i, timeline.get(i).yearNumber);
        }
        Collections.sort(yearList);
        return yearList;
    }
    public void addYear(Year newYear){
        if(timeline.contains(newYear)){
            System.out.println("Year already Exists! Year not added");
        }
        else{
            timeline.add(newYear);
        }
    }
}
