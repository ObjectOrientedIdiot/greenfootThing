import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;


/**
 * Write a description of class intersection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class intersection extends Actor
{
    /**
     * Act - do whatever the intersection wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int timer = 0;
        
    public int[] getTempDestination(Direction dir, boolean wait, boolean start){ //wait == true is at the waiting line, wait == false is going away from the center
        double dFromCenter = 196.468827044; //distance from center
        double aFromCenter = (wait ? -0.25732371497 : 0.25732371497); //angle from center for east
        switch(dir){
            case SOUTH:
                aFromCenter += Math.PI/2;
                break;
            case WEST:
                aFromCenter += Math.PI;
                break;
            case NORTH:
                aFromCenter += Math.PI*3/2;
            default:
                break;
        }
        int[] out = {
            getX()+(int)(Math.cos(aFromCenter)*dFromCenter)+(((dir == Direction.EAST || dir == Direction.WEST)&&!start ? 210 : 0)*(dir == Direction.WEST ? -1 : 1)),
            getY()+(int)(Math.sin(aFromCenter)*dFromCenter)+(((dir == Direction.NORTH || dir == Direction.SOUTH)&&!start ? 210 : 0)*(dir == Direction.NORTH ? -1 : 1))
        };
        return out;
    }
    
    public static void plotCourse(car car, intersection inter, Direction start, Direction end)
    {
        ArrayList<MoveFrame> course = new ArrayList<>();
        int speed = (int)(Math.random()*50+20);
        int startFrames = speed;
        int turnFrames = (int)((double)speed*1.2);
        int endFrames = speed;
        for(int i=0; i<startFrames; i++)
        {
            int dx = (inter.getTempDestination(start, true, true)[0] - inter.getTempDestination(start, true, false)[0])/startFrames*i;
            int dy = (inter.getTempDestination(start, true, true)[1] - inter.getTempDestination(start, true, false)[1])/startFrames*i;
            MoveFrame mF = new MoveFrame(inter.getTempDestination(start, true, false)[0]+dx, inter.getTempDestination(start, true, false)[1]+dy, DMethods.angleFromDirection(DMethods.invertDirection(start)));
            course.add(mF);
        }
        
        for(int i=0; i<turnFrames; i++)
        {
            int dx = (inter.getTempDestination(end, false, true)[0] - inter.getTempDestination(start, true, true)[0])/turnFrames*i;
            int dy = (inter.getTempDestination(end, false, true)[1] - inter.getTempDestination(start, true, true)[1])/turnFrames*i;
            MoveFrame mF = new MoveFrame(inter.getTempDestination(start, true, true)[0]+dx, inter.getTempDestination(start, true, true)[1]+dy, (int)Math.toDegrees(Math.atan2((double)(inter.getTempDestination(end, false, true)[0] - inter.getTempDestination(start, true, true)[0]),(double)(inter.getTempDestination(start, true, true)[1]-inter.getTempDestination(end, false, true)[1]))));
            course.add(mF);
        }
        /*
        if((start == Direction.NORTH && end == Direction.SOUTH)||(start == Direction.SOUTH && end == Direction.NORTH)||(start == Direction.EAST && end == Direction.WEST)||(start == Direction.WEST && end == Direction.EAST)) // go straight
        {
            
        }*/
        
        for(int i=0; i<endFrames; i++)
        {
            int dx = (inter.getTempDestination(end, false, false)[0] - inter.getTempDestination(end, false, true)[0])/endFrames*i;
            int dy = (inter.getTempDestination(end, false, false)[1] - inter.getTempDestination(end, false, true)[1])/endFrames*i;
            MoveFrame mF = new MoveFrame(inter.getTempDestination(end, false, true)[0]+dx, inter.getTempDestination(end, false, true)[1]+dy, DMethods.angleFromDirection(end));
            course.add(mF);
        }
        car.setCourse(course);
    }
    
    public void act()
    {
        timer++;
        if(timer >= 60){ //spawn car
            timer = 0;
            Direction startDir = DMethods.randomDirection();
            Direction endDir = DMethods.randomDirection(startDir);
            int[] position = getTempDestination(startDir, true, false);
            car c = new car();
            getWorld().addObject(c, position[0],position[1] );
            plotCourse(c, this, startDir, endDir);
        }
    }
}


