package strategies;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import endgame.EndGameProblem;
import search.Node;
import search.SearchStrategy;

public class BFS extends SearchStrategy {

	public BFS(EndGameProblem problem) {
		problem.setNodes(new ArrayDeque<Node>());
	}

	@Override
	public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {
		expandedNodes.forEach((expandedNode) -> nodes.add(expandedNode));
		return nodes;
	}

}