package strategies;

import java.util.ArrayList;
import java.util.Iterator;

import search.Node;
import search.SearchStrategy;

public class UCS extends SearchStrategy {

    @Override
    public ArrayList<Node> execute(ArrayList<Node> nodes, ArrayList<Node> expandedNodes) {
    	Iterator<Node> iterator = expandedNodes.iterator();
    	while(iterator.hasNext()) {
            Node expandedNode = iterator.next();
    		if(nodes.isEmpty()) {
    			nodes.add(expandedNode);
    		}else {
    			// If there are items in the nodes list insert the expanded nodes in order
    			for (int i = 0; i < nodes.size(); i++) {
                    if (nodes.get(i).compareTo(expandedNode) > 0) {
                        nodes.add(i, expandedNode);
                        break;
                    }
                }
    		}
        }
    	System.out.println(nodes.size());
        return nodes;
    }

}