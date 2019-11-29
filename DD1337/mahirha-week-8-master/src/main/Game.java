import java.util.ArrayList;
import java.util.Random;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Mahir Hambiralovic
 * @version 2018.11.07
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> carriedItems;
    private Random randomizer;
    private Item key, sword;
    private Room village, outside, forest, woods, dungeon, darkness, chest, 
    gollumsCave, object, passage, door, hall, writing, deathRoom;
          


    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createWorld();
        parser = new Parser();
        randomizer = new Random();
    }

    /**
     * Create the world. 
     * Items are created and placed in rooms.
     * Rooms are created and their exits linked together.
     * Rooms are given items required for entry, if applicable.
     */
    private void createWorld()
    {
        // Create the items
        key = new Item("key");
        sword = new Item("sword");

        carriedItems = new ArrayList<>();

        // create the rooms and initialize exits and requiredItems
        village = new Room("in the little village of Fantasia");
        outside = new Room("outside the giant cave");
        forest = new Room("in the forest");
        woods = new Room("in the woods");
        dungeon = new Room("inside the cave. It's dark, moist and yucky. You probably shouldn't be in here...");
        darkness = new Room("in a dark room. You can barely see anything in here. You can hear a squeeking noise coming from the neighbouring room");
        chest = new Room("next to a big, old chest.");
        gollumsCave = new Room("in Gollums Cave \n'PRECIOUS!! WHERE IS MY PRECIOUS?! ARGHH STRANGER!!!'\n Gollum runs away, you are left alone");
        object = new Room("... Ohh, shiny!");
        passage = new Room("in the passage. It smells in here.. There are corpses on the ground.. \nYou can hear a rumbling noise from deep within the cave");
        door = new Room("next to a door...");
        hall = new Room("in the hall. There is an altar in the center of the room. You can see some writing on the wall...", key);
        writing = new Room("next to the writing. 'DO NOT ENTER. HORRIBLE DEATH.'\n The message was written in blood. Maybe you should listen");
        deathRoom = new Room("... \nThe door closes behind you... \nYou have entered the 'death room'...");


        village.setExit("outside", outside);

        outside.setExit("village", village);
        outside.setExit("forest", forest);
        outside.setExit("dungeon", dungeon);

        forest.setExit("outside", outside);
        forest.setExit("woods", woods);

        woods.setExit("forest", forest);

        // Enter dungeon from outside
        dungeon.setExit("outside", outside);
        dungeon.setExit("darkness", darkness);
        dungeon.setExit("passage", passage);

        darkness.setExit("dungeon", dungeon);
        darkness.setExit("chest", chest);
        darkness.setExit("gollumsCave", gollumsCave);

        chest.setExit("darkness", darkness);
        chest.setItems(key);

        gollumsCave.setExit("darkness", darkness);
        gollumsCave.setExit("object", object);
        gollumsCave.setExit("crack", dungeon);

        object.setExit("gollumsCave", gollumsCave);
        object.setItems(sword);

        passage.setExit("dungeon", dungeon);
        passage.setExit("door", door);

        door.setExit("passage", passage);
        door.setExit("hall", hall);

        hall.setExit("door", door);
        hall.setExit("writing", writing);
        hall.setExit("deathRoom", deathRoom);

        writing.setExit("hall", hall);


        currentRoom = village;  // start in the village
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                // Check for death room to play deathGame
                if(currentRoom == deathRoom){
                    deathGame();
                    wantToQuit = true;
                    
                }
                break;

            case TAKE:
                takeItem(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, check if any items
     * are neccessary for entry. Enter the new room if possible,
     * otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            // Check if no items are needed to enter, and enter
            if(nextRoom.getRequiredItem() == null){
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
            else{
                // Check if player has required items and enter
                if(hasItem(nextRoom.getRequiredItem())){
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                } 
                else{
                    System.out.println("You don't have the " + nextRoom.getRequiredItem().getName());
                }
            }
        }
    }

    /** 
     * Try to take an Item. If it is in the current room,
     * add it to carriedItems, else return error message.
     */
     
    private void takeItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what");
            return;
        }

        String thing = command.getSecondWord();

        // Try to take the item.
        Item item = currentRoom.getItem(thing);

        if (item == null) {
            System.out.println("There is no such item!");
        }
        else {
            carriedItems.add(item);
            System.out.println("You have picked up a " + item.getName());
        }
    }

    /**
     * Check if player has item
     */
    private boolean hasItem(Item thing){
        for(Item item : carriedItems){
            if (thing == item){
                return true;
            }
        }
        return false;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * The final game. Starts automatically in deathRoom.
     * You fight Bianca Ingrosso.
     * If you have a sword, odds of winning are 3/4
     * Else, your odds of winning are 1/4
     */
    private void deathGame(){
        wait(3000);
        System.out.println("A wild Bianca Ingrosso appears! She has grown strong in the shadows..");
        wait(3000);
        System.out.println("You look around and realize that you have an obligation to humanity to slay this beast!");
        for(int i = 0; i < 3; i++){
            wait(1500);
            System.out.print(".");
        }

        System.out.print("\nYou rush toward her with your ");
        if(hasItem(sword)){
            System.out.print("sword!");
            for(int i = 0; i < 3; i++){
                wait(1500);
                System.out.print("!");
            }
            // Play
            if(randomizer.nextInt(3) >= 2){
                System.out.println("YOU DID IT!! \nYou saved humanity and all of this universe.");
                wait(3000);
                System.out.println("Your name will be remembered throughout all of history!");
            }
            else{
                System.out.println("OH NO! Bianca steals your sword.");
                wait(3000);
                System.out.println("She throws it away. And starts... Singing.");
                wait(5000);
                System.out.println("Your ears start bleeding and you die a slow death.");
                wait(5000);
                System.out.println("GAME OVER");
            }
        }
        else{
            for(int i = 0; i < 3; i++){
                wait(1500);
                System.out.print(".");
            }
            System.out.print("fists!");
            for(int i = 0; i < 3; i++){
                wait(1500);
                System.out.print("!");
            }
            for(int i = 0; i < 3; i++){
                wait(1500);
                System.out.print("?");
            }

            // Play
            if(randomizer.nextInt(3) == 3){
                System.out.println("\nYOU DID IT!! \nYou saved humanity and all of this universe.");
                wait(3000);
                System.out.println("Your name will be remembered throughout all of history!");
            }
            else{
                System.out.println("\nOH NO! Queen B stops your attacks.");
                wait(3000);
                System.out.println("She gives you a hug and starts... Singing.");
                wait(3000);
                System.out.println("Your ears start bleeding and you die a slow death.");
                wait(3000);
                System.out.println("GAME OVER");
            }
        }
    }

    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
        }
    }
         

}
