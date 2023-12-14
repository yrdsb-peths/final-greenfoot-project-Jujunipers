import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seed extends Actor
{
    boolean dragging = false;
    // Original location of seedbag
    public int ogX = 100;
    public int ogY = 25;
    
    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        // Allow mouse to click and drag seedbag around
        if(mouseInfo != null) {
            if(!dragging && Greenfoot.mouseDragged(this)) {
                dragging = true;
            }
            if(dragging && Greenfoot.mouseDragEnded(this)) {
                dragging = false;
                setLocation(ogX, ogY); // return seedbag to og location when drag is released
            }
            // Make seedbag follow mouse if dragging is true
            if(dragging) {
                setLocation(mouseInfo.getX(), mouseInfo.getY());
            }
        }
        
        // Plant seed in pot, but only if it doesn't already have a plant
        if(dragging && isTouching(Pot.class)) {
            dragging = false;
            if(MyWorld.instance.pot.hasPlant) {
                System.out.println("Pot already full");
            } else {
                MyWorld.instance.pot.hasPlant = true;
            
                setLocation(500, 100);
            }
            
            //setLocation(MyWorld.instance.pot.getX(), MyWorld.instance.pot.getY());
            
        }
    }
}
