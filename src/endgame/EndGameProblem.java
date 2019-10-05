package endgame;

import java.util.ArrayList;

import cells.Cell;
import cells.EmptyCell;
import cells.IronManCell;
import cells.StoneCell;
import search.Node;
import search.Operator;
import search.Problem;
import search.State;
import java.awt.Point;

public class EndGameProblem extends Problem {
	private Cell[][] map;

	public EndGameProblem(Point ironManLoc, Point thanosLoc, ArrayList<Point> stonesLoc, ArrayList<Point> warriorsLoc,
			Cell[][] map) {
		super.setInitialState(new EndGameState(ironManLoc, stonesLoc, warriorsLoc, thanosLoc));
		constructMap((EndGameState) super.getInitialState());
	}

	@Override
	public State transitionFunction(State currentState, Operator operator) {

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

	public void constructMap(EndGameState state) {
		for (int x = 0; x < map.length; x++)
			for (int y = 0; y < map[x].length; y++)
				this.map[x][y] = new EmptyCell(new Point(x, y));

		this.map[state.getIronManLoc().x][state.getIronManLoc().y] = new IronManCell(state.getIronManLoc());

		for (Point stoneLoc : state.getStonesLoc())
			this.map[stoneLoc.x][stoneLoc.y] = new StoneCell(stoneLoc);

		for (Point warriorLoc : state.getWarriorsLoc())
			this.map[warriorLoc.x][warriorLoc.y] = new StoneCell(warriorLoc);

		this.map[state.getThanosLoc().x][state.getThanosLoc().y] = new IronManCell(state.getIronManLoc());
	}
}
