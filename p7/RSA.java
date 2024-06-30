package lab.p7;

import java.math.*;

public class RSA {
   public static void main(String args[]) {
      int M = 17;
      int e;
      int d = 0;

      // get 2 prime numbers p and q
      int p = 7;
      int q = 11;

      // eval n and phi_n = x
      int n = p * q;
      int x = (p - 1) * (q - 1);

      // evaluate e -> gcd(a, x) = 1
      for (e = 2; e < x; e++) {
         if (gcd(e, x) == 1)
            break;
      }

      // evaluate d => e-1 mod x
      for (int i = 0; i < 10; i++) {
         int temp = 1 + (i * x);

         if (temp % e == 0) {
            d = temp / e;
            break;
         }
      }

      System.out.println("PU = {" + e + ", " + d + "}");

      // calculate c and ans

      // c = m^e mod n
      double c = Math.pow(M, e) % n;
      System.out.println("Encrypted message: " + c);

      BigInteger ans;

      // D = C^d mod n
      BigInteger bigc = BigDecimal.valueOf(c).toBigInteger();
      BigInteger bign = BigInteger.valueOf(n);

      ans = bigc.pow(d).mod(bign);
      System.out.println("Initial message: " + ans);

   }

   static int gcd(int a, int b) {
      if (b == 0)
         return a;
      return gcd(b, a % b);
   }
}
