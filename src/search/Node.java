package search;

public class Node {
	private State state;
	private Node parent;
	private int cost;
	private int depth;
	private Operator operator;

	public Node(State state, Node parent, Operator operator) {
		this.parent = parent;
		this.state = state;
		this.operator = operator;
		this.depth = parent == null ? 0 : parent.depth + 1;
		this.cost = parent.cost + operator.getCost();
	}

	public Node(State state) {
		this.parent = null;
		this.state = state;
		this.operator = null;
		this.depth = 0;
		this.cost = 0;
	}

	public State getState() {
		return state;
	}

	public Node getParent() {
		return parent;
	}

	public int getCost() {
		return cost;
	}

	public int getDepth() {
		return depth;
	}

}
