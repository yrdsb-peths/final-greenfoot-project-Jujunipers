/**
 * Write a description of class PlayerData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerData  
{
    // This is the Singleton design pattern
    // https://gameprogrammingpatterns.com/singleton.html
    // Store instance of MyWorld in the variable, instance
    public static PlayerData instance;
    
    public static int numSeeds;

    public PlayerData()
    {
        // Set variable instance to the current instance of MyWorld
        // To call variables in MyWorld from other classes: MyWorld.instance.variable
        instance = this;
        
        numSeeds = 3;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        return 5;
    }
}
