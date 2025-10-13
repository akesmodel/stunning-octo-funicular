import java.util.Scanner;

public class Ballot{
    private static String[] cands={"Pancakes","Waffles","French Toast","Crepes"};
    private String[] votes;
    public Ballot(){
        votes=new String[4];
    }
    public Ballot(String a, String b, String c, String d){
        String[] votes={a,b,c,d};
        this.votes=votes;
    }

    public void castVote(){
        Scanner scanner= new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Choice "+ (i+1)+": Pancakes [A], Waffles [B], French Toast [C], or Crepes [D]?"); 
            char c =scanner.next().charAt(0);
            if (c=='A'){
                votes[i]="Pancakes";
            }
            else if (c=='B'){
                votes[i]="Waffles";
            }
            else if (c=='C'){
                votes[i]="French Toast";
            }
            else if (c=='D'){
                votes[i]="Crepes";
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                if (votes[i].equals(votes[j])){
                    System.out.println("Please only choose each candidate once. Try again.");
                    castVote();
                }
            }
        }
    }

    public String[] getVoteList(){
        return votes;
    }
    public static String[] getCandidateList(){
        return cands;
    }
    public String toString(){
        String toRet="First choice: "+votes[0];
        toRet+="\nSecond choice: "+votes[1];
        toRet+="\nThird choice: "+votes[2];
        toRet+="\nFourth choice: "+votes[3];
        return toRet;
    }
}