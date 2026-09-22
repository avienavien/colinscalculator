/**
 * CycleCalculator class which uses Colins top secret rules to calculate the 
 * estimated duration of a cycle given certain information about the cyclist, 
 * the route and the weather.
 */
public class CycleCalculator
{
    // speed are in MPH.
    // constants must be in upper-case
    private final int BEGINNER_AVERAGE_SPEED =  10;
    private final int INTERMEDIATE_AVERAGE_SPEED =  15;
    private final int ADVANCED_AVERAGE_SPEED =  20;

    private final double CYCLE_WITH_SOMEONE =  1.2; // multiply

    private final double YEARS_OF_CYCLING = 0.2; // increase for each amount of year

    private final int CELSIUS_FOR_HOT = 20;
    private final int CELSIUS_FOR_COLD = 10;

    private final double DECREASE_FOREACH_DEGREE = 0.1; // DECREASE

    private final int MPH_FOR_WIND = 15;
    private final int DECREASE_FOREACH_WIND = 1; // DECREASE

    private final int rain_condition = 2; //DECREASE

    // FOR CHECKPOINT
   public double getDuration(int numMiles, String competency, int numYearsExperience, boolean cyclingAlone,
                             int temp, int windSpeed, boolean isRaining)
   {
	  // fill in!
	  return 0.0;
   }
   
   // advanced work: arrays
   public double getTotalDuration(double[] durations)
   {
	   // fill in!
	   return 0.0;
   }
   

}
