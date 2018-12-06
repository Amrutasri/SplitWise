import java.util.Scanner;

public class InputDriver {

    Scanner integerScanner = new Scanner(System.in);
    Scanner doubleScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);

    public int readInputAsInteger() {
        return integerScanner.nextInt();
    }

    public double readInputAsDouble() {
        return doubleScanner.nextDouble();
    }

    public String readInputAsString() {
        return stringScanner.nextLine();
    }
 }
