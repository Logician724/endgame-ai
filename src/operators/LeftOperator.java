package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;

public class LeftOperator extends Operator implements Transitionable {

    public LeftOperator(Point mapDimensions) {
        super(1, mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) {
        // TODO Auto-generated method stub
        return null;
    }

}