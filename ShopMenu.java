import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shop menu that player can open/close.
 * 
 * @author Julia
 * @version December 2023
 */
public class ShopMenu extends Actor
{
    public static ShopButton shopButton1;
    
    GreenfootImage shopImage;
    
    public ShopMenu() {
        // Set shop menu image
        shopImage = new GreenfootImage("images/shop/shop.png");
        shopImage.scale((int) (MyWorld.instance.scale * (double) shopImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopImage.getHeight()));
        setImage(shopImage);
        
        // Create seeds shopButton
        shopButton1 = new ShopButton("seeds");
        MyWorld.instance.addObject(shopButton1, 1005, 240);
        
        // Hide entire shop menu at the start of the game
        hide();
    }
    
    public void act()
    {
        
    }
    
    public void show() {
        shopImage.setTransparency(255);
        shopButton1.show();
    }
    
    public void hide() {
        shopImage.setTransparency(0);
        shopButton1.hide();
    }
}
