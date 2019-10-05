package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;

public class KillOperator extends Operator implements Transitionable {

    public KillOperator(Point mapDimensions) {
        super(1, mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) {
        // TODO Auto-generated method stub
        return null;
    }

}