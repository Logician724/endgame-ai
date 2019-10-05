package operators;

import endgame.EndGameState;
import search.Operator;
import java.awt.Point;

public class DownOperator extends Operator implements Transitionable {

    public DownOperator(Point mapDimensions) {
        super(1, mapDimensions);
    }

    @Override
    public EndGameState transition(EndGameState currentState) {
        // TODO Auto-generated method stub
        return null;
    }

}