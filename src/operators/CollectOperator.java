package operators;

import search.State;

import endgame.EndGameState;
import exceptions.CannotCollectException;
import exceptions.OperatorFailedException;
import search.Operator;

public class CollectOperator extends Operator {

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();

        if (!nextState.getStonesLoc().contains(nextState.getIronManLoc()))
            throw new CannotCollectException();

        nextState.getStonesLoc().remove(nextState.getIronManLoc());

        return nextState;
    }

}