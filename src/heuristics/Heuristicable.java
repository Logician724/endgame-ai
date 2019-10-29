package heuristics;

import search.State;

public interface Heuristicable {
	public abstract int estimate(State currentState);
}