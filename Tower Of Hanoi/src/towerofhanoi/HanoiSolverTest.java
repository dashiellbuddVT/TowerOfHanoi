package towerofhanoi;
import student.TestCase;

/**
 * 
 * @author dashiell budd
 * @version 3/21/23
 *
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver game;
    
    /**
     * sets up the hanoi solver
     */
    public void setUp()
    {
        game = new HanoiSolver(3);
    }
    
    /**
     * tests the disks method
     */
    public void testDisks()
    {
        assertEquals(3, game.disks());
    }
    
    /**
     * tests the get tower method
     */
    public void testGetTower()
    {
        Position m = Position.MIDDLE;
        assertEquals(Position.LEFT, game.getTower(Position.LEFT).position());
        assertEquals(m, game.getTower(m).position());
        assertEquals(Position.RIGHT, game.getTower(Position.RIGHT).position());
    }
    
    /**
     * tests the toString method
     */
    public void testToString()
    {
        assertEquals("[][][]", game.toString());
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(3);
        game.getTower(Position.LEFT).push(disk3);
        game.getTower(Position.LEFT).push(disk2);
        game.getTower(Position.LEFT).push(disk1);
        assertEquals("[1, 2, 3][][]", game.toString());
    }
    
    /**
     * tests the solve method
     */
    public void testSolve()
    {
        Disk disk1 = new Disk(1);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(3);
        game.getTower(Position.LEFT).push(disk3);
        game.getTower(Position.LEFT).push(disk2);
        game.getTower(Position.LEFT).push(disk1);
        game.solve();
        assertEquals("[][][1, 2, 3]", game.toString());
    }
    
}
