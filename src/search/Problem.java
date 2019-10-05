package search;

import java.util.ArrayList;

public abstract class Problem {
	private State initialState;
	private Operator[] operators;
	private int expandedNodes;

	public abstract State transitionFunction(State currentState, Operator operator);

	public abstract int pathCost(State currentState, State nextState);

	public abstract boolean goalTest(State currentState);

	public abstract ArrayList<Node> expand(Node currentNode);

	public Node solveUsingSearch(SearchStrategy strategy) throws SolutionNotFoundException {

		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node(initialState));
		while (!nodes.isEmpty()) {
			Node currentNode = nodes.remove(0);
			if (goalTest(currentNode.getState())) {
				return currentNode;
			}
			nodes = strategy.execute(nodes, expand(currentNode));
			expandedNodes++;
		}
		throw new SolutionNotFoundException();
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public Operator[] getOperators() {
		return operators;
	}

	public void setOperators(Operator[] operators) {
		this.operators = operators;
	}
}
