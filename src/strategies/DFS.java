package strategies;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

import endgame.EndGameProblem;
import search.Node;
import search.SearchStrategy;

public class DFS extends SearchStrategy {
	public DFS(EndGameProblem problem) {
		problem.setNodes(new ArrayDeque<Node>());
	}

	@Override
	public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {

		ListIterator<Node> iterator = expandedNodes.listIterator(expandedNodes.size());
		while (iterator.hasPrevious()) {
			Node expandedNode = iterator.previous();
			((ArrayDeque<Node>) nodes).addFirst(expandedNode);
		}
		return nodes;
	}

}