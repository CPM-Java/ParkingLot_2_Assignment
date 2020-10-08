
/** Modify this class to function with a Histogram object
 *   and perform the 12 hour simulations as described
 *   by the StuffMart executives.
 *   
 * Creates the flow of inbound traffic.
 * Displays parking lot.
 * 
 * @author gk
 * @version 1/8/16
 */
public class Model
{
    private final int LOT_CAPACITY = 20;
    private final int VEHICLES_IN = 4;  //vehicles entering lot per time period
    private final double VEHICLE_LEAVE_PROBABILITY = .40;
    private ParkingLot myPL = new ParkingLot(LOT_CAPACITY); //create lot

    //constructor
    public Model()
    {
        //Sets initial condition: lot half-full
        inboundTraffic(LOT_CAPACITY / 2);
    }
    
    public void act()
    {
        //A 3 hour simulation if each time period is 10 minutes
        for(int timePeriod = 18; timePeriod > 0; timePeriod--)
        {
           //vehicles out, vehicles in
           myPL.departures();
           this.inboundTraffic(VEHICLES_IN);
           
           //you may use this diagnostic showing each time period
           System.out.println(myPL + "\n"); 
        }
        System.out.println(myPL + "\n"); // view lot
    }
    
    //Creates (numVehicles) of Vehicle objects and inserts them into the lot.
    private void inboundTraffic(int numVehicles)
    {
        while(numVehicles > 0)
        {
            Vehicle v = new Vehicle(VEHICLE_LEAVE_PROBABILITY);
            myPL.arrival(v);
            numVehicles--;
        }
    }
}
