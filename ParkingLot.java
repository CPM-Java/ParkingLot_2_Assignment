
/**Modify this class to provide the necessary
 *  additional information to the Model
 *  
 * Handles storage and removal of Vehicle objects
 * 
 * @author gk
 * @version 1/8/16
 */
public class ParkingLot
{
    private int myNumSpaces;
    private Vehicle[] myLot;
    private boolean myLotFull;
    
    public ParkingLot()
    {
        this(50);  //default number of spaces
    }
    
    public ParkingLot(int spaces)
    {
        myNumSpaces = spaces;
        myLot = new Vehicle[myNumSpaces];
    }
    
    public void arrival(Vehicle c)
    {
        boolean VehicleParked = false;
        
        //the closest spot will always be taken if empty
        if(myLot[0] == null)
        {
            myLot[0] = c;
            VehicleParked = true;
        }
        
        else
        {
            //Vehicles begin filling the lot begining closest to the store
            //leaving every other space empty.  
            for(int x = 1; x < myLot.length - 1; x++)
            {
                if(myLot[x-1] == null && myLot[x] == null && myLot[x+1] == null)
                {
                    myLot[x] = c;
                    x = myLot.length;
                    VehicleParked = true;
                }
            }
        }
        //otherwise closest to the store.
        if(!VehicleParked)
        {
            for(int x = 0; x < myLot.length; x++)
            {
                if(myLot[x] == null)
                {
                    myLot[x] = c;
                    x = myLot.length;
                    VehicleParked = true;
                }
            }
        }
        myLotFull = !VehicleParked;
    }
    
    public void departures()
    {
        for(int x = 0; x < myLot.length; x++)
        {
            if(myLot[x] != null && myLot[x].readyToLeave())
               myLot[x] = null;
        }
    }
    
    public String toString()
    {
        String out = "| DOOR |";
        for(int x = 0; x < myLot.length; x++)
        {
            if(myLot[x] != null) out += myLot[x] + "|";
            else out += "___|";
        }
        return out;
    }
}
