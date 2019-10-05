package operators;

import search.Operator;
import java.awt.Point;
import java.util.ArrayList;

import endgame.EndGameState;

public class KillOperator extends Operator implements Transitionable {

    public KillOperator(Point mapDimensions) {
        super(1, mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) {
        EndGameState nextState = currentState.clone();
        /*
         * Kill all warriors in the east, west, north, and south of iron man if they
         * exist
         */
        KillWarriorIfExists(nextState.getWarriorsLoc(),
                new Point(nextState.getIronManLoc().x - 1, nextState.getIronManLoc().y));
        KillWarriorIfExists(nextState.getWarriorsLoc(),
                new Point(nextState.getIronManLoc().x + 1, nextState.getIronManLoc().y));
        KillWarriorIfExists(nextState.getWarriorsLoc(),
                new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y - 1));
        KillWarriorIfExists(nextState.getWarriorsLoc(),
                new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y + 1));

        return nextState;
    }

    private static void KillWarriorIfExists(ArrayList<Point> warriorsLoc, Point targetPoint) {
        for (Point warriorLoc : warriorsLoc)
            if (warriorLoc.equals(targetPoint)) {
                warriorsLoc.remove(warriorLoc);
                return;
            }
    }

}