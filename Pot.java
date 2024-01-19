import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.Instant;

/**
 * Pot that contains each plant.
 * 
 * @author Julia
 * @version December 2023
 */
public class Pot extends Actor
{
    public int index; // index of pot in Pot[] array in MyWorld
    public boolean hasPlant = false;
    
    // Create plant and waterIcon variables. plants and waterIcons now belong to each pot instance
    public Plant plant;
    
    
    
    private GreenfootImage potImage;
    
    public Pot(int index) {
        this.index = index;
        
        // Set pot image
        potImage = new GreenfootImage("images/pot.png");
        potImage.scale((int) (MyWorld.instance.scale * (double) potImage.getWidth()), (int) ((double) MyWorld.instance.scale * potImage.getHeight()));
        setImage(potImage);
    }
    
    public void act()
    {
        
    }
    
    /**
     * Creates the plant in the pot
     */
    public void createPlant() {
        hasPlant = true;
        
        // Create plant
        plant = new Plant(this);
        int plantX = this.getX() + 5;
        int plantY = this.getY() - 75;
        //int plantY = this.getY() + plant.yAdjust[plant.growthStage];
        MyWorld.instance.addObject(plant, plantX, plantY);
        
        // Create plant's waterIcon
        int waterIconX = plantX + 30;
        int waterIconY = plantY + 20;
        MyWorld.instance.addObject(plant.waterIcon, waterIconX, waterIconY);
        
        
    }
    
    /**
     * Creates a new plant in the pot
     * 
     * @param species  plant species
     */
    public void plantSeed(String species) {
        PlayerDataManager.getPlayerData().plantData[index] = new PlantData(); // makes it not null (creates the object lol)
        PlayerDataManager.getPlayerData().plantData[index].species = species;
        
        // Get the current epoch time in seconds
        long epochSeconds = Instant.now().getEpochSecond();
        
        // Set lastWateredTime to now!
        PlayerDataManager.getPlayerData().plantData[index].lastWateredTime = epochSeconds;
        
        createPlant();
        
        // Play plantSFX
        MyWorld.audioManager.plantSFX.play();
    }
    
    /**
     * Try to load plant from save file. If plant existed in the pot in the save file, add plant to pot.
     */
    public void tryLoadPlant() {
        // Create a plant from save file
        if(PlayerDataManager.getPlayerData().plantData[index] != null) { // null means there's no plant in that pot -> if that plant should exist, create plant from save file
            createPlant();
        }
    }
}
