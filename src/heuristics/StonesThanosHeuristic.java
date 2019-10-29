package heuristics;

import search.State;
import endgame.EndGameState;

public class StonesThanosHeuristic implements Heuristicable {

	@Override
	public int estimate(State currentState) {
		EndGameState currentEndGameState = ((EndGameState) currentState);

		int estimate = (currentEndGameState.getStonesLoc().size() * 3);
		if (currentEndGameState.getThanosLoc() == null) {
			return estimate;
		}
		// Add the damage occuring from Thanos's attack once on iron man
		return estimate + 5;
	}

}