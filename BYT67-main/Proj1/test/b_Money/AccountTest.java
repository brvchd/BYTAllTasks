package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		String tmsg = "Should exist";
		String fmsg = "Should NOT exist";
		testAccount.addTimedPayment("1", 1, 1, new Money(100000, SEK), SweBank, "Alice" );
		testAccount.addTimedPayment("2", 2, 2, new Money(200000, SEK), SweBank, "Alice" );
		assertTrue(tmsg, testAccount.timedPaymentExists("1"));
		assertTrue(tmsg, testAccount.timedPaymentExists("2"));
		assertFalse(fmsg, testAccount.timedPaymentExists("3"));

	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		String tmsg = "Should be the same";
		testAccount.addTimedPayment("1", 0, 0, new Money(100000, SEK), SweBank, "Alice" );
		for(int timer = 0; timer < 15; ++timer){
			testAccount.tick();
			if(timer==3){
				assertTrue(tmsg, testAccount.getBalance().equals(new Money(9600000, SEK)));
				testAccount.removeTimedPayment( "1");
				testAccount.addTimedPayment("2", 2, 3, new Money(300000, SEK), SweBank, "Alice");
			}
		}
		assertTrue(tmsg, testAccount.getBalance().equals(new Money(8700000, SEK)));

	}

	@Test
	public void testAddWithdraw() {
		String tmsg = "Should be the same";
		testAccount.withdraw(new Money(1000000, SEK));
		assertTrue(tmsg, testAccount.getBalance().equals(new Money(9000000, SEK)));
		testAccount.withdraw(new Money(2000000, SEK));
		assertTrue(tmsg, testAccount.getBalance().equals(new Money(7000000, SEK)));
	}
	@Test
	public void testGetBalance() {
		String tmsg = "Should be the same";
		assertTrue(tmsg, testAccount.getBalance().equals(new Money(10000000, SEK)));

	}
}
