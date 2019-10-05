package operators;

import endgame.EndGameState;
import java.awt.Point;

public class OperatorUtils {
    protected static boolean pointCollidesWithOtherObjectsOnMap(Point targetPoint, EndGameState currentState) {
        for (Point warriorLoc : currentState.getWarriorsLoc()) {
            if (warriorLoc.equals(targetPoint)) {
                return true;
            }
        }

        if (targetPoint.equals(currentState.getThanosLoc())) {
            return true;
        }

        return false;
    }

}