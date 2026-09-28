/**
 * CycleCalculator class which uses Colins top secret rules to calculate the 
 * estimated duration of a cycle given certain information about the cyclist, 
 * the route and the weather.
 */
public class CycleCalculator
{
    // speeds are in MPH.
    // constants must be in upper-case
    private final double BEGINNER_AVERAGE_SPEED = 10;
    private final double INTERMEDIATE_AVERAGE_SPEED = 15;
    private final double ADVANCED_AVERAGE_SPEED = 20;

    private final double CYCLING_WITH_SOMEONE_MULTIPLIER = 1.2;      // multiply
    private final double SPEED_INCREASE_PER_YEAR = 0.2;              // increase for each year

    private final int HOT_TEMPERATURE_CELSIUS = 20;
    private final int COLD_TEMPERATURE_CELSIUS = 10;
    private final double SPEED_DECREASE_PER_DEGREE = 0.1;            // decrease

    private final int WIND_STEP_MPH = 15;
    private final int SPEED_DECREASE_PER_WIND_STEP = 1;              // decrease

    private final int SPEED_DECREASE_WHEN_RAINING = 2;               // decrease

    public double getDuration(int numMiles, String competency, int numYearsExperience,
                              boolean cyclingAlone, int temp, int windSpeed,
                              boolean isRaining)
    {
        double averageSpeed = 0.0;

        // base speed from competency
        if (competency.equals("Beginner"))
        {
            averageSpeed = BEGINNER_AVERAGE_SPEED;
        }
        else if (competency.equals("Intermediate"))
        {
            averageSpeed = INTERMEDIATE_AVERAGE_SPEED;
        }
        else if (competency.equals("Advanced"))
        {
            averageSpeed = ADVANCED_AVERAGE_SPEED;
        }

        // cycling with someone is faster
        if (!cyclingAlone)
        {
            averageSpeed = averageSpeed * CYCLING_WITH_SOMEONE_MULTIPLIER;
        }

        // years of experience
        averageSpeed = averageSpeed + numYearsExperience * SPEED_INCREASE_PER_YEAR;

        // temp
        if (temp > HOT_TEMPERATURE_CELSIUS)
        {
            averageSpeed = averageSpeed
                    - (temp - HOT_TEMPERATURE_CELSIUS) * SPEED_DECREASE_PER_DEGREE;
        }
        else if (temp < COLD_TEMPERATURE_CELSIUS)
        {
            averageSpeed = averageSpeed
                    - (COLD_TEMPERATURE_CELSIUS - temp) * SPEED_DECREASE_PER_DEGREE;
        }

        // wind: integer division counts the whole 15 mph steps
        averageSpeed = averageSpeed - (windSpeed / WIND_STEP_MPH) * SPEED_DECREASE_PER_WIND_STEP;

        // rain
        if (isRaining)
        {
            averageSpeed = averageSpeed - SPEED_DECREASE_WHEN_RAINING;
        }

        return numMiles / averageSpeed;
    }

    // advanced work: arrays
    public double getTotalDuration(double[] durations)
    {
        double totalDuration = 0;
        for (double duration : durations) {
            totalDuration += duration;
        }

        return totalDuration;
    }
}