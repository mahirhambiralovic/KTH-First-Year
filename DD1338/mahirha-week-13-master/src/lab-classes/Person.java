/**
 * Person superclass used for Students and Instructors
 */
public class Person
{
    // Persons full name
    protected String name;

    public Person(String fullName)
    {
        name = fullName;
    }

    /**
     * Return the full name of this person.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

}