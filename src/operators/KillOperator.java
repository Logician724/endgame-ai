package operators;

import search.Operator;
import java.awt.Point;
import endgame.EndGameState;
import search.State;

public class KillOperator extends Operator {
	Point mapDimensions;

	public KillOperator(Point mapDimensions) {
		this.mapDimensions = mapDimensions;
	}

	@Override
	public EndGameState transition(State currentState) {
		EndGameState currentEndGameState = (EndGameState) currentState;
		EndGameState nextState = ((EndGameState) currentState).clone();
		/*
		 * Kill all warriors in the east, west, north, and south of iron man if they
		 * exist
		 */

		boolean noEnemiesAround = true;

		if (currentEndGameState.getWarriorsLoc().contains(
				new Point(currentEndGameState.getIronManLoc().x - 1, currentEndGameState.getIronManLoc().y))) {
			nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x - 1, nextState.getIronManLoc().y));
			noEnemiesAround = false;
		}

		if (currentEndGameState.getWarriorsLoc().contains(
				new Point(currentEndGameState.getIronManLoc().x + 1, currentEndGameState.getIronManLoc().y))) {
			nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x + 1, nextState.getIronManLoc().y));
			noEnemiesAround = false;
		}

		if (currentEndGameState.getWarriorsLoc().contains(
				new Point(currentEndGameState.getIronManLoc().x, currentEndGameState.getIronManLoc().y - 1))) {
			nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y - 1));
			noEnemiesAround = false;
		}

		if (currentEndGameState.getWarriorsLoc().contains(
				new Point(currentEndGameState.getIronManLoc().x, currentEndGameState.getIronManLoc().y + 1))) {
			nextState.getWarriorsLoc().remove(new Point(nextState.getIronManLoc().x, nextState.getIronManLoc().y + 1));
			noEnemiesAround = false;
		}

		if (noEnemiesAround)
			return null;

		return nextState;
	}

}