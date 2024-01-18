import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world the game starts in upon being opened.
 * 
 * @author Julia
 * @version January 2024
 */
public class TitleScreen extends World
{
    private GreenfootImage bgImage = new GreenfootImage("images/title_screen.png");
    
    public TitleScreen()
    {    
        super(1200, 675, 1);
        
        bgImage.scale(1200, 675);
        setBackground(bgImage);
        Greenfoot.setWorld(this);
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
