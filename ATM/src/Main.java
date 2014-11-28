import java.io.*;
import java.util.InputMismatchException;

public class Main
{

  public static final float CHARGE = 0.50f;

  public static void main(String[] args) throws IOException, InputMismatchException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = in.readLine();
    String[] inputs = line.split(" ");
    int withdraw = Integer.parseInt(inputs[0]);
    float balance = Float.parseFloat(inputs[1]);

    if (withdraw % 5 == 0 && balance > withdraw + CHARGE && withdraw > 0) {
      balance -= (withdraw + CHARGE);
    }

    System.out.printf("%.2f", balance);
  }
}
