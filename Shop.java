import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages the shop icon and the opening of the shop menu.
 * 
 * @author Julia
 * @version December 2023
 */
public class Shop extends Actor
{
    GreenfootImage shopIconImage;
    
    // Create shopMenu and shopButton variables. shopMenu instance and shopButton instances now belong to Shop instance
    public static ShopMenu shopMenu;
    
    // Whether or not shop is open
    public boolean isOpen;
    
    public Shop() {
        // Set shopIcon image
        shopIconImage = new GreenfootImage("images/shopping_cart.png");
        shopIconImage.scale((int) (MyWorld.instance.scale * (double) shopIconImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopIconImage.getHeight()));
        setImage(shopIconImage);
        
        // Create shopMenu
        shopMenu = new ShopMenu();
        MyWorld.instance.addObject(shopMenu, 1055, 340);
    }
    
    public void act()
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        // Check if mouse clicked on Shop icon, and if yes, open shopMenu
        if(mouseInfo != null) {
            if(!isOpen && Greenfoot.mouseClicked(this)) {
                isOpen = true;
                shopMenu.show();
            } else if(isOpen && Greenfoot.mouseClicked(this)) {
                isOpen = false;
                shopMenu.hide();
            }
        }
    }
}
