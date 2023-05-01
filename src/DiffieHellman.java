import java.util.Scanner;

/**
 * This program is the Java implementation of Diffie Hellman algorithm
 **/

public class DiffieHellman {

    // This method performs mod operation and returns the result
    // returns ((a ^ b) % p)
    private static long modOperation(long a, long b, long p) {
        return (b == 1) ? a : (((long)Math.pow(a, b)) % p);
    }

    public static void main(String[] args) {
        long user1_PublicKey, user2_PublicKey, user1_GeneratedKey, p1, user2_GeneratedKey, p2, user1_SecretKey, user2_SecretKey;

        // Gets the input value for User1
        Scanner sc = new Scanner(System.in);
        user1_PublicKey = sc.nextInt();
        System.out.print("The value of user1 is:" + user1_PublicKey);

        // Gets the input value for User2
        user2_PublicKey = sc.nextInt();
        System.out.println("The value of user2 is:" + user2_PublicKey);

        // Gets the Private Key for User1
        p1 = sc.nextInt();
        System.out.println("The private key p1 for user1:" + p1);

        // Call the method modOperation to return the User1's generated key
        user1_GeneratedKey = modOperation(user2_PublicKey, p1, user1_PublicKey);

        // Gets the Private Key for User2
        p2 = sc.nextInt();
        System.out.println("The private key p2 for user1:" + p2);

        // Call the method modOperation to return the User2's generated key
        user2_GeneratedKey = modOperation(user2_PublicKey, p2, user1_PublicKey);

        // Call the method modOperation by passing the generated keys the corresponding user values + private key
        user1_SecretKey = modOperation(user2_GeneratedKey, p1, user1_PublicKey); // Secret key for User1
        user2_SecretKey = modOperation(user1_GeneratedKey, p2, user1_PublicKey); // Secret key for User2

        System.out.println("Secret key for the user1 is:" + user1_SecretKey);
        System.out.println("Secret key for the user2 is:" + user2_SecretKey);
    }
}
