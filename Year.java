import java.util.ArrayList;

public class Year extends Timeline{
    ArrayList<Game> gameList = new ArrayList<Game>();

    public int getYearNumber() {
        return yearNumber;
    }

    int yearNumber;

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
