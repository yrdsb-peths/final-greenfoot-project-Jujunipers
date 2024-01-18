import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.Instant;

/**
 * Commands to allow player to cheat/progress through the game faster
 * 
 * @author Julia
 * @version January
 */
public class Cheat extends Actor
{
    public Cheat() {
        getImage().setTransparency(0); // hide green foot image
    }

    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        // Press A to add 'move time forward'
        if(Greenfoot.isKeyDown("A")) {
            for(int i = 0; i < PlayerDataManager.getPlayerData().plantData.length; i++) {
                if(PlayerDataManager.getPlayerData().plantData[i] == null) {
                    continue;
                }
                long lastWateredTime = PlayerDataManager.getPlayerData().plantData[i].lastWateredTime;
                Instant instant = Instant.ofEpochSecond(lastWateredTime); // convert lastWateredTime (long) into an Instant
                PlayerDataManager.getPlayerData().plantData[i].lastWateredTime = instant.minusSeconds(5L).getEpochSecond();
            }
        }
    }
}