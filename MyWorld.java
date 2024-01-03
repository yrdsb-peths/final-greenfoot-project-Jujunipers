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
    public WateringCan wateringCan;
    public Seed seed;
    public Shop shopIcon;
    
    // Create arrays
    public Pot[] pots = new Pot[15];
    public Pot currentPotInstance;
    
    // Create playerData instance
    public PlayerData playerData = new PlayerData();
    
    // Create currency Label
    public Label currencyLabel;
    
    // Create image variables
    private GreenfootImage bgImage = new GreenfootImage("images/bg.png");
    
    // This is the Singleton design pattern
    // https://gameprogrammingpatterns.com/singleton.html
    // Store instance of MyWorld in the variable, instance
    public static MyWorld instance;
    
    // Dimensions (scaled to 1.5x of 1600x900)
    public double scale = 0.75;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // UI that I drew - canvas is 1600x900, but doesn't fit my comp screen,
        // so I instead made MyWorld 1.5x those dimensions
        super(1200, 675, 1);
        
        // Set variable instance to the current instance of MyWorld
        // To call variables in MyWorld from other classes: MyWorld.instance.variable
        instance = this;

        
        // Set background image
        bgImage.scale(1200, 675);
        this.setBackground(bgImage);
        
        // Create watering can, in menu
        wateringCan = new WateringCan();
        addObject(wateringCan, wateringCan.ogX, wateringCan.ogY);
        
        // Create seedbag, in menu
        seed = new Seed(true, "test"); // isOgicon = true, icon cannot be dragged, counts numSeeds
        addObject(seed, seed.ogX, seed.ogY);
        seed = new Seed(false, "test"); // isOgIcon = false, draggable icon, doesn't count numSeeds
        addObject(seed, seed.ogX, seed.ogY);
        
        // Create currency Label
        currencyLabel = new Label(PlayerDataManager.getPlayerData().currency, 40);
        addObject(currencyLabel, 140, 610);
        
        // Create pots in pot array
        for(int i = 0; i < pots.length; i++) {
            pots[i] = new Pot(i);
            addObject(pots[i], 420+(i%5 *95), 120+(i/5 * 180));
            pots[i].tryLoadPlant();
        }
        
        // Create shopIcon
        shopIcon = new Shop();
        addObject(shopIcon, 1097, 588);
        
        // Set order of object images
        setPaintOrder(Label.class, ShopButton.class, ShopMenu.class, Shop.class, Seed.class, WateringCan.class, WaterIcon.class, Pot.class, Plant.class);
    }
    
    public void stopped() {
        PlayerDataManager.saveData();
    }
}
