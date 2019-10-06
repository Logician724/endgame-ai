package endgame;

import java.awt.Point;

import exceptions.ThanosDoesNotExistException;

public class EndGameUtils {

    public static int CountEnemiesAround(EndGameState state) {
        int enemiesCount = 0;

        if (state.getWarriorsLoc().contains(new Point(state.getIronManLoc().x - 1, state.getIronManLoc().y)))
            enemiesCount++;
        if (state.getWarriorsLoc().contains(new Point(state.getIronManLoc().x + 1, state.getIronManLoc().y)))
            enemiesCount++;
        if (state.getWarriorsLoc().contains(new Point(state.getIronManLoc().x, state.getIronManLoc().y - 1)))
            enemiesCount++;
        if (state.getWarriorsLoc().contains(new Point(state.getIronManLoc().x, state.getIronManLoc().y + 1)))
            enemiesCount++;

        return enemiesCount;
    }

    public static boolean IsThanosAround(EndGameState state) throws ThanosDoesNotExistException {
        if (state.getThanosLoc() == null) {
            throw new ThanosDoesNotExistException();
        }
        if (state.getThanosLoc().equals(new Point(state.getIronManLoc().x, state.getIronManLoc().y)))
            return true;
        if (state.getThanosLoc().equals(new Point(state.getIronManLoc().x - 1, state.getIronManLoc().y)))
            return true;
        if (state.getThanosLoc().equals(new Point(state.getIronManLoc().x + 1, state.getIronManLoc().y)))
            return true;
        if (state.getThanosLoc().equals(new Point(state.getIronManLoc().x, state.getIronManLoc().y - 1)))
            return true;
        if (state.getThanosLoc().equals(new Point(state.getIronManLoc().x, state.getIronManLoc().y + 1)))
            return true;

        return false;
    }

}