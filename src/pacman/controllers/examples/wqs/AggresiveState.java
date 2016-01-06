package pacman.controllers.examples.wqs;

import pacman.game.Constants.*;
import pacman.game.Game;

/**
 * Created by wangqisen on 2016/1/4.
 */
public class AggresiveState implements MachineState{

    @Override
    public MachineStateEnum next(Game game,GHOST ghost) {
        if(game.getGhostEdibleTime(ghost)>0 || GhostsUtil.closeToPower(game))	//retreat from Ms Pac-Man if edible or if Ms Pac-Man is close to power pill
            return MachineStateEnum.NEGATIVE;
        else
            return MachineStateEnum.AGGRESSIVE;
    }

    @Override
    public void doAction(Game game, GHOST ghost) {
        MachineState currentState=Machine.currentAggresiveMachineState.get(ghost);
        MachineStateEnum nextStateEnum=currentState.next(game, ghost);
        MachineState nextState=Machine.getMachineStateByEnum(nextStateEnum);

        currentState=nextState;
        Machine.currentAggresiveMachineState.put(ghost,currentState);
        currentState.doAction(game, ghost);
    }
}
