package search;

import java.util.Queue;

import cells.Cell;
import cells.IronManCell;
import cells.IronManStoneCell;
import cells.IronManThanosCell;
import cells.StoneCell;
import cells.ThanosCell;
import cells.WarriorCell;
import endgame.EndGameProblem;
import endgame.EndGameState;
import operators.CollectOperator;
import operators.DownOperator;
import operators.KillOperator;
import operators.LeftOperator;
import operators.RightOperator;
import operators.SnapOperator;
import operators.UpOperator;

import java.util.ArrayList;
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
		Node currentNode = new Node(null);
		visitedStates.add(currentNode.getState());
		while (!nodes.isEmpty()) {
			currentNode = nodes.poll();
			if (goalTest(currentNode.getState()))
				return currentNode;

			LinkedList<Node> expandedNodes = expand(currentNode);
			Iterator<Node> iterator = expandedNodes.iterator();
			LinkedList<Node> notRepeatedExpandedNodes = new LinkedList<Node>();

			while (iterator.hasNext()) {
				Node expandedNode = iterator.next();

				if (!visitedStates.add(expandedNode.getState()))
					continue;

				notRepeatedExpandedNodes.add(expandedNode);
			}

			nodes = strategy.execute(nodes, notRepeatedExpandedNodes);
			expandedNodesCount++;
		}

		throw new SolutionNotFoundException();
	}

	public void reset() {
		visitedStates.clear();
		expandedNodesCount = -1;
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
