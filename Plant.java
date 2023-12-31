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
    public GreenfootImage[] plantImages = new GreenfootImage[5];
    
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
            for(int i = 0; i < 5; i++) {
                plantImages[i] = new GreenfootImage("images/plant_stages/stage" + i + ".png");
                plantImages[i].scale((int) (MyWorld.instance.scale * (double) plantImages[i].getWidth()), (int) ((double) MyWorld.instance.scale * plantImages[i].getHeight()));
            }
            //yAdjust = new int[]{-35, -40, -60, -75, -75};
        }
    }
    
    public void act()
    {
        // Depending on age: set different plant growth image, set different growthStage, adjust y pos of image
        if(age <= 0) {
            growthStage = 0;
            setImage(plantImages[growthStage]);
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(age <= 1) {
            growthStage = 1;
            setImage(plantImages[growthStage]);
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(age <= 2) {
            growthStage = 2;
            setImage(plantImages[growthStage]);
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else if(age <= 2) {
            growthStage = 3;
            setImage(plantImages[growthStage]);
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        } else {
            growthStage = 4;
            setImage(plantImages[growthStage]);
            //setLocation(getX(), potInstance.getY() + yAdjust[growthStage]); // move image according to yAdjust
        }
        
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!thirsty) {
            // Since not thirsty, set water icon to be transparent
            potInstance.waterIcon.transparency = 0;
            if(waterTimer.millisElapsed() < 1000) { // 10000
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
