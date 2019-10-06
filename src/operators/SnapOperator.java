package operators;

import endgame.EndGameState;
import exceptions.CannotSnapException;
import exceptions.OperatorFailedException;
import search.Operator;
import search.State;

public class SnapOperator extends Operator {

    @Override
    public EndGameState transition(State currentState) throws OperatorFailedException {
        EndGameState nextState = ((EndGameState) currentState).clone();

        if (!nextState.getIronManLoc().equals(nextState.getThanosLoc()) || nextState.getStonesLoc().size() != 0)
            throw new CannotSnapException();

        nextState.killThanos();

        return nextState;
    }

}