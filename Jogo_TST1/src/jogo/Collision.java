package jogo;

@FunctionalInterface

public interface Collision {
    
    public abstract void on(int[] something, int direction);
    
}
