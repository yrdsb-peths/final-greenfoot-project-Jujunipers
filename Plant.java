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
    private boolean fullyGrown = false;
    private int maxThirst = 600;
    private boolean tooThirsty = false;
    
    // p variable accesses the object at the index of the plantData[] array in PlayerData that this plant's variables are saved into
    PlantData p;
    
    // Create waterIcon, sparkleAnim associated with this plant instance
    public WaterIcon waterIcon;
    public Sparkles sparkles;
    
    // Growth timer - counts time between each increase of currentGrowth (without watering)
    SimpleTimer growthTimer = new SimpleTimer();
    
    // Plant growth images (depends on species)
    public GreenfootImage[] plantImages = new GreenfootImage[5];
    
    // Price value when sold (depends on species)
    private int value;
    
    // Adjustment variables for y pos compared to pot (depends on species and growth images of species)
    //public int[] yAdjust;
    
    // Pot instance
    public Pot potInstance;
    
    // Label with right-click selling instructions
    private Label sellInstructions = new Label("Right-click to sell!", 35);
    
    public Plant(Pot potInstance) {
        this.potInstance = potInstance;
        
        waterIcon = new WaterIcon();
        sparkles = new Sparkles(this);
        
        p = PlayerDataManager.getPlayerData().plantData[potInstance.index];
        
        // Load plant growth images depending on plant species
        if(p.species.equals("test")) {
            for(int i = 0; i < 5; i++) {
                plantImages[i] = new GreenfootImage("images/plant_stages/stage" + i + ".png");
                plantImages[i].scale((int) (MyWorld.instance.scale * (double) plantImages[i].getWidth()), (int) ((double) MyWorld.instance.scale * plantImages[i].getHeight()));
            }
            //yAdjust = new int[]{-35, -40, -60, -75, -75};
            value = 150;
        }
        
        growthTimer.mark(); // starts growthTimer
    }
    
    public void act()
    {
        // Depending on age: set different plant growth image, set different growthStage
        if(p.currentGrowth < 20) {
            p.growthStage = 0;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.currentGrowth <= 40) {
            p.growthStage = 1;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.currentGrowth <= 60) {
            p.growthStage = 2;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(p.currentGrowth <= 80) {
            p.growthStage = 3;
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else {
            p.growthStage = 4;
            // Create plant's sparkle animation, but only if just fully grew
            if(!fullyGrown) {
                fullyGrown = true;
                MyWorld.instance.addObject(sparkles, this.getX(), this.getY());
            }
            displaySellInstructionsOnHover();
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        }
        setImage(plantImages[p.growthStage]);
       
        // Increase plant thirst
        long epochSeconds = Instant.now().getEpochSecond();
        p.thirst = (int) (epochSeconds - p.lastWateredTime); // set thirst equal to the number of seconds that passed since last watering
        p.thirst = Math.min(p.thirst, maxThirst); // min returns the smaller of p.thirst and maxThirst, sets p.thirst to that -> ensures p.thirst doesn't go over maxThirst
        
        
        // If thirsty, make water icon appear
        if(p.isThirsty()) {
            waterIcon.show();
            // Increase size of waterIcon
            waterIcon.setScale(p.thirst/600.0);
        }
        
        // If right click on plant, sell plant, but only if full grown
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null) {
            if(p.growthStage == 4 && mouseInfo.getButton() == 3 && (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(this.potInstance))) {
                sellPlant();
            }
        }
        
        // Start next loop if 10 000 millis (10 secs) haven't passed. Only grow currentGrowth every 10 secs
        if(growthTimer.millisElapsed() < 10000) {
            return;
        }
        growthTimer.mark(); // reset growthTimer
        tooThirsty = p.thirst == maxThirst;
        if(!tooThirsty) {
            p.currentGrowth++;
        }
    }
    
    public void waterPlant() {
        // Play wateringSFX
        MyWorld.audioManager.wateringSFX.play();
        
        p.age++; // increase age
        waterIcon.hide(); // hide waterIcon
        
        // Convert all thirst to add to currentGrowth, then reset thirst
        p.currentGrowth += p.thirst / 100.0;
        p.thirst = 0;
        
        // Set last watered time to now:
        long epochSeconds = Instant.now().getEpochSecond();
        p.lastWateredTime = epochSeconds;
    }
    
    public void sellPlant() {
        MyWorld.instance.removeObject(sellInstructions);
        MyWorld.instance.removeObject(this);
        MyWorld.instance.removeObject(waterIcon);
        potInstance.hasPlant = false;
        EconomyManager.addMoney(value);
        PlayerDataManager.getPlayerData().plantData[potInstance.index] = null;
        MyWorld.audioManager.soldSFX.play();
    }
    
    public void displaySellInstructionsOnHover() {
        if(mouseIsHoveringOverPlant()) {
            sellInstructions.setFillColor(Color.WHITE);
            sellInstructions.setLineColor(Label.transparent);
            MyWorld.instance.addObject(sellInstructions, 1050, 30);
        } else {
            sellInstructions.setFillColor(Label.transparent);
            sellInstructions.setLineColor(Label.transparent);
        }
    }
    
    public boolean mouseIsHoveringOverPlant() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null) {
            // Coordinates for boundaries of plant + pot
            int plantLeft = this.getX() - (this.getImage().getWidth())/2;
            int plantRight = this.getX() + (this.getImage().getWidth())/2;
            int plantTop = this.getY() - (this.getImage().getHeight())/2;
            int plantBottom = this.getY() + (this.getImage().getHeight())/2;
            return mouseInfo.getX() > plantLeft && mouseInfo.getX() < plantRight && mouseInfo.getY() > plantTop && mouseInfo.getY() < plantBottom;
        }
        return false;
    }
}
