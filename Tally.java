import java.util.ArrayList; /*Imports ArrayLists */

public class Tally{
    /*Attributes--there's a lot, I'll walk you through the ones I added.*/
    
    private ArrayList<Ballot> breakfasts; 
    private int[] counter;
    private int round=1; /*Keeps track of what round we're on to be returned for the toString*/
    private ArrayList<String> ignore; /*Each candidate to ignore */
    private String winner; /*The winner to be returned */
    private int winnerNumber=0; /*Which index on the candidate list each winner is */
    String[] candidates=Ballot.getCandidateList(); /*statically calls the candidate list */

    /*Constructor */
    public Tally(ArrayList<Ballot> breakfasts){ 
        /*Instantiating breakfasts, counter, and ignore */
        this.breakfasts=breakfasts;
        counter=new int[4];
        ignore=new ArrayList<>(); 
    }
    /*Counts the votes and returns winner */
    public void countNext(){
        while(winner==null&&round<5){ /*will keep repeating until a winner is reached */
            for(int i=0; i<breakfasts.size(); i++){ /*repeats the count for every voter */
                String[] decisions=breakfasts.get(i).getVoteList(); /*pulls up the voter's list */
                for (int j = 0; j < 4; j++) { /*repeats for each candidate: */
                    /*if the candidate matches the voter's ballot for that round and the candidate is not being ignored */
                    if (candidates[j].equals(decisions[round-1])&&ignore.indexOf(candidates[j])==-1){
                        /*add their vote to the tally at the corresponding number */
                        counter[j]++;
                    }
                }
            }
            if(!isMajority()){ /*If there isn't a majority, increase the round and the loop runs again*/
                round++;
            } 
            else{ /*Otherwise save the winner's name based on the winning number established by running isMajority */
                winner=candidates[winnerNumber]; 
            }
        }
    }
    public boolean isMajority(){ /*Determines majority, reacts accordingly */
        int min=0;
        int max=0;
        for (int i = 1; i < 4; i++) {
            if(counter[i]<counter[min]){ /*Updates minimum */
                min=i; 
            }
            if(counter[i]>counter[min]){ /*Updates maximum */
                max=i;
            }
        }
        if (candPercent(max)>50){ /*If there is a majority, save the winners number and return true */
            winnerNumber=max;
            return true;
        }
        else{ /*Else, add min to list of people to ignore, delete all votes for the min, and return false */
            ignore.add(Ballot.getCandidateList()[min]);
            counter[min]=0;
            return false;
        }

    }
    public double candPercent(int a){
        if (a<0||a>3){
            return 0; /*Never will actually run, but needs to return something, so I put that there so the code wouldn't scream at me :) */
        }
        else{
            double tot=counter[0]+counter[1]+counter[2]+counter[3]; /*Total number of active votes */
            return (100*counter[a]/tot); /*Percent of votes for candidate a */
        }
    }
    public String toString(){ /*Returns the results of the election */
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