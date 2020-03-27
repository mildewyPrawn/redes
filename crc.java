/*
  Program to implement CRC (Cyclic Redundancy Check) error detection algorithm in Java
  Author: Manav Sanghavi		Author Link: https://www.facebook.com/manav.sanghavi
  www.pracspedia.com
*/
import java.util.*;

class CRC {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n;

        // String d = "01001000011011110110110001100001001000000110110101110101011011100110010001101111";
        // String d = "01001000011011110110110001100001001000000110110101110101011011100110010001101111 00011110 11100010 00000000 00000000"
        // String d = "01001000011011110110110001100001001000000110110101110101011011100110010001101111 00011110 11100010"
        String d = "010010000110111101101100011000010010000001101101011101010110111001100100011011110001111011100010";


        String p = "11000000000000101";


        char[] dataC = d.toCharArray(); 
        char[] polyC = p.toCharArray();

        int[] data = new int[d.length()];
        int[] divisor = new int[p.length()];

        for (int i = 0; i < d.length(); i++)
            data[i] = Character.getNumericValue(dataC[i]);

        for (int i = 0; i < p.length(); i++)
            divisor[i] = Character.getNumericValue(polyC[i]);
		
        // Accept the input
        //System.out.println("Enter the size of the data:");
        //n = scan.nextInt();
        //int data[] = new int[n];
	
        /*System.out.println("Enter the data, bit by bit:");
          for(int i=0 ; i < n ; i++) {
          System.out.println("Enter bit number " + (n-i) + ":");
          data[i] = scan.nextInt();
          }*/
		
        // Accept the divisor
        /*System.out.println("Enter the size of the divisor:");
          n = scan.nextInt();
          int divisor[] = new int[n];
          System.out.println("Enter the divisor, bit by bit:");
          for(int i=0 ; i < n ; i++) {
          System.out.println("Enter bit number " + (n-i) + ":");
          divisor[i] = scan.nextInt();
          }*/
		
        // Divide the inputted data by the inputted divisor
        // Store the remainder that is returned by the method
        int remainder[] = divide(data, divisor);
        for(int i=0 ; i < remainder.length-1 ; i++) {
            System.out.print(remainder[i]);
        }
        System.out.println("\nThe CRC code generated is:");
		
        for(int i=0 ; i < data.length ; i++) {
            System.out.print(data[i]);
        }
        for(int i=0 ; i < remainder.length-1 ; i++) {
            System.out.print(remainder[i]);
        }
        System.out.println();
		
        // Create a new array
        // It will have the remainder generated by the above method appended
        // to the inputted data
        /*int sent_data[] = new int[data.length + remainder.length - 1];
          System.out.println("Enter the data to be sent:");
          for(int i=0 ; i < sent_data.length ; i++) {
          System.out.println("Enter bit number " + (sent_data.length-i)
          + ":");
          sent_data[i] = scan.nextInt();
          }
          receive(sent_data, divisor);*/
    }
	
    static int[] divide(int old_data[], int divisor[]) {
        int remainder[] , i;
        int data[] = new int[old_data.length + divisor.length];
        System.arraycopy(old_data, 0, data, 0, old_data.length);
        // Remainder array stores the remainder
        remainder = new int[divisor.length];
        // Initially, remainder's bits will be set to the data bits
        System.arraycopy(data, 0, remainder, 0, divisor.length);
		
        // Loop runs for same number of times as number of bits of data
        // This loop will continuously exor the bits of the remainder and
        // divisor
        for(i=0 ; i < old_data.length ; i++) {
            System.out.println((i+1) + ".) First data bit is : "
                               + remainder[0]);
            System.out.print("Remainder : ");
            if(remainder[0] == 1) {
                // We have to exor the remainder bits with divisor bits
                for(int j=1 ; j < divisor.length ; j++) {
                    remainder[j-1] = exor(remainder[j], divisor[j]);
                    System.out.print(remainder[j-1]);
                }
            }
            else {
                // We have to exor the remainder bits with 0
                for(int j=1 ; j < divisor.length ; j++) {
                    remainder[j-1] = exor(remainder[j], 0);
                    System.out.print(remainder[j-1]);
                }
            }
            // The last bit of the remainder will be taken from the data
            // This is the 'carry' taken from the dividend after every step
            // of division
            remainder[divisor.length-1] = data[i+divisor.length];
            System.out.println(remainder[divisor.length-1]);
        }
        return remainder;
    }
	
    static int exor(int a, int b) {
        // This simple function returns the exor of two bits
        if(a == b) {
            return 0;
        }
        return 1;
    }

    static void receive(int data[], int divisor[]) {
        // This is the receiver method
        // It accepts the data and divisor (although the receiver already has
        // the divisor value stored, with no need for the sender to resend it)
        int remainder[] = divide(data, divisor);
        // Division is done
        for(int i=0 ; i < remainder.length ; i++) {
            if(remainder[i] != 0) {
                // If remainder is not zero then there is an error
                System.out.println("There is an error in received data...");
                return;
            }
        }
        //Otherwise there is no error in the received  data
        System.out.println("Data was received without any error.");
    }
}
