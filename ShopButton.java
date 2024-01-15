import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button for each item that can be bought in the shop menu.
 * 
 * @author Julia
 * @version December 2023
 */
public class ShopButton extends Actor
{
    public int price;
    public String item;
    public boolean isDisabled = false;
    
    public Label priceLabel;
    
    GreenfootImage shopButtonImage;
    GreenfootImage shopButtonImageDark; // icon for when button is disabled
    
    public ShopButton(String item) {
        this.item = item;
        shopButtonImage = new GreenfootImage("images/shop/shop_item_" + item + ".png");
        shopButtonImage.scale((int) (MyWorld.instance.scale * (double) shopButtonImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopButtonImage.getHeight()));
        setImage(shopButtonImage);
        
        shopButtonImageDark = new GreenfootImage("images/shop/shop_item_" + item + "_dark.png");
        shopButtonImageDark.scale((int) (MyWorld.instance.scale * (double) shopButtonImageDark.getWidth()), (int) ((double) MyWorld.instance.scale * shopButtonImageDark.getHeight()));
        
        // Set price
        if(item.equals("seeds")) {
            price = 100;
        }
        
        // Create price label, display price
        priceLabel = new Label(price, 21);
        priceLabel.setLineColor(new Color(0, 0, 0, 0)); // transparent lines
        MyWorld.instance.addObject(priceLabel, 500, 500);
        
    }
    
    public void act()
    {
        // Reset priceLabel location
        priceLabel.setLocation(getX() - 4, getY() + 51);
        
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        
        
        // Check if mouse clicked on ShopButton, and if yes, buy item
        if(mouseInfo != null) {
            if(EconomyManager.hasEnoughMoney(this.price) && Greenfoot.mouseClicked(this)) {
                // Decrease currency
                EconomyManager.addMoney(-price);
                MyWorld.audioManager.boughtSFX.play();
                
                // Increase item amount in inventory
                if(item.equals("seeds")) {
                    PlayerDataManager.getPlayerData().numSeeds ++;
                    MyWorld.toolManager.seed.seedCounter.setValue(PlayerDataManager.getPlayerData().numSeeds);
                }
            }
        }
        
        // Set icon image to regular (enabled) or dark (disabled) depending on whether or not player has enough money to buy
        if(!isDisabled && !EconomyManager.hasEnoughMoney(this.price)) {
            setImage(shopButtonImageDark);
            isDisabled = true;
        }
        if(isDisabled && EconomyManager.hasEnoughMoney(this.price)) {
            setImage(shopButtonImage);
            isDisabled = false;
        }
    }
    
    public void show() {
        shopButtonImage.setTransparency(255);
        shopButtonImageDark.setTransparency(255);
        priceLabel.setFillColor(new Color(236, 206, 159, 255));
    }
    
    public void hide() {
        shopButtonImage.setTransparency(0);
        shopButtonImageDark.setTransparency(0);
        priceLabel.setFillColor(new Color(236, 206, 159, 0));
    }
}
