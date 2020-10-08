
/** DO NOT MODIFY
 * A vehicle fills a parking space
 * Has a unique vehicle id number (up to 999)
 * 
 * @author gk
 * @version 1/8/16
 */

public class Vehicle
{
    private static int vinNum; //belongs to the class Vehicle
    
    private String myVinNumStr;
    private double myChanceOfLeaving = .10; //default

    
    /**
     * Constructor for objects of class Car
     */
    public Vehicle(double col)
    {
        myChanceOfLeaving = col;
        
        //generate up to 3 digit vehicle ID number
        if(vinNum < 999) vinNum++;
        else vinNum = 0;
        
        //each vehicle object is now assigned its own number
        myVinNumStr = "" + vinNum;
        //format string with leading zeros
        while(myVinNumStr.length() < 3)
              myVinNumStr = "0" + myVinNumStr;
    }

    /**
     * Determines if vehicle is ready to leave
     * within one time period.
     */
    public boolean readyToLeave()
    {
        if(Math.random() <= myChanceOfLeaving) return true;
        else return false;
    }
    
    //returns the vehicles personal vin number
    public String toString()
    {
        return myVinNumStr;
    }
}
