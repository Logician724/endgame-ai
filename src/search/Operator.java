package search;

import java.awt.Point;

public abstract class Operator {
	private int cost;
	private Point mapDimensions;

	public Operator(int cost, Point mapDimensions) {
		this.cost = cost;
		this.mapDimensions = mapDimensions;
	}

	public Operator(int cost) {
		this.cost = cost;
		this.mapDimensions = null;
	}

	public int getCost() {
		return cost;
	}

	public Point getMapDimensions() {
		return mapDimensions;
	}

}
