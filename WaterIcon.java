import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Water icon belonging to each plant that appears when plant is thirsty.
 * 
 * @author Julia
 * @version December 2023
 */
public class WaterIcon extends Actor
{
    GreenfootImage waterIcon;
    
    // Min/max scale of waterIcon
    private int minX = 12;
    private int minY = 16;
    private int maxX = (int)1.5*minX;
    private int maxY = (int)1.5*minY;
    
    public WaterIcon() {
        waterIcon = new GreenfootImage("images/water-droplet.png");
        waterIcon.scale(minX, minY);
        waterIcon.setTransparency(0); // Set it to be invisible at first
        setImage(waterIcon);
    }
    
    public void act()
    {
        
    }
    
    public void setScale(double thirstPercent) {
        waterIcon = new GreenfootImage("images/water-droplet.png");
        waterIcon.scale(minX + (int)(thirstPercent*maxX), minY + (int)(thirstPercent*maxY));
        setImage(waterIcon);
    }
    
    public void show() {
        waterIcon.setTransparency(255);
    }
    
    public void hide() {
        waterIcon.setTransparency(0);
    }
}
