import java.util.ArrayList;
import java.util.Arrays;

public class pset0{
    public static void main(String[] args) {
        int[] example={14, -34, 6, 7, -4, 1, 2};
        System.out.println(countInRange(example, 1, 20));
        ArrayList<String> clumpers= new ArrayList<>(Arrays.asList("sign", "up", "for","math","team"));
        clump(clumpers);
        System.out.println(clumpers);
        int[][] magic={{2,7,6},{9,5,1},{4,3,8}};
        System.out.println(isMagicSquare(magic));
        System.out.println(median(example));
    }
    public static int countInRange(int[] x, int a, int b){
        int toRet=0;
        for (int i=0; i<x.length; i++){
            if (x[i]>=a&&x[i]<=b){
                toRet++;
            }
        }
        return toRet;
    }
    public static void clump(ArrayList<String> input){
        int a=input.size();
        for (int i=a-(a%2)-1; i>0; i-=2){
            String temp=input.get(i-1);
            temp+=" "+input.get(i);
            input.set(i-1,temp);
            input.remove(i);
        }
        
    }
    public static boolean isMagicSquare(int[][] input){
        int sum=0;
        for (int i = 0; i < input[0].length; i++) {
            sum+=input[0][i];
        }
        for (int i = 1; i < input[0].length; i++) {
            int temp=0;
            for (int j = 0; j < input[0].length; j++) {
                temp+=input[i][j];
            }
            if (temp!=sum){
                return false;
            }
        }
        for (int j = 0; j < input[0].length; j++) {
            int temp=0;
            for (int i = 0; i < input[0].length; i++) {
                temp+=input[i][j];
            }
            if (temp!=sum){
                return false;
            }
        }
        int temp=0;
        for (int i = 0; i < input[0].length; i++) {
            temp+=input[i][i];
        }
        if (temp!=sum){
            return false;
        }
        return true;
    }
    public static int median(int[] input){
        for (int i = 0; i <input.length; i++) {
            int min=0;
            int max=0;
            for (int j = 0; j <input.length; j++) {
                if(input[i]>input[j]){
                    min++;
                }
                else if(input[i]<input[j]){
                    max++;
                }
            }
            if (min==max){
                return input[i];
            }
        }
        return 0;
    }
}