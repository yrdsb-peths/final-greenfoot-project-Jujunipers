import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToolManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToolManager extends Actor
{
    // Create tool variables
    public static WateringCan wateringCan;
    public static Seed seed;
    
    public ToolManager() {
        // Create all tools in menu
        
        // Create wateringCan
        wateringCan = new WateringCan();
        MyWorld.instance.addObject(wateringCan, wateringCan.ogX, wateringCan.ogY);
        
        // Create seedbag, in menu
        seed = new Seed(true, "test"); // isOgicon = true, icon cannot be dragged, counts numSeeds
        MyWorld.instance.addObject(seed, seed.ogX, seed.ogY);
        seed = new Seed(false, "test"); // isOgIcon = false, draggable icon, doesn't count numSeeds
        MyWorld.instance.addObject(seed, seed.ogX, seed.ogY);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
