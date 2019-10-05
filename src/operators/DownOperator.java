package operators;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;
import search.Operator;
import java.awt.Point;

public class DownOperator extends Operator implements Transitionable {

    public DownOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();
        Point currentIronManLoc = currentState.getIronManLoc();
        // Check that iron man is not in the first row
        if (currentIronManLoc.x >= this.getMapDimensions().x - 1) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x + 1, currentIronManLoc.y);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, currentState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}