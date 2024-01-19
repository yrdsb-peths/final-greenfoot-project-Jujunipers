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
        
        // Add this to be a listener to property change events of EconomyManager
        EconomyManager.addListener(this);
    }
    
    /**
     * Called when a property change event is fired from EconomyManager (when player's currency changes)
     * -> updates currencyLabel's display value to new value
     * 
     * @param evt  instance of PropertyChangeEvent, describes the change that happened
     */
    public void propertyChange(PropertyChangeEvent evt) {
        currencyLabel.setValue((int) evt.getNewValue());
    }
}
