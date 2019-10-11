package strategies;

import java.util.LinkedList;
import java.util.Queue;

import endgame.EndGameProblem;
import search.Node;
import search.Problem;

public class IDS extends DFS {
    private Problem problem;
    private int depthSoFar = 0;

    public IDS(EndGameProblem problem) {
        super(problem);
        this.problem = problem;
    }

    @Override
    public Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes) {

        if (expandedNodes.size() > 0 && expandedNodes.peek().getDepth() > depthSoFar)
            expandedNodes.clear();

        if (expandedNodes.size() > 0 && nodes.size() == 0) {
            nodes.add(problem.getRoot());
            depthSoFar++;

            return nodes;
        }

        return super.execute(nodes, expandedNodes);
    }
}