package towerofhanoi;
import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

/**
 * 
 * @author dashiell budd
 * @version 3/15/23
 *
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * constructor that takes width as a param
     * @param width the of the disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom gen = new TestableRandom();
        int red = gen.nextInt(256) / 2;
        int green = gen.nextInt(256);
        int blue = gen.nextInt(256);
        Color bkRd = new Color(red, green, blue);
        this.setBackgroundColor(bkRd);        
    }
    
    /**
     * @Override
     * compares 2 disks
     * @param o the 2nd disk
     * @return positive if the calling disk is bigger 
     * and 0 is they are the same. 
     * Negative means the parameter disk is bigger
     */
    public int compareTo(Disk o) {
        if (o == null)
        {
            throw new IllegalArgumentException();
        }
        
        return this.getWidth() - o.getWidth();
    }
    
    /**
     * returns the width as a string
     * @return the width as a string
     */
    public String toString()
    {
        return Integer.toString(getWidth());
    }
    
    /**
     * sees if the two disks are the same
     * @param object the object to be tested against the calling disk
     * @return true if they have the same width
     */
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        return this.getWidth() == ((Disk)object).getWidth();   
    }
    
    
    
    

}
