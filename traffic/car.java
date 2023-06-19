import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class car extends Actor
{
    protected ArrayList<MoveFrame> course;
    protected boolean wait = false;
    public static double clamp(double val, double min, double max)
    {
        return Math.max(min, Math.min(max, val));
    }
    
    public void setCourse(ArrayList<MoveFrame> course)
    {
        this.course = course; 
    }
    
    public void act()
    {
        if(course == null)
        {
            getWorld().removeObject(this);
            return;
        }
        if(course.size()<1)
        {
            getWorld().removeObject(this);
            return;
        }
        if(!wait){
            MoveFrame current = course.get(0);
            setLocation(current.x(), current.y());
            setRotation(current.a());
            course.remove(0);
        }
        
        if(isTouching(car.class))
        {
            explosion e = new explosion();
            Actor other = getOneIntersectingObject(car.class);
            getWorld().addObject(e, getX(), getY());
            getWorld().addObject(e, other.getX(), other.getY());
            getWorld().removeObject(other);
            getWorld().removeObject(this);
            return;
        }
    }
    
    protected void addedToWorld(World world)
    {
        
    }
}
