// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		Client.printPerson(out, bobSmith);
		assertEquals("Bob Smith", out.toString());

		out = new StringWriter();
		Client.printPerson(out, jennyJJones);
		assertEquals("Jenny J Jones", out.toString());

		assertEquals("Smith, Bob", Client.formatPerson(bobSmith));
		assertEquals("Jones, Jenny J", Client.formatPerson(jennyJJones));

		out = new StringWriter();
		Client.display(out, bobSmith);
		assertEquals("Smith, Bob", out.toString());

		out = new StringWriter();
		Client.display(out, jennyJJones);
		assertEquals("Jones, Jenny J", out.toString());

		assertEquals("Smith, Bob", Client.toString(bobSmith));
		assertEquals("Jones, Jenny J", Client.toString(jennyJJones));
	}
}
