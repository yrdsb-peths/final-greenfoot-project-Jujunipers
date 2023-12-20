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
    
    // Create plant and waterIcon variables. plants and waterIcons now belong to each pot instance
    public Plant plant;
    public WaterIcon waterIcon;
    
    
    private GreenfootImage potImage;
    
    public Pot() {
        // Set pot image
        potImage = new GreenfootImage("images/pot.jpg");
        potImage.scale(66, 62);
        setImage(potImage);
    }
    
    public void act()
    {
        
    }
    
    public void createPlant() {
        hasPlant = true;
        
        // Create plant
        plant = new Plant(this, "test");
        int plantX = this.getX();
        int plantY = this.getY() + plant.yAdjust[plant.growthStage];
        MyWorld.instance.addObject(plant, plantX, plantY);
        
        // Create plant's waterIcon
        waterIcon = new WaterIcon();
        int waterIconX = plantX + 30;
        int waterIconY = plantY - 20;
        MyWorld.instance.addObject(waterIcon, waterIconX, waterIconY);
    }
}
