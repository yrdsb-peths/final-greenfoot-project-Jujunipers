import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Watering can
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wateringcan extends Actor
{
    boolean dragging = false;
    // Original location of watering can
    public int ogX = 25;
    public int ogY = 25;
    
    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        // Allow mouse to click and drag wateringCan around
        if(mouseInfo != null) {
            if(!dragging && Greenfoot.mouseDragged(this)) {
                dragging = true;
            }
            if(dragging && Greenfoot.mouseDragEnded(this)) {
                dragging = false;
                
                Pot potInstance = (Pot) getOneIntersectingObject(Pot.class); // gets the specific pot instance that the mouse is touching
                // If wateringCan is over plant by end of drag, water plant, but only if thirsty. If not thirsty, return wateringCan to og location
                if(isTouching(Pot.class)) {
                    if(potInstance.plant.thirsty) {
                        potInstance.plant.waterPlant();
                        setLocation(100, 100); // temporary, replace with watering animation
                    }
                } else {
                    setLocation(ogX, ogY); // return wateringCan to og location when drag is released
                }
            }
            // Make wateringCan follow mouse if dragging is true
            if(dragging) {
                setLocation(mouseInfo.getX(), mouseInfo.getY());
            }
        }
        
        
        
        
    }
}
