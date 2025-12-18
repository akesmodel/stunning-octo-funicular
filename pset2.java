import java.util.*;

public class pset2{
    public static void main(String[] args) {
        HashSet<String> fruits= new HashSet<>();
        fruits.add("watermelon");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("apple");
        System.out.println(maxLength(fruits));
        removeEvenLength(fruits);
        for(String word:fruits){
            System.out.println(word);
        }



        Map<Integer,String> trial=new HashMap<>();
        trial.put(6, "Abby");
        trial.put(22, "Hunter");
        trial.put(37, "Kesmodel");
        trial.put(1434, "Abby");
        Map<String, Integer> transformation=flip(trial);
        for(String item: transformation.keySet()){
            System.out.println(item+" "+transformation.get(item));
        }
         Map<String,Integer> hullo=new HashMap<>();
        hullo.put("Comp",1);
        hullo.put("Sci",4);
        hullo.put("Coding",3);
        hullo.put("Practice",4);
        hullo.put("Test",4);
        hullo.put("Run",3);
        hullo.put("Problem",5);
        hullo.put("Four",3);
        System.out.println(mostCommon(hullo));
    }
    public static int maxLength(HashSet<String> input){
        int toRet=0;
        for(String word:input){
            if (word.length()>toRet){
                toRet= word.length();
            }
        }
        return toRet;
    }
    public static void removeEvenLength(Set<String> input){
        Set<String> temp=new HashSet<>();
        for (String word:input) {
            if (word.length()%2==0){
                temp.add(word);
            }
        }
        input.removeAll(temp);
    }
    public static Map<String, Integer> flip(Map<Integer,String> input){
        Map<String,Integer> toRet=new HashMap<>();
        for(int item: input.keySet()){
            toRet.put(input.get(item),item);
        }
        return toRet;
    }
    public static int mostCommon(Map<String,Integer> input){
        int toRet=1;
        int toRetCount=0;
        Map<Integer,Integer> track= new HashMap<>();
        if (input==null){
        return -1;
       }
       for (String item : input.keySet()) {
            int value=input.get(item);
           if (track.containsKey(value)){
            track.put(value, track.get(value)+1);
           }
           else{
            track.put(value, 1);
           }
           if (track.get(value)>toRetCount){
            toRet=value;
            toRetCount=track.get(value);
           }
           else if (track.get(value)==toRetCount&&value<toRet){
            toRet=value;
            toRetCount=track.get(value);
           }
       }
       return toRet;
    }
}