import java.math.*;
import java.util.*;
 

public class RSA_Algorithm_Encrypt_Decrypt {
	
	 static int gcd(int e, int z)
	    {
	        if (e == 0)
	            return z;
	        else
	            return gcd(z % e, e);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int p, q, n, phai_n, d = 0, e, i;
		 
		 Scanner sc = new Scanner (System.in);
		 
	        int msg = 222;
	        double cipher;
	        BigInteger msgback;
	 
	        System.out.println("Enter 1st prime number p: ");
	        p = sc.nextInt();
	 
	        System.out.println("Enter 2nd prime number q: ");
	        q = sc.nextInt();
	        
	        // Calculating n
	        n = p * q;
	        
	        // Calculating phai_n
	        phai_n = (p - 1) * (q - 1);
	        System.out.println("the value of phai_n = " + phai_n);
	 
	        for (e = 2; e < phai_n; e++) {
	 
	            // e is for public key exponent
	            if (gcd(e, phai_n) == 1) {
	                break;
	            }
	        }
	        
	        System.out.println("the value of e = " + e);
	        
	        for (i = 0; i <= 9; i++) {
	            int x = 1 + (i * phai_n);
	 
	            // d is for private key exponent
	            if (x % e == 0) {
	                d = x / e;
	                break;
	            }
	        }
	        System.out.println("the value of d = " + d);
	        cipher = (Math.pow(msg, e)) % n;
	        
	        System.out.println("Encrypted message is : " + cipher);
	 
	        // converting int value of n to BigInteger which helps in 
	        // very big integer calculations that are outside the limit of all available primitive data types
	        BigInteger N = BigInteger.valueOf(n);
	 
	        // converting float value of c to BigInteger
	        BigInteger C = BigDecimal.valueOf(cipher).toBigInteger();
	        msgback = (C.pow(d)).mod(N);
	        System.out.println("Decrypted message is : "
	                           + msgback);
	    }
	 
	   

}


