package endgame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

import search.State;

public class EndGameState extends State {
	private Point ironManLoc;
	private HashSet<Point> stonesLoc;
	private HashSet<Point> warriorsLoc;
	private Point thanosLoc;

	public EndGameState(Point ironManLoc, HashSet<Point> stonesLoc, HashSet<Point> warriorsLoc, Point thanosLoc) {
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

	public HashSet<Point> getStonesLoc() {
		return stonesLoc;
	}

	public HashSet<Point> getWarriorsLoc() {
		return warriorsLoc;
	}

	public Point getThanosLoc() {
		return thanosLoc;
	}

	public void killThanos() {
		this.thanosLoc = null;
	}

	public boolean isRepeated(HashSet<State> visitedStates) {
		return visitedStates.contains(this);
	}

	@Override
	public boolean equals(Object otherState) {
		EndGameState targetState = (EndGameState) otherState;

		return this.ironManLoc.equals(targetState.getIronManLoc())
				&& this.getStonesLoc().size() == targetState.getStonesLoc().size()
				&& this.getWarriorsLoc().size() == targetState.getWarriorsLoc().size()
				&& ArePointsIdentical(this.getStonesLoc(), targetState.getStonesLoc())
				&& ArePointsIdentical(this.getWarriorsLoc(), targetState.getWarriorsLoc())
				&& targetState.getThanosLoc() != null && this.getThanosLoc() != null;
	}

	private static boolean ArePointsIdentical(HashSet<Point> currentPoints, HashSet<Point> targetPoints) {
		for (Point currentPoint : currentPoints) {
			if (!targetPoints.contains(currentPoint)) {
				return false;
			}
		}
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public EndGameState clone() throws NullPointerException {
		Point newIronManLoc = new Point(ironManLoc.x, ironManLoc.y);

		HashSet<Point> newStonesLoc = (HashSet<Point>) this.stonesLoc.clone();

		HashSet<Point> newWarriorsLoc = (HashSet<Point>) this.warriorsLoc.clone();

		Point newThanosLoc = new Point(thanosLoc.x, thanosLoc.y);

		return new EndGameState(newIronManLoc, newStonesLoc, newWarriorsLoc, newThanosLoc);
	}

}