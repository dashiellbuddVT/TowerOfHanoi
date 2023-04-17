package towerofhanoi;
import student.TestCase;

/**
 * 
 * @author dashiell budd
 * @version 3/20/23
 *
 */
public class DiskTest extends TestCase {
    
    private Disk d1;
    private Disk dN;
    private Disk dS;
    private Disk d2;
    
    /**
     * sets up the disks to be tested
     */
    public void setUp()
    {
        d1 = new Disk(3);
        dS = new Disk(3);
        d2 = new Disk(4);
    }
    
    /**
     * tests the compare to method
     */
    public void testCompareTo()
    {
        assertEquals(0, d1.compareTo(dS));
        assertEquals(1, d2.compareTo(d1));
        assertEquals(-1, d1.compareTo(d2));
        try
        {
            d1.compareTo(dN);
        }
        catch (Exception e)
        {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
    
    /**
     * tests the toString method
     */
    public void testToString()
    {
        assertEquals("3", d1.toString());
        assertEquals("3", dS.toString());
        assertEquals("4", d2.toString());
    }
    
    /**
     * tests the equals method
     */
    public void testEquals()
    {
        assertEquals(d1, dS);
        assertEquals(d1, d1);
        assertNotSame(d1, d2);
        assertNotSame(d1, "Bob");
        assertNotSame(d1, dN); 
    }
}
