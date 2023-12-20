import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    SimpleTimer waterTimer = new SimpleTimer();
    
    public boolean thirsty = false;
    
    private int age = 0;
    public int growthStage = 0; // growthStage determines image to use for plant, as well as amount of y to adjust from pot
    
    // Plant species
    public String species = "";
    
    // Plant growth images (depends on species)
    public GreenfootImage[] plantImages = new GreenfootImage[3];
    
    // Adjustment variables for y pos compared to pot (depends on species and growth images of species)
    public int[] yAdjust;
    
    // Pot instance
    Pot potInstance;
    
    /*
     * Constructor
     */
    public Plant(Pot potInstance, String species) {
        waterTimer.mark(); // starts waterTimer
        
        this.potInstance = potInstance;
        this.species = species;
        
        // Load plant growth images depending on plant species
        if(species.equals("test")) {
            //plantImages = new GreenfootImage[3];
            for(int i = 0; i < 3; i++) {
                plantImages[i] = new GreenfootImage("images/plant" + i + ".png");
            }
            yAdjust = new int[]{-32, -42, -69};
        }
    }
    
    public void act()
    {
        // Depending on age: set different plant growth image, set different growthStage, adjust y pos of image
        if(age <= 1) {
            growthStage = 0;
            plantImages[growthStage].scale(57, 24);
            setImage(plantImages[growthStage]);
            setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(age <= 2) {
            growthStage = 1;
            plantImages[growthStage].scale(58, 44);
            setImage(plantImages[growthStage]);
            setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else {
            growthStage = 2;
            plantImages[growthStage].scale(58, 99);
            setImage(plantImages[growthStage]);
            setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        }
        
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!thirsty) {
            // Since not thirsty, set water icon to be transparent
            potInstance.waterIcon.transparency = 0;
            if(waterTimer.millisElapsed() < 10000) {
                return;
            }
            thirsty = true;
            System.out.println("thirsty");
            System.out.println("!");
        }
        waterTimer.mark(); // reset waterTimer
        
        // If thirsty, make water icon appear
        if(thirsty) {
            potInstance.waterIcon.transparency = 255;
        }
    }
    
    public void waterPlant() {
        potInstance.plant.thirsty = false;
        potInstance.plant.waterTimer.mark(); // restart the thirst count
        age++; // increase age
    }
}
