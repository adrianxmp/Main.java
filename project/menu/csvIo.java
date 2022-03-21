package project.menu;
import project.data.*;

import java.io.*;
import java.util.*;

public abstract class csvIo extends Menu{
    /**
     * Creates a CSV file from the currently loaded data inside the program
     * @param filename the name of the file, INCLUDING the .csv part of the name
     */
    static public void loadCsv(String filename){
        File newFile = new File(filename);
        Scanner input = null;
        if(newFile.isFile() == true){
            try {
                int previousyear = 0;
                input = new Scanner(newFile).useDelimiter(",|\\n+");
                for(int i = 0; input.hasNext() == true; i++)
                    if(i != 0){
                        String Home = input.next();
                        String Away = input.next();
                        int homeFouls = input.nextInt();
                        int awayFouls = input.nextInt();
                        int homeShots = input.nextInt();
                        int awayShots = input.nextInt();
                        int homeGoals = input.nextInt();
                        int awayGoals = input.nextInt();
                        String date = input.next();
                        int year = Integer.parseInt(date.substring(0,4));
                        if(year != previousyear){
                            Timeline.addYear(year);
                        }
                        Game newGame = new Game(Home, Away, homeFouls, awayFouls, homeShots, awayShots, homeGoals, awayGoals, date);
                        Timeline.addGameToYear(newGame, year);
                        previousyear = year;
                    }
                    else{
                        for(int k = 0; k < 9; k++){
                            input.next();
                        }
                    }
                    System.out.println("CSV Successfully loaded!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Error! File does not exist!");
        }

    }
    /**
     * Creates a csv from the current values in the Timeline class
     * @param filename the name of the file to be created, EXCLUDING the .csv (it's added below)
     */
    static public void createCsv(String filename){
        File newFile = new File(filename+".csv");
        if(newFile.isFile() == false){
            try {
                newFile.createNewFile();
                PrintWriter writer = new PrintWriter(newFile);
                ArrayList<Year> timelinewriter = Timeline.getTimeline();
                writer.print("Home,Away,Home Fouls,Away Fouls,Home Shots,Away Shots,Home Goals,Away Goals,Date\n");
                for(int i = 0; i < timelinewriter.size(); i++){
                    for(int j = 0; j < timelinewriter.get(i).getGameList().size(); j++){
                        writer.print(timelinewriter.get(i).getGameList().get(j).getHome() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getAway() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getHomeFouls() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getAwayFouls() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getHomeShots() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getAwayShots() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getHomeGoals() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getAwayGoals() + ",");
                        writer.print(timelinewriter.get(i).getGameList().get(j).getDate() + "\n");
                    }
                }
                writer.flush();
                System.out.println("CSV Successfully saved!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("File already exists! Please create a new file!");
        }
    }
}
