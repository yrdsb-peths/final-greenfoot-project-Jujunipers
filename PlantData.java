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
    
    public boolean thirsty = false;
    
    public int age = 0;
    public int growthStage = 0; // growthStage determines image to use for plant, as well as amount of y to adjust from pot
    
    // Plant species
    public String species = "";
    
    

    public PlantData()
    {
        
    }
}
