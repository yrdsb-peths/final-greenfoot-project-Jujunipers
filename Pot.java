import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pot extends Actor
{
    public boolean hasPlant = false;
    
    // Location
    public int x = 400;
    public int y = 300;
    
    // Create plant and waterIcon variables. plants and waterIcons now belong to each pot instance
    public Plant plant;
    public WaterIcon waterIcon;
    
    public void act()
    {
        
    }
    
    public void createPlant() {
        // Create plant
        plant = new Plant();
        int plantX = this.x;
        int plantY = this.y - 20;
        MyWorld.instance.addObject(plant, plantX, plantY);
        
        // Create plant's waterIcon
        waterIcon = new WaterIcon();
        int waterIconX = plantX + 30;
        int waterIconY = plantY - 20;
        MyWorld.instance.addObject(waterIcon, waterIconX, waterIconY);
    }
}
