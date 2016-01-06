package pacman.controllers.examples.wqs;

import pacman.game.Constants.GHOST;
import pacman.game.Game;

/**
 * Created by wangqisen on 2016/1/4.
 */
public interface MachineState {

    MachineStateEnum next(Game game, GHOST ghost);

    void doAction(Game game, GHOST ghost);
}
