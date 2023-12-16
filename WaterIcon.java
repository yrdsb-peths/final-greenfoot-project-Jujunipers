import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterIcon extends Actor
{
    // Transparency
    public int transparency = 0;
    
    GreenfootImage waterIcon;
    
    public WaterIcon() {
        waterIcon = new GreenfootImage("images/water-droplet.png");
        waterIcon.scale(12, 16);
        waterIcon.setTransparency(0); // Set it to be invisible at first
        setImage(waterIcon);
    }
    
    public void act()
    {
        waterIcon.setTransparency(transparency);
    }
}
