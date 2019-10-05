package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;

public class LeftOperator extends Operator implements Transitionable {

    public LeftOperator(Point mapDimensions) {
        super(1, mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();
        Point currentIronManLoc = currentState.getIronManLoc();
        // Check that iron man is not in the first row
        if (currentIronManLoc.y <= 0) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x, currentIronManLoc.y - 1);
        if (OperatorUtils.pointCollidesWithOtherObjectsOnMap(targetIronManLoc, currentState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}