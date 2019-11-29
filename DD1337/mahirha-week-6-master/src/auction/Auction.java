import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // The number seems to be reasonable.
            // Find the lot with the correct lotNumber
            for(Lot lot : lots){
                if(lot.getNumber() == lotNumber){
                    return lot;
                }
            }
        }
        // If not found, does not exist
        System.out.println("Lot number: " + lotNumber + " does not exist.");
        return null;
    }

    /**
     * Close the auction and print all lots winners.
     * Checks if there is any bid on each lot.
     */
    public void close() {
        // Iterate over lots
        for(Lot lot : lots) {
            // Check for bid, if none - UNSOLD
            if (lot.getHighestBid() == null) {
                System.out.println(" -- NOT SOLD -- ");
                System.out.println("Lot no. " + lot.getNumber());
                System.out.println("Description: " + lot.getDescription());
                System.out.println("");
            }
            // Else print info for SOLD
            else {
                System.out.println(" -- SOLD to " + lot.getHighestBid().getBidder().getName() + " -- ");
                System.out.println("Lot no. " + lot.getNumber());
                System.out.println("Description: " + lot.getDescription());
                System.out.println("");
            }
        }
    }

    /**
     * Returns an ArrayList of unsold items
     */
    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot> unsolds = new ArrayList<Lot> ();
        // Iterate over lots
        for(Lot lot : lots) {
            // Check for bid. If none, add to list of unsolds
            if (lot.getHighestBid() == null) {
                unsolds.add(lot);
            }
        }
        return unsolds;
    }

    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int number) {
        Iterator<Lot> it = lots.iterator();

        // Iterate over list and remove the correct lot
        while(it.hasNext()) {
            Lot lot = it.next();
            if(lot.getNumber() == number) {
                it.remove();
                return lot;
            }
        }
        return null;
    }
}
