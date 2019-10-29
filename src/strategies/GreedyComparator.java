package strategies;

import java.util.Comparator;

import search.Node;

public class GreedyComparator implements Comparator<Node> {

	@Override
	public int compare(Node currentNode, Node otherNode) {

		return currentNode.getEstimate() - otherNode.getEstimate();
	}

}