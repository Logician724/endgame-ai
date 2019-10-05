package search;

import java.util.ArrayList;

public abstract class Problem {
	private State initialState;
	private Node root;
	private ArrayList<State> visitedStates;
	private Operator[] operators;
	private int expandedNodesCount;

	public Problem(State initialState, Operator[] operators) {
		this.initialState = initialState;
		this.root = new Node(initialState);
		this.visitedStates = new ArrayList<State>();
		this.operators = operators;
		this.expandedNodesCount = 0;
	}

	public abstract State transitionFunction(State currentState, Operator operator);

	public abstract int pathCost(State currentState, State nextState);

	public abstract boolean goalTest(State currentState);

	public abstract ArrayList<Node> expand(Node currentNode);

	public Node solveUsingSearch(SearchStrategy strategy) throws SolutionNotFoundException {

		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node currentNode = nodes.remove(0);
			// Add the visited node to the visited nodes array to avoid state repetition
			visitedStates.add(currentNode.getState());
			if (goalTest(currentNode.getState())) {
				return currentNode;
			}
			nodes = strategy.execute(nodes, expand(currentNode));
			expandedNodesCount++;
		}
		throw new SolutionNotFoundException();
	}

	public State getInitialState() {
		return initialState;
	}

	public ArrayList<State> getVisitedStates() {
		return visitedStates;
	}

	public Operator[] getOperators() {
		return operators;
	}

	public void setOperators(Operator[] operators) {
		this.operators = operators;
	}

	public Node getRoot() {
		return root;
	}

	public int getExpandedNodesCount() {
		return expandedNodesCount;
	}

}
