package operators;

import search.Operator;
import java.awt.Point;
import search.State;
import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;

public class LeftOperator extends Operator {

    public LeftOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();
        Point currentIronManLoc = nextState.getIronManLoc();
        // Check that iron man is not in the first column
        if (currentIronManLoc.y <= 0) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x, currentIronManLoc.y - 1);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}