package endgame;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.TooMuchDamageException;
import search.State;

public class EndGameState extends State {
	private Point ironManLoc;
	private int ironManDamage;
	private static final int maxDamage = 100;
	private ArrayList<Point> stonesLoc;
	private boolean isThanosDead;

	public EndGameState(Point ironManLoc, ArrayList<Point> stonesLoc) {
		this.ironManLoc = ironManLoc;
		this.ironManDamage = 0;
		this.stonesLoc = stonesLoc;
		this.isThanosDead = false;
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

	public int getIronManDamage() {
		return ironManDamage;
	}

	public boolean isThanosDead() {
		return isThanosDead;
	}

	public void killThanos() {
		this.isThanosDead = true;
	}

}