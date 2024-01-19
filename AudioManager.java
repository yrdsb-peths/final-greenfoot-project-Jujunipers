import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates all audio files and sets their volumes
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
    
    public static GreenfootSound bgm;
    
    public AudioManager() {
        boughtSFX = new GreenfootSound("bought.wav");
        boughtSFX.setVolume(80);
        soldSFX = new GreenfootSound("sold.wav");
        soldSFX.setVolume(75);
        plantSFX = new GreenfootSound("planting.wav");
        plantSFX.setVolume(80);
        wateringSFX = new GreenfootSound("watering.wav");
        bgm = new GreenfootSound("bgm.mp3");
        bgm.setVolume(60);
    }
    
    public void act()
    {
        
    }
}
