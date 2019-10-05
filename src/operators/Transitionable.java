package operators;

import cells.Cell;
import endgame.EndGameState;

public interface Transitionable {
    public abstract EndGameState transition(EndGameState currentState, Cell[][] map);
}