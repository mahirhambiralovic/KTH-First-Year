import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Mahir Hambiralovic
 * @version 2018.11.07
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items;
    private Item requiredItem;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * This constructor includes requiredItems for entry.
     * @param description The room's description.
     * @param thing The item neccessary for entering this room
     */
    public Room(String description, Item thing) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        requiredItem = thing;
    }

    /**
     * Create a room described "description", with. Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }


    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "\nYou are " + description + ".\n" + "\nItems: " + 
                getItemNames() + "\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Add items to the room
     * @param thing What to add to the room
     */
    public void setItems(Item thing){
        items.add(thing);
    }

    /**
     * Pick up an item (and remove it) from the room.
     * @param thing A string describing the item to get.
     * @return The Item objectm or null.
     */
    public Item getItem(String thing){
        for(Item item : items){
            if (thing.equals(item.getName())){
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    /**
     * Returns items in the room
     * @return A String listing all objects
     */
    public String getItemNames(){
        String returnString = "";
        for(Item item : items){
            returnString += item.getName();
            returnString += "";
        }
        return returnString;
    }

    /**
     * Returns items required to enter this room
     * @return Item object required for entering.
     */
    public Item getRequiredItem(){
        return requiredItem;
    }
}

