package endgame;

import java.util.ArrayList;

import cells.Cell;
import search.Node;
import search.Operator;
import search.Problem;
import search.State;
import java.awt.Point;

public class EndGameProblem extends Problem {
	private Cell[][] map;

	public EndGameProblem(Point ironManLoc, ArrayList<Point> stonesLoc, Cell[][] map) {
		super.setInitialState(new EndGameState(ironManLoc, stonesLoc));
		this.map = map;
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

	public Cell[][] getMap() {
		return map;
	}
}
