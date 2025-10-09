import java.util.Scanner;

public class Ballot{
    String[] cands={"Pancakes","Waffles","French Toast","Crepes"};
    private String[] votes;
    public Ballot(){
        votes=new String[4];
    }
    public Ballot(String a, String b, String c, String d){
        votes[0]=a;
        votes[1]=b;
        votes[2]=c;
        votes[3]=d;
    }

    public void castVote(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("First choice candidate:");
        votes[0]=scanner.next();
        System.out.println("Second choice candidate:");
        while (scanner.next().equals(votes[0])){
            System.out.println("You can't vote for the same person twice. Try again.");
        }
        votes[1]=scanner.next();
        System.out.println("Third choice candidate:");
        while (scanner.next().equals(votes[0])||scanner.next().equals(votes[1])){
            System.out.println("You can't vote for the same person twice. Try again.");
        }
        votes[2]=scanner.next();
        System.out.println("Fourth choice candidate:");
        while (scanner.next().equals(votes[0])||scanner.next().equals(votes[1])||scanner.next().equals(votes[2])){
            System.out.println("You can't vote for the same person twice. Try again.");
        }
        votes[3]=scanner.next();
        
    }

    public String[] getVoteList(){
        return votes;
    }
    public String[] getCandidateList(){
        return cands;
    }
    public String toString(){
        String toRet="First choice: "+votes[0];
        toRet+="\n Second choice: "+votes[1];
        toRet+="\n Third choice: "+votes[2];
        toRet+="\n Fourth choice: "+votes[3];
        return toRet;
    }
}