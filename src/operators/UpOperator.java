package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;
import search.State;

public class UpOperator extends Operator {

    public UpOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();
        Point currentIronManLoc = nextState.getIronManLoc();
        // Check that iron man is not in the first row
        if (currentIronManLoc.x <= 0) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x - 1, currentIronManLoc.y);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}