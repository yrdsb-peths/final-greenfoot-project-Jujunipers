import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopMenu extends Actor
{
    public int transparency = 0;
    
    GreenfootImage shopImage;
    
    public ShopMenu() {
        // Set shop menu image, but transparent
        shopImage = new GreenfootImage("images/shop.png");
        shopImage.scale((int) (MyWorld.instance.scale * (double) shopImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopImage.getHeight()));
        setImage(shopImage);
    }
    
    public void act()
    {
        shopImage.setTransparency(transparency);
    }
}
