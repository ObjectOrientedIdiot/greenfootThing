import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class explosion extends Actor
{
    int timer = 0;
    
    public void act()
    {
        timer++;
        if(timer>30){
            getWorld().removeObject(this);
            return;
        }
    }
}
