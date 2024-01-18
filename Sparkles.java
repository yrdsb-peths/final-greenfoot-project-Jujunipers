import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sparkles here.
 * 
 * @author Julia
 * @version January 2024
 */
public class Sparkles extends Actor
{
    // SparkleAnim images
    private GreenfootImage[] sparkles = new GreenfootImage[3];
    private GreenfootImage transparentImage = new GreenfootImage("images/sparkle_anim/sparkle0.png"); // transparent version of sparkle
    private int imageIndex = 0; // keeps track of the frame that animation is on
    
    Plant plantInstance;
    
    // Create instance of imported timer
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Sparkles(Plant plantInstance) {
        this.plantInstance = plantInstance;
        
        // Create sparkleAnim images
        for(int i = 0; i < sparkles.length; i++) {
            sparkles[i] = new GreenfootImage("images/sparkle_anim/sparkle" + i + ".png");
        }
        
        // Set transparent image as default
        transparentImage.setTransparency(0);
        setImage(transparentImage);
        
        animationTimer.mark(); // resets timer to start at 0
    }
    
    public void act()
    {
        /*
        // Press F to play sparkle animation
        if(Greenfoot.isKeyDown("F") || Greenfoot.isKeyDown("f")) {
            playSparkleAnim();
        } else {
            hide();
        }
        */
    }
    
    public void playSparkleAnim() {
        if(animationTimer.millisElapsed() < 150)
        {
            return; // not return anything and get out of the method
            // What happens here is that we stay in this if statement for
            // ~100 milliseconds before getting out of the if statement
            // and moving on to next code (i observed this thru experimenting
            // with Log.info)
        }
        animationTimer.mark();
        
        if(imageIndex < sparkles.length) {
            setImage(sparkles[imageIndex]);
            imageIndex++;
        } else {
            hide();
        }
    }
    
    public void hide() {
        setImage(transparentImage);
    }
}
