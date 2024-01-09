import java.io.Serializable;

/**
 * Contains all player data to be saved in player's save file.
 * 
 * @author Julia 
 * @version January 2024
 */
public class PlayerData implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public int numSeeds = 3;
    public int currency = 500;
    public PlantData[] plantData = new PlantData[15];

    public PlayerData()
    {
        
    }
}
