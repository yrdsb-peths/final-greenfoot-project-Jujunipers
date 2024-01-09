import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cheat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cheat extends Actor
{
    public Cheat() {
        
    }
    
    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        if(mouseInfo != null) {
            if(Greenfoot.isKeyDown("C") && mouseInfo.getButton() == 3) {
                EconomyManager.addMoney(500);
            }
        }
    }
    
    
}
