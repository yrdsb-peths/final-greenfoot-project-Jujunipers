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
                // Plant seed in pot, but only if it doesn't already have a plant
                if(isTouching(Pot.class) && !MyWorld.instance.pot.hasPlant) {
                    setLocation(500, 100); // temporary, replace with planting animation
                    MyWorld.instance.pot.hasPlant = true;
                    MyWorld.instance.pot.createPlant();
                } else {
                    setLocation(ogX, ogY); // return seedbag to og location when drag is released
                }
            }
            // Make seedbag follow mouse if dragging is true
            if(dragging) {
                setLocation(mouseInfo.getX(), mouseInfo.getY());
            }
        }
    }
}
