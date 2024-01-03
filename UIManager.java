import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIManager extends Actor
{
    // Create currency Label
    public static Label currencyLabel;
    
    public static Shop shopIcon;
    
    public UIManager() {
        // Create currency Label
        currencyLabel = new Label(PlayerDataManager.getPlayerData().currency, 40);
        MyWorld.instance.addObject(currencyLabel, 140, 610);
        
        // Create shopIcon
        shopIcon = new Shop();
        MyWorld.instance.addObject(shopIcon, 1097, 588);
    }
    
    public void act()
    {
        
    }
}
