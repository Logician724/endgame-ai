package strategies;

import java.util.ArrayList;

import search.Node;
import search.SearchStrategy;

public class BFS extends SearchStrategy {

    @Override
    public ArrayList<Node> execute(ArrayList<Node> nodes, ArrayList<Node> expandedNodes) {
        expandedNodes.forEach((expandedNode) -> nodes.add(expandedNode));
        return expandedNodes;
    }

}