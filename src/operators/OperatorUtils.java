package operators;

import endgame.EndGameState;
import java.awt.Point;

public class OperatorUtils {
    protected static boolean PointCollidesWithOtherObjectsOnMap(Point targetPoint, EndGameState currentState) {
        for (Point warriorLoc : currentState.getWarriorsLoc()) {
            if (warriorLoc.equals(targetPoint)) {
                return true;
            }
        }

        if (targetPoint.equals(currentState.getThanosLoc()) && currentState.getStonesLoc().size() != 0) {
            return true;
        }

        return false;
    }

}