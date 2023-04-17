package towerofhanoi;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * 
 * @author Dashiell Budd
 * @version 3/19/23
 *
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    public static final int WIDTH_FACTOR = 15;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 15;
    private static final int SPEED = 1;
    
    public PuzzleWindow(HanoiSolver g)
    {
        game = g;
        game.addObserver(this);
        window = new Window("Tower Of Hanoi");
        
        int h = (game.disks()+1) * DISK_HEIGHT;
        
        int x = window.getWidth()/2;
        int y = window.getHeight()/4;
        int w = window.getWidth()/80;
        
        
        middle = new Shape(x-w/2,y,w,h);
        left = new Shape((x/2)-w/2,y,w,h);
        right = new Shape((x/2*3)-w/2,y,w,h);
        
        
        left.setBackgroundColor(Color.GRAY);
        right.setBackgroundColor(Color.GRAY);
        middle.setBackgroundColor(Color.GRAY);
        
        
        for(int i = 0; i < game.disks(); i++)
        {
            Disk newDisk = new Disk((game.disks()-i) * WIDTH_FACTOR);
            window.addShape(newDisk);
            game.getTower(Position.LEFT).push(newDisk);
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button button = new Button("Solve");
        window.addButton(button, WindowSide.NORTH);
        button.onClick(this, "clickedSolve");
    }
    
    private void moveDisk(Position p)
    {
        Disk currentDisk = game.getTower(p).peek();
        Shape currentPole;
        switch (p)
        {
            case LEFT: 
                currentPole = left;
                break;
            case MIDDLE: 
                currentPole = middle;
                break;
            case RIGHT: 
                currentPole = right;
                break;
            default: currentPole = left;
        }
        int height = (game.getTower(p).size() + DISK_GAP) * DISK_HEIGHT;
        int x = currentPole.getX() - currentDisk.getWidth()/2 + currentPole.getWidth()/2;
        int y = currentPole.getY() + currentPole.getHeight() - height;
        currentDisk.moveTo(x,y);
    }    
    
    @Override
    public void update(Observable o, Object arg) {
        Position p = Position.DEFAULT;
        if(arg.getClass() == Position.class)
        {
           p = (Position)arg;
        }
        moveDisk(p);
        sleep();
    }
    
    private void sleep() {
        try {
            Thread.sleep(500/SPEED);
        }
        catch (Exception e) {
        }
    }


    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
