import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Watering can in tool bar that player can drag to water plants.
 * 
 * @author Julia
 * @version December 2023
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
                if(tryToWaterSucceeds()) {
                    setLocation(ogX, ogY); // return wateringCan to og location when drag is released
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
    
    /**
     * Tries to water plant that wateringCan is hovering over. If plant is thirsty, then water. Otherwise, don't water.
     * 
     * @return  whether or not plant is watered
     */
    public boolean tryToWaterSucceeds() {
        if(isTouching(Pot.class)) {
            Pot potInstance = (Pot) getOneIntersectingObject(Pot.class); // gets the specific pot instance that the mouse is touching
            if(PlayerDataManager.getPlayerData().plantData[potInstance.index] != null) { // if the plant in that pot exists, try to water it
                if(PlayerDataManager.getPlayerData().plantData[potInstance.index].isThirsty()) { // if the plant is thirsty, water it and return true for success in watering plant
                    potInstance.plant.waterPlant();
                    return true;
                }
                return false;
            }
            return false;
        } else if(isTouching(Plant.class)) {
            Plant plantInstance = (Plant) getOneIntersectingObject(Plant.class);
            if(PlayerDataManager.getPlayerData().plantData[plantInstance.potInstance.index].isThirsty()) { // if plant is thirsty, try to water it
                plantInstance.waterPlant();
                return true;
            }
            return false;
        }
        return false;
    }
}
