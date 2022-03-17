import java.util.*;
public class Timeline {
    private static ArrayList<Year> timeline = new ArrayList<Year>();
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> yearList = new ArrayList<Integer>();
        for(int i = 0; i < timeline.size(); i++){
            yearList.add(i, timeline.get(i).yearnumber);
        }
        Collections.sort(yearList);
        return yearList;
    }
    public void addYear(Year newYear){

    }
}
