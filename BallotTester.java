import java.util.ArrayList;

public class BallotTester{
    public static void main(String[] args){
        Ballot vote1= new Ballot("Waffles", "French Toast", "Crepes", "Pancakes");
        System.out.println(vote1.toString()); /*Prints out choices of vote1 */
        Ballot vote2= new Ballot("Waffles", "French Toast", "Pancakes", "Crepes");
        Ballot vote3= new Ballot("Pancakes", "French Toast", "Waffles", "Crepes");
        Ballot vote4= new Ballot("French Toast", "Crepes", "Pancakes", "Waffles");
        Ballot vote5= new Ballot(); /*No arg constructor */
        vote5.castVote(); /*User inputs their picks */
        
        ArrayList<Ballot> hold=new ArrayList<Ballot>();
        hold.add(vote1);
        hold.add(vote2);
        hold.add(vote3);
        hold.add(vote4);
        hold.add(vote5);
        /*Creates an ArrayList of the Ballots we created */

        Tally election=new Tally(hold) /*Creates an election object, initializes */;
        System.out.println(election); /*Prints the results before the election takes place */
        election.countNext(); /*Runs elections */
        System.out.println(election); /*Should return results of the election */
    }
}