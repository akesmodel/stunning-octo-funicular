import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class musicAnalysis{
    public static void main(String[] args)throws FileNotFoundException {
        keyFinder("/Users/akesmodel/Desktop/Cs_Seminar/stunning-octo-funicular/1980sClassics.csv");
    }
    public static void keyFinder(String pathname) throws FileNotFoundException{
        File f= new File(pathname);
        Scanner sc= new Scanner(f);

        String[] header=sc.nextLine().split(" ");
        int key_idx = 6;
        int[] keys= new int[12];
        String[] keynames={"C", "Db", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B"};

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