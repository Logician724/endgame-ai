package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;
import search.State;

public class RightOperator extends Operator {

    public RightOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();
        Point currentIronManLoc = nextState.getIronManLoc();
        // Check that iron man is not in the last column
        if (currentIronManLoc.y >= this.getMapDimensions().y - 1) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x, currentIronManLoc.y + 1);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }
}