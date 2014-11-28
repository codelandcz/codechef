import java.io.*;
import java.util.InputMismatchException;

// http://www.purplemath.com/modules/factzero.htm
public class Main
{
  public static void main(String[] args) throws IOException, InputMismatchException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    int number, zeroes, divider;

    while (n-- > 0) {
      zeroes = 0;
      divider = 5;
      number = Integer.parseInt(in.readLine());

      while (divider <= number) {
        zeroes += number / divider;
        divider *= 5;
      }

      System.out.println(zeroes);
    }

    in.close();
  }
}
