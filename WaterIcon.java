import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterIcon extends Actor
{
    // Location
    public int x = MyWorld.instance.plant.x + 30;
    public int y = MyWorld.instance.plant.y - 20;
    
    // Transparency
    public int transparency = 0;
    
    GreenfootImage waterDrop;
    
    public WaterIcon() {
        waterDrop = new GreenfootImage("images/water-droplet.png");
        waterDrop.scale(12, 16);
        waterDrop.setTransparency(0); // Set it to be invisible at first
        setImage(waterDrop);
    }
    
    public void act()
    {
        waterDrop.setTransparency(transparency);
    }
}
