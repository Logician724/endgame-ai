package search;

public abstract class Operator {
	private int cost;

	public Operator(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

}
