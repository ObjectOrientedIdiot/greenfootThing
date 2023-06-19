/**
 * Write a description of class MoveFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoveFrame  
{
    protected int x;
    protected int y;
    protected int a;
    
    public int x(){
        return x;
    }
    
    public int y(){
        return y;
    }
    
    public int a(){
        return a;
    }
    
    public MoveFrame(int x, int y, int a)
    {
        this.x = x;
        this.y = y;
        this.a = a;
    }
    
}
