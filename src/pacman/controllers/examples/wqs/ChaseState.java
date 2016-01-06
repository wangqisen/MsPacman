package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

/**
 * Created by wangqisen on 2016/1/4.
 */
public class ChaseState implements MachineState {

    @Override
    public MachineStateEnum next(Game game, Constants.GHOST ghost) {
        if (GhostsUtil.closeToMsPacman(ghost, game))    //approach Ms Pac-Man if she is near
            return MachineStateEnum.CHASE;
        else
            return MachineStateEnum.AGGRESSIVE_RANDOM;
    }

    @Override
    public void doAction(Game game, GHOST ghost) {

        Machine.myMoves.put(ghost, game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
                game.getPacmanCurrentNodeIndex(), game.getGhostLastMoveMade(ghost), DM.PATH));

    }
}
