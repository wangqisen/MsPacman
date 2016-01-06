package pacman.controllers.examples;

import pacman.controllers.Controller;
import pacman.controllers.examples.wqs.Machine;
import pacman.controllers.examples.wqs.MachineState;
import pacman.game.Constants;
import pacman.game.Constants.*;
import pacman.game.Game;

import java.util.EnumMap;

/**
 * Created by wangqisen on 2016/1/6.
 */
public class MyGhosts extends Controller<EnumMap<Constants.GHOST,Constants.MOVE>> {

    @Override
    public EnumMap<Constants.GHOST, Constants.MOVE> getMove(Game game, long timeDue) {
        Machine.myMoves.clear();
        for(GHOST ghost:GHOST.values()){
            if(game.doesGhostRequireAction(ghost)) {
                MachineState currentGhostState = Machine.ghostsState.get(ghost);
                MachineState nextGhostState = Machine.getMachineStateByEnum(currentGhostState.next(game, ghost));

                currentGhostState = nextGhostState;
                Machine.ghostsState.put(ghost, currentGhostState);
                currentGhostState.doAction(game, ghost);
            }
        }

        return Machine.myMoves;
    }

    public MyGhosts(){
        Machine.ghostsState.put(GHOST.BLINKY, Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.INKY,Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.PINKY,Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.SUE,Machine.aggresiveState);
    }
}
