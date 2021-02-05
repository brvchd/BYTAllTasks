public class Matcher {
	public Matcher() {
	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		// Check for length differences
		if (actual.length != expected.length)
			return false;

		// Clip "too-large" values
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit) {
				actual[i] = clipLimit;
			} else if (Math.abs(expected[i] - actual[i]) > delta) {
				return false;
			}
		}
		return true;
	}
}