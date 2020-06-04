import java.util.ArrayList;
/**
 * Visually test the DLCList here, rather than unit test.
 */
public class Main
{
    public static void main(String[] args) {
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
