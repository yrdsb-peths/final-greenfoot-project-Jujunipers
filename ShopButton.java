import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButton extends Actor
{
    public int price;
    public String item;
    
    public Label priceLabel;
    
    GreenfootImage shopButtonImage;
    
    public ShopButton(String item) {
        this.item = item;
        shopButtonImage = new GreenfootImage("images/shop/shop_item_" + item + ".png");
        shopButtonImage.scale((int) (MyWorld.instance.scale * (double) shopButtonImage.getWidth()), (int) ((double) MyWorld.instance.scale * shopButtonImage.getHeight()));
        setImage(shopButtonImage);
        
        // Set price
        if(item.equals("seeds")) {
            price = 300;
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
        boolean hasMoney = PlayerDataManager.getPlayerData().currency >= this.price; // prolly don't needa be asked every frame
        
        // Check if mouse clicked on ShopButton, and if yes, buy item
        if(mouseInfo != null) {
            if(hasMoney && Greenfoot.mouseClicked(this)) {
                // Decrease currency
                PlayerDataManager.getPlayerData().currency -= this.price;
                MyWorld.instance.currencyLabel.setValue(PlayerDataManager.getPlayerData().currency);
                System.out.println("bought!");
                
                // Increase item amount in inventory
                if(item.equals("seeds")) {
                    MyWorld.instance.playerData.numSeeds ++;
                    MyWorld.instance.seed.seedCounter.setValue(MyWorld.instance.playerData.numSeeds);
                }
            }
        }
    }
    
    public void show() {
        shopButtonImage.setTransparency(255);
        priceLabel.setFillColor(new Color(236, 206, 159, 255));
    }
    
    public void hide() {
        shopButtonImage.setTransparency(0);
        priceLabel.setFillColor(new Color(236, 206, 159, 0));
    }
}
