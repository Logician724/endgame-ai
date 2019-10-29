package strategies;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import endgame.EndGameProblem;
import heuristics.Heuristicable;
import search.Node;
import search.SearchStrategy;

public class GRS extends SearchStrategy {
	Heuristicable heuristic;

	public GRS(EndGameProblem problem, Heuristicable heuristic) {
		problem.setNodes(new PriorityQueue<Node>(new GreedyComparator()));
		this.heuristic = heuristic;
	}

	@Override
	public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {
		expandedNodes.forEach((expandedNode) -> expandedNode.setEstimate(heuristic.estimate(expandedNode.getState())));
		expandedNodes.forEach((expandedNode) -> nodes.add(expandedNode));
		return nodes;
	}

}