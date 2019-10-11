package search;

public interface Heuristicable {
    public abstract State estimate(State currentState);
}