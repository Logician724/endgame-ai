package operators;

import endgame.EndGameState;
import exceptions.CannotSnapException;
import exceptions.OperatorFailedException;
import search.Operator;

public class SnapOperator extends Operator implements Transitionable {

    @Override
    public EndGameState transition(EndGameState currentState) throws OperatorFailedException {
        EndGameState nextState = currentState.clone();

        if (!currentState.getIronManLoc().equals(currentState.getThanosLoc())
                || currentState.getStonesLoc().size() != 0)
            throw new CannotSnapException();

        nextState.killThanos();

        return nextState;
    }

}