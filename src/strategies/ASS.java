package strategies;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import endgame.EndGameProblem;
import heuristics.Heuristicable;
import search.Node;
import search.SearchStrategy;

public class ASS extends SearchStrategy {
    Heuristicable heuristic;

    public ASS(EndGameProblem problem, Heuristicable heuristic) {
        problem.setNodes(new PriorityQueue<Node>());
        this.heuristic = heuristic;
    }

    @Override
    public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {
        expandedNodes.forEach((expandedNode) -> expandedNode.setEstimate(heuristic.estimate(expandedNode.getState())));
        expandedNodes.forEach((expandedNode) -> nodes.add(expandedNode));
        return nodes;
    }

}