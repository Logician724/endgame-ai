package strategies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import endgame.EndGameProblem;
import search.Node;
import search.SearchStrategy;

public class UCS extends SearchStrategy {
    public UCS(EndGameProblem problem) {
        problem.setNodes(new PriorityQueue<Node>());
    }

    @Override
    public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {
        expandedNodes.forEach((expandedNode) -> nodes.add(expandedNode));
        return nodes;
    }

}