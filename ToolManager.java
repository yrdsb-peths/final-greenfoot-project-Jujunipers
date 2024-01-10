import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates all items in the toolbar.
 * 
 * @author Julia
 * @version December 2023
 */
public class ToolManager
{
    // Create tool variables
    public static WateringCan wateringCan;
    public static Seed seed;
    
    public ToolManager() {
        // Create wateringCan
        wateringCan = new WateringCan();
        MyWorld.instance.addObject(wateringCan, wateringCan.ogX, wateringCan.ogY);
        
        // Create seedbag, in menu
        seed = new Seed(true, "test"); // isOgicon = true, icon cannot be dragged, counts numSeeds
        MyWorld.instance.addObject(seed, seed.ogX, seed.ogY);
        seed = new Seed(false, "test"); // isOgIcon = false, draggable icon, doesn't count numSeeds
        MyWorld.instance.addObject(seed, seed.ogX, seed.ogY);
    }
}
