import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product p = findProduct(id);
        if (p == null) {
            System.out.println("Product does not exist in stock. Please add it first.");
        }
        else {
            p.increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        // Look through all items for matching ID. If match, print and return it.
        for(Product item:stock) {
            if(item.getID() == id) {
                return item;
            }
        }

        System.out.println("Could not find product id " + id);
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product p = findProduct(id);
        if (p == null) {
            System.out.println("Product does not exist in stock.");
            return 0;
        }
        else {
            return p.getQuantity();
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        // Look through all items and print details
        for(Product item:stock) {
            System.out.println(item.toString());
        }
    }
}
