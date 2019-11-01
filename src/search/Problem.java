package search;

import java.util.Queue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Problem {
	private State initialState;
	private Node root;
	private HashSet<State> visitedStates;
	private Operator[] operators;
	private int expandedNodesCount;
	private Queue<Node> nodes;

	public Problem(State initialState, Operator[] operators) {
		this.initialState = initialState;
		this.root = new Node(initialState);
		this.visitedStates = new HashSet<State>();
		this.operators = operators;
		this.expandedNodesCount = 0;
	}

	public abstract int pathCost(Node currentNode, State nextState, Operator operator);

	public abstract boolean goalTest(State currentState);

	public abstract LinkedList<Node> expand(Node currentNode);

	public Node solveUsingSearch(SearchStrategy strategy) throws SolutionNotFoundException {
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node currentNode = nodes.poll();
			if(visitedStates.add(currentNode.getState())) {
				if (goalTest(currentNode.getState()))
					return currentNode;
				nodes = strategy.execute(nodes, expand(currentNode));
				expandedNodesCount++;
			}else {
				nodes = strategy.execute(nodes, new LinkedList<Node>());
			}
		}

		throw new SolutionNotFoundException();
	}

	public void reset() {
		visitedStates.clear();
		nodes.clear();
	}

	public State getInitialState() {
		return initialState;
	}

	public HashSet<State> getVisitedStates() {
		return visitedStates;
	}

	public Operator[] getOperators() {
		return operators;
	}

	public Node getRoot() {
		return root;
	}

	public int getExpandedNodesCount() {
		return expandedNodesCount;
	}

	public Queue<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Queue<Node> nodes) {
		this.nodes = nodes;
	}
}
