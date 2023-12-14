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
    
    /**
     * Constructor
     */
    public Plant() {
        waterTimer.mark(); // starts waterTimer
    }
    
    public void act()
    {
        
        if(waterTimer.millisElapsed() < 10000) {
            return;
        }
        
        System.out.println("thirsty");
        System.out.println("!");
        waterTimer.mark(); // reset waterTimer
    }
}
