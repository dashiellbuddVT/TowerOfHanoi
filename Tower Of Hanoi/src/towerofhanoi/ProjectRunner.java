package towerofhanoi;

/**
 * 
 * @author dashiell budd
 * @version 3/19/23
 * 
 *
 */
public class ProjectRunner {
    /**
     * default constructor
     */
    public ProjectRunner()
    {
        String[] args = {};
        main(args);
    }
    
    public static void main(String[] args)
    {
        HanoiSolver hSolver;
        int disks = 6;
        if(args.length != 1) {
            hSolver = new HanoiSolver(disks);
        }
        else
        {
            int h = Integer.parseInt(args[0]);
            hSolver = new HanoiSolver(h);
        }
        new PuzzleWindow(hSolver);
        
    }
}
