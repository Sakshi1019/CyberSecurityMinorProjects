import java.util.*;  

public class Diffie_Hellman_Algo_Implementation {
	
	 private static long cal_Power(long m, long n, long P)  
	    {  
	        long result = 0;          
	        if (n == 1){  
	            return m;  
	        }  
	        else{  
	            result = ((long)Math.pow(m, n)) % P;  
	            return result;  
	        }  
	    } 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long P, G, A, a, B, b, ka, kb;  
       
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("Enter value for public key G:");  
        G = sc.nextLong(); 
        
        System.out.println("Enter value for public key P:");  
        P = sc.nextLong();  
        
        // Input from user for private keys a and b selected by User1 and User2  
        System.out.println("Enter value for private key a selected by user1:");  
        a = sc.nextLong();  
        System.out.println("Enter value for private key b selected by user2:");  
        b = sc.nextLong();  
          
        // call calculatePower() method to generate A and B keys  
        A = cal_Power(G, a, P);  
        B = cal_Power(G, b, P);  
        // call calculatePower() method to generate ka and kb secret keys after the exchange of x and y keys          
        // calculate secret key for User1  
        ka = cal_Power(B, a, P);  
        // calculate secret key for User2   
        kb = cal_Power(A, b, P);  
        // print s3ecret keys of user1 and user2  
        System.out.println("Secret key for User1 is:" + ka);  
        System.out.println("Secret key for User2 is:" + kb);  

	}

}
