package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

import java.util.Random;


/**
 * Created by wangqisen on 2016/1/4.
 */
public class NegativeRandomState implements MachineState {

    @Override
    public MachineStateEnum next(Game game, Constants.GHOST ghost) {
        if (GhostsUtil.closeToMsPacman(ghost, game))    //if Ms Pac-Man is near
        {
            return MachineStateEnum.RETREAT;
        } else
            return MachineStateEnum.NEGATIVE_RANDOM;
    }

    @Override
    public void doAction(Game game, Constants.GHOST ghost) {
        if (GhostsUtil.areTherePills(game)) {
            Machine.myMoves.put(ghost, game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
                    GhostsUtil.farthestPilltoPM(game), game.getGhostLastMoveMade(ghost), DM.PATH));
        } else {
            Random rnd = new Random();
            MOVE[] possibleMoves = game.getPossibleMoves(game.getGhostCurrentNodeIndex(ghost), game.getGhostLastMoveMade(ghost));
            Machine.myMoves.put(ghost, possibleMoves[rnd.nextInt(possibleMoves.length)]);
        }
    }
}
