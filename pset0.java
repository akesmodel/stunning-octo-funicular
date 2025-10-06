import java.util.ArrayList;
import java.util.Arrays;

public class pset0{
    public static void main(String[] args) {
        /*Problem 1 */
        int[] example={14, -34, 6, 7, -4, 1, 2};
        System.out.println(countInRange(example, 1, 20));

        /*Problem 2 */
        ArrayList<String> clumpers= new ArrayList<>(Arrays.asList("sign", "up", "for","math","team"));
        clump(clumpers);
        System.out.println(clumpers);

        /*Problem 3 */
        int[][] magic={{2,7,6},{9,5,1},{4,3,8}};
        System.out.println(isMagicSquare(magic));

        /*Problem 4 */
        System.out.println(median(example));
    }
    public static int countInRange(int[] x, int a, int b){
        int toRet=0; /*Counter variable to keep track */
        for (int i=0; i<x.length; i++){
            if (x[i]>=a&&x[i]<=b){
                toRet++; /*Add to counter if in the range */
            }
        }
        return toRet;
    }
    public static void clump(ArrayList<String> input){
        int a=input.size();
        for (int i=a-(a%2)-1; i>0; i-=2){ /*Starts at the largest odd index and works down */
            String temp=input.get(i-1);
            temp+=" "+input.get(i);
            input.set(i-1,temp); /*Sets the even values equal to itself + the one after it */
            input.remove(i); /*Gets rid of the duplicate, descending so it doesn't mess up the indexes */
        }
        
    }
    public static boolean isMagicSquare(int[][] input){
        int sum=0;
        for (int i = 0; i < input[0].length; i++) {
            sum+=input[0][i]; /*Uses the first row to figure out what the sum is */
        }
        for (int i = 1; i < input[0].length; i++) { /*Checks the remaining rows */
            int temp=0;
            for (int j = 0; j < input[0].length; j++) {
                temp+=input[i][j];
            }
            if (temp!=sum){
                return false;
            }
        }
        for (int j = 0; j < input[0].length; j++) { /*Checks the columns */
            int temp=0;
            for (int i = 0; i < input[0].length; i++) {
                temp+=input[i][j];
            }
            if (temp!=sum){
                return false;
            }
        }
        int temp=0;
        for (int i = 0; i < input[0].length; i++) { /*Checks the major diagonal */
            temp+=input[i][i];
        }
        if (temp!=sum){
            return false;
        }
        return true; /*Returns true if it doesn't fail elsewise */
    }
    public static int median(int[] input){
        for (int i = 0; i <input.length; i++) {
            int min=0;
            int max=0;
            for (int j = 0; j <input.length; j++) {
                if(input[i]>input[j]){
                    min++; /*counts the numbers less than i */
                }
                else if(input[i]<input[j]){
                    max++; /*counts the numbers more than i */
                }
            }
            if (min==max){ /*It's the median if there's the same amount of numbers above and below it */
                return input[i];
            }
        }
        return 0; /*I just put this here because the code flipped out at me if I didn't put something :) */
    }
}