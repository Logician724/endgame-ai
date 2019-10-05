package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;

public class RightOperator extends Operator implements Transitionable {

    public RightOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();
        Point currentIronManLoc = currentState.getIronManLoc();
        // Check that iron man is not in the first row
        if (currentIronManLoc.y >= this.getMapDimensions().y - 1) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x, currentIronManLoc.y + 1);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, currentState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }
}