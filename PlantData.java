import java.io.Serializable;

/**
 * Contains the data of each plant to be saved in PlayerData.
 * 
 * @author Julia
 * @version January 2024
 */
public class PlantData implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    //public boolean thirsty = false;
    
    // Last time plant was watered, epoch time in seconds
    public long lastWateredTime;
    
    public int age = 0; // age is number of waters
    public int thirst = 0; // num seconds since lastWateredTime
    public double currentGrowth = 0.0; // num seconds of growth
    public int growthStage = 0; // growthStage determines image to use for plant, as well as amount of y to adjust from pot
    
    // Plant species
    public String species = "";
    
    
    
    

    public PlantData()
    {
        
    }
    
    public boolean isThirsty() {
       return thirst >= 15;
       }
   

}
