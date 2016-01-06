package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Game;
/**
 * Created by wangqisen on 2016/1/4.
 */
public class NegativeState implements MachineState{

    @Override
    public MachineStateEnum next(Game game, Constants.GHOST ghost) {
        if(game.getGhostEdibleTime(ghost)>0 || GhostsUtil.closeToPower(game))	//retreat from Ms Pac-Man if edible or if Ms Pac-Man is close to power pill
            return MachineStateEnum.NEGATIVE;
        else
            return MachineStateEnum.AGGRESSIVE;
    }

    @Override
    public void doAction(Game game, Constants.GHOST ghost) {
        MachineState currentState=Machine.currentNegativeMachineState.get(ghost);
        MachineState nextState=Machine.getMachineStateByEnum(currentState.next(game, ghost));

        currentState=nextState;
        Machine.currentNegativeMachineState.put(ghost,currentState);
        currentState.doAction(game, ghost);
    }
}
