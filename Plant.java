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
    
    /**
     * Constructor
     */
    public Plant() {
        waterTimer.mark(); // starts waterTimer
    }
    
    public void act()
    {
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!thirsty) {
            if(waterTimer.millisElapsed() < 10000) {
                return;
            }
            thirsty = true;
            System.out.println("thirsty");
            System.out.println("!");
        }
        waterTimer.mark(); // reset waterTimer
    }
}
