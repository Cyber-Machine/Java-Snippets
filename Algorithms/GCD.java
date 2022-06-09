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

	// H.C.F. by Binary Method(Eucladian Algorithm)
	private static int gcdBinary(int x, int y)
	{
	  int shift;
	
	  /* GCD(0, y) == y; GCD(x, 0) == x, GCD(0, 0) == 0 */
	  if (x == 0)
		return y;
	  if (y == 0)
		return x;
	
	  int gcdX = Math.abs(x);
	  int gcdY = Math.abs(y);
	
	  if (gcdX == 1 || gcdY == 1)
		return 1;
	
	  /* Let shift := lg K, where K is the greatest power of 2 dividing both x and y. */
	  for (shift = 0; ((gcdX | gcdY) & 1) == 0; ++shift)
	  {
		gcdX >>= 1;
		gcdY >>= 1;
	  }
	
	  while ((gcdX & 1) == 0)
		gcdX >>= 1;
	
	  /* From here on, gcdX is always odd. */
	  do
	  {
		/* Remove all factors of 2 in gcdY -- they are not common */
		/* Note: gcdY is not zero, so while will terminate */
		while ((gcdY & 1) == 0)
		  /* Loop X */
		  gcdY >>= 1;
	
		/*
		 * Now gcdX and gcdY are both odd. Swap if necessary so gcdX <= gcdY,
		 * then set gcdY = gcdY - gcdX (which is even). For bignums, the
		 * swapping is just pointer movement, and the subtraction
		 * can be done in-place.
		 */
		if (gcdX > gcdY)
		{
		  final int t = gcdY;
		  gcdY = gcdX;
		  gcdX = t;
		}  // Swap gcdX and gcdY.
		gcdY = gcdY - gcdX;                       // Here gcdY >= gcdX.
	  }while (gcdY != 0);
	
	  /* Restore common factors of 2 */
	  return gcdX << shift;
	}
}