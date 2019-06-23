package section10.challenge;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    int played;
    int won;
    int lost;
    int tied;
    
    private ArrayList<T> members = new ArrayList<>();
    
    public Team(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<T> getMembers() {
        return members;
    }
    
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on the team.");
            return false;
        } else {
            System.out.println(player.getName() +  " picked for team " + name);
            return members.add(player);
        }
    }
    
    public int numPlayers() {
        return members.size();
    }
    
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        
        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played ++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }         
    }
    
    public int ranking() {
        return won * 2 + tied;
    }
    
    @Override
    public String toString() {
        return "[ name: " + name + 
                ", played: " + played + 
                ", won: " + won + 
                ", lost: " + lost + 
                ", tied: " + tied + 
                ", members: " + members +
                "]";
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
