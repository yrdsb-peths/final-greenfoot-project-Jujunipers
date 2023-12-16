import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    SimpleTimer waterTimer = new SimpleTimer();
    
    public boolean thirsty = false;
    
    // Pot instance
    public Pot potInstance;
    
    /*
     * Constructor
     */
    public Plant(Pot potInstance) {
        waterTimer.mark(); // starts waterTimer
        
        this.potInstance = potInstance;
    }
    
    public void act()
    {
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!thirsty) {
            // Since not thirsty, set water icon to be transparent
            potInstance.waterIcon.transparency = 0;
            if(waterTimer.millisElapsed() < 10000) {
                return;
            }
            thirsty = true;
            System.out.println("thirsty");
            System.out.println("!");
        }
        waterTimer.mark(); // reset waterTimer
        
        // If thirsty, make water icon appear
        if(thirsty) {
            potInstance.waterIcon.transparency = 255;
        }
    }
    
    public void waterPlant() {
        Pot potInstance = (Pot) getOneIntersectingObject(Pot.class); // gets the specific pot instance that the mouse is touching
        setLocation(100, 100); // temporary, replace with watering animation
        potInstance.plant.thirsty = false;
        potInstance.plant.waterTimer.mark(); // restart the thirst count
    }
}
