package endgame;

import java.awt.Point;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ironManLoc == null) ? 0 : ironManLoc.hashCode());
		result = prime * result + ((stonesLoc == null) ? 0 : stonesLoc.hashCode());
		result = prime * result + ((thanosLoc == null) ? 0 : thanosLoc.hashCode());
		result = prime * result + ((warriorsLoc == null) ? 0 : warriorsLoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EndGameState other = (EndGameState) obj;
		if (ironManLoc == null) {
			if (other.ironManLoc != null)
				return false;
		} else if (!ironManLoc.equals(other.ironManLoc))
			return false;
		if (stonesLoc == null) {
			if (other.stonesLoc != null)
				return false;
		} else if (!stonesLoc.equals(other.stonesLoc))
			return false;
		if (thanosLoc == null) {
			if (other.thanosLoc != null)
				return false;
		} else if (!thanosLoc.equals(other.thanosLoc))
			return false;
		if (warriorsLoc == null) {
			if (other.warriorsLoc != null)
				return false;
		} else if (!warriorsLoc.equals(other.warriorsLoc))
			return false;
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