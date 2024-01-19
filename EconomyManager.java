import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

   
/** Hosts methods involving everything to do with player's currency, manages all classes that are related to currency.
 * 
 * @author Julia
 * @version January 2024
 */
public class EconomyManager
{
    private static PropertyChangeSupport support;

    public EconomyManager()
    {
        support = new PropertyChangeSupport(this);
    }
    
    /**
     * Add pcl as a listener to EconomyManager's property changes
     * 
     * @param pcl  PropertyChangeListener to be added as a listener. Will be notified upon property changes
     */
    public static void addListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
    
    /**
     * Remove pcl from being a listener.
     * 
     * @param pcl  PropertyChangeListener to be removed from list of listeners
     */
    public static void removeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
    
    /**
     * Checks whether or not player has enough currency to purchase seed
     * 
     * @param price  price of seed
     * @return  whether or not player has enough currency to purchase seed
     */
    public static boolean hasEnoughMoney(int price) {
        return PlayerDataManager.getPlayerData().currency >= price;
    }
    
    /**
     * Increases currency by a certain value
     * 
     * @param value  value of currency to increased by
     */
    public static void addMoney(int value) {
        int oldValue = PlayerDataManager.getPlayerData().currency;
        PlayerDataManager.getPlayerData().currency += value;
        support.firePropertyChange("coins", oldValue, PlayerDataManager.getPlayerData().currency);
    }
    
    /**
     * Set player's currency to a certain value
     * 
     * @param value  value of currency to be set to
     */
    public static void setMoney(int value) {
        int oldValue = PlayerDataManager.getPlayerData().currency;
        PlayerDataManager.getPlayerData().currency = value;
        support.firePropertyChange("coins", oldValue, value);
    }
    
    /**
     * @return  player's currency value
     */
    public static int getMoney() {
        return PlayerDataManager.getPlayerData().currency;
    }
}
