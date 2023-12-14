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
    public Plant plant;
    public Pot pot;
    
    // Create arrays
    public Pot[] pots = new Pot[3];
    
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

        
        // Create watering can
        wateringCan = new Wateringcan();
        addObject(wateringCan, wateringCan.ogX, wateringCan.ogY);
        
        // Create plant
        plant = new Plant();
        addObject(plant, 300, 300);
        
        // Create pots
        for(int i = 0; i < pots.length; i++) {
            Pot pot = new Pot();
            addObject(pot, 100 + i*100, 200);
        }
        
    }
    
}
