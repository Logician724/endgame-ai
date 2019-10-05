package operators;

import endgame.EndGameState;
import exceptions.CannotCollectException;
import exceptions.OperatorFailedException;
import search.Operator;

import java.awt.Point;

public class CollectOperator extends Operator implements Transitionable {

    public CollectOperator() {
        super(1);
    }

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();

        boolean isEmpty = true;
        for (Point stoneLoc : currentState.getStonesLoc())
            if (currentState.getIronManLoc().equals(stoneLoc)) {
                nextState.getStonesLoc().remove(stoneLoc);
                isEmpty = false;
                break;
            }

        if (isEmpty)
            throw new CannotCollectException();

        return nextState;
    }

}