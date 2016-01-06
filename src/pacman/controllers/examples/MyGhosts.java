package pacman.controllers.examples;

import pacman.controllers.Controller;
import pacman.controllers.examples.wqs.Machine;
import pacman.controllers.examples.wqs.MachineState;
import pacman.game.Constants;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

import java.util.EnumMap;

/**
 * Created by wangqisen on 2016/1/6.
 */
public class MyGhosts extends Controller<EnumMap<Constants.GHOST, Constants.MOVE>> {

    /*
    * My ghosts inition.All four ghosts are at aggresive station at first.
    */
    public MyGhosts() {
        Machine.ghostsState.put(GHOST.BLINKY, Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.INKY, Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.PINKY, Machine.aggresiveState);
        Machine.ghostsState.put(GHOST.SUE, Machine.aggresiveState);
    }


    /*
    *get next moves by state machine.See Machine for details.
    */
    @Override
    public EnumMap<Constants.GHOST, Constants.MOVE> getMove(Game game, long timeDue) {
        Machine.myMoves.clear();
        for (GHOST ghost : GHOST.values()) {
            if (game.doesGhostRequireAction(ghost)) {
                MachineState currentGhostState = Machine.ghostsState.get(ghost);
                MachineState nextGhostState = Machine.getMachineStateByEnum(currentGhostState.next(game, ghost));

                currentGhostState = nextGhostState;
                Machine.ghostsState.put(ghost, currentGhostState);
                currentGhostState.doAction(game, ghost);
            }
        }

        return Machine.myMoves;
    }
}
