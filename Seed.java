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
    public int ogX;
    public int ogY;
    
    // Create seedCounter variable (amount of seeds that player owns). seedCounter belongs to the seed instance
    public Label seedCounter;
    
    public String species;
    
    GreenfootImage seedImage;
    
    public Seed(boolean isOgIcon, String species) {
        this.isOgIcon = isOgIcon;
        this.species = species;
        
        // Create seed image
        if(species.equals("test")) {
            seedImage = new GreenfootImage("images/seeds.png");
            seedImage.scale((int) (MyWorld.instance.scale * (double) seedImage.getWidth()), (int) ((double) MyWorld.instance.scale * seedImage.getHeight()));
            // original menu location for icon
            ogX = 90;
            ogY = 210;
        }
        setImage(seedImage);
        
        // Create seedCounter number, but only addObject if seed instance is the original icon
        seedCounter = new Label(PlayerDataManager.getPlayerData().numSeeds, 35);
        if(isOgIcon) {
            MyWorld.instance.addObject(seedCounter, ogX + 30, ogY + 30);
        }
    }
    
    public void act()
    {
        // Only allow mouse to click and drag seedback around if numSeeds > 0
        
        if(PlayerDataManager.getPlayerData().numSeeds >0) {
        
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
                    if(isTouching(Pot.class) && !potInstance.hasPlant && PlayerDataManager.getPlayerData().numSeeds > 0) {
                        setLocation(ogX, ogY); // temporary, replace with planting animation
                        
                        // Create plant
                        potInstance.plantSeed(species);
                        
                        // Change numSeeds value in PlayerData and label image
                        PlayerDataManager.getPlayerData().numSeeds--;
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
        seedCounter.setValue(PlayerDataManager.getPlayerData().numSeeds);
    }
}
