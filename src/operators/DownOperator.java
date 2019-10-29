package operators;

import endgame.EndGameState;
import search.Operator;
import search.State;
import java.awt.Point;

public class DownOperator extends Operator {
	Point mapDimensions;

	public DownOperator(Point mapDimensions) {
		this.mapDimensions = mapDimensions;
	}

	@Override
	public EndGameState transition(State currentState) {
		EndGameState nextState = ((EndGameState) currentState).clone();
		Point currentIronManLoc = nextState.getIronManLoc();
		// Check that iron man is not in the last row
		if (currentIronManLoc.x >= this.mapDimensions.x - 1) {
			return null;
		}
		Point targetIronManLoc = new Point(currentIronManLoc.x + 1, currentIronManLoc.y);
		if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
			return null;
		}
		nextState.setIronManLoc(targetIronManLoc);
		return nextState;
	}

}