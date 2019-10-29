package heuristics;

import search.State;
import endgame.EndGameState;

public class StonesHeuristic implements Heuristicable {

	@Override
	public int estimate(State currentState) {
		EndGameState currentEndGameState = (EndGameState) currentState;
		return (currentEndGameState.getStonesLoc().size() * 3);
	}

}