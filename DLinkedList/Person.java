
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String ID;
    private String first;
    private String last;
    
    /**
     * Constructor for Person.
     * @param first String of first name.
     * @param last String of last name.
     * @param ID 9 digit ID.
     * @return new Person object.
     */
    public Person(String first, String last, String ID)
    {
        testID(ID);
        this.ID = ID;
        this.first = first;
        this.last = last;
    }
    
    /**
     * @return the ID.
     */
    public String getID() {
        return ID;
    }
    
    /**
     * @return the persons first name.
     */
    public String getFirstName() {
        return first;
    }
    
    /**
     * @return the persons last name.
     */
    public String getLastName() {
        return last;
    }
    
    /**
     * Test the ID and make sure it's 9 characters in length.
     * @throw RuntimeException if ID is not 9 characters in length.
     */
    public void testID(String ID) {
        if(ID.length() != 9) {
            throw new RuntimeException("Bad ID length entered.");
        }
    }
    
    /**
     * Print out the persons first, last, and ID in sequence.
     */
    public String toString() {
        return first + " " + last + " " + ID;
    }
}
