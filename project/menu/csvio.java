package project.menu;
import java.io.*;
public abstract class csvio extends Menu{
    static public void loadcsv(File filename){

    }
    /**
     * Creates a csv from the current values in the Timeline class
     * @param filename the name of the file to be created
     */
    static public void createcsv(String filename){
        File newfile = new File(filename+".csv");
        if(newfile.isFile() == false){
            try {
                newfile.createNewFile();
                PrintWriter writer = new PrintWriter(newfile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("File already exists! Please create a new file!");
        }
    }
}
