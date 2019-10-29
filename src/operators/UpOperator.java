package operators;

import search.Operator;
import java.awt.Point;

import endgame.EndGameState;
import search.State;

public class UpOperator extends Operator {
	Point mapDimensions;

	public UpOperator(Point mapDimensions) {
		this.mapDimensions = mapDimensions;
	}

	@Override
	public EndGameState transition(State currentState) {
		EndGameState nextState = ((EndGameState) currentState).clone();
		Point currentIronManLoc = nextState.getIronManLoc();
		// Check that iron man is not in the first row
		if (currentIronManLoc.x <= 0) {
			return null;
		}
		Point targetIronManLoc = new Point(currentIronManLoc.x - 1, currentIronManLoc.y);
		if (OperatorUtils.PointCollidesWithOtherObjectsOnMap(targetIronManLoc, nextState)) {
			return null;
		}
		nextState.setIronManLoc(targetIronManLoc);
		return nextState;
	}

}