package tictactoe.domain;

public enum Stat {
    
    STAT_WIN(0), STAT_LOSS(1);
    
    private final int id;
    Stat(int id) { this.id = id; }
    public int getValue() { return id; }
    
}