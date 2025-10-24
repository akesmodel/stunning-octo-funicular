import java.io.*;
import java.util.*;

/* Question: Does sugar percent increase popularity of candy?*/
/* We'll look at 2 groups: Candies over and under 50% sugar.*/

public class CandyData{
    public static void main(String[] args) throws FileNotFoundException{
        highSugarVslowSugar("/Users/akesmodel/Desktop/Cs_Seminar/stunning-octo-funicular/candy-data.csv");
    }
    public static void highSugarVslowSugar(String pathname) throws FileNotFoundException{
        File f= new File(pathname);
        Scanner sc= new Scanner(f);

        String[] header=sc.nextLine().split(" ");
        int sugar_idx = 10;
        int win_idx=12;
        ArrayList<Double> highSugar=new ArrayList();
        ArrayList<Double> lowSugar=new ArrayList();


        while (sc.hasNextLine()){
            ArrayList<String> line= new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            if(Double.parseDouble(line.get(sugar_idx))>0.5){
                highSugar.add(Double.parseDouble(line.get(win_idx)));
            }
            else{
                lowSugar.add(Double.parseDouble(line.get(win_idx)));
            }
        }

        double highSug_avg=0;
        for(Double d: highSugar){
            highSug_avg+=d;
        }
        double lowSug_avg=0;
        for(Double d: lowSugar){
            lowSug_avg+=d;
        }
        highSug_avg/=highSugar.size();
        lowSug_avg/=lowSugar.size();
        System.out.println("High Sugar average: "+highSug_avg+"%");
        System.out.println("Low Sugar average: "+lowSug_avg+"%");
        if(highSug_avg>lowSug_avg){
            System.out.println("Sugary candies are more popular!");
        }
        else if(highSug_avg<lowSug_avg){
            System.out.println("Less sugary candies are more popular!");
        }
        else{
            System.out.println("Tie!");
        }


    }
}