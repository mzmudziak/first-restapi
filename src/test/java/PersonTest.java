import com.mzmudziak.firstrestapi.entity.Person;
import junit.framework.TestCase;

public class PersonTest extends TestCase {
    Person p = new Person();

    public void testPersonSetId() {
        p.setId(1);

        assertEquals("Id test", p.getId(), 1);
    }

    public void testPersonSetFirstName() {
        p.setFirstName("Andrew");
        assertEquals("FirstName test", p.getFirstName(), "Andrew");
    }

    public void testPersonSetLastName() {
        p.setLastName("Hutch");
        assertEquals("LastName test", p.getLastName(), "Hutch");
    }

    public void testPersonParametrizedConstructor() {
        Person testedPerson = new Person(0, "Andy", "Wilson");
        assertEquals(testedPerson.getId(), 0);
        assertEquals(testedPerson.getFirstName(), "Andy");
        assertEquals(testedPerson.getLastName(), "Wilson");
    }
}