package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;

public class UpOperator extends Operator implements Transitionable {

    public UpOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();
        Point currentIronManLoc = currentState.getIronManLoc();
        // Check that iron man is not in the first row
        if (currentIronManLoc.x <= 0) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x - 1, currentIronManLoc.y);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, currentState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}