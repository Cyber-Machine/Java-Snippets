/**
 * Greatest Common Divisor 
 *  - Finding out GCD using Euclidean Algorithm
 *  -- Euclidean Algorithm is a recursive algorithm that calculates gcd by finding difference between two numbers.
 *  -- For more Information https://cp-algorithms.com/algebra/euclid-algorithm.html
 * 	-- A more faster method of calculating GCD would be using Binary GCD . 
 */
public interface GCD {

    public static int gcd(int a, int b) {
		while (b > 0) {
			int c = a;
			a = b;
			b = c % b;
		}
		return a;
	}
}