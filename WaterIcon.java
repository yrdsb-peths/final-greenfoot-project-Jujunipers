import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Water icon belonging to each plant that appears when plant is thirsty.
 * 
 * @author Julia
 * @version December 2023
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
