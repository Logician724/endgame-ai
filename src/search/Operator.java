package search;

import java.awt.Point;

public abstract class Operator implements Transitionable {
	private Point mapDimensions;

	public Operator() {

	}

	public Operator(Point mapDimensions) {
		this.mapDimensions = mapDimensions;
	}

	public Operator(int cost) {
		this.mapDimensions = null;
	}

	public Point getMapDimensions() {
		return mapDimensions;
	}

}
