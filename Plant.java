import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    // p variable accesses the object at the index of the plantData[] array in PlayerData that this plant's variables are saved into
    PlantData p;
        
    
    SimpleTimer waterTimer = new SimpleTimer();
    
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
        waterTimer.mark(); // starts waterTimer
        
        this.potInstance = potInstance;
        
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
        
        // If right click on plant, sell plant, but only if full grown
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null) {
            if(p.growthStage == 4 && mouseInfo.getButton() == 3 && (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(this.potInstance))) {
                sellPlant();
            }
        }
        
        // Plant becomes thirsty again after every 10 000 milliseconds
        if(!p.thirsty) {
            // Since not thirsty, set water icon to be transparent
            potInstance.waterIcon.transparency = 0;
            if(waterTimer.millisElapsed() < 1000) { // 10000
                return;
            }
            p.thirsty = true;
            System.out.println("thirsty");
            System.out.println("!");
        }
        waterTimer.mark(); // reset waterTimer
        
        // If thirsty, make water icon appear
        if(p.thirsty) {
            potInstance.waterIcon.transparency = 255;
        }
    }
    
    public void waterPlant() {
        p.thirsty = false;
        waterTimer.mark(); // restart the thirst count
        p.age++; // increase age
    }
    
    public void sellPlant() {
        PlayerDataManager.getPlayerData().currency += value;
        MyWorld.instance.uiManager.currencyLabel.setValue(PlayerDataManager.getPlayerData().currency);
        System.out.println("Sold!");
    }
    
    public void saveData() {
        if(p == null) {
            p = new PlantData();
        }
        
    }
}
