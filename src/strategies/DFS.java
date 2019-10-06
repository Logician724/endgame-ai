package strategies;

import java.util.ArrayList;
import java.util.ListIterator;

import search.Node;
import search.SearchStrategy;

public class DFS extends SearchStrategy {

    @Override
    public ArrayList<Node> execute(ArrayList<Node> nodes, ArrayList<Node> expandedNodes) {
        ListIterator<Node> iterator = expandedNodes.listIterator(expandedNodes.size());
        while (iterator.hasPrevious()) {
            Node expandedNode = iterator.previous();
            nodes.add(0, expandedNode);
        }
        return expandedNodes;
    }

}