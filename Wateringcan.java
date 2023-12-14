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
    public int ogX = 300;
    public int ogY = 200;
    
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
                setLocation(ogX, ogY); // return wateringCan to og location when drag is released
            }
            // Make wateringCan follow mouse if dragging is true
            if(dragging) {
                setLocation(mouseInfo.getX(), mouseInfo.getY());
            }
        }
        
        // Water plant
        if(dragging && isTouching(Plant.class)) {
            dragging = false;
            //setLocation(100, 100);
            
        }
        

        
    }
}
