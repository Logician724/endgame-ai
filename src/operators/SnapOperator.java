package operators;

import endgame.EndGameState;
import search.Operator;
import search.State;

public class SnapOperator extends Operator {

	@Override
	public EndGameState transition(State currentState) {
		EndGameState nextState = ((EndGameState) currentState).clone();

		if (!nextState.getIronManLoc().equals(nextState.getThanosLoc()) || nextState.getStonesLoc().size() != 0)
			return null;

		nextState.killThanos();

		return nextState;
	}

}