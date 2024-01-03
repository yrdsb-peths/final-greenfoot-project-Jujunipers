import java.io.Serializable;

/**
 * Write a description of class PlayerData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
