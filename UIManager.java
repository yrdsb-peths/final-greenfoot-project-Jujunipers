import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates all items releated to UI.
 * 
 * @author Julia
 * @version December 2023
 */
public class UIManager
{
    
    public static CoinLabel coinLabel;
    
    public static Shop shopIcon;
    
    public UIManager() {
        // Create coinLabel
        coinLabel = new CoinLabel();
        
        // Create shopIcon
        shopIcon = new Shop();
        MyWorld.instance.addObject(shopIcon, 1097, 588);
    }
}
