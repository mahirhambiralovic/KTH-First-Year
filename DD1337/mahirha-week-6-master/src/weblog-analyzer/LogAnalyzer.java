/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Return the number of accesses recorded in the log
     * file.
     */
    public int numberOfAccesses() {
        int total = 0;
        // Iterate over values in the hours and add to to.
        for(int value : hourCounts) {
            total += value;
        }
        return total;
    }

    /**
     * Return the busiest hour recorded in the log
     * file.
     */
    public int busiestHour() {
        int maxCount = 0;
        int maxHour = 0;
        // Iterate over hours
        for(int hour = 0; hour < hourCounts.length; hour++) {
            // If hourcount is higher than busiest previous, make it busiest
            if(hourCounts[hour] > maxCount) {
                maxCount = hourCounts[hour];
                maxHour = hour;
            }
        }
        return maxHour;
    }

    /**
     * Return the quietest hour recorded in the log
     * file.
     */
    public int quietestHour() {
        // Start with first count as minimum count
        int minCount = hourCounts[0];
        int minHour = 0;
        // Iterate over hours
        for(int hour = 0; hour < hourCounts.length; hour++) {
            // If hourcount is higher than busiest previous, make it busiest
            if(hourCounts[hour] < minCount) {
                minCount = hourCounts[hour];
                minHour = hour;
            }
        }
        return minHour;
    }

    public int busiestTwoHours() {
        int maxCount = 0;
        int maxHour = 0;
        // Iterate over hours
        for(int hour = 0; hour < hourCounts.length -1; hour++) {
            int totalCount = hourCounts[hour] + hourCounts[hour +1];
            // If hourcount is higher than busiest previous, make it busiest
            if(totalCount > maxCount) {
                maxCount = totalCount;
                maxHour = hour;
            }
        }
        return maxHour;
    }
}
