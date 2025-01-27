package section_10_generics.challenge;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    public String name;
    private ArrayList<T> league = new ArrayList<>();
    
    public League(String name) {
        this.name = name;
    }
    
    public boolean add(T team) {
        if (league.contains(team)) {
            return false;
        }
        
        return league.add(team);        
    }
    
    public void showLeagueTable() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    } 
    
}
