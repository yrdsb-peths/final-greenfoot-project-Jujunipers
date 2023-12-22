import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seed extends Actor
{
    boolean dragging = false;
    boolean isOgIcon;
    // Original location of seedbag
    public int ogX = 100;
    public int ogY = 25;
    
    // Create seedCounter variable (amount of seeds that player owns). seedCounter belongs to the seed instance
    public Label seedCounter;
    
    GreenfootImage seed;
    
    public Seed(boolean isOgIcon) {
        this.isOgIcon = isOgIcon;
        
        // Create seed image
        seed = new GreenfootImage("images/seeds.jpg");
        seed.scale(36, 38);
        setImage(seed);
        
        // Create seedCounter number, but only addObject if seed instance is the original icon
        seedCounter = new Label(MyWorld.instance.playerData.numSeeds, 25);
        if(isOgIcon) {
            MyWorld.instance.addObject(seedCounter, ogX + 25, ogY + 20);
        }
    }
    
    public void act()
    {
        // Only allow mouse to click and drag seedback around if numSeeds > 0
        
        if(MyWorld.instance.playerData.numSeeds >0) {
        
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            
            // Allow mouse to click and drag seedbag around
            if(mouseInfo != null) {
                if(!dragging && Greenfoot.mouseDragged(this)) {
                    dragging = true;
                }
                if(dragging && Greenfoot.mouseDragEnded(this)) {
                    dragging = false;
                    
                    Pot potInstance = (Pot) getOneIntersectingObject(Pot.class); // gets the specific pot instance that the mouse is touching
                    // Plant seed in pot, but only if it doesn't already have a plant and player still has seeds left
                    if(isTouching(Pot.class) && !potInstance.hasPlant && MyWorld.instance.playerData.numSeeds > 0) {
                        setLocation(ogX, ogY); // temporary, replace with planting animation
                        
                        // Create plant
                        potInstance.createPlant();
                        
                        // Change numSeeds value in PlayerData and label image
                        MyWorld.instance.playerData.numSeeds--;
                    } else {
                        setLocation(ogX, ogY); // return seedbag to og location when drag is released
                    }
                }
                // Make seedbag follow mouse if dragging is true
                if(dragging) {
                    setLocation(mouseInfo.getX(), mouseInfo.getY());
                }
            }
        }
        // Set value of numSeeds in its label, and update the label image
        seedCounter.setValue(MyWorld.instance.playerData.numSeeds);
    }
}
