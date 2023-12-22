import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Create the variables here (so that they can be accessed from other classes)
    public Wateringcan wateringCan;
    public Seed seed;
    
    // Create arrays
    public Pot[] pots = new Pot[5];
    public Pot currentPotInstance;
    
    // Create playerData instance
    public PlayerData playerData = new PlayerData();
    
    // Create currency Label
    public Label currencyLabel;
    
    // This is the Singleton design pattern
    // https://gameprogrammingpatterns.com/singleton.html
    // Store instance of MyWorld in the variable, instance
    public static MyWorld instance;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // Set variable instance to the current instance of MyWorld
        // To call variables in MyWorld from other classes: MyWorld.instance.variable
        instance = this;

        
        // Create watering can, in menu
        wateringCan = new Wateringcan();
        addObject(wateringCan, wateringCan.ogX, wateringCan.ogY);
        
        // Create seedbag, in menu
        seed = new Seed(true, "test"); // isOgicon = true, icon cannot be dragged, counts numSeeds
        addObject(seed, seed.ogX, seed.ogY);
        seed = new Seed(false, "test"); // isOgIcon = false, draggable icon, doesn't count numSeeds
        addObject(seed, seed.ogX, seed.ogY);
        
        // Create currency Label
        currencyLabel = new Label(this.playerData.currency, 100);
        addObject(currencyLabel, 300, 50);
        
        // Create pots in pot array
        for(int i = 0; i < pots.length; i++) {
            pots[i] = new Pot();
            addObject(pots[i], 100*(i+1), 200);
        }
    }
    
}
