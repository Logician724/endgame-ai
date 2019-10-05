package operators;

import endgame.EndGameState;
import exceptions.OperatorFailedException;

public interface Transitionable {
    public abstract EndGameState transition(EndGameState currentState) throws OperatorFailedException;
}