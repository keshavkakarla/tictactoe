package tictactoe.domain;

public class User {
    
    private String name;
    private int[] stats;
    
    public User(String name) {
        this.name = name;
        this.stats = new int[2];
    }
    
    public String getName() {
        return name;
    }
    
    public void changeUsername(String name) {
        this.name = name;
    }
    
    public void updateStatistics(Stat stat) {
        stats[stat.getValue()]++;
    }
    
}