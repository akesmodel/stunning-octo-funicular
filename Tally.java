import java.util.ArrayList;

public class Tally{
    private ArrayList<Ballot> breakfasts;
    private int[] counter;
    private int round=1;
    private ArrayList<String> ignore;
    private String winner;

    public Tally(ArrayList<Ballot> breakfasts){
        breakfasts=this.breakfasts;
        counter=new int[4];
    }
    public void countNext(){
        for(int i=0; i<breakfasts.size(); i++){
            String[] temp=breakfasts.get(i).getVoteList();
            String[] candidates=Ballot.getCandidateList();
            for (int j = 0; i < 4; j++) {
                if(temp[round-1].equals(candidates[j])&&ignore.indexOf(candidates[j])==-1){
                    counter[j]++;
                }
            }
        }
        if(!isMajority()){
            round++;
        }
    }
    public boolean isMajority(){
        int min=0;
        int max=0;
        int tot=counter[0]+counter[1]+counter[2]+counter[3];
        for (int i = 1; i < 4; i++) {
            if(counter[i]<counter[min]){
                min=i;
            }
            if(counter[i]>counter[min]){
                max=i;
            }
        }
        if (max/(double)tot>1/2){
            winner=Ballot.getCandidateList()[max];
            return true;
        }
        else{
            ignore.add(Ballot.getCandidateList()[min]);
            return false;
        }

    }

    
    public String toString(){
        String toRet="Winner: "+winner;
        toRet+="\nRounds: "+round;
        int tot=counter[0]+counter[1]+counter[2]+counter[3];
        toRet+="Percentage: "+(/(double)tot);
        return toRet;
    }


}