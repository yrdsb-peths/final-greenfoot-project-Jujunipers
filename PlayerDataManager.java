import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Write a description of class PlayerDataLoader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream when trying to save, check your file access permissions?");
        }
    }
    
    public static void loadData() {
        try {
            FileInputStream fi = new FileInputStream(new File(SAVE_FILE_NAME));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            // Read objects, sets playerData
            playerData = (PlayerData) oi.readObject();
            
            oi.close();
            fi.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found, creating new save...");
        } catch (IOException e) {
            System.out.println("Error initializing stream when trying to load, check your file access permissions?");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("OOPS!");
            e.printStackTrace();
        }
        if(playerData == null) {
            playerData = new PlayerData();
        }
    }
}
