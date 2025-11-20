import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//These all import the things needed to analyze the data:
//The first two deal with file types, the next two are imported datatypes, and the last one reads the csv file

public class musicAnalysis{
    public static void main(String[] args)throws FileNotFoundException { //runs the code and throws exception if it doesn't work
        keyFinder("/Users/akesmodel/Desktop/Cs_Seminar/stunning-octo-funicular/1980sClassics.csv");
    }
    public static void keyFinder(String pathname) throws FileNotFoundException{ //keeps a tally of how often each key is used, and returns results
        File f= new File(pathname); //creates a File object using link
        Scanner sc= new Scanner(f); //reads file object

        String[] header=sc.nextLine().split(" "); //Used purely to scan past the 1st line
        int key_idx = 6; //Corresponds to the column that stores what key everything is in
        int[] keys= new int[12]; //used to tally how many songs are in each key
        String[] keynames={"C", "Db", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B"}; //Each of the different key names

        while (sc.hasNextLine()){
            ArrayList<String> line= new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            int indKey=(int)(Double.parseDouble(line.get(key_idx)));
            keys[indKey]++;
        }
        int max=0; 
        for (int i=1; i<12; i++){
            if(keys[i]>keys[max]){
                max=i;
            }
        }
        for(int i=0; i<12; i++){
            System.out.println(keynames[i]+": "+keys[i]);
        }
        System.out.println("The most songs were in the key of "+keynames[max]+"!");
    }
}