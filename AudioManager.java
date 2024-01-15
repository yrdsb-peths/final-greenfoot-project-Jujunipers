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
    
    public AudioManager() {
        boughtSFX = new GreenfootSound("bought.mp3");
        soldSFX = new GreenfootSound("sold.wav");
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
