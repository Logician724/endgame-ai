package endgame;

import java.util.ArrayList;

import search.Node;
import search.Operator;
import search.Problem;
import search.State;

public class EndGameProblem extends Problem {

	public EndGameProblem(EndGameState initialState) {
		super.setInitialState(initialState);
	}

	@Override
	public State transitionFunction(State currentState, Operator operator) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int pathCost(State currentState, State nextState) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean goalTest(State currentState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Node> expand(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

}
