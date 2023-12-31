import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    GreenfootImage shopIconImage;
    
    // Create shopMenu variable. shopMenu now belong to each Shop instance
    public ShopMenu shopMenu;
    
    // Whether or not shop is open
    public boolean isOpen;
    
    public Shop() {
        // Set shopIcon image
        shopIconImage = new GreenfootImage("images/shopping_cart.png");
        shopIconImage.scale((int) (MyWorld.instance.scale * (double) shopIconImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopIconImage.getHeight()));
        setImage(shopIconImage);
        
        shopMenu = new ShopMenu();
        MyWorld.instance.addObject(shopMenu, 1055, 340);
    }
    
    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        // Allow mouse to click and drag wateringCan around
        if(mouseInfo != null) {
            if(!isOpen && Greenfoot.mouseClicked(this)) {
                isOpen = true;
                shopMenu.transparency = 255;
            } else if(isOpen && Greenfoot.mouseClicked(this)) {
                isOpen = false;
                shopMenu.transparency = 0;
            }
        }
    }
}
