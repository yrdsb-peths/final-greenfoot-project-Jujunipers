import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.beans.*;

/**
 * Display of player's currency in the bottom left corner of the game screen.
 * 
 * @author Julia
 * @version December 2023
 */
public class CoinLabel implements PropertyChangeListener
{
    // Create currency Label
    public static Label currencyLabel;
    
    public CoinLabel() {
        // Create currency Label
        currencyLabel = new Label(EconomyManager.getMoney(), 40);
        MyWorld.instance.addObject(currencyLabel, 140, 610);
        
        EconomyManager.addListener(this);
    }
    
    public void propertyChange(PropertyChangeEvent evt) {
        currencyLabel.setValue((int) evt.getNewValue());
    }
}
