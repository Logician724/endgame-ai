package operators;

import endgame.EndGameState;
import exceptions.CellOccupiedException;
import exceptions.OperatorFailedException;
import exceptions.OutOfMapException;
import search.Operator;
import search.State;
import java.awt.Point;

public class DownOperator extends Operator {

    public DownOperator(Point mapDimensions) {
        super(mapDimensions);
    }

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();
        Point currentIronManLoc = nextState.getIronManLoc();
        // Check that iron man is not in the last row
        if (currentIronManLoc.x >= this.getMapDimensions().x - 1) {
            throw new OutOfMapException();
        }
        Point targetIronManLoc = new Point(currentIronManLoc.x + 1, currentIronManLoc.y);
        if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
            throw new CellOccupiedException();
        }
        nextState.setIronManLoc(targetIronManLoc);
        return nextState;
    }

}