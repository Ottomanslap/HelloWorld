import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner( System.in );

	public static void main(String[] args){
		System.out.println(readInputI());
		input.nextLine();
		input.nextLine();
		input.nextLine();
		input.nextLine();
		input.nextLine();
	}

	static int readInputI() {
		//inputs an integer and tries again if the input is not appropriate.
		
		try { int x = input.nextInt();
		return x;
		} catch (InputMismatchException exception){
			System.out.print("The value you have entered is invalid, please try again: ");
			input.nextLine();
			return readInputI();
		} catch (NoSuchElementException exception){
			System.out.print("The value you have entered is invalid, please try again: ");
			input.nextLine();
			return readInputI();
		}
	}
}
