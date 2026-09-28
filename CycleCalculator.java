/**
 * CycleCalculator class which uses Colins top secret rules to calculate the 
 * estimated duration of a cycle given certain information about the cyclist, 
 * the route and the weather.
 */
public class CycleCalculator
{
    // speed are in MPH.
    // constants must be in upper-case
    private final double BEGINNER_AVERAGE_SPEED =  10;
    private final double INTERMEDIATE_AVERAGE_SPEED =  15;
    private final double ADVANCED_AVERAGE_SPEED =  20;

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
       double speed = 0.0;

       if (competency.equals("Beginner")) {
           speed = BEGINNER_AVERAGE_SPEED;
       }
       else if (competency.equals("Intermediate")){
           speed = INTERMEDIATE_AVERAGE_SPEED;
       }
       else
           speed = ADVANCED_AVERAGE_SPEED;

       if(!cyclingAlone){
        speed = speed * CYCLE_WITH_SOMEONE;
       }

       //years of experience
       speed = speed + numYearsExperience * YEARS_OF_CYCLING;

       //testing temperature
       if(temp > CELSIUS_FOR_HOT){
           speed = speed - (temp - CELSIUS_FOR_HOT) * DECREASE_FOREACH_DEGREE;
       }
       else if (temp < CELSIUS_FOR_COLD)
       {
           speed = speed - (CELSIUS_FOR_COLD - temp) * DECREASE_FOREACH_DEGREE;
       }

       speed = speed - (windSpeed / MPH_FOR_WIND) * DECREASE_FOREACH_WIND;

       //Test for rain
       if(isRaining){
           speed = speed - rain_condition;
       }


	  return numMiles / speed;
   }
   
   // advanced work: arrays
   public double getTotalDuration(double[] durations)
   {
       double totalDuration = 0;
	   for (int i = 0; i < durations.length; i++ ){
           totalDuration += durations[i];
       }
	   return totalDuration;
   }
   

}
