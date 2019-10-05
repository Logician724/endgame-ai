package endgame;

import java.util.ArrayList;

import cells.*;
import search.Node;
import search.Operator;
import search.Problem;
import search.State;
import java.awt.Point;
import operators.*;

public class EndGameProblem extends Problem {
	private Point mapDimensions;

	public EndGameProblem(Point ironManLoc, Point thanosLoc, ArrayList<Point> stonesLoc, ArrayList<Point> warriorsLoc,
			Point mapDimensions) {

		super(new EndGameState(ironManLoc, stonesLoc, warriorsLoc, thanosLoc),
				new Operator[] { new UpOperator(mapDimensions), new DownOperator(mapDimensions),
						new LeftOperator(mapDimensions), new RightOperator(mapDimensions), new CollectOperator(),
						new KillOperator(mapDimensions), new SnapOperator() });
		this.mapDimensions = mapDimensions;
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
		return ((EndGameState) currentState).getThanosLoc() == null ? true : false;
	}

	@Override
	public ArrayList<Node> expand(Node currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Point getMapDimensions() {
		return mapDimensions;
	}

	public Cell[][] constructMap(EndGameState state) {
		Cell[][] map = new Cell[mapDimensions.x][mapDimensions.y];

		for (int x = 0; x < map.length; x++)
			for (int y = 0; y < map[x].length; y++)
				map[x][y] = new EmptyCell(new Point(x, y));

		map[state.getIronManLoc().x][state.getIronManLoc().y] = new IronManCell(state.getIronManLoc());

		for (Point stoneLoc : state.getStonesLoc())
			map[stoneLoc.x][stoneLoc.y] = new StoneCell(stoneLoc);

		for (Point warriorLoc : state.getWarriorsLoc())
			map[warriorLoc.x][warriorLoc.y] = new WarriorCell(warriorLoc);

		map[state.getThanosLoc().x][state.getThanosLoc().y] = new IronManCell(state.getIronManLoc());

		return map;
	}
}
