package endgame;

import java.awt.Point;
import java.util.ArrayList;

import search.State;
import search.Node;
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

	public boolean isStateRepeated(ArrayList<Node> visitedNodes) {
		for (Node currentNode : visitedNodes)
			if (this.equals(currentNode))
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

}