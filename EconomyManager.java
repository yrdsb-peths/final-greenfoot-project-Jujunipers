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
    
    
    public static void addListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
    
    public static void removeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
    
    public static boolean hasEnoughMoney(int price) {
        return PlayerDataManager.getPlayerData().currency >= price;
    }

    public static void addMoney(int value) {
        int oldValue = PlayerDataManager.getPlayerData().currency;
        PlayerDataManager.getPlayerData().currency += value;
        support.firePropertyChange("coins", oldValue, PlayerDataManager.getPlayerData().currency);
    }
    
    public static void setMoney(int value) {
        int oldValue = PlayerDataManager.getPlayerData().currency;
        PlayerDataManager.getPlayerData().currency = value;
        support.firePropertyChange("coins", oldValue, value);
    }
    
    public static int getMoney() {
        return PlayerDataManager.getPlayerData().currency;
    }
}
