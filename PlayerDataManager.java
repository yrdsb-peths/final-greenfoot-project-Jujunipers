import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Manages the loading and saving of player's data.
 * 
 * @author Julia
 * @version January 2024
 */
public class PlayerDataManager  
{
    static PlayerData playerData;
    
    static final String SAVE_FILE_NAME = "Player_save.meow";

    public PlayerDataManager()
    {
        
    }
    
    public static PlayerData getPlayerData() {
        if(playerData == null) {
            loadData();
        }
        return playerData;
    }
    
    public static void saveData() {
        try {
            FileOutputStream f = new FileOutputStream(new File(SAVE_FILE_NAME));
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            // Write objects to file
            o.writeObject(playerData);
            
            o.close();
            f.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void loadData() {
        try {
            FileInputStream fi = new FileInputStream(new File(SAVE_FILE_NAME));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            // Read objects, set playerData
            playerData = (PlayerData) oi.readObject();
            
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(playerData == null) {
            playerData = new PlayerData();
        }
    }
}
