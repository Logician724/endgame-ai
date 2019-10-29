package operators;

import search.State;

import endgame.EndGameState;
import search.Operator;

public class CollectOperator extends Operator {

	@Override
	public EndGameState transition(State currentState) {
		EndGameState nextState = ((EndGameState) currentState).clone();

		if (!nextState.getStonesLoc().contains(nextState.getIronManLoc()))
			return null;

		nextState.getStonesLoc().remove(nextState.getIronManLoc());

		return nextState;
	}

}