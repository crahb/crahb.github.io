import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Visually test the DLCList here, rather than unit test.
 */
public class Main
{
    public static void main(String[] args) {
        //testPerson();
        testInteger();
    }

    public static List<Integer> read() { //create integers to read
        List<Integer> lines = new ArrayList<>();
        try{
            File file = new File("numbers.txt");
            FileReader inputFile = new FileReader(file);
            BufferedReader reader = new BufferedReader(inputFile);
        
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
        }
        catch (IOException ioException) {
            System.err.format("IOException: %s%n", ioException);
        }
        return lines;
    }
    
    private static void testInteger() {
        DLCList<Integer> theList = new DLCList<>();
        theList.addAll(read());
        
        System.out.println("Initial DLCList:");
        System.out.println(theList);
        System.out.println();
        
        
        System.out.println("Remove from index 3 with delete(3)");
        theList.delete(3);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("deleteFirst and deleteLast");
        theList.deleteFirst();
        theList.deleteLast();
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Current size of list: " + theList.size());
        System.out.println();
        
        System.out.println("contains(345) test: " +
                            theList.contains(345));
        System.out.println();
                            
        System.out.println("get(1): " + theList.get(1));
        System.out.println("getLast(): " + theList.getLast());
        System.out.println("getFirst(): " + theList.getFirst());
        System.out.println();
        
        System.out.println("Insert 600 into the second location with insert(1)");
        theList.insert(1, 600);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Set a 700 over the first number with set(1, 700)");
        theList.set(1, 700);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Final list after testing (almost) all methods in our DLCList");
        System.out.println(theList);
        System.out.println("Finally, the clear method: ");
        theList.clear();
        System.out.println(theList);
        System.out.println();
    }
    
    private static ArrayList<Integer> addInteger() {
        Integer a = new Integer(1);
        Integer b = new Integer(6);
        Integer c = new Integer(4);
        Integer d = new Integer(3);
        Integer e = new Integer(2);
        ArrayList<Integer> p = new ArrayList<>();
        p.add(a); p.add(b); p.add(c); p.add(d); p.add(e);
        return p;
    }
    
    private static void testPerson() {
        DLCList<Person> theList = new DLCList<>();
        ArrayList<Person> people = addPeople();
        theList.addAll(people);
        
        System.out.println("Initial DLCList:");
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Add person to front with addFirst()");
        Person frontPerson = new Person("Front", "Person", "999999999");
        theList.addFirst(frontPerson);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Remove Mai from index 3 with delete(3)");
        theList.delete(3);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("deleteFirst and deleteLast");
        theList.deleteFirst();
        theList.deleteLast();
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Current size of list: " + theList.size());
        System.out.println();
        
        System.out.println("contains(Front Person 9999--) test: " +
                            theList.contains(frontPerson));
        System.out.println("contains(Bob Smith 12345--) test: " +
                            theList.contains(theList.get(0)));
        System.out.println();
                            
        System.out.println("get(1): " + theList.get(1));
        System.out.println("getLast(): " + theList.getLast());
        System.out.println("getFirst(): " + theList.getFirst());
        System.out.println();
        
        System.out.println("Insert Front Person into the second location with insert(1)");
        theList.insert(1, frontPerson);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Set a new person over the front person with set(1)");
        Person newPerson = new Person("New", "Person", "coolestID");
        theList.set(1, newPerson);
        System.out.println(theList);
        System.out.println();
        
        System.out.println("Final list after testing (almost) all methods in our DLCList");
        System.out.println(theList);
        System.out.println("Finally, the clear method: ");
        theList.clear();
        System.out.println(theList);
        System.out.println();
    }
        
    private static ArrayList<Person> addPeople() {
        Person a = new Person("Bob", "Smith", "123456789");
        Person b = new Person("Paul", "John", "123459876");
        Person c = new Person("Mai", "Evans", "987654321");
        Person d = new Person("John", "Doe", "123456789");
        Person e = new Person("Blue", "Jay", "545454545");
        ArrayList<Person> p = new ArrayList<>();
        p.add(a); p.add(b); p.add(c); p.add(d); p.add(e);
        return p;
    }
}
