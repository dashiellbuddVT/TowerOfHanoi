package towerofhanoi;

import student.TestCase;

/**
 * 
 * @author dashiell budd
 * @version 3/21/23
 */
public class TowerTest extends TestCase {
    
    private Tower leftTower;

    
    /**
     * sets up the towers
     */
    public void setUp()
    {
        leftTower = new Tower(Position.LEFT);
    }
    
    /**
     * tests the position method
     */
    public void testPosition()
    {
        assertEquals(Position.LEFT, leftTower.position());
    }
    
    /**
     * tests the push method
     */
    public void testPush()
    {
        leftTower.push(new Disk(3));
        assertEquals(1, leftTower.size());
        try
        {
            leftTower.push(null);
        }
        catch (Exception e)
        {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
    
    /**
     * tests the error
     */
    public void testPushError()
    {
        leftTower.push(new Disk(3));
        try
        {
            leftTower.push(new Disk(4));
        }
        catch (Exception e)
        {
            assertEquals(IllegalStateException.class, e.getClass());
        }
    }
}
