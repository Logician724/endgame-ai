package operators;

import endgame.EndGameState;
import exceptions.CannotCollectException;
import exceptions.OperatorFailedException;
import search.Operator;

public class CollectOperator extends Operator implements Transitionable {

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();

        if (!currentState.getStonesLoc().contains(currentState.getIronManLoc()))
            throw new CannotCollectException();

        nextState.getStonesLoc().remove(nextState.getIronManLoc());

        return nextState;
    }

}