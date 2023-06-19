/**
 * Write a description of class DMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DMethods  
{
    public static Direction invertDirection(Direction dir)
    {
        switch(dir)
        {
            case EAST:
                return Direction.WEST;
            case SOUTH:
                return Direction.NORTH;
            case WEST:
                return Direction.EAST;
            case NORTH:
                return Direction.SOUTH;
            default:
                return Direction.NORTH;
        }
    }
    
    public static int angleFromDirection(Direction dir)
    {
        switch(dir)
        {
            case EAST:
                return 90;
            case SOUTH:
                return 180;
            case WEST:
                return 270;
            case NORTH:
                return 0;
            default:
                return 0;
        }
    }
    
    public static Direction randomDirection()
    {
        int random = (int)(Math.random()*4);
        Direction out;
        switch(random)
        {
            case 0:
                out = Direction.NORTH;
                break;
            case 1:
                out = Direction.EAST;
                break;
            case 2:
                out = Direction.SOUTH;
                break;
            case 3:
                out = Direction.WEST;
                break;
            default:
                out = Direction.NORTH;
                break;
        }
        return out;
    }
    
    public static Direction randomDirection(Direction exclude)
    {
        int random = (int)(Math.random()*4);
        Direction out;
        switch(random)
        {
            case 0:
                out = Direction.NORTH;
                break;
            case 1:
                out = Direction.EAST;
                break;
            case 2:
                out = Direction.SOUTH;
                break;
            case 3:
                out = Direction.WEST;
                break;
            default:
                out = Direction.NORTH;
                break;
        }
        if(out == exclude){
            return randomDirection(exclude);
        }else{
            return out;
        }
    }
}
