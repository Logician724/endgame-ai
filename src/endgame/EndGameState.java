package endgame;

import java.awt.Point;
import java.util.ArrayList;

import search.State;
import exceptions.TooMuchDamageException;

public class EndGameState extends State {
	private Point ironManLoc;
	private int ironManDamage;
	private static final int maxDamage = 100;
	private ArrayList<Point> stonesLoc;
	private ArrayList<Point> warriorsLoc;
	private Point thanosLoc;

	public EndGameState(Point ironManLoc, ArrayList<Point> stonesLoc, ArrayList<Point> warriorsLoc, Point thanosLoc) {
		this.ironManLoc = ironManLoc;
		this.ironManDamage = 0;
		this.stonesLoc = stonesLoc;
		this.warriorsLoc = warriorsLoc;
		this.thanosLoc = thanosLoc;
	}

	private EndGameState(Point ironManLoc, int ironManDamage, ArrayList<Point> stonesLoc, ArrayList<Point> warriorsLoc,
			Point thanosLoc) {
		this(ironManLoc, stonesLoc, warriorsLoc, thanosLoc);
		this.ironManDamage = ironManDamage;
	}

	public void pickUpStone(Point stoneLoc) {
		for (Point currentLoc : stonesLoc) {
			if (currentLoc.equals(stoneLoc)) {
				stonesLoc.remove(currentLoc);
			}
		}
	}

	public void addDamage(int damage) throws TooMuchDamageException {
		this.ironManDamage += damage;

		if (this.ironManDamage >= maxDamage)
			throw new TooMuchDamageException();
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

	public int getIronManDamage() {
		return ironManDamage;
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

	public boolean isStateRepeated(ArrayList<State> visitedStates) {
		for (State currentState : visitedStates)
			if (this.equals(currentState))
				return true;

		return false;
	}

	@Override
	public boolean equals(Object otherState) {
		EndGameState targetState = (EndGameState) otherState;

		return this.ironManLoc.equals(targetState.getIronManLoc())
				&& this.ironManDamage == targetState.getIronManDamage()
				&& this.stonesLoc.size() == targetState.getStonesLoc().size()
				&& this.warriorsLoc.size() == targetState.getWarriorsLoc().size()
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

		return new EndGameState(newIronManLoc, ironManDamage, newStonesLoc, newWarriorsLoc, newThanosLoc);
	}

}