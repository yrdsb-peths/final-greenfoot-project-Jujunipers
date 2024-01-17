import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AudioManager here.
 * 
 * @author Julia
 * @version January 2024
 */
public class AudioManager extends Actor
{
    public static GreenfootSound boughtSFX;
    public static GreenfootSound soldSFX;
    public static GreenfootSound plantSFX;
    public static GreenfootSound wateringSFX;
    
    public AudioManager() {
        boughtSFX = new GreenfootSound("bought.wav");
        boughtSFX.setVolume(80);
        soldSFX = new GreenfootSound("sold.wav");
        soldSFX.setVolume(75);
        plantSFX = new GreenfootSound("planting.wav");
        plantSFX.setVolume(80);
        wateringSFX = new GreenfootSound("watering.wav");
    }
    
    public void act()
    {
        // Add your action code here.
    }
}