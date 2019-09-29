package search;

import java.util.ArrayList;

public abstract class SearchStrategy {
	public abstract ArrayList<Node> execute(ArrayList<Node> nodes, ArrayList<Node> expandedNodes);
}
