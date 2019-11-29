import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }
    
    /**
     * Takes a single integer parameter and checks whether it is a valid 
     * index for the current state of the collection.
     * To be valid, the parameter must lie in the range 0 to size()–1.
     * Returns error message if not
     */
    public void checkIndex(int index)
    {
        if(index < 0 || index >= files.size()) {
            if(files.size() == 0) {
                 System.out.println("List is empty");
            }
            else{
                 System.out.println("Valid ranges lie between 0 and " + (files.size() -1));
            }
        }
    }
    
    /**
     * Takes a single integer parameter and checks whether it is a valid 
     * index for the current state of the collection.
     * To be valid, the parameter must lie in the range 0 to size()–1.
     * Returns boolean
     */
    public boolean validIndex(int index)
    {
        if(index < 0 || index >= files.size()) {
            if(files.size() == 0) {
                 return false;
            }
            else{
                 return false;
            }
        }
        return true;
    }
}
