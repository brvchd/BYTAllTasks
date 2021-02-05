package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
	    //Check if the method getName returns correct currency name
	    assertEquals("SEK", SEK.getName());
	    assertEquals("DKK", DKK.getName());
	    assertEquals("EUR", EUR.getName());
	}

	@Test
	public void testGetRate() {
        //Check if the method getRate returns correct currency rate
        assertEquals(new Double(0.15), SEK.getRate());
        assertEquals(new Double(0.2), DKK.getRate());
        assertEquals(new Double(1.5), EUR.getRate());
	}

	@Test
			(expected = RateCanNotBeSetToNullException.class)
	public void testSetRate() throws RateCanNotBeSetToNullException, RateMustBePositiveException {
	    //Setting new rates using setRate and checking them using getRate method
        double newRateSEK = 0.2, newRateDKK = 0.3, newRateEUR = 1.7;
	    SEK.setRate(newRateSEK);
        assertEquals(new Double(newRateSEK), SEK.getRate());
        DKK.setRate(newRateDKK);
        assertEquals(new Double(newRateDKK), DKK.getRate());
        EUR.setRate(newRateEUR);
        assertEquals(new Double(newRateEUR), EUR.getRate());
		try {
			EUR.setRate(-5.0);
		}catch (RateMustBePositiveException exc){
			try {
				EUR.setRate(0.0);
			}catch (RateMustBePositiveException ignore){}
		}
		EUR.setRate(null);
	}

	@Test
    //*testUniversalValue
	public void testGlobalValue() {
	    //Multiplying rate of currency by needed amount and compering with universalValue output
        int amountSEK = 10, amountDKK = 20, amountEUR = 30;
        assertEquals(new Integer((int) (SEK.getRate()*amountSEK)), SEK.universalValue(amountSEK));
        assertEquals(new Integer((int) (DKK.getRate()*amountDKK)), DKK.universalValue(amountDKK));
        assertEquals(new Integer((int) (EUR.getRate()*amountEUR)), EUR.universalValue(amountEUR));
	}

	@Test
	public void testValueInThisCurrency() {
		// Dividing universal value of start currency by rate of desired one
        int amountSEK = 50, amountDKK = 30, amountEUR = 60;
        assertEquals(new Integer((int) (DKK.universalValue(amountDKK)/SEK.getRate())), SEK.valueInThisCurrency(amountDKK, DKK));
        assertEquals(new Integer((int) (EUR.universalValue(amountEUR)/DKK.getRate())), DKK.valueInThisCurrency(amountEUR, EUR));
        assertEquals(new Integer((int) (SEK.universalValue(amountSEK)/EUR.getRate())), EUR.valueInThisCurrency(amountSEK, SEK));
	}

}
