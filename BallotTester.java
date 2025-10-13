import java.util.ArrayList;

public class BallotTester{
    public static void main(String[] args){
        Ballot vote1= new Ballot("Waffles", "French Toast", "Crepes", "Pancakes");
        System.out.println(vote1.toString());
        Ballot vote2= new Ballot("Waffles", "French Toast", "Pancakes", "Crepes");
        Ballot vote3= new Ballot("Pancakes", "French Toast", "Waffles", "Crepes");
        Ballot vote4= new Ballot("French Toast", "Crepes", "Pancakes", "Waffles");
        Ballot vote5= new Ballot();
        vote5.castVote();
        ArrayList<Ballot> hold=new ArrayList<Ballot>();
        hold.add(vote1);
        hold.add(vote2);
        hold.add(vote3);
        hold.add(vote4);
        hold.add(vote5);
        Tally election=new Tally(hold);
        System.out.println(election);
        election.countNext();
        System.out.println(election);
    }
}