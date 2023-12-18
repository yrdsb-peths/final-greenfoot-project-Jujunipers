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
                
                Pot potInstance = (Pot) getOneIntersectingObject(Pot.class); // gets the specific pot instance that the mouse is touching
                // Plant seed in pot, but only if it doesn't already have a plant
                if(isTouching(Pot.class) && !potInstance.hasPlant) {
                    setLocation(ogX, ogY); // temporary, replace with planting animation
                    potInstance.createPlant();
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
