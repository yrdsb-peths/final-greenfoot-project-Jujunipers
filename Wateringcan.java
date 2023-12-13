import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Watering can
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wateringcan extends Actor
{
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        // Watering can location follows mouse
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        if(mouseInfo != null) {
            if(mouseInfo.getButton() == 1 && mouseInfo.getX() > this.getX() - 50 && mouseInfo.getX() < this.getX() + 50 && mouseInfo.getY() > this.getY() - 50 && mouseInfo.getY() < this.getY() + 50) {
                setLocation(mouseInfo.getX(), mouseInfo.getY());
                
            }
        }
        
        
        /*
        if(mouseInfo != null) {
            boolean mouseOnWateringCan = mouseInfo.getX() == this.getX() && mouseInfo.getY() == this.getY();
            if(mouseOnWateringCan) {
                int x = mouseInfo.getX();
                int y = mouseInfo.getY();
                setLocation(x, y);
            }
            
        }
        */
    }
}
