package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.Constants.*;

/**
 * Created by wangqisen on 2016/1/4.
 */
public interface MachineState{

    MachineStateEnum next(Game game,GHOST ghost);
    void doAction(Game game,GHOST ghost);
}
