import java.util.ArrayList;

public class Tally{
    private ArrayList<Ballot> breakfasts;
    private int[] counter;
    private int round=1;
    private ArrayList<String> ignore;
    private String winner;
    private int winnerNumber=0;
    String[] candidates=Ballot.getCandidateList();

    public Tally(ArrayList<Ballot> breakfasts){
        this.breakfasts=breakfasts;
        counter=new int[4];
        ignore=new ArrayList<>();
    }
    public void countNext(){
        ignore.add("");
        while(winner==null&&round<5){
            for(int i=0; i<breakfasts.size(); i++){
                String[] decisions=breakfasts.get(i).getVoteList();
                for (int j = 0; j < 4; j++) {
                    if (candidates[j].equals(decisions[round-1])&&ignore.indexOf(candidates[j])==-1){
                        counter[j]++;
                    }
                }
            }
            if(!isMajority()){ 
                round++;
            } 
            else{ 
                winner=candidates[winnerNumber]; 
            }
        }
    }
    public boolean isMajority(){
        int min=0;
        int max=0;
        for (int i = 1; i < 4; i++) {
            if(counter[i]<counter[min]){
                min=i;
            }
            if(counter[i]>counter[min]){
                max=i;
            }
        }
        if (candPercent(max)>50){
            winnerNumber=max;
            return true;
        }
        else{
            ignore.add(Ballot.getCandidateList()[min]);
            counter[min]=0;
            return false;
        }

    }
    public double candPercent(int a){
        if (a<0||a>3){
            return 0;
        }
        else{
            double tot=counter[0]+counter[1]+counter[2]+counter[3];
            return (100*counter[a]/tot);
        }
    }
    public int[] votesToNums(Ballot ex){
        String[] candidate=Ballot.getCandidateList();
        String[] choice=ex.getVoteList();
        int[] toRet= new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(candidate[i].equals(choice[j])){
                    toRet[j]=i;
                }
            }
        }
        return toRet;

    }

    
    public String toString(){
        if (winner==null){
            return "Sorry, votes haven't been tallied yet!";
        }
        else{
            String toRet="Winner: "+winner;
            toRet+="\nRounds: "+round;
            toRet+="\nPercent of votes: "+candPercent(winnerNumber);
            return toRet;
        }
    }


}