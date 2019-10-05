package operators;

import search.Operator;
import java.awt.Point;
import endgame.EndGameState;

public class KillOperator extends Operator implements Transitionable {

    public KillOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) {
        EndGameState nextState = currentState.clone();
        /*
         * Kill all warriors in the east, west, north, and south of iron man if they
         * exist
         */

        if (currentState.getWarriorsLoc()
                .contains(new Point(currentState.getIronManLoc().x - 1, currentState.getIronManLoc().y)))
            nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x - 1, nextState.getIronManLoc().y));

        if (currentState.getWarriorsLoc()
                .contains(new Point(currentState.getIronManLoc().x + 1, currentState.getIronManLoc().y)))
            nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x + 1, nextState.getIronManLoc().y));

        if (currentState.getWarriorsLoc()
                .contains(new Point(currentState.getIronManLoc().x, currentState.getIronManLoc().y - 1)))
            nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y - 1));

        if (currentState.getWarriorsLoc()
                .contains(new Point(currentState.getIronManLoc().x, currentState.getIronManLoc().y + 1)))
            nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y + 1));

        return nextState;
    }

}