import java.math.BigInteger;

public class DigitsAsPowersOfTwo {

	public static void main(String[] args){

		BigInteger number = new BigInteger("131072");
		// A normal int (integer) type number would not have been enough.
		// So I used the BigInteger class and started with 1 as 2 to the 0th power is 1.
		
		BigInteger power = new BigInteger("17");
		// This is a variable to record which power of two we are on.
		
		BigInteger two = new BigInteger("2");
		// Since we are using BigIntegers, we need a BigInteger that's equal to two as well.

		while (hasPowersOfTwo(number)){
			// First, look down to the code for this function below.
			// (Where it says "public static boolean hasPowersOfTwo(BigInteger number)" )
			
			// So this while loop will cycle as long as the number it comes to next has some of its digits
			// equal to powers of two.
			
			// What we need to do now is start generating powers of two.
			
			number = number.multiply(two);
			// Every power of two is is twice the last one.
			// We multiply the number by two to produce the next number.
			
			power = power.add(BigInteger.ONE);
			// Since we increased the power by one, let's record that change.
			
		}
		
		// The fact that the code reached here means that we have found a number that does not have
		// powers of two in their digits.
		// Let's see what the number is.
		
		System.out.println(number.toString() + " is 2 to the power of " + power.toString() );
		
		
		// You will now see that the number that comes up first when you run the program is 65536,
		// or 2 to the power of 16.
		
		// Now change the program to start at 2 times that, 131072 or 2 to the power of 17.
		// Don't forget to change the power value as well!
		
		// What? No value? That's because at least for a looooong while (as far as we know I presume),
		// there are no other values that suit our conditions.
	}

	public static boolean hasPowersOfTwo(BigInteger number) {
		// This function returns a boolean value (true or false),
		// depending on whether the number has a power of two.

		// First we have to turn the number into a String (a text).
		String string = number.toString();
		// so the variable string (of the type String) is our number in text form.

		// Now we have to see if its digits include the powers of 2.

		for (int x = 0 ; x < string.length() ; x++){
			// This is a loop that repeats the code inside as many times as the length of our number.
			// Every time, the variable x increases by 1 (the x++ at the end) starting at zero,
			// and capped at the length of the number minus one.

			if (string.charAt(x) == '1' || string.charAt(x) == '2' || string.charAt(x) == '4' || string.charAt(x) == '8'){
				// If the digit is one of 1,2,4 or 8, we need to stop the process
				// and tell the program that the number has the digit.

				return true;
				// Yes, it has powers of two.
				// the return function carries the true value out the function and to the rest of the program.
			}
		}
		
		// When the number doesn't have any digits equal to powers of two, the function comes here.
		// So, we have to say that the number does not contain any.

		return false;
	}
}