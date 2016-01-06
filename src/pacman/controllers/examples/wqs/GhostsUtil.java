package pacman.controllers.examples.wqs;

import pacman.game.Constants;
import pacman.game.Game;

/**
 * Created by wangqisen on 2016/1/4.
 */
public class GhostsUtil {
    private final static int PILL_PROXIMITY=15;		//if Ms Pac-Man's distance to a power pill is smaller than it, retreat
    private final static int PM_PROXIMITY=70;		//the limit distance of the pacman to ghosts

    /**
     * checks if Ms Pac-Man is close to an available power pill.
     * @param game our game
     * @return true or false
     */
    public static boolean closeToPower(Game game)
    {
        int[] powerPills=game.getPowerPillIndices();

        for(int i=0;i<powerPills.length;i++)
        {
            if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex())<PILL_PROXIMITY)
                return true;
        }

        return false;
    }

    /**
     * checks if current ghost is close to Ms Pac-Man.
     * @param ghost current ghost
     * @param game out game
     * @return true or false
     */
    public static boolean closeToMsPacman(Constants.GHOST ghost, Game game)
    {
        if(game.getShortestPathDistance(game.getGhostCurrentNodeIndex(ghost),game.getPacmanCurrentNodeIndex())<PM_PROXIMITY)
            return true;

        return false;
    }

    /**
     * checks the closest power pill to Ms Pac-Man.
     * @param game our game
     * @return node of the pill
     */
    public static int nearestPilltoPM(Game game)
    {
        int[] powerPills=game.getPowerPillIndices();
        int distance_aux = game.getShortestPathDistance(powerPills[0],game.getPacmanCurrentNodeIndex());
        int pill = 0;

        for(int i=1;i<powerPills.length;i++)
        {
            if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex()) < distance_aux)
                pill = i;
        }

        return powerPills[pill];
    }

    /**
     * checks the farthest power pill to Ms Pac-Man.
     * @param game our game
     * @return node of the pill
     */
    public static int farthestPilltoPM(Game game)
    {
        int[] powerPills=game.getPowerPillIndices();
        int distance_aux = game.getShortestPathDistance(powerPills[0],game.getPacmanCurrentNodeIndex());
        int pill = 0;

        for(int i=1;i<powerPills.length;i++)
        {
            if(game.isPowerPillStillAvailable(i) && game.getShortestPathDistance(powerPills[i],game.getPacmanCurrentNodeIndex()) > distance_aux)
                pill = i;
        }

        return powerPills[pill];
    }

    /**
     * checks if there are power pills.
     * @param game our game
     * @return true or false
     */
    public static boolean areTherePills(Game game)
    {
        int[] powerPills=game.getPowerPillIndices();

        for(int i=0;i<powerPills.length;i++)
        {
            if(game.isPowerPillStillAvailable(i))
                return true;
        }

        return false;
    }
}
