import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.Instant;
import java.lang.Math;

/**
 * Each plant that the player grows.
 * 
 * @author Julia 
 * @version December 2023
 */
public class Plant extends Actor
{
    // p variable accesses the object at the index of the plantData[] array in PlayerData that this plant's variables are saved into
    PlantData p;
    
    // Create waterIcon associated with this plant instance
    public WaterIcon waterIcon;
        
    
    //SimpleTimer waterTimer = new SimpleTimer();
    
    // Plant growth images (depends on species)
    public GreenfootImage[] plantImages = new GreenfootImage[5];
    
    // Price value when sold (depends on species)
    private int value;
    
    // Adjustment variables for y pos compared to pot (depends on species and growth images of species)
    //public int[] yAdjust;
    
    // Pot instance
    public Pot potInstance;
    
    /*
     * Constructor
     */
    public Plant(Pot potInstance) {
        //waterTimer.mark(); // starts waterTimer
        
        this.potInstance = potInstance;
        
        waterIcon = new WaterIcon();
        
        p = PlayerDataManager.getPlayerData().plantData[potInstance.index];
        
        // Load plant growth images depending on plant species
        if(p.species.equals("test")) {
            for(int i = 0; i < 5; i++) {
                plantImages[i] = new GreenfootImage("images/plant_stages/stage" + i + ".png");
                plantImages[i].scale((int) (MyWorld.instance.scale * (double) plantImages[i].getWidth()), (int) ((double) MyWorld.instance.scale * plantImages[i].getHeight()));
            }
            //yAdjust = new int[]{-35, -40, -60, -75, -75};
            value = 100;
        }
    }
    
    public void act()
    {
        // Depending on age: set different plant growth image, set different growthStage, adjust y pos of image
        if(p.age <= 0) {
            p.growthStage = 0;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.age <= 1) {
            p.growthStage = 1;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.age <= 2) {
            p.growthStage = 2;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.age <= 2) {
            p.growthStage = 3;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else {
            p.growthStage = 4;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        }
        setImage(plantImages[p.growthStage]);
        
        /*
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!p.thirsty) {
            // Since not thirsty, set water icon to be transparent
            waterIcon.transparency = 0;
            if(waterTimer.millisElapsed() < 1000) { // 10000
                return;
            }
            p.thirsty = true;
        }
        waterTimer.mark(); // reset waterTimer
        */
       
        // Increase plant thirst
        long epochSeconds = Instant.now().getEpochSecond();
        p.thirst = (int) (epochSeconds - p.lastWateredTime); // set thirst equal to the number of seconds that passed since last watering
        p.thirst = Math.min(p.thirst, 600); // min returns the smaller of p.thirst and 600, sets p.thirst to that -> ensures p.thirst doesn't go over 600
        // Increase size of waterIcon
        waterIcon.setScale(p.thirst/600.0);
        
        // If thirsty, make water icon appear
        if(p.isThirsty()) {
            waterIcon.show();
        }
        
        // If right click on plant, sell plant, but only if full grown
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null) {
            if(p.growthStage == 4 && mouseInfo.getButton() == 3 && (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(this.potInstance))) {
                sellPlant();
            }
        }
    }
    
    public void waterPlant() {
        //waterTimer.mark(); // restart the thirst count
        p.age++; // increase age
        waterIcon.hide(); // hide waterIcon
        
        // Convert all thirst to currentGrowth, then reset thirst
        p.currentGrowth = p.thirst;
        p.thirst = 0;
        
        // Set last watered time to now:
        long epochSeconds = Instant.now().getEpochSecond();
        p.lastWateredTime = epochSeconds;
    }
    
    public void sellPlant() {
        MyWorld.instance.removeObject(this);
        MyWorld.instance.removeObject(waterIcon);
        potInstance.hasPlant = false;
        EconomyManager.addMoney(value);
        PlayerDataManager.getPlayerData().plantData[potInstance.index] = null;
        MyWorld.audioManager.soldSFX.play();
    }
    
    /* Just in case I implement manual saving
    public void saveData() {
        if(p == null) {
            p = new PlantData();
        }
    }
    */
   
    
    
    
}
