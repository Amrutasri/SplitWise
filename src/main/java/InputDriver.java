import java.util.Scanner;

public class InputDriver {

    Scanner doubleScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);

    public double readInputAsDouble() {
        double input = doubleScanner.nextDouble();
        return input;
    }

    public String readInputAsString() {
        String input = stringScanner.nextLine();
        return input;
    }
 }
