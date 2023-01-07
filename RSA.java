/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.math.BigInteger;
import java.util.Random;
import java.io.*;
/**
 *
 * @author nabil
 */
class RSA {
    public BigInteger p;
    public BigInteger q;
    public BigInteger e;
    public BigInteger n;
    public BigInteger d;
    public BigInteger phi;
    public Random r;
    public int bitlength = 512;  

    /**
     * @param args the command line arguments
     */
    //to generate distinct 512 probable prime p and q
    public RSA(){
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);

        //calculate product of two prime
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        //to check if nmber are relatively prime
        e = BigInteger.probablePrime(bitlength/2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
    
     public RSA (BigInteger e, BigInteger d, BigInteger phi)
    {
        this.e = e;
        this.d = d;
        this.phi = phi;
    }
     
     public void flushKeys(){
         p = null;
         q = null;
         n = null;
         phi = null;
         d = null;
     }

    public static void main(String args[])throws IOException
    {
        /*RSA rsa = new RSA();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("Enter text: ");
        String text = br.readLine();
        

        //encrypt
        System.out.println("Encrypted text: " + text);
        byte[] encrypted = rsa.encrypt(text.getBytes());
        System.out.println("P = " + bytesToString(text.getBytes()));

        //decrypt
        System.out.println("Decrypted text: " + text);
        byte[] decrypted = rsa.decrypt(text.getBytes());
        System.out.println("Q = " + bytesToString(text.getBytes()));*/
    }
    
        //convert byte to string
        private static String bytesToString(byte[] encrypted) {
            String test = "";
            for (byte a : encrypted)
            {
                test += Byte.toString(a);
            } 
            return test;
        }

        // Encrypt message     
        public byte[] encrypt(byte[] message){         
            return (new BigInteger(message)).modPow(e, phi).toByteArray();    
        }       

        // Decrypt message     
        public byte[] decrypt(byte[] message){         
            return (new BigInteger(message)).modPow(d, phi).toByteArray();
        } 
}
