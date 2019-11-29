
/**
 * Write a description of class Heater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heater
{
    // instance variables - replace the example below with your own
    private double temperature;
    private double increment;
    private double min;
    private double max;
    

    /**
     * Constructor for objects of class Heater
     */
    public Heater(double minimum, double maximum)
    {
        // initialise instance variables
        temperature = 15.0;
        increment = 5.0;
        min = minimum;
        max = maximum;
        
        if (min > max)
        {
            System.out.println("Minimum cannot be greater than maximum \n");
            System.out.println("Cannot guarantee proper functioning");
        }
    }

    /**
     * Increase temperature by 5
     */
    public void wamer()
    {
        if (temperature + increment <= max)
        {
            // add 5.0 to temp
            temperature += increment;
        }
        else
        {
            // error, overheated
            System.out.println("Temperature is: " + temperature + ". \nCan't heat more or will overheat, past maximum: " + max);
        }
    }
    
    /**
     * Decrease temperature by 5
     */
    public void cooler()
    {
        if (temperature - increment >= min)
        {
            // remove 5.0 from temp
            temperature -= increment;
        }
        else
        {
            // error, overheated
            System.out.println("Temperature is: " + temperature + ". \nCan't cool more or will go under minimum: " + min);
        }
    }
    
    public void setIncrement(double newinc)
    {
        if (newinc >= 0.0)
        {
            increment = newinc;
        }
        else
        {
            System.out.println("Increment cannot be negative");
        }
    }
    
    /**
     * Return temperature
     */
    public double returnTemperature()
    {
        return temperature;
    }
        
}
