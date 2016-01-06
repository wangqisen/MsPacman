package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Game;

import java.util.Random;

/**
 * Created by wangqisen on 2016/1/4.
 */
public class AggresiveRandomState implements MachineState{

    @Override
    public MachineStateEnum next(Game game, Constants.GHOST ghost) {
        if(GhostsUtil.closeToMsPacman(ghost, game)){
            return MachineStateEnum.CHASE;
        }else{
            return MachineStateEnum.AGGRESSIVE_RANDOM;
        }
    }

    @Override
    public void doAction(Game game, Constants.GHOST ghost) {

        if(GhostsUtil.areTherePills(game)){
            Machine.myMoves.put(ghost, game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),
                    GhostsUtil.nearestPilltoPM(game), game.getGhostLastMoveMade(ghost), Constants.DM.PATH));

        }
        else{
            Random rnd=new Random();
            Constants.MOVE[] possibleMoves=game.getPossibleMoves(game.getGhostCurrentNodeIndex(ghost),game.getGhostLastMoveMade(ghost));
            Machine.myMoves.put(ghost,possibleMoves[rnd.nextInt(possibleMoves.length)]);
        }
    }
}
