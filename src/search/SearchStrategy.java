package search;

import java.util.LinkedList;
import java.util.Queue;

public abstract class SearchStrategy {
	public abstract Queue<Node> execute(Queue<Node> nodes, LinkedList<Node> expandedNodes);
}
