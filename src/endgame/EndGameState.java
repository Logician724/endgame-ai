package endgame;

import java.awt.Point;
import java.util.ArrayList;

import search.State;

public class EndGameState extends State {
	private Point ironManLoc;
	private ArrayList<Point> stonesLoc;
	private ArrayList<Point> warriorsLoc;
	private Point thanosLoc;

	public EndGameState(Point ironManLoc, ArrayList<Point> stonesLoc, ArrayList<Point> warriorsLoc, Point thanosLoc) {
		this.ironManLoc = ironManLoc;
		this.stonesLoc = stonesLoc;
		this.warriorsLoc = warriorsLoc;
		this.thanosLoc = thanosLoc;
	}

	public void pickUpStone(Point stoneLoc) {
		for (Point currentLoc : stonesLoc) {
			if (currentLoc.equals(stoneLoc)) {
				stonesLoc.remove(currentLoc);
			}
		}
	}

	public Point getIronManLoc() {
		return ironManLoc;
	}

	public void setIronManLoc(Point ironManLoc) {
		this.ironManLoc = ironManLoc;
	}

	public ArrayList<Point> getStonesLoc() {
		return stonesLoc;
	}

	public ArrayList<Point> getWarriorsLoc() {
		return warriorsLoc;
	}

	public Point getThanosLoc() {
		return thanosLoc;
	}

	public void killThanos() {
		this.thanosLoc = null;
	}

	public boolean isRepeated(ArrayList<State> visitedStates) {
		for (State currentState : visitedStates)
			if (this.equals(currentState))
				return true;

		return false;
	}

	@Override
	public boolean equals(Object otherState) {
		EndGameState targetState = (EndGameState) otherState;

		return this.ironManLoc.equals(targetState.getIronManLoc())
				&& this.stonesLoc.size() == targetState.getStonesLoc().size()
				&& this.warriorsLoc.size() == targetState.getWarriorsLoc().size()
				&& this.thanosLoc != null
				&& targetState.getThanosLoc() != null
				&& this.thanosLoc.equals(targetState.getThanosLoc());

	}

	@Override
	public EndGameState clone() throws NullPointerException {
		Point newIronManLoc = new Point(ironManLoc.x, ironManLoc.y);

		ArrayList<Point> newStonesLoc = new ArrayList<Point>();
		this.stonesLoc.forEach((stoneLoc) -> newStonesLoc.add(new Point(stoneLoc.x, stoneLoc.y)));

		ArrayList<Point> newWarriorsLoc = new ArrayList<Point>();
		this.warriorsLoc.forEach((warriorLoc) -> newWarriorsLoc.add(new Point(warriorLoc.x, warriorLoc.y)));

		Point newThanosLoc = new Point(thanosLoc.x, thanosLoc.y);

		return new EndGameState(newIronManLoc, newStonesLoc, newWarriorsLoc, newThanosLoc);
	}

}