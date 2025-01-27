package section_10_generics.challenge;

public abstract class Player {

    private String name;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
