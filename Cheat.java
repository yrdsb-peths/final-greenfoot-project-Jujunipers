import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.time.Instant;

/**
 * Write a description of class Cheat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cheat extends Actor
{
    public Cheat() {
        getImage().setTransparency(0); // hide green foot image
    }

    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        if(mouseInfo != null) {
            if(Greenfoot.isKeyDown("C") && mouseInfo.getButton() == 3) {
                EconomyManager.addMoney(500);
            }
        }
       
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