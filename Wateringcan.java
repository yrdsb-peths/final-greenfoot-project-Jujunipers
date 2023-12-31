import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WateringCan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WateringCan extends Actor
{
    boolean dragging = false;
    // Original location of watering can
    public int ogX = 80;
    public int ogY = 85;
    
    private GreenfootImage wateringCanImage;
    
    public WateringCan() {
        // Set wateringCan image
        wateringCanImage = new GreenfootImage("images/watering_can.png");
        wateringCanImage.scale((int) (MyWorld.instance.scale * (double) wateringCanImage.getWidth()), (int) ((double) MyWorld.instance.scale * wateringCanImage.getHeight()));
        setImage(wateringCanImage);
    }
    
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
                if(potInstance == null) { // potInstance is null
                    setLocation(ogX, ogY); // return wateringCan to og location, meaning pot isn't touching it
                } else if(isTouching(Pot.class) && isTouching(Plant.class) && potInstance.plant.thirsty) {
                    potInstance.plant.waterPlant();
                    setLocation(ogX, ogY); // temporary, replace with watering animation
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
