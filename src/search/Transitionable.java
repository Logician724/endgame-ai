package search;

public interface Transitionable {
	public abstract State transition(State currentState);
}