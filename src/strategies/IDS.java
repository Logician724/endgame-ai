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
		if (!expandedNodes.isEmpty() && expandedNodes.peek().getDepth() > depthSoFar)
			expandedNodes.clear();

		if (expandedNodes.isEmpty() && nodes.isEmpty()) {
			problem.reset();
			nodes.add(problem.getRoot());
			depthSoFar++;
		}

		return super.execute(nodes, expandedNodes);
	}
}