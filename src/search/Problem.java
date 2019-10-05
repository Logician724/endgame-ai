package search;

import java.util.ArrayList;

public abstract class Problem {
	private State initialState;
	private Node root;
	private ArrayList<Node> visitedNodes;
	private Operator[] operators;
	private int expandedNodes;

	public abstract State transitionFunction(State currentState, Operator operator);

	public abstract int pathCost(State currentState, State nextState);

	public abstract boolean goalTest(State currentState);

	public abstract ArrayList<Node> expand(Node currentNode);

	public Node solveUsingSearch(SearchStrategy strategy) throws SolutionNotFoundException {

		ArrayList<Node> nodes = new ArrayList<Node>();
		Node root = new Node(initialState);
		this.root = root;
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node currentNode = nodes.remove(0);
			// Add the visited node to the visited nodes array to avoid state repetition
			visitedNodes.add(currentNode);
			if (goalTest(currentNode.getState())) {
				return currentNode;
			}
			nodes = strategy.execute(nodes, expand(currentNode));
			expandedNodes++;
		}
		throw new SolutionNotFoundException();
	}

	public State getInitialState() {
		return this.initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public ArrayList<Node> getVisitedNodes() {
		return this.visitedNodes;
	}

	public Operator[] getOperators() {
		return this.operators;
	}

	public void setOperators(Operator[] operators) {
		this.operators = operators;
	}
}
