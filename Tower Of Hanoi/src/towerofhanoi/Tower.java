package towerofhanoi;

/**
 * 
 * @author dashiell budd
 * @version 3/20/23
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;
    
    /**
     * constructs a tower object
     * @param p the position of the tower
     */
    public Tower(Position p)
    {
        super();
        position = p;
    }
    
    /**
     * 
     * @return the position of the tower
     */
    public Position position()
    {
        return position;
    }
    
    
    
    /**
     * @override
     * @param disk the disk to add
     * @throws IllegalStateException if the disk pushed is bigger than the 
     * current disk
     * @throws IllegalArgumentException if the disk is null
     */
    public void push(Disk disk) throws IllegalStateException
    {
        if ((!this.isEmpty()) && this.peek().compareTo(disk) < 0) {
            throw new IllegalStateException();
        }
        else {
            super.push(disk);
        }
    }
}
