package operators;

import endgame.EndGameState;

public interface Transitionable {
    public abstract EndGameState transition(EndGameState currentState);
}