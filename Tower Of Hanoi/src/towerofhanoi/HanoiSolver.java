package towerofhanoi;
import java.util.Observable;


/**
 * 
 * @author dashiell budd
 * @version 3/20/23
 * 
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * constructs a Hanoi solver object
     * @param numDisks the number of disks in the game
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * returns the number of disks in the game
     * @return the number of disks
     */
    public int disks()
    {
        return numDisks;
    }
    
    /**
     * returns the tower at the position given
     * @param pos the posiiton
     * @return the Tower at the position
     */
    public Tower getTower(Position pos)
    {
        switch(pos) {
            case LEFT: return left;
            case MIDDLE: return middle;
            case RIGHT: return right;
            default: return middle;
        }  
    }
    
    /**
     * returns the toString of each tower
     * @return the toString of each tower
     */
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }
    
    private void move(Tower tower1, Tower tower2)
    {
        tower2.push(tower1.pop());
        setChanged();
        notifyObservers(tower2.position());
    }
    
    private void solveTowers(int total, Tower start, Tower temp, Tower end)
    {
        if (total == 1) {
            move(start, end);
        }
        else
        {
            solveTowers(total - 1, start, end, temp);
            move(start, end);
            solveTowers(total - 1, temp, start, end);
        }

        
    }
    
    /**
     * solves the towers 
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
    
    
}
