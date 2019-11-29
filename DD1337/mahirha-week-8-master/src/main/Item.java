/**
 * Class item - an item in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * 
 * @author Mahir Hambiralovic
 * @version 2018.11.07
 */

public class Item{
    private String name;

    /**
     * Creates an item with a descritption field
     */
    public Item(String name){
        this.name = name;
    }


    /**
     * @return The short description of the item
     * (the one that was defined in the constructor).
     */
    public String getName()
    {
        return name;
    }

}