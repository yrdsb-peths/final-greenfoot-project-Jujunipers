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
                // Plant seed in pot, but only if it doesn't already have a plant and player still has seeds left
                if(isTouching(Pot.class) && !potInstance.hasPlant && MyWorld.instance.playerData.numSeeds > 0) {
                    setLocation(ogX, ogY); // temporary, replace with planting animation
                    potInstance.createPlant();
                    MyWorld.instance.playerData.numSeeds--;
                    System.out.println(MyWorld.instance.playerData.numSeeds);
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
