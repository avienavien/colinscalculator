/**
 * CycleCalculator class which uses Colins top secret rules to calculate the 
 * estimated duration of a cycle given certain information about the cyclist, 
 * the route and the weather.
 */

public class CycleCalculator
{
    // speeds are in MPH.
    private final double BEGINNER_AVERAGE_SPEED = 10;
    private final double INTERMEDIATE_AVERAGE_SPEED = 15;
    private final double ADVANCED_AVERAGE_SPEED = 20;

    private final double CYCLING_WITH_SOMEONE_MULTIPLIER = 1.2;      // multiply if cycling with someone
    private final double SPEED_INCREASE_PER_YEAR = 0.2;              // increase for each year

    private final int HOT_TEMPERATURE_CELSIUS = 20;
    private final int COLD_TEMPERATURE_CELSIUS = 10;
    private final double SPEED_DECREASE_PER_DEGREE = 0.1;            // decrease per degree

    private final int WIND_STEP_MPH = 15;
    private final int SPEED_DECREASE_PER_WIND_STEP = 1;              // decrease per 15mph wind

    private final int SPEED_DECREASE_WHEN_RAINING = 2;               // decrease if raining true

    public double getDuration(int numMiles, String competency, int numYearsExperience,
                              boolean cyclingAlone, int temp, int windSpeed,
                              boolean isRaining)
    {
        double averageSpeed = 0.0;

        // BASE SPEED FROM COMPETENCY
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

        // CYCLING WITH SOMEONE IS FASTER
        if (!cyclingAlone)
    {
        averageSpeed = averageSpeed * CYCLING_WITH_SOMEONE_MULTIPLIER;
    }

        // YEARS OF EXPERIENCE
        averageSpeed = averageSpeed + numYearsExperience * SPEED_INCREASE_PER_YEAR;

        // TESTING TEMPERATURE
        if (temp > HOT_TEMPERATURE_CELSIUS)
        {
            averageSpeed = averageSpeed - (temp - HOT_TEMPERATURE_CELSIUS) * SPEED_DECREASE_PER_DEGREE;
        }
        else if (temp < COLD_TEMPERATURE_CELSIUS)
        {
            averageSpeed = averageSpeed - (COLD_TEMPERATURE_CELSIUS - temp) * SPEED_DECREASE_PER_DEGREE;
        }

        // TESTING WIND: INTEGER DIVISION COUNTS THE WHOLE 15 MPH STEPS (no decimals)
        averageSpeed = averageSpeed - (windSpeed / WIND_STEP_MPH) * SPEED_DECREASE_PER_WIND_STEP;

        // TESTING RAIN
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

    public String getFormattedDuration(double time){
        double hours =  Math.floor(time); //rounds down no matter what
        double fractionOfHour = time - hours;
        double minutes =  Math.round(fractionOfHour * 60); //rounds to nearest whole number

        // handles 60 minutes values and turn them into 1 hour
        if (minutes == 60)
        {
            hours = hours + 1;
            minutes = 0;
        }

        // handles proper pluralization
        String hourWord;
        if (hours == 1)
        {
            hourWord = "hour";
        }
        else
        {
            hourWord = "hours";
        }

        String minWord;
        if(minutes == 1){
            minWord = "min";
        }
        else {
            minWord = "mins";
        }

        return (int) hours + " " + hourWord + " and " + (int) minutes + " " + minWord;
    }
}