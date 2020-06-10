import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DLCListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLCListTest
{
    private DLCList<Person> listOne;
    private Person[] people;
    private Person aPerson;
    
    /**
     * Default constructor for test class DLCListTest
     */
    public DLCListTest()
    {
        people = new Person[] {
            new Person("Bob", "Smith", "123456789"),
            new Person("Paul", "John", "123459876"),
            new Person("Mai", "Evans", "987654321"),
            //new Person("Last", "Person", "123123123"),
        };
        
        aPerson = new Person("New", "Person", "123123123");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        listOne = new DLCList<>();
        listOne.add(people[0]);
        listOne.add(people[1]);
        listOne.add(people[2]);
    }

    @Test
    public void testAdd() {
        listOne.add(aPerson);
        //System.out.println(listOne.getLast().getFirst());
        //System.out.println(listOne.size());
        assertTrue(listOne.size() == people.length + 1);
    }
    
    @Test
    public void testAddFirst() {
        listOne.addFirst(aPerson);
        //System.out.println(listOne.getLast().getFirst());
        //System.out.println(listOne.size());
        //assertTrue(listOne.size() == people.length + 1);
        assertTrue(listOne.getFirst().getID().equals("123123123"));
    }
    
    @Test
    public void testAddLast() {
        listOne.add(aPerson);
        //System.out.println(listOne.getLast().getFirst());
        //System.out.println(listOne.size());
        //assertTrue(listOne.size() == people.length + 1);
        assertTrue(listOne.getLast().getID().equals("123123123"));
    }
    
    @Test
    public void testInsert() {
        setUp();
        Person newPerson = new Person("New", "Person", "432143211");
        listOne.insert(2, newPerson);
        assertTrue(listOne.get(2).getID().equals("432143211"));
    }
    
    @Test
    public void testSet() {
        setUp();
        Person newPerson = new Person("New", "Person", "432143211");
        listOne.set(2, newPerson);
        assertTrue(listOne.get(2).getID().equals("432143211"));
    }
    
    @Test
    public void testGetFirst() {
        assertTrue(listOne.getFirst().getID().equals("123456789"));
    }
    
    @Test
    public void testGetLast() {
        System.out.println(listOne.getLast().getFirstName());
        assertTrue(listOne.getLast().getID().equals("987654321"));
    }
    
    @Test
    public void testLength() {
        assertTrue(people.length == listOne.size());
    }
    
    @Test
    public void testDeleteFirst() {
        Person first = listOne.getFirst();
        listOne.deleteFirst(); //delete first
        Person newFirst = listOne.getFirst();
        assertTrue(!(first == newFirst)); //compate old first with new first)
    }
    
    @Test
    public void testDeleteLast() {
        Person last = listOne.getLast();
        listOne.deleteLast(); //delete first
        Person newLast = listOne.getFirst();
        assertTrue(!(last == newLast)); //compate old first with new first)
    }
    
    @Test
    public void testDelete() {
        setUp();
        int ogSize = listOne.size();
        listOne.delete(2);
        assertTrue(!(listOne.size() == ogSize));
    }
    
    @Test
    public void testContains() {
        listOne.add(aPerson);
        boolean contains = listOne.contains(aPerson);
        assertTrue(contains);
    }
    
    @Test
    public void testClear() {
        setUp();
        //Person ogPerson = listOne.getFirst(); //compare the first element
        //System.out.println(listOne.getFirst());
        listOne.clear();
        //System.out.println(listOne.getFirst());
        System.out.println(listOne.size());
        assertTrue("The list was not cleared.", listOne.size() == 0); //!(ogPerson == listOne.getFirst()));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
