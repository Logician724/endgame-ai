package operators;

import search.Operator;
import java.awt.Point;
import search.State;
import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;

public class LeftOperator extends Operator {
    private Point mapDimensions;

    public LeftOperator(Point mapDimensions) {
        this.mapDimensions = mapDimensions;
    }

    @Override
    public EndGameState transition(State currentState) {
        EndGameState nextState = ((EndGameState) currentState).clone();
        Point currentIronManLoc = nextState.getIronManLoc();
        // Check that iron man is not in the first column
        if (currentIronManLoc.y <= 0) {
            return null;
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x, currentIronManLoc.y - 1);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
            return null;
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}