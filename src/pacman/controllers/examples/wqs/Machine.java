package pacman.controllers.examples.wqs;

import pacman.game.Constants.*;

import javax.crypto.Mac;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqisen on 2016/1/4.
 */
public class Machine {

    public static final AggresiveState aggresiveState=new AggresiveState();
    public static final NegativeState negativeState=new NegativeState();
    public static final ChaseState chaseState=new ChaseState();
    public static final RetreatState retreatState=new RetreatState();
    public static final AggresiveRandomState aggresiveRandomState=new AggresiveRandomState();
    public static final NegativeRandomState negativeRandomState=new NegativeRandomState();

    public static final Map<GHOST,MachineState> currentAggresiveMachineState = new HashMap<GHOST, MachineState>();
    public static final Map<GHOST,MachineState> currentNegativeMachineState = new HashMap<GHOST, MachineState>();;

    public static final Map<MachineStateEnum,MachineState> machineStateMap=new HashMap<MachineStateEnum, MachineState>();

    static {

        for(GHOST ghost:GHOST.values()){
            currentAggresiveMachineState.put(ghost,chaseState);
            currentNegativeMachineState.put(ghost,retreatState);
        }

        machineStateMap.put(MachineStateEnum.AGGRESSIVE,aggresiveState);
        machineStateMap.put(MachineStateEnum.NEGATIVE,negativeState);
        machineStateMap.put(MachineStateEnum.CHASE,chaseState);
        machineStateMap.put(MachineStateEnum.RETREAT,retreatState);
        machineStateMap.put(MachineStateEnum.AGGRESSIVE_RANDOM,aggresiveRandomState);
        machineStateMap.put(MachineStateEnum.NEGATIVE_RANDOM,negativeRandomState);
    }

    public static final Map<GHOST,MachineState> ghostsState=new HashMap<GHOST,MachineState>();
    public static final EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);

    public static MachineState getMachineStateByEnum(MachineStateEnum machineStateEnum){
        return machineStateMap.get(machineStateEnum);
    }

}
